package hr.fer.oop.zi.z1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PovertyLoader {
    private static final String delimiter=",";

    public static List<PovertyDatum> load(String path)
    {
        List<PovertyDatum> dataset = new ArrayList<>();

        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);

                dataset.add(new PovertyDatum(tempArr[0], Integer.parseInt(tempArr[1]), Double.parseDouble(tempArr[2])));
            }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return dataset;
    }
}
