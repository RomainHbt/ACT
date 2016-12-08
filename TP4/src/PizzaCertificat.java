import pizza.Part;
import pizza.Pizza;


public class PizzaCertificat implements Certificat {
	
	protected Pizza pizza;
	protected int c; //Surface part
	protected int n; //Nombre de jambon
	protected int surfaceTotale;
	
	public PizzaCertificat(Pizza pizza){
		this.pizza = pizza;
		this.surfaceTotale = 0;
	}

	@Override
	public boolean estCorrect() {
		for (Part p : pizza.getParts()) {
			if(!(p.isRectangle() && p.getNbJambon() >= n && p.getSurface() <= c)) return false;
			this.surfaceTotale += p.getSurface();
		}
		return true;
	}

	@Override
	public void suivant() {
		
	}

	@Override
	public boolean estDernier() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alea() {
		// TODO Auto-generated method stub

	}

	@Override
	public void affiche() {
		// TODO Auto-generated method stub

	}

}
