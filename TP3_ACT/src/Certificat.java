
public interface Certificat {
	//retournera vrai SSi le certificat est bien correct pour le pb auquel il est associé
	public boolean estCorrect();
	
	//pour pouvoir énumérer les certificats, on définit un ordre sur les certificats
	//le certificat prend la valeur suivante dans l’ordre choisi
	public void suivant();
	
	//le certificat est le dernier dans l’ordre choisi
	public boolean estDernier();
	
	//le certificat prend une valeur alétaoire
	public void alea();
	public void affiche();
}
