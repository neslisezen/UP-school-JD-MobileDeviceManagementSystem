package section2project;

import java.util.HashMap;

import section2project.Exceptions.*;

public class AppManager {
	HashMap<String, App> appList;


	public AppManager() {
		appList = new HashMap<String, App>();
	}

	public void addApp(App app) {
		try {
			if (appList.putIfAbsent(app.getName(), app) == null)
				System.out.println("App is successfully added.");
			else
				throw new existingApp("This app already exists!");
		} catch (existingApp e) {
			System.out.println(e.getMessage());

		}
	}

	public void deleteApp(String appName) {
		try {
			if (appList.remove(appName) != null)
				System.out.println("Contact is successfully deleted.");
			else
				throw new noApp("There is no such app!");
		} catch (noApp e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateApp(String appName, int choice, String newValue) {
		try {
			if (appList.get(appName) == null)
				throw new noApp("There is no such app!");

			switch (choice) {
			case 1 -> {
				appList.get(appName).setName(newValue);
			}
			case 2 -> {
				appList.get(appName).setVersion(newValue);
			}
			case 3 -> {
				appList.get(appName).setSize(newValue);
			}
			}
		} catch (noApp e) {
			System.out.println(e.getMessage());
		}

	}

	public void listApps() {
		try {
			if (appList.isEmpty())
				throw new noApp("There is no such app!");

			for (App app : appList.values()) {
				System.out.println(app.toString());
			}
		} catch (noApp e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean listApp(String appName) {
		try {
			if (appList.get(appName) != null) {
				System.out.println(appList.get(appName).toString());
				return true;}
			else
				throw new noApp("There is no such app!");
		} catch (noApp e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public double sizeOfApps() {
		double size = 0.0;
		if (appList != null  && !appList.isEmpty()) {
		for (App app : appList.values()) {
			size = size + app.getSize();
		}}
		return size;
	}
	public String fileInfos() {
		String file = "";
		if (!appList.isEmpty()) {
			for (App app : appList.values()) {
				file += app.fileString();
			}}
		return file;
	}
}
