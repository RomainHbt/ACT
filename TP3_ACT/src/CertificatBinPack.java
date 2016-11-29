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
	
	@Override
	public boolean estCorrect() {
		for (Sac sac : this.pb.sacs){
			if (sac.estSurcharge())
				return false;
		}
		return true;
	}

	@Override
	public void suivant() {
		int lastIndex = this.nbSacs - 1;
		for (int i = this.repartition.length; i >= 0; i--){
			if (this.repartition[i] == lastIndex)
				// Si l'on est sur le dernier index , on revient à zéro (Premier sac)
				this.repartition[i] = 0;
			else
				// Sinon on incrémente (Sac suivant)
				this.repartition[i]++;
		}
	}

	@Override
	public boolean estDernier() {
		int lastIndex = this.nbSacs - 1;
		for (int i = this.repartition.length; i >= 0; i--){
			if (this.repartition[i] != lastIndex)
				return false;
		}
		return true;
	}

	@Override
	public void alea() {
		Random random = new Random();
		for (int i = 0; i < this.nbObjets; i++)
			this.repartition[i] = random.nextInt(this.nbSacs);
	}

	@Override
	public void affiche() {
		System.out.println(this.pb);
	}

}
