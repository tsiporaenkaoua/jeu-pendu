package pendu;
import java.util.Scanner;
import java.util.Random;

public class jeu {
	
	//jeu de données
	public static final String[] sentences = {"norme", "ordinateur", "java", "voiture", "canard"};
	public static final int essai = 6;
	public static Scanner sc = new Scanner(System.in);
	
	//MAIN
	public static void main(String[] args) {
		System.out.println("Bienvenue dans notre jeu le pendu !");
		int saisie = selectChoice();
		switch (saisie) {
		case 0 :
			launchGame();
			break;
		case 1 :
			System.exit(0);
		}
	}

	
	//Jouer ou non
	public static int selectChoice() {
		int saisie=2;
		//menu
		while(saisie!=0 && saisie!=1) {
			System.out.println("Entrer 0 pour commencer, 1 pour quitter.");
			saisie = sc.nextInt();
		}
		return saisie;
	}
	
	//Génération du jeu
	public static void launchGame() {
		System.out.println("Début du jeu");
		System.out.println("Génération d'un mot...");
		String word = getWord();
		
	}

	//Séléction du mot
	public static String getWord() {
		Random random = new Random();
		return sentences[random.nextInt(sentences.length)];
	}
	
	
}
