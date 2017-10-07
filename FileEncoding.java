package fileEncoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileEncoding {
	
    public void transFileEncoding(String filePathName) throws IOException{
    	InputStreamReader isr = new InputStreamReader(new FileInputStream(filePathName),"GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePathName+"2"),"UTF-8");
		BufferedReader bufr = new BufferedReader(isr);		
		String line = null;
		while((line=bufr.readLine())!=null){
			//System.out.println(line);
			osw.write(line+'\n');
		}		
		isr.close();
		osw.close();
		bufr.close();		
		deFile(filePathName);
		//read(filePathName);
    }
    public void deFile(String filePathName){
    	File file = new File(filePathName);
    	File file2 = new File(filePathName+"2");
    	File file3 = new File(filePathName);
    	file.delete();
    	file2.renameTo(file3);
    }
    
	/*
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(new FileInputStream("ReadKey.java"),"GBK");
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("ReadKey2.java"),"UTF-8");
		BufferedReader bufr = new BufferedReader(isr);
		String line = null;
		while((line=bufr.readLine())!=null){
			System.out.println(line);
			osw.write(line+'\n');
		}		
		isr.close();
		osw.close();
		bufr.close();
		read("ReadKey.java");
	}*/

	public static void read(String filePathName) throws IOException {
		// TODO Auto-generated method stub
		
		FileReader fr = new FileReader(filePathName);	
		BufferedReader bufr = new BufferedReader(fr);		
		String line = null;
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		
		fr.close();
		bufr.close();
	}
}