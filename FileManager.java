package section2project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

	public boolean fileWriter(String backupString) {
		try {
			File file = new File("backup.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fileWriter = new FileWriter(file, true);
			BufferedWriter bWriter = new BufferedWriter(fileWriter);
			if (backupString == null || backupString.isEmpty()) {
				bWriter.close();
				return false;
			}
			bWriter.write(backupString);
			bWriter.write(System.lineSeparator());
			bWriter.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean fileReader(AppManager appManager, ContactManager contactManager, PhoneManager phoneManager) {
		FileReader fileReader;
		BufferedReader br;
		try {
			fileReader = new FileReader(("backup.txt"));

			String line;

			br = new BufferedReader(fileReader);

			while ((line = br.readLine()) != null) {

				String[] parts = line.strip().split(",");
				switch(parts[0]) {
				case "App"-> {
					appManager.addApp(new App(parts[1],parts[2],parts[3]));
				}
				case "Phone"-> {
					phoneManager.addPhone(new Phone(parts[1],parts[2],parts[3],parts[4],parts[5]));
					MobileDeviceManagement.phoneSerialNumber = parts[3];
				}
				case "Contact"-> {
					contactManager.createContact(new Contact(parts[1],parts[2],parts[3],parts[4]));
				}
				}
				

			}
			br.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			return false;
		} catch (IOException e) {
			System.out.println("File Exception");
			return false;
		}

	}
}
