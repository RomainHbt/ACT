
public class PblBinPack extends PblDec{
	
	private int nbObjets;
	private int poids[];
	private int cap;
	private int nbSacs;

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
