package hr.fer.oop;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TMWriter extends Writer {

    private final Writer out;
    private static final Map<String, String> replacements;

    static {
        replacements = new HashMap<>();
        replacements.put("č", "cx");
        replacements.put("Č", "Cx");
        replacements.put("ć", "cy");
        replacements.put("Ć", "Cy");
        replacements.put("dž", "dx");
        replacements.put("Dž", "Dx");
        replacements.put("đ", "dy");
        replacements.put("Đ", "Dy");
        replacements.put("nj", "ny");
        replacements.put("Nj", "Ny");
        replacements.put("lj", "ly");
        replacements.put("Lj", "Ly");
        replacements.put("š", "sx");
        replacements.put("Š", "Sx");
        replacements.put("ž", "zx");
        replacements.put("Ž", "Zx");
    }

    public TMWriter(Writer out) {
        this.out = out;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {

        String string = new String(cbuf, off, len);

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            string = string.replace(entry.getKey(), entry.getValue());
        }

        out.write(string, 0, string.length());
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

}
