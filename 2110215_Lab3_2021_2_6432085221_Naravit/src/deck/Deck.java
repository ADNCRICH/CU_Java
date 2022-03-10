package deck;


import java.util.Arrays;

import card.base.Card;


public class Deck {
	// TODO: constructor
	private String name;
	private int deckSize;
	private Card[] deckList;
	
	public Deck(String name, Card[] deckList) {
		this.name = name;
		setDeckSize(deckList.length);
		this.deckList = deckList;
	}

	//You CAN modify the first line
		public int insertCard(Card card) throws InsertCardFailedException{
			int count = 0;
			for(int i=0;i<deckSize;i++)
				if(card == deckList[i])
					count++;
			if(count >= 4) 
				throw new InsertCardFailedException("You can only put 4 of the same cards into the deck");
			//FILL CODE HERE
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size
			//Must return new deckSize
			Card[] reCards = Arrays.copyOf(deckList,deckSize+1); 
			reCards[deckSize] = card;
			setDeckSize(deckSize+1);
			deckList = reCards;
			return deckSize;
		}

		//You CAN modify the first line
		public Card removeCard(int slotNumber) throws RemoveCardFailedException {
			if (this.deckList.length <= slotNumber) {
				throw new RemoveCardFailedException("Number you insert exceed deck size");
			}		
			if (this.deckList[slotNumber] == null) {
				throw new RemoveCardFailedException("There is no card in that slot");
			}
			//FILL CODE HERE
			//You can use Arrays.copyOf(Original Array, New Length) to create new arrays with bigger size (Added slot is empty)
			//Once card is removed, other card down the list must rearrange to the empty slot
			//Must return card that was removed
			Card re = deckList[slotNumber];
			for(int i=slotNumber;i<deckSize-1;i++)
				deckList[i] = deckList[i+1];
			deckList = Arrays.copyOf(deckList, deckSize-1);
			setDeckSize(deckSize-1);
			return re;
		}

	@Override
	public String toString() {
		return new StringBuilder()
				.append("{").append(this.getName()).append("}")
				.append("(").append(this.getDeckSize()).append(" deck size)")
				.toString();
	}
	
	/* GETTERS & SETTERS */
	public String getName() {
		return name;
	}

	public int getDeckSize() {
		return deckSize;
	}

	public Card[] getDeckList() {
		return deckList;
	}

	public void setDeckSize(int deckSize) {
		this.deckSize = deckSize;
	}

	
	

	

}
