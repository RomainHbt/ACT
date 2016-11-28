import java.util.Map;
import java.util.TreeMap;


public class GrayOptimizer {
	
	public int[] palette;

	public void meilleurGris(int premierGris, int dernierGris){
		
		// Calcul de poids
		Map<Integer, Integer> poidsCouleur = new TreeMap<>();
		for (int i = premierGris; i < dernierGris; i++) {
			if(poidsCouleur.containsKey(i)){
				poidsCouleur.put(i, poidsCouleur.get(i) + 1);
			} else {
				poidsCouleur.put(i, 1);
			}
		}
		
		// Calcul de la distance minimale
		int distanceMinimale
		for (int i = 0; i < array.length; i++) {
			if(this.distanceMin() < distanceMinimale){
				
			}
		}
		
		
		// Calcul de la moyenne (apres fusion)
		
	}
	
	public int distanceMin(){
		
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
