package pizza;

public abstract class Garniture {
	
	private int x;
	private int y;
	
	public Garniture(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() { return this.x; }
	
	public int getY() { return this.y; }
	
	public abstract boolean isHam();
	public abstract String toString();

}
