package section2project;

import java.util.Scanner;

public class MobileDeviceManagement {
	AppManager appManager;
	ContactManager contactManager;
	FileManager fileManager;
	PhoneManager phoneManager;
	StorageManager storageManager;
	Scanner input;
	boolean exit;
	static String phoneSerialNumber;

	public MobileDeviceManagement() {
		appManager = new AppManager();
		contactManager = new ContactManager();
		fileManager = new FileManager();
		phoneManager = new PhoneManager();
		storageManager = new StorageManager();
		input = new Scanner(System.in);
		exit = false;
	}

	public static void main(String[] args) {
		MobileDeviceManagement mdm = new MobileDeviceManagement();
		mdm.generalMenu();
	}

	public void generalMenu() {
		String brand, model, serialNumber, storage, operatingSystem, password, email;
		int choice;
		String menu = """
				🌈Mobile Device Management System🌈
				1: My Phone
				2: New Phone register
				3: List my phones
				4: Recover my phone
				5: Help
				6: Exit
				Your choice: """;

		here: do {

			System.out.print(menu);
			choice = input.nextInt();
			System.out.println("**************************");
			switch (choice) {
			case 1 -> {
				if (phoneManager.registeredPhoneNumber() > 0) {
					System.out.println("Registration successful");
					this.phoneMenu();
				} else
					System.out.println("***Please register or recover your phone!!!***");
			}
			case 2 -> {
				System.out.print("Phone brand: ");
				brand = input.nextLine();
				input.next();
				System.out.print("Phone model: ");
				model = input.nextLine();
				input.next();
				System.out.print("Serial number: ");
				serialNumber = input.nextLine();
				input.next();
				System.out.print("Storage(GB): ");
				storage = input.nextLine();
				input.next();
				System.out.print("Operating System: ");
				operatingSystem = input.nextLine();
				input.next();
				phoneManager.addPhone(new Phone(brand, model, serialNumber, storage, operatingSystem));
				System.out.println("Registration successful " + brand + " " + model);
				phoneSerialNumber = serialNumber;
				phoneMenu();
			}
			case 3 -> {
				if (phoneManager.listPhones()) {
					System.out.print("Please write the serial number of the phone you want to register: ");
					String serial = input.nextLine();
					if (phoneManager.isSerialNumberRight(serial)) {
						phoneSerialNumber = serial;
						System.out.println("Registration successful");
						phoneMenu();
					} else
						System.out.println("There is no such serial number!");
				}

			}
			case 4 -> {
				if (fileManager.fileReader(appManager, contactManager, phoneManager)) {
					System.out.println("Registration successful");
					phoneMenu();
				}
			}
			case 5 -> { // spaeter
				System.out.println("***************HELP*************");
				System.out.println("""
						User login is necessary to search Film and add Film.
						Please login in your account or register yourself.
						Username is the combination of your first and last name. For example: neslisezen
						You can also search for usernames. Please choose "List Users".\s""");
				System.out.println("********************************");
				continue here;
			}
			case 6 -> {
				return;
			}

			}
		}

		while (true);

	}

	public void phoneMenu() {
		int choice;
		String myPhoneMenu = """
				💎 My Phone 💎
				1: Contact settings
				2: Apps
				3: Storage space
				4: Phone details
				5: Back up your phone
				6: Previous menu
				7: Exit
				Your Choice: """;

		do {

			System.out.print(myPhoneMenu);
			choice = input.nextInt();
			System.out.println("**************************");

			switch (choice) {
			case 1 -> {
				this.contactMenu();
			}

			case 2 -> {
				this.appsMenu();
			}
			case 3 -> {
				storageManager.storageDetails(appManager.sizeOfApps(),phoneManager.getStorage(phoneSerialNumber));
			}
			case 4 -> {
				this.PhoneDetailsMenu();
			}
			case 5 -> {// check
				fileManager.fileWriter(phoneManager.fileInfos());
				fileManager.fileWriter(appManager.fileInfos());
				fileManager.fileWriter(contactManager.fileInfos());
			}
			case 6 -> {
				return;
			}
			case 7 -> {
				exit = true;
			}
			}
		} while (!exit);

	}

