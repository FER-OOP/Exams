package hr.fer.oop;

import java.io.IOException;
import java.io.InputStream;

public class CompressingInputStream extends InputStream {

    private final InputStream is;
    private Integer storedByte = null;
    private Integer counter = null;

    public CompressingInputStream(InputStream is) {
        this.is = is;
    }

    @Override
    public int read() throws IOException {        
        if (counter != null) {
            //the byte value was previously returned, return its repetition counter and reset
            int result = counter;
            counter = null;
            return result;
        }

        int currentByte;
        if (storedByte == null) {
            //the initial read, no byte has been stored yet
            currentByte = is.read();
            counter = 1;
        } else if (storedByte == -1) {
            //the end of stream has been detected, propagate EOF
            return -1;
        } else {
            //the stored byte was read during the preceeding read call
            counter = 1;
            currentByte = storedByte;
        }

        //read and count until a different byte is encountered
        int nextByte;
        while ((nextByte = is.read()) == currentByte) {
            counter++;
        }
        
        //store the different byte for the following read calls
        storedByte = nextByte;

        //return the current byte, its repetition counter will be returned on the next read call
        return currentByte;
    }

    @Override
    public void close() throws IOException {
        is.close();
    }       
}