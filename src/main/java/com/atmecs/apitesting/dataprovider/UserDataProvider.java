package com.atmecs.apitesting.dataprovider;

import com.atmecs.apitesting.constants.FileConstants;

public class UserDataProvider {

	@DataProvider(name = "usersdata")
	public static Object[][] getUsersData() {
		PropReader usersDataReader = new PropReader(FileConstants.);
		String url = usersDataReader.get("url");
		String firstName = usersDataReader.get("firstName");
		String lastName = usersDataReader.get("lastName");
		
		Object[][] data = new Object[1][3];
		data[0][0] = url;
		data[0][1] = firstName;
		data[0][2] = lastName;
		
		return data;
	}
	
	
	@DataProvider(name = "createuserdata")
	public static Object[][] getCreateUserData() {
		JsonReader jsonReader = new JsonReader(FileConstants.;
		Object object = jsonReader.parse();
		Object[][] data = new Object[1][1];
		data[0][0] = object;
		return data;
	}

}
