package hr.fer.oop.zi.z1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PovertyStats {

    private List<PovertyDatum> dataset;

    public PovertyStats(List<PovertyDatum> dataset) {
        this.dataset = new ArrayList<PovertyDatum>();

        for(PovertyDatum dat: dataset)
        {
            this.dataset.add(new PovertyDatum(dat));
        }
    }

    public List<String> topImproving(int cutoff)
    {
        return
        dataset.stream().collect(Collectors.groupingBy(PovertyDatum::getLocation)).entrySet().stream().
                map(t -> {List<PovertyDatum> temp= t.getValue().stream().sorted(Comparator.comparing(PovertyDatum::getYear).reversed()).limit(2).collect(Collectors.toList());
                    double improvement = 0.0;
                    if (temp.size()==2) improvement = temp.get(0).getProportion()-temp.get(1).getProportion();
                    improvement = (improvement > 0)? improvement:0.0;
                    return Map.entry(t.getKey(),improvement);}).filter(t-> t.getValue()>0).sorted(Comparator.comparing(t->-t.getValue())).
                limit(cutoff).map(t-> t.getKey()).collect(Collectors.toList());

    }

    public List<String> topWorsening(int cutoff)
    {
        return
                dataset.stream().collect(Collectors.groupingBy(PovertyDatum::getLocation)).entrySet().stream().
                        map(t -> {List<PovertyDatum> temp= t.getValue().stream().sorted(Comparator.comparing(PovertyDatum::getYear).reversed()).limit(2).collect(Collectors.toList());
                            double improvement = 0.0;
                            if (temp.size()==2) improvement = temp.get(0).getProportion()-temp.get(1).getProportion();
                            improvement = (improvement < 0)? improvement:0.0;
                            return Map.entry(t.getKey(),improvement);}).filter(t-> t.getValue()<0).sorted(Comparator.comparing(t->t.getValue())).
                        limit(cutoff).map(t-> t.getKey()).collect(Collectors.toList());
    }

    public PovertyDatum theWorst()
    {
        PovertyDatum worst= this.dataset.stream().max(Comparator.comparing(PovertyDatum::getProportion)).get();
        return new PovertyDatum(worst); // return copy
    }
}