	public void contactMenu() {
		String name, surname, phoneNumber, email;
		int choice;

		String userMenu = """
				💎 Contact Settings 💎
				1: My Contacts
				2: Create a contact
				3: Delete a contact
				4: Edit a contact
				5: Previous menu
				6: Exit
				Your Choice: """;

		here: do {

			System.out.print(userMenu);
			choice = input.nextInt();
			System.out.println("**************************");
			switch (choice) {
			case 1 -> {

				contactManager.listContacts();
			}
			case 2 -> {
				System.out.print("*Please write the contact details you want to add*");
				System.out.print("Name of the person: ");
				name = input.nextLine();
				input.next();
				System.out.print("Surname of the person: ");
				surname = input.nextLine();
				input.next();
				System.out.print("Phone number: ");
				phoneNumber = input.nextLine();
				input.next();
				System.out.print("E-mail: ");
				email = input.nextLine();
				input.next();
				contactManager.createContact(new Contact(name, surname, phoneNumber, email));
			}
			case 3 -> {
				System.out.print("Please write the name and surname of the person you want to delete");
				System.out.print("Name of the person: ");
				name = input.nextLine();
				System.out.print("Surname of the person: ");
				input.nextLine();
				surname = input.nextLine();
				input.next();
				contactManager.deleteContact(name, surname);
			}
			case 4 -> {
				System.out.print("Please write the name and surname of the person whose information you want to edit");
				System.out.print("Name of the person: ");
				name = input.nextLine();
				input.next();
				System.out.print("Surname of the person: ");
				surname = input.nextLine();
				input.next();
				if (!contactManager.listContact(name, surname)) {
					continue here;
				}
				System.out.print("Which info do you want to edit? ");
				System.out.print("1.Name\n2.Surname\3.Phone Number\n4.E-mail\nPlease choose: ");
				choice = input.nextInt();
				input.next();
				System.out.print("Please write the new info: ");
				String value = input.nextLine();
				input.next();
				contactManager.updateContact(name, surname, choice, value);
			}
			case 5 -> {
				return;
			}
			case 6 -> {
				exit = true;
			}
			}
		} while (!exit);
	}

	public void appsMenu() {
		String name, version, size;
		int choice;
		String userMenu = """
				💎 App Settings 💎
				1: My Apps
				2: Add an app
				3: Delete an app
				4: Update an app
				5: Previous menu
				6: Exit
				Your Choice: """;

		here: do {

			System.out.print(userMenu);
			choice = input.nextInt();
			System.out.println("**************************");

			switch (choice) {
			case 1 -> {
				appManager.listApps();
			}
			case 2 -> {
				System.out.print("*Please write the add details you want to add*");
				System.out.print("App name: ");
				name = input.nextLine();
				input.next();
				System.out.print("App Version: ");
				version = input.nextLine();
				input.next();
				System.out.print("App size(GB): ");
				size = input.nextLine();
				input.next();
				appManager.addApp(new App(name, version, size));
			}
			case 3 -> {
				System.out.print("Please write the name of the app you want to delete");
				System.out.print("App Name: ");
				name = input.nextLine();
				input.next();
				appManager.deleteApp(name);
			}
			case 4 -> {
				System.out.print("Please write the app whose information you want to edit");
				System.out.print("App Name: ");
				name = input.nextLine();
				input.next();
				if (!appManager.listApp(name)) {
					continue here;
				}
				System.out.print("Which info do you want to edit? ");
				System.out.print("1.Name\n2.Version\3.Size\nPlease choose: ");
				choice = input.nextInt();
				input.next();
				System.out.print("Please write the new info: ");
				String value = input.nextLine();
				input.next();
				appManager.updateApp(name, choice, value);
			}
			case 5 -> {
				return;
			}
			case 6 -> {
				exit = true;
			}
			}

		} while (!exit);
	}

	public void PhoneDetailsMenu() {
		String name;
		int choice;
		String userMenu = """
				💎 Phone Settings 💎
				1: My Phone Details
				2: Add phone
				3: Delete phone
				4: Update phone details
				5: Previous menu
				6: Exit
				Your Choice: """;

		here: do {

			System.out.print(userMenu);
			choice = input.nextInt();
			System.out.println("**************************");

			switch (choice) {
			case 1 -> {
				phoneManager.listPhone(phoneSerialNumber);
			}
			case 2 -> {
				System.out.print("Please write the details of the phone you want to add");
				System.out.print("Phone brand: ");
				String brand = input.nextLine();
				input.next();
				System.out.print("Phone model: ");
				String model = input.nextLine();
				input.next();
				System.out.print("Serial number: ");
				String serialNumber = input.nextLine();
				input.next();
				System.out.print("Storage(GB): ");
				String storage = input.nextLine();
				input.next();
				System.out.print("Operating System: ");
				String operatingSystem = input.nextLine();
				input.next();
				phoneManager.addPhone(new Phone(brand, model, serialNumber, storage, operatingSystem));

			}
			case 3 -> {
				System.out.print("Please write the name of the app you want to delete");
				System.out.print("App Name: ");
				name = input.nextLine();
				input.next();
				appManager.deleteApp(name);
			}
			case 4 -> {
				System.out.print("Please write the app whose information you want to edit");
				System.out.print("App Name: ");
				name = input.nextLine();
				input.next();
				if (!appManager.listApp(name)) {
					continue here;
				}
				System.out.print("Which info do you want to edit? ");
				System.out.print("1.Name\n2.Version\3.Size\nPlease choose: ");
				choice = input.nextInt();
				input.next();
				System.out.print("Please write the new info: ");
				String value = input.nextLine();
				input.next();
				appManager.updateApp(name, choice, value);
			}
			case 5 -> {
				return;
			}
			case 6 -> {
				exit = true;
			}
			}

		} while (!exit);
	}
}