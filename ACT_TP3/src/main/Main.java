package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import binpack.PblBinPack;

public class Main {
	
	@SuppressWarnings("resource")
	private static int choixProbleme() {
		System.out.println("\nVeuillez choisir un probl�me parmis les suivants (indiquer num�ro) :");
		System.out.println("1. BinPack");
		System.out.println("2. Partition");
		System.out.println("3. Sum");
		System.out.print("Num�ro du probl�me : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		if(tmp < 1 || tmp > 3) {
			System.err.println("Num�ro de probl�me invalide");
			return 0;
		}
		return tmp;
	}
	
	@SuppressWarnings("resource")
	private static int entrerNombreDeSacs() {
		System.out.print("\nNombre de sacs : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		if(tmp < 1) {
			System.err.println("Veuillez indiquer un entier positif\n");
			return -1;
		}
		return tmp;
	}
	
	@SuppressWarnings("resource")
	private static String entrerMode() {
		System.out.println("\nVeuillez choisir un mode d'ex�cution parmis les suivants :");
		System.out.println("Exhaustif (exh)");
		System.out.println("Non d�terministe (nd)");
		System.out.println("V�rification (ver)");
		System.out.print("Mode : ");
		Scanner scan = new Scanner(System.in);
		String tmp = scan.next();
		if(!tmp.equals("exh") && !tmp.equals("nd") && !tmp.equals("ver")) {
			System.err.println(tmp + " Mode non valide\n");
			return "";
		}
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
			
			/* Fichier � lire */
			br = new BufferedReader(new FileReader("DonTPNP/BinPack/exBPeq1"));
			
			/* Lecture des donn�es du fichier */
			capacite = Integer.parseInt(br.readLine());
			nbObjets = Integer.parseInt(br.readLine());
			poids = new int[nbObjets];
			for(int i = 0; i < nbObjets; i++)
				poids[i] = Integer.parseInt(br.readLine());
			
			/* Saisie du nombre de sacs */
			nbSacs = -1;
			while(nbSacs == -1)
				nbSacs = entrerNombreDeSacs();
			
			/* Choix du mode d'ex�cution */
			mode = "";
			while(!mode.equals("exh") && !mode.equals("nd") && !mode.equals("ver"))
				mode = entrerMode();
			
			/* Initialisation de BinPack */
			PblBinPack binPack = new PblBinPack(nbObjets, poids, nbSacs, capacite);
			
			switch(mode) {
				case "exh":
					res = binPack.aUneSolution();
					if(res) {
						System.out.println("Solution trouv�e:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Aucune solution trouv�e");
					break;
				case "nd":
					res = binPack.aUneSolutionNonDeterministe();
					if(res) {
						System.out.println("Solution non d�terministe trouv�e:\n");
						binPack.getCertificat().affiche();
					} else
						System.out.println("Le certificat g�n�r� n'est pas une solution.");
					break;
				default:
					System.out.println("V�rification pas encore impl�ment�e");
					break;
			}
			
			break;
			
		default:
			System.err.println("An error occured during the problem choice");
			break;
		}

	}

}
