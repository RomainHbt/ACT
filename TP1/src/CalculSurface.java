import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;


public class CalculSurface {
	
	public static long l;
	public static long h;
	public static long nbPoints;
	public static long[][] points;

	public static void main(String[] args) {
		
		String fichier ="./donneesPourTests/ex500_7616";
		//String fichier ="./donneesPourTests/ex100000_100000";
		
		//lecture du fichier texte	
		try{
			InputStream ips=new FileInputStream(fichier); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			String[] dimensions;
			ligne=br.readLine();
			dimensions = ligne.split(" ");
			l = Long.parseLong(dimensions[0]);
			h = Long.parseLong(dimensions[1]);
			
			
			ligne=br.readLine();
			nbPoints = Long.parseLong(ligne);
			points = new long[((int) nbPoints)+2][2];
			
			points[0][0] = 0;
			points[0][1] = 0;
			int i = 1;
			while ((ligne=br.readLine())!=null){
				String[] coords = ligne.split(" ");
				points[i][0] = Long.parseLong(coords[0]);
				points[i][1] = Long.parseLong(coords[1]);
				i++;
			}
			br.close();
			points[i][0] = l;
			points[i][1] = 0;
			//Arrays.sort(points);
			
			long debut = System.currentTimeMillis();
			long res = calcul();
			System.out.println("Temps calcul simple : "+(System.currentTimeMillis()-debut));
			System.out.println(res);
			
			debut = System.currentTimeMillis();
			res = calculDiviserPourRegner();
			System.out.println("Temps diviser pour régner : "+(System.currentTimeMillis()-debut));
			System.out.println(res);
		}		
		catch (Exception e){
			System.err.println(e.toString());
		}
		

	}
	
	/**
	 * Question 1
	 * @return Surface Max
	 */
	public static long calcul(){
		long surfaceMax = 0;
		for (int i = 0; i < points.length; i++) {
			long abs1 = points[i][0];
			for (int j = i+1; j < points.length; j++) {
				long abs2 = points[j][0];
				long largeur = abs2 - abs1;
				long hauteur = h;
				long surface;

				if(j != i+1){ // Points intermédiaires
					for (int k = i+1; k < j; k++) {
						if(points[k][1] != 0 && points[k][1] < hauteur) hauteur = points[k][1];
					}
				}
				
				surface = largeur * hauteur;
				
				if(surface > surfaceMax) surfaceMax = surface;
			}
		}
		return surfaceMax;
	}
	
	/**
	 * Question 2
	 * @return Surface Max
	 */
	public static long calculDiviserPourRegner(){
		long surfaceMax = 0;
		
		long hauteurMin = h;
		int pointDeSeparation = 0;
		
		for (int i = 0; i < points.length; i++) {
			if(points[i][1] != 0 && points[i][1] < hauteurMin){
				hauteurMin = points[i][1];
				pointDeSeparation = i;
			}
		}
		
		return surfaceMax;
	}
	
	public static long calculRecursif(int pointDeSeparation, int idx){
		return 0;
	}

}
