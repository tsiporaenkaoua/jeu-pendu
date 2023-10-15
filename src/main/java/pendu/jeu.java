package pendu;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class jeu {
	
	//jeu de données
	public static final String[] sentences = {"norme", "ordinateur", "java", "voiture", "canard"};
	public static final int countTry = 6;
	public static Scanner sc = new Scanner(System.in);
	public static int essai = 0;
	
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
			sc.nextLine();
		}
		return saisie;
	}
	
	//Génération du jeu
	public static void launchGame() {
		System.out.println("Début du jeu");
		System.out.println("Génération d'un mot...");
		//Récupération du mot
		String sentence = getSentence();
		String[] sentenceWithSecret = initialiseSentenceWithSecret(sentence);
		boolean found= false;
		while(essai < countTry && !found) {
			System.out.println("Voici l'état actuel du jeu " + displaySentenceWithSecret(sentenceWithSecret));
			getAndModifySentenceWithSecret( sentenceWithSecret, sentence );
			found = checkIfSentenceFounded (sentenceWithSecret);
		}
		if(found) {
			System.out.println("Bravo! vous avez touvé le mot " + sentence );
		}else {
			System.out.println("Perdu... Le mot était " + sentence );
		}
	}


	//affichage de n'avancée dees lettres trouvées dans notre code
	private static String displaySentenceWithSecret(String[] sentenceWithSecret) {
		String stringToDisplay = "";
		for(int i = 0; i<sentenceWithSecret.length; i++) {
			stringToDisplay += sentenceWithSecret[i];
		}
		return stringToDisplay;
		
	}
	
	public static boolean checkIfSentenceFounded(String[] sentenceWithSecret) {
		return Arrays.stream(sentenceWithSecret).noneMatch(caractere->caractere.equals("_"));
		
	}
	
	public static void getAndModifySentenceWithSecret(String[] sentenceWithSecret, String sentence) {
		System.out.println("Entrez un caractère : ");
		String saisie = sc.nextLine();
		if(!sentence.contains(saisie)) {
			essai++;
			System.out.println("La lettre " + saisie + " n'est pas contenue dans le mot secret.");
		}else {
			for(int i = 0; i<sentence.length(); i++) {
				if(sentence.charAt(i)==saisie.charAt(0)) {
					sentenceWithSecret[i]=saisie;
				}
			} 	
		}
	}

	
	//display le mot en underscore
	public static String[] initialiseSentenceWithSecret(String sentence) {
		String[] sentenceSecret = new String[sentence.length()];
		Arrays.fill(sentenceSecret,"_");
		return sentenceSecret;
	}

	
	//Séléction du mot de maniere aléatoire
		public static String getSentence() {
			Random random = new Random();
			return sentences[random.nextInt(sentences.length)];//un tableau est retourné
		}
		
	



	
	


	
	
}
