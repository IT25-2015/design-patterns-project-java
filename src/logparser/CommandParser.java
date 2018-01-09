package logparser;

public class CommandParser {
	private static CommandParser instance;

	private CommandParser() {
	}

	/**
	 * Return Thread safe singleton object also using Lazy Loading
	 * 
	 * @return
	 */
	public static CommandParser getInstance() {
		if (instance == null) {
			synchronized (CommandParser.class) {
				if (instance == null) {
					instance = new CommandParser();
				}
			}
		}
		return instance;
	}
}
