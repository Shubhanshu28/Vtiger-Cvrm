package DDTExtra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DDTExtraPractise {

	public static void main(String[] args) throws IOException {
          FileInputStream fis = new FileInputStream("./src/test/resources/cd.properties");
          Properties pobj = new Properties();
          pobj.load(fis);
          String browser = pobj.getProperty("bro");
         System.out.println(browser);
         System.out.println(pobj.getProperty("url"));
         System.out.println(pobj.getProperty("un"));
         System.out.println(pobj.getProperty("pwd"));
	}

}
