import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CalculSurface {
	
	public static long l;
	public static long h;
	public static long nbPoints;
	public static long[][] points;

	public static void main(String[] args) {
		
		String fichier ="./donneesPourTests/ex500_7616";
		
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
			
			while ((ligne=br.readLine())!=null){
				
			}
			br.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
		

	}
	
	public int calcul(){
		
		
		return 0;
	}

}
