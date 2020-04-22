package properties;

import java.util.ResourceBundle;

public class Property {
	
	
	public static String getProperty(String propertyName) {
		
		String value = propertyName;
		if (value.isEmpty()) {
			value="";
		}else {
			try {
				
				ResourceBundle rb = ResourceBundle.getBundle("config/config");
				
				value = rb.getString(propertyName);
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
				
		return value;
		
		
	}

}
