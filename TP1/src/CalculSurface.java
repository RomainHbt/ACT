import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class CalculSurface {
	
	public static long l;
	public static long h;
	public static long nbPoints;
	public static long[][] points;
	public static List<Point> listPoints;

	public static void main(String[] args) {
		listPoints = new ArrayList<Point>();
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
			
			Point firstPoint = new Point(0, 0);
			listPoints.add(firstPoint);
			
			int i = 1;
			while ((ligne=br.readLine())!=null){
				String[] coords = ligne.split(" ");
				points[i][0] = Long.parseLong(coords[0]);
				points[i][1] = Long.parseLong(coords[1]);
				Point currentPointParsed = new Point(Long.parseLong(coords[0]), Long.parseLong(coords[1]));
				listPoints.add(currentPointParsed);
				i++;
			}
			br.close();
			points[i][0] = l;
			points[i][1] = 0;
			Point lastPoint = new Point(l, 0);
			listPoints.add(lastPoint);
			
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
		Point lastPoint = new Point(0, 0);
		lastPoint = listPoints.get(listPoints.size() - 1);
		return calculRecursif(listPoints, 0, lastPoint.getX());
	}
	
	public static long calculRecursif(List<Point> newPoints, long indexGauche, long indexDroite){
		List<Point> partieGauche = new ArrayList<Point>();
		List<Point> partieDroite = new ArrayList<Point>();
		
		if (indexDroite - indexGauche > 0 && !newPoints.isEmpty()){
			
			long hauteurMin = h;
			int pointDeSeparation = 0;
			
			for (int i = 0; i < newPoints.size(); i++) {
				if(newPoints.get(i).getY() != 0 & newPoints.get(i).getY() < hauteurMin){
					hauteurMin = newPoints.get(i).getY();
					pointDeSeparation = i;
				}
			}
			
			long surface = (indexDroite - indexGauche) * hauteurMin;
			
			if (pointDeSeparation > 0){
				partieGauche = newPoints.subList(0, pointDeSeparation);
			}
			
			if (pointDeSeparation < newPoints.size()){
				partieDroite = newPoints.subList(pointDeSeparation + 1, newPoints.size());
			}
			
			long newSurface = Long.max(calculRecursif(partieGauche, indexGauche, newPoints.get(pointDeSeparation).getX()),
					calculRecursif(partieDroite, newPoints.get(pointDeSeparation).getX(), indexDroite));
			return Long.max(surface, newSurface);
		}
		else
			return 0;
	}

}
