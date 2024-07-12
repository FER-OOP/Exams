package hr.fer.oop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Main {

    private static final String LOWER_CASE_EXAMPLE = "Franc Hlapić smješta ključ od gvožđa uz džbunje.";
    private static final String UPPER_CASE_EXAMPLE = "franc hlapiĆ smjeŠta kLjuČ od gvoŽĐa uz DžbuNje.";

    public static void main(String[] args) throws IOException {
        //print original
        System.out.println("Original:");
        System.out.println(LOWER_CASE_EXAMPLE);
        System.out.println(UPPER_CASE_EXAMPLE);
        
        //writer
        StringWriter sWriter = new StringWriter(); //to simplify, we will read the text from a string rather than from a file
        TMWriter tmWriter = new TMWriter(sWriter); //TMWriter decorates the StringWriter
        BufferedWriter bWriter = new BufferedWriter(tmWriter);
        bWriter.write(LOWER_CASE_EXAMPLE);
        bWriter.newLine();
        bWriter.write(UPPER_CASE_EXAMPLE);
        bWriter.flush();
        bWriter.close();
        
        //print tm style
        System.out.println("TM Style:");
        System.out.println(sWriter.toString());
    }
}
