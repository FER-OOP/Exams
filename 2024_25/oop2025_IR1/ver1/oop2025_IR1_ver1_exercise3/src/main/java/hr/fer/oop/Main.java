package hr.fer.oop;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

    public static void main(String[] args) {
        //input stream demo
        byte[] data = new byte[]{0x10, 0x10, 0x10, 0x20, 0x20, 0x30, 0x30, 0x30, 0x30};

        try (ByteArrayInputStream source = new ByteArrayInputStream(data); InputStream cis = new CompressingInputStream(source)) {
            int b;
            //prints 10 03 20 02 30 04
            while ((b = cis.read()) != -1) {
                //read each byte of the input stream and write it to the console
                System.out.printf("%02X ", b);
            }
            System.out.println("");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //output stream demo
        byte[] compressedData = new byte[]{0x10, 0x03, 0x20, 0x02, 0x30, 0x04};

        try (ByteArrayOutputStream destination = new ByteArrayOutputStream(); OutputStream dos = new DecompressingOutputStream(destination)) {
            for (byte b : compressedData) {
                //write each byte of the output stream
                dos.write(b);
            }

            //prints 10 10 10 20 20 30 30 30 30
            for (byte rb : destination.toByteArray()) {
                System.out.printf("%02X ", rb);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
