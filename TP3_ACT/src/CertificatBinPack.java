import java.util.List;
import java.util.Random;

public class CertificatBinPack implements Certificat {
	
	protected PblBinPack pb; //le pb auquel est associe le certificat
	protected int[] repartition;
	protected int nbSacs;
	protected int nbObjets;

	
	public CertificatBinPack(PblBinPack binPack){
		this.pb = binPack;
		this.nbSacs = binPack.sacs.size();
		this.nbObjets = binPack.objets.size();
		this.repartition = new int[this.nbObjets];
	}
	
	public boolean estCorrect() {
		int nbObjets = 0;
		for (Sac sac : this.pb.sacs){
			nbObjets += sac.objets.size();
			if (sac.estSurcharge())
				return false;
		}
		if (nbObjets != this.nbObjets){
			return false;
		}
		return true;
	}
	
	public void ajouterObjetsDansSacs() {
		this.pb.viderSacs();
		this.ajouterObjetsDansSacs();
		List<Sac> sacs = this.pb.getSacs();
		List<Objet> objets = this.pb.getObjets();
		for(int i = 0; i < this.nbObjets; i++)
			sacs.get(repartition[i]).ajouter(objets.get(i));
	}

	public void suivant() {
		System.out.println("NEXT");
		int lastIndex = this.nbSacs - 1;
		for (int i = this.repartition.length - 1; i >= 0; i--){
			if (this.repartition[i] == lastIndex)
				// Si l'on est sur le dernier index , on revient à zéro (Premier sac)
				this.repartition[i] = 0;
			else
				// Sinon on incrémente (Sac suivant)
				this.repartition[i]++;
		}
	}

	public boolean estDernier() {
		int lastIndex = this.nbSacs - 1;
		for (int i = this.repartition.length - 1; i >= 0; i--){
			if (this.repartition[i] != lastIndex)
				return false;
		}
		return true;
	}

	public void alea() {
		Random random = new Random();
		for (int i = 0; i < this.nbObjets; i++)
			this.repartition[i] = random.nextInt(this.nbSacs);
	}

	public void affiche() {
		for (int i = 0; i < this.repartition.length; i++){
			System.out.print(this.repartition[i] + " - ");
		}
		System.out.println(this.pb.toString());
	}

}
