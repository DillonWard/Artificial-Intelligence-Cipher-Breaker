package ie.gmit.sw.ai;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileParser {

	private String filename;
	//private String outputFile = "output.txt";
	
	public FileParser(){
		
	}

	public FileParser(String filename){
		this.filename = filename;
	}
	
	public String readFile(String fileName) throws Throwable {
		byte[] bytes = new byte[1050];
		int length;
		
		InputStream inputStream = new FileInputStream(fileName);
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		

		while ((length = inputStream.read(bytes)) != -1) {
		    result.write(bytes, 0, length);
		}
		return result.toString();
	}

	
		
}
