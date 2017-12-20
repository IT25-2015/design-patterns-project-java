package shapes;

public interface Moveable {
	/**
	 * Moves shape to given x,y coordinates
	 * 
	 * @param x
	 * @param y
	 */
	public void moveTo(int x, int y);

	/**
	 * Moves shape for given x,y coordinates
	 * 
	 * @param x
	 * @param y
	 */
	public void moveFor(int x, int y);
}
