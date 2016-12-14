import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {
	
	private static int choixProbleme() {
		System.out.println("Chosir un problème");
		System.out.println("1. BinPack");
		System.out.println("2. Partition");
		System.out.println("3. Sum");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		return tmp;
	}
	
	private static int entrerNombreDeSacs() {
		System.out.println("Nombre de sacs : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		return tmp;
	}
	
	private static String entrerMode() {
		System.out.println("Mode d'execution");
		System.out.println("Exhaustif (exh)");
		System.out.println("Non deterministe (nd)");
		System.out.println("Verification (ver)");
		Scanner scan = new Scanner(System.in);
		String tmp = scan.next();
		scan.close();
		return tmp;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		/* Choix du probl�me */
		int pb = 0;
		while(pb == 0)
			pb = choixProbleme();
		
		BufferedReader br;
		int capacite;
		int nbObjets;
		int[] poids;
		int nbSacs;
		String mode;
		boolean res;
		
		switch(pb) {
		
		/////////////
		/* BinPack */
		/////////////
		case 1:
			
			//Fichier à lire
			br = new BufferedReader(new FileReader("donnees/BinPack/exBPeq1"));
			
			// Lecture des données
			capacite = Integer.parseInt(br.readLine());
			nbObjets = Integer.parseInt(br.readLine());
			poids = new int[nbObjets];
			for(int i = 0; i < nbObjets; i++)
				poids[i] = Integer.parseInt(br.readLine());
			
			nbSacs = -1;
			while(nbSacs == -1)
				nbSacs = entrerNombreDeSacs();
			
			// Mode d'execution
			mode = "";
			while(!mode.equals("exh") && !mode.equals("nd") && !mode.equals("ver"))
				mode = entrerMode();
			
			// Init bin pack
			PblBinPack binPack = new PblBinPack(nbObjets, poids, nbSacs, capacite);
			
			switch(mode) {
				case "exh":
					res = binPack.aUneSolution();
					if(res) {
						System.out.println("Solution trouvée :");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Aucune solution");
					break;
				case "nd":
					res = binPack.aUneSolutionNonDeterministe();
					if(res) {
						System.out.println("Solution non deterministe:");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Le certificat n'est pas une solution");
					break;
				default:
					System.out.println("Not yet implemented");
					break;
			}
			
			break;
		
		default:
			System.err.println("An error occured during the problem choice");
			break;
		}

	}

}