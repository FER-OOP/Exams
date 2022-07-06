package hr.fer.oop.zi.z1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillionaireLoader {
    private static final String delimiter="\t";

    public static List<BillionaireDatum> load(String path)
    {
        List<BillionaireDatum> dataset = new ArrayList<>();

        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = " ";
            String[] tempArr;
            while ((line = br.readLine()) != null) {
                tempArr = line.split(delimiter);
                dataset.add(new BillionaireDatum(Integer.parseInt(tempArr[0]), tempArr[1], tempArr[2].length()>0?Integer.parseInt(tempArr[2]):null,Integer.parseInt(tempArr[3]),tempArr[4]));
            }
            br.close();
        }
        catch(IOException ioe) {
            ioe.printStackTrace();
        }
        return dataset;
    }
}
