package shapes;

public interface Command {
	/**
	 * Execute command
	 */
	void execute();

	/**
	 * Unexecute command (Undo)
	 */
	void unexecute();
}
