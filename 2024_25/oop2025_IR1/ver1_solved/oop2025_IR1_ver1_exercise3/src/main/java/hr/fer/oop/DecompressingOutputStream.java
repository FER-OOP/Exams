package hr.fer.oop;

import java.io.IOException;
import java.io.OutputStream;

public class DecompressingOutputStream extends OutputStream {

    private OutputStream os;
    private Integer storedByte = null;

    public DecompressingOutputStream(OutputStream os) {
        this.os = os;
    }

    @Override
    public void write(int b) throws IOException {
        if (storedByte == null) {
            //store the byte value, its repeatition counter will be written on the following write call
            storedByte = b;
        } else {
            //the number of repeats has been passed, write the stored byte value 'b' times
            for (int i = 0; i < b; i++) {
                os.write(storedByte);
            }
            storedByte = null;
        }
    }

    @Override
    public void close() throws IOException {
        os.close();
    } 

    @Override
    public void flush() throws IOException {
        os.flush();
    }        
}
