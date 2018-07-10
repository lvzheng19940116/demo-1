package ad.util;

import java.io.File;
import java.io.FileNotFoundException;

import org.springframework.util.ResourceUtils;

public class GetClassPath {

	public static String ClassPath() throws FileNotFoundException{
		 File path = new File(ResourceUtils.getURL("classpath:").getPath());
		 if(!path.exists()){
			path = new File(""); 
		 } 
		 //下载目录
		 String classPath = path.getAbsolutePath();
		 return classPath;
	}
	public static String printPath = "\\src\\main\\java\\com\\navinfo\\wecloud\\ad\\util\\";
}
