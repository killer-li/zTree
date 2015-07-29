package property;

import java.io.InputStream;
import java.util.Properties;


public class PropertysTest {
	public static void main(String[] args) {
		PropertysTest pt = new PropertysTest();
		System.out.println("name: " + pt.getProper("name"));
		System.out.println("password: " + pt.getProper("password"));
	}
	
	public String getProper(String name) {
		InputStream in = null;
		Properties p = new Properties();
		try {
			in = this.getClass().getResourceAsStream("/property/test.properties");
			//in = Class.forName("property.PropertysTest").getResourceAsStream("/property/test.properties");
			p.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p.getProperty(name);
	}
}
