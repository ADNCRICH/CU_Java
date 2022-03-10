package logic;

import java.util.ArrayList;

public class UnitDeck {

	private ArrayList<CardCounter> cardsInDeck;
	private String deckName;

	public UnitDeck(String deckName) {
		this.setDeckName(deckName);
		this.setCardsInDeck(new ArrayList<CardCounter>());
	}

	public void addCard(UnitCard newCard, int count) {
		if (count < 1)
			return;
		for (CardCounter x : cardsInDeck) {
			if (x.getCard() == newCard) {
				x.setCount(x.getCount() + count);
				return;
			}
		}
		cardsInDeck.add(new CardCounter(newCard, count));
	}

	public void removeCard(UnitCard toRemove, int count) {
		if (count < 1)
			return;
		for (int i=0;i<cardsInDeck.size();i++) {
			if (cardsInDeck.get(i).getCard().equals(toRemove)) {
				if (cardsInDeck.get(i).getCount() > count)
					cardsInDeck.get(i).setCount(cardsInDeck.get(i).getCount() - count);
				else
					cardsInDeck.remove(i);
					
			}
		}
	}

	public int cardCount() {
		int s = 0;
		for (CardCounter x : cardsInDeck) {
			s += x.getCount();
		}
		return s;
	}

	public boolean existsInDeck(UnitCard card) {
		for (CardCounter x : cardsInDeck) {
			if (x.getCard().equals(card) && x.getCount() >= 1)
				return true;
		}
		return false;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnitDeck other = (UnitDeck) obj;
		if (deckName == null) {
			if (other.deckName != null)
				return false;
		} else if (!deckName.equals(other.deckName))
			return false;
		return true;
	}

	public ArrayList<CardCounter> getCardsInDeck() {
		return cardsInDeck;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
		this.cardsInDeck = cardsInDeck;
	}

	public void setDeckName(String deckName) {
		if (deckName.isBlank())
			deckName = "Untitled Deck";
		this.deckName = deckName;
	}

}
