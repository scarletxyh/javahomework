import java.io.*;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HashDir {
    public static void main(String[] args) {
    	try {
    		String str = dfs("/Users/xyh/eclipse-workspace/Homework4");
    		//获得当前目录下的value
    		
    		File file = new File("result.txt");
    		//创建一个新的文件存储当前目录的value
    		
    		FileWriter fileWriter = new FileWriter(file);
    		fileWriter.write(str);
    		fileWriter.close();
    		//关闭文件写入器
    		
    		FileInputStream res = new FileInputStream(file);
    		//创建文件输入流
    		
    		byte[] sha1 = SHA1Checksum(res);
    		String result = "";
    		for(int j = 0; j < sha1.length; j++) {
    			result += Integer.toString(sha1[j]&0xFF, 16);
    			//计算目录的key值
    		}
    		file.delete(); //删除文件
    		System.out.println(result); //输出当前目录的hash值
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    public static byte[] SHA1Checksum(InputStream is) throws Exception{
    	//用SHA1方法计算hash值
    	byte[] buffer = new byte[1024];
    	MessageDigest complete = MessageDigest.getInstance("SHA-1");
    	int numRead = 0;
    	while(numRead != -1) {
    		numRead = is.read(buffer);
    		if(numRead > 0) {
    			complete.update(buffer,0,numRead);
    		}
    	}
    	is.close();
    	return complete.digest();  //返回字节数组
    }
    public static String dfs(String path) throws Exception {
    	File dir = new File(path);
    	File[] fs = dir.listFiles();
    	List<File> fileList = Arrays.asList(fs);
    	
    	Collections.sort(fileList, new Comparator<File>() {
    		//将文件夹中的文件按照文件名排序
    		public int compare(File o1, File o2) {
    			if(o1.isDirectory() && o2.isFile())return -1;
    			if(o1.isFile() && o2.isDirectory())return 1;
    			return o1.getName().compareTo(o2.getName());
    		}
    	});
        String result = "";//result存储文件夹value值
    	
    	for(int i = 0; i < fileList.size(); i++) {
    		if(fileList.get(i).isFile()) {
    			//判断如果是文件则直接计算其key值
    			
    			FileInputStream res = new FileInputStream(fileList.get(i));
    			result += fileList.get(i).getName();
    			//加入文件名
    			
    			byte[] sha1 = SHA1Checksum(res);
        		for(int j = 0; j < sha1.length; j++) {
        			result += Integer.toString(sha1[j]&0xFF, 16);
        			//加入文件的key值
        		}	
    		}
    		if(fileList.get(i).isDirectory()) {
    			//计算子文件夹的value值
                result += fileList.get(i).getName();
    			result += dfs(path + File.separator + fileList.get(i).getName());
    		}
    	}
    	return result;
    }
}
