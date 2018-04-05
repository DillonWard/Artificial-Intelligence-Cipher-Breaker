package ie.gmit.sw.ai;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileParser {

	public FileParser() {
	}

	public String readFile(String fileName) throws Throwable {
		
		InputStream input = new FileInputStream(fileName);
		ByteArrayOutputStream response = new ByteArrayOutputStream();

		byte[] bytes = new byte[1050];
		int length;

		
		while((length = input.read(bytes))!= -1){
			response.write(bytes, 0, length);
		}
		return(response.toString().length() > 750) ? response.toString().substring(0, 750) : response.toString();
	}

	
}
