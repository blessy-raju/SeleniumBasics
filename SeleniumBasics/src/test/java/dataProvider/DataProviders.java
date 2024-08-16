package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="InvalidUserCredentials")
	public Object[][] verifyUserCredentialsData() {
		Object[][] data=new Object[3][2];
		data[0][0]="blessy@gmail.com";
		data[0][1]="test";
		
		data[1][0]="bless@gmail.com";
		data[1][1]="Password@123";
		
		data[2][0]="test@gmail.com";
		data[2][1]="test";
		return data;
	}

}
