package jsj.tysf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class Factory {
	private static Properties properties=new Properties();
	private static HashMap map=new HashMap();
	static {
		try {
			FileInputStream fis=new FileInputStream("peizhi.properties");
			properties.load(fis);
			Enumeration e=properties.keys();
			while(e.hasMoreElements()){
				String key=(String) e.nextElement();
				String value=properties.getProperty(key);
				Class c=Class.forName(value);
				Operator o=(Operator) c.newInstance();
				map.put(key,o);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
	}

	public static Operator createOprate(String[] ops) {
		//取得运算符
		Operator o=(Operator) map.get(ops[1]);
		return o;
	}

}
