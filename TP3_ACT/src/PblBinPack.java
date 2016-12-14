import java.util.ArrayList;
import java.util.List;

public class PblBinPack extends PblDec{
	
	protected List<Objet> objets;
	protected List<Sac> sacs;
	protected Certificat certificat;
	
	public PblBinPack(int nbObjets, int[] poids, int nbSacs, int poidsSacs) {
		// Instanciation des listes d'objets et de sacs
		this.objets = new ArrayList<Objet>();
		this.sacs = new ArrayList<Sac>();
		
		// Ajout des objets et des sacs
		for(int i = 0; i < nbObjets; i++)
			objets.add(new Objet(poids[i]));
		for(int i = 0; i < nbSacs; i++)
			this.sacs.add(new Sac(poidsSacs));
	}
	
	public Certificat getCertificat(){
		return this.certificat;
	}

	@Override
	public boolean aUneSolution() {
		if (this.certificat == null)
			this.certificat = new CertificatBinPack(this);
		while (!this.certificat.estDernier()){
			// Tant qu'il reste des certificats à vérifier
			if (this.certificat.estCorrect()){
				// Si un des certificats est correct, on renvoie vraie
				return true;
			}
			else {
				// Sinon on passe au suivant
				this.certificat.suivant();
			}
		}
		// Cas du tout dernier certificat
		return this.certificat.estCorrect();
	}
	
	//Algo non deterministe
	//si il y a une solution, au moins une execution doit retourner Vrai
	// sinon, toutes les executions doivent retourner Faux
	public boolean aUneSolutionNonDeterministe() {
		this.certificat = new CertificatBinPack(this);
		this.certificat.alea();
		return this.certificat.estCorrect();
	}

}
