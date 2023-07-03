package section2project;

public class StorageManager {
	private final double systemStorage;

	StorageManager() {
		systemStorage = 10.0;
	}

	void storageDetails(double sizeOfApps, double phoneStorage) {
		double totalSizeUsed= sizeOfApps + systemStorage;
		System.out.println("*****************************************");
		System.out.println("Storage used by the apps: "+ sizeOfApps);
		System.out.printf("Storage used by the System:"+ systemStorage);
		System.out.println(""+ totalSizeUsed+" GB of"+phoneStorage +"GB Used");
		System.out.println("*****************************************");
	}

}
