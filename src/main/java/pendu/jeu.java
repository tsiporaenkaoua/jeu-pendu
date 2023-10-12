package pendu;
import java.util.Scanner;
import java.util.Random;

public class jeu {
	
	//jeu de données
	public static final String[] sentences = {"norme", "ordinateur", "java", "voiture", "canard"};
	public static final int essai = 6;
	public static Scanner sc = new Scanner(System.in);
	public static String foundingWord = "";
	
	
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
		
		int countTry=0;
		boolean found = false;
		displaySecretWord(word);
		while(countTry<essai && !found) {
		countTry++;
		System.out.println("Voici l'avancée de votre jeu" + foundingWord);
		foundingWord = displayLetterFound(word);
		}
	}

	

	//Séléction du mot
	public static String getWord() {
		Random random = new Random();
		return sentences[random.nextInt(sentences.length)];
	}
	
	
	//1ere affichage du texte avec underscore
	public static String displaySecretWord(String word) {
		for (int i =0; i<word.length(); i++) {
			foundingWord+="_ ";
		}
		return foundingWord;
	
	}
	
	//compare et affiche les lettres du mot trouvées
		public static String displayLetterFound(String word) {
			System.out.println("Entrez une lettre : ");
			char letter = sc.nextLine().charAt(0);//on ne peut pas directement récuperer un char
			foreach element of word{
				if(letter = element) {
					int index = word.indexOf(letter);
					
				}
				return foundingWord;
				}
			}
			
		}
	
	
}
