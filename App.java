package section2project;

import java.util.Objects;

public class App {
	private String name;
	private String version;
	private String size;

	public App(String name, String version, String size) {
		this.name = name;
		this.version = version;
		this.size = size;
	}

	String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void setSize(String size) {
		this.size = size;
	}

	double getSize() {
		return Double.valueOf(size);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, size, version);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		App other = (App) obj;
		return Objects.equals(name, other.name) && Objects.equals(size, other.size)
				&& Objects.equals(version, other.version);
	}

	@Override
	public String toString() {
		return "App Info: " + (name != null ? "Name: " + name + ", " : "")
				+ (version != null ? " version: " + version + ", " : "") + (size != null ? " size: " + size : "") + "]";
	}
	public String fileString() {
		return ("App," + name + ","
				+ version + "," + size +",");
	}

}
