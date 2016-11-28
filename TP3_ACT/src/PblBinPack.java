import java.util.ArrayList;
import java.util.List;

public class PblBinPack extends PblDec{
	
	protected List<Objet> objets;
	protected List<Sac> sacs;
	protected Certificat certificat;
	
	public PblBinPack(int nbObjets, int[] poids, int nbSacs, int poidsSacs) {
		this.objets = new ArrayList<Objet>();
		this.sacs = new ArrayList<Sac>();
		
		for(int i = 0; i < nbObjets; i++)
			objets.add(new Objet(poids[i]));
		for(int i = 0; i < nbSacs; i++)
			this.sacs.add(new Sac(poidsSacs));
	}

	@Override
	public boolean aUneSolution() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Algo non déterministe
	//si il y a une solution, au moins une exécution doit retourner Vrai
	// sinon, toutes les exécutions doivent retourner Faux
	public boolean aUneSolutionNonDeterministe() {
		return false;
		//génère alétaoirement un certificat et vérifie si il est correct ..
	}

}
