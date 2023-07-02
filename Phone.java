package section2project;

public class Phone {

	private String brand;
	private String model;
	private String serialNumber;
	private String storage;
	private String operatingSystem;

	public Phone(String brand, String model, String serialNumber, String storage, String operatingSystem) {
		this.brand = brand;
		this.model = model;
		this.serialNumber = serialNumber;
		this.storage = storage;
		this.operatingSystem = operatingSystem;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	String getSerialNumber() {
		return serialNumber;
	}

	double getStorage() {
		return Double.valueOf(storage);
	}

	String getPhoneInfo() {
		return "" + brand + " " + model + ", serial number: " + serialNumber;
	}

	public String fileString() {
		return ("Phone," + brand + "," + model + "," + serialNumber + "," + storage + "," + operatingSystem + ",");
	}

	@Override
	public String toString() {
		return "Phone Info: " + (brand != null ? "Brand:" + brand + ", " : "")
				+ (model != null ? "model:" + model + ", " : "")
				+ (serialNumber != null ? "serialNumber:" + serialNumber + ", " : "")
				+ (storage != null ? "storage:" + storage + ", " : "")
				+ (operatingSystem != null ? "operatingSystem:" + operatingSystem : "") + "]";
	}

}
