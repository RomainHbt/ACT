import java.util.ArrayList;
import java.util.List;

public class Sac {
	
	protected int capacite;
	protected List<Objet> objets;
	
	public Sac(int capacite){
		this.capacite = capacite;
		this.objets = new ArrayList<Objet>();
	}
	
	public int getCapacite(){
		return this.capacite;
	}
	
	public List<Objet> getObjets(){
		return this.objets;
	}
	
	public void ajouter(Objet objet){
		this.objets.add(objet);
	}
	
	public void vider(){
		this.objets.clear();
	}
	
	public int getPoidsTotal(){
		int poidsTotal = 0;
		for (Objet objet : this.objets){
			poidsTotal += objet.getPoids();
		}
		return poidsTotal;
	}
	
	public boolean estSurcharge(){
		return this.getPoidsTotal() > this.getCapacite();
	}
	
}
