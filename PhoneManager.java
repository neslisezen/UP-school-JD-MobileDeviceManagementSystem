package section2project;

import java.util.HashMap;

import section2project.Exceptions.*;

public class PhoneManager {
	HashMap<String, Phone> phoneList;
	

	public PhoneManager() {
		phoneList = new HashMap<String, Phone>();
	}

	public void addPhone(Phone phone) {
		try {
			if (phoneList.putIfAbsent(phone.getSerialNumber(), phone) == null) {
				System.out.println("Phone is succussfully added.");
			
				}
			else
				throw new phoneIsAlreadyRegistered("This mobile phone is already registered!");
		} catch (phoneIsAlreadyRegistered e) {
			System.out.println(e.getMessage());
			
		} // false ->update phone?

	}

	public boolean deletePhone(String serialNumber) {
		try {
			if (phoneList.remove(serialNumber) != null) {
				System.out.println("Phone is successfully deleted.");
				return true;
			}
			else
				throw new noPhone("There is no such contact!");
		}
		catch (noPhone e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public void updatePhone(String serialNumber,int choice,String newValue) {
		switch (choice) {
		case 1 -> {
			phoneList.get(serialNumber).setBrand(newValue);
		}
		case 2 -> {
			phoneList.get(serialNumber).setModel(newValue);
		}
		case 3 -> {
			phoneList.get(serialNumber).setSerialNumber(newValue);
		}
		case 4 -> {
			phoneList.get(serialNumber).setStorage(newValue);
		}
		case 5 -> {
			phoneList.get(serialNumber).setOperatingSystem(newValue);
		}
		}
	}

	public boolean listPhones() {
		try {
		if (phoneList.isEmpty() == true)
			throw new noPhone("There is no phone registered.");			
		for (Phone phone : phoneList.values()) {
			System.out.println(phone.getPhoneInfo());
		}
		return true;
		}
		catch(noPhone e) {
			System.out.println(e.getMessage());
			return false;
		}

	}
	public boolean isSerialNumberRight(String serialnumber) {
		return phoneList.containsKey(serialnumber);

	}
	public double getStorage(String serialNumber){
		return phoneList.get(serialNumber).getStorage();
	}

	public boolean listPhone(String serialNumber) {
		try {
			if (phoneList.get(serialNumber) != null) {
				System.out.println(phoneList.get(serialNumber).toString());
				return true;}
			else
				throw new noPhone("There is no such phone!");
		} catch (noPhone e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public String fileInfos() {
		String file = "";
		if (phoneList.isEmpty() != true) {
			for (Phone phone : phoneList.values()) {
				file += phone.fileString();
			}}
		return file;
	}
	public int registeredPhoneNumber() {
		return phoneList.size();
	}

}
