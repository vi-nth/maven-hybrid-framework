package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en");
	Faker faker = new Faker(local);
	
	public static DataHelper getDataHelper() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.address().firstName();
	}
	public String getLastName() {
		return faker.address().lastName();
	}
	public String getEmailAddrress() {
		return faker.internet().emailAddress();
	}
	public String getCity() {
		return faker.address().city();
	}
	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}
	public String getAddress() {
		return faker.address().streetAddress();
	}
	public String getPassword() { //text, number, special chars
		return faker.internet().password(6, 12, true, true);
	}

}
