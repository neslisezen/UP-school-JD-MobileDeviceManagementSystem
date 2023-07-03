package section2project;

import java.util.Objects;

public class Contact {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String key;

	public Contact(String firstName, String lastName, String phoneNumber, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		key = firstName.toLowerCase() + lastName.toLowerCase();
	}

	String getKey() {
		return key;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
		key = firstName.toLowerCase() + lastName.toLowerCase();
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
		key = firstName.toLowerCase() + lastName.toLowerCase();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Person Info: " + "First name:" + firstName + ", "
				+ " last name:" + lastName+ ", "
				+ " phone number:" + phoneNumber+ ", "
				+ " email:" + email;
	}
	public String fileString() {
		return ("Contact," + firstName + ","
				+ lastName + "," + phoneNumber + ","+ email +",");
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstName, key, lastName, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(key, other.key) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

}
