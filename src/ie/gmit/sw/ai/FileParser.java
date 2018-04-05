package ie.gmit.sw.ai;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileParser {

	private String filename;

	
	public FileParser(String filename){
		this.filename = filename;
	}
	
	public String fileInput(String filename) throws Throwable{
		int length;
		byte[] bytes = new byte[1050];
		
		InputStream inputStream = new FileInputStream(filename);
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		
		while((length = inputStream.read(bytes)) != -1){
			result.write(bytes, 0, length);
		}
		return filename.toString();		
	}
	
	public String fileOutput(String filename) throws Throwable{
		return filename;
		
	}
	
}
