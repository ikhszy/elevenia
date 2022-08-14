package alami.elevenia.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
			
		} catch(Exception e) {
			System.out.println("exception: " + e.getMessage());
		}
	}
	
	public String getBaseURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String uname = prop.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pass = prop.getProperty("password");
		return pass;
	}
	
	public String getChromepath() {
		String chromepath = prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxPath() {
		String geckopath = prop.getProperty("geckopath");
		return geckopath;
	}

}
