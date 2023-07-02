package section2project;

public class StorageManager {
	private double systemStorage = 1.0;

	StorageManager() {
//		appManager = new AppManager();
	}

	void storageDetails(double sizeOfApps, double phoneStorage) {
		System.out.println("*****************************************");
		System.out.println("Storage used by the apps: "+ sizeOfApps);
		System.out.printf("Storage used by the System:"+ systemStorage);
		System.out.println(""+(sizeOfApps + systemStorage)+" GB of"+phoneStorage +"GB Used");
		System.out.println("*****************************************");
	}

}
