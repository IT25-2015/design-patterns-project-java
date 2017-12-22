package shapes;

import java.io.Serializable;

public interface Command extends Serializable {
	/**
	 * Execute command
	 */
	void execute();

	/**
	 * Unexecute command (Undo)
	 */
	void unexecute();
}
