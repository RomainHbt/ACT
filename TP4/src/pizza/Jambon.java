package pizza;

public class Jambon extends Garniture {

	public Jambon(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isHam() {
		return true;
	}

	@Override
	public String toString() {
		return "H";
	}

}
