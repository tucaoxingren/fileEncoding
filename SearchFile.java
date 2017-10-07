package fileEncoding;

import java.io.File;
import java.io.IOException;

public class SearchFile {
	
	//D:\\BaiduYunDownload\\[IT教程网]JavaSE基础视频\\Code
	//D:\\Users\\javawork\\ALiBaBa
	private static String dirPath = "D:\\BaiduYunDownload\\[IT教程网]JavaSE基础视频\\Code";
//	private static String dirPath = "D:\\Users\\javawork\\Day20\\utfFile";
	/**
	 * 将制定路径下所有的Java文件编码格式由GBK转为UTF-8
	 * 使用前请将 dirPath 改为需要操作的路径
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File dir = new File(dirPath);
		search(dir);
	}

	private static void search(File dir) throws IOException {
		String fileName = null;
		
		File[] files = dir.listFiles();
		
		for(int x=0; x<files.length; x++){
			
			if(files[x].isDirectory()){
				search(files[x]);
			}
			else{
				fileName = files[x].getName();
				if(JudgeFileExtensionName(fileName)){
					System.out.println(fileName);
					FileEncoding fileE = new FileEncoding();
					fileE.transFileEncoding(files[x].getCanonicalPath());
					}
			}
		}

	}

	private static boolean JudgeFileExtensionName(String fileName) {
		// TODO Auto-generated method stub
		String regex = "[a-zA-z]*[.][j][a][v][a]";
		boolean flag = false;
		flag = fileName.matches(regex);
		return flag;
	}
	

}
