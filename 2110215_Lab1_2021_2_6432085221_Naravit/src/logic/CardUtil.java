package logic;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CardUtil {

	public static boolean isExistsInList(UnitCard card, ArrayList<UnitCard> list) {
		for (UnitCard x : list) {
			if (x.equals(card))
				return true;
		}

		return false;

	}

	public static boolean isExistsInList(UnitDeck deck, ArrayList<UnitDeck> list) {
		for (UnitDeck x : list) {
			if (x.equals(deck))
				return true;
		}
		return false;
	}

	public static boolean cardExistsInDeckList(ArrayList<UnitDeck> deckList, UnitCard cardToTest) {

		// TODO: Fill Code
		for (UnitDeck x : deckList) {
			if (x.existsInDeck(cardToTest))
				return true;
		}
		return false;
	}

	public static ArrayList<UnitCard> getCardsFromFile(String filename) {
		try {
			File fileToRead = new File(filename);

			ArrayList<UnitCard> cardsFromFile = new ArrayList<UnitCard>();

			// TODO: Fill Code

			Scanner sc = new Scanner(fileToRead);
			while (sc.hasNextLine()) {
				String[] t = sc.nextLine().split(",");
				if (t.length != 5) {
					System.out.println("File contains string with incorrect format!");
					sc.close();
					return null;
				}
				UnitCard card = new UnitCard(t[0], Integer.parseInt(t[1]), Integer.parseInt(t[2]),
						Integer.parseInt(t[3]), t[4]);
				cardsFromFile.add(card);
			}
			sc.close();
			return cardsFromFile;
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file!");
			return null;
		} catch (Exception e) {
			System.out.println("File contains string with incorrect format!");
			return null;
		}
	}

	public static void printCardList(ArrayList<UnitCard> cardList, boolean verbose) {

		for (int i = 0; i < cardList.size(); i++) {
			System.out.println(i + ") " + cardList.get(i));
			if (verbose) {
				System.out.println("Blood Cost: " + cardList.get(i).getBloodCost());
				System.out.println(cardList.get(i).getFlavorText());
				if (i < cardList.size() - 1)
					System.out.println("-----");
			}
		}
	}

	public static void printDeck(UnitDeck ud) {

		if (ud.getCardsInDeck().size() == 0) {
			System.out.println("EMPTY DECK");
		} else {
			for (CardCounter cc : ud.getCardsInDeck()) {
				System.out.println(cc);
			}
		}

		System.out.println("Total Cards: " + ud.cardCount());
	}

	public static void printDeckList(ArrayList<UnitDeck> deckList) {

		for (int i = 0; i < deckList.size(); i++) {
			System.out.println(i + ") " + deckList.get(i).getDeckName());
			printDeck(deckList.get(i));
			if (i < deckList.size() - 1)
				System.out.println("-----");
		}
	}
}
