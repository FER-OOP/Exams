package treci;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;


public class Digest {
	public static String MD5(Path file)
	{
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		
		md.update(Files.readAllBytes(file));
		byte[] digest= md.digest();
		
		return bytesToHex(digest);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
		
		
	}
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	private static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}

}
