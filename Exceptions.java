package section2project;

import java.lang.Exception;

public class Exceptions {

	public static class phoneIsAlreadyRegistered extends Exception {

		public phoneIsAlreadyRegistered(String message) {
			super(message);
		}
	}

	public static class existingContact extends Exception {

		public existingContact(String message) {
			super(message);
		}
	}

	public static class existingApp extends Exception {

		public existingApp(String message) {
			super(message);
		}
	}

	public static class noContact extends Exception {

		public noContact(String message) {
			super(message);
		}
	}

	public static class noPhone extends Exception {

		public noPhone(String message) {
			super(message);
		}
	}

	public static class noApp extends Exception {

		public noApp(String message) {
			super(message);
		}
	}

}