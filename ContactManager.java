package section2project;

import java.util.HashMap;

import section2project.Exceptions.*;

public class ContactManager {

	HashMap<String, Contact> contactList;

	ContactManager() {
		contactList = new HashMap<String, Contact>();
	}

	public boolean createContact(Contact contact) {
		try {
			if (contactList.putIfAbsent(contact.getKey(), contact) == null) {
				System.out.println("Contact is succussfully created.");
				return true;
			} else
				throw new existingContact("This contact already exists!"); // wrong contactName?
		} catch (existingContact e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void deleteContact(String contactName, String contactSurname) {
		String key = contactName.toLowerCase() + contactSurname.toLowerCase();
		try {
			if (contactList.remove(key) != null) {
				System.out.println("Contact is succussfully deleted.");

			} else
				throw new noContact("There is no such contact!"); // wrong contactName?
		} catch (noContact e) {
			System.out.println(e.getMessage());

		}
	}

	public void updateContact(String contactName, String contactSurname, int choice, String newValue) { // anonymous
		String key = contactName.toLowerCase() + contactSurname.toLowerCase();
		switch (choice) {
		case 1 -> {
			contactList.get(key).setFirstName(newValue);
		}
		case 2 -> {
			contactList.get(key).setLastName(newValue);
		}
		case 3 -> {
			contactList.get(key).setPhoneNumber(newValue);
		}
		case 4 -> {
			contactList.get(key).setEmail(newValue);
		}
		}

	}

	public void listContacts() {
		try {
			if (contactList.isEmpty())
				throw new noContact("There is no contact registered.");

			for (Contact contact : contactList.values()) {
				System.out.println(contact.toString());
			}
		} catch (noContact e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean listContact(String contactName, String contactSurname) {
		String key = contactName.toLowerCase() + contactSurname.toLowerCase();
		try {
			if (contactList.get(key) != null) {
				System.out.println(contactList.get(key).toString());
				return true;
			}

			else
				throw new noContact("There is no contact registered.");
		} catch (noContact e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public String fileInfos() {
		String file = "";
		if (contactList.isEmpty() == false) {
			for (Contact contact : contactList.values()) {
				file += contact.fileString();
			}}
		return file;
	}
}
