package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import pkgEnum.eRank;
import pkgEnum.eSuit;
//last commit
public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		cardsInDeck = new ArrayList<Card>();
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}
	
	public Card Draw() {
		//attempt to remove the first card
		try {
			return cardsInDeck.remove(0);
		}
		//catch the exception that there's no cards
		//throw the "There's no cards left"
		catch (Exception EXCEPT) {
			System.out.println("No cards left");
			throw EXCEPT;
			}
	}
	public Card Draw(eSuit eSuit) {
			for (Card newCard: this.cardsInDeck) {
					if (newCard.geteSuit() == eSuit) {
						cardsInDeck.remove(newCard);
						return newCard;
					}
			}
			return null;
	}
	
	public Card Draw(eRank eRank) {
		for (Card newCard: this.cardsInDeck) {
				if (newCard.geteRank() == eRank) {
					cardsInDeck.remove(newCard);
					return newCard;
				}
		}
		return null;
	}
	
	public int Count(eSuit eSuit) {
			ArrayList<Card> CardSuit = cardsInDeck.stream().filter(type -> type.geteSuit() == eSuit).collect(Collectors.toCollection(ArrayList::new));
			return CardSuit.size();
			
	}
	
	public int Count(eRank eRank) {
			ArrayList<Card> CardRank = cardsInDeck.stream().filter(type -> type.geteRank() == eRank).collect(Collectors.toCollection(ArrayList::new));
			return CardRank.size();
	}
	
	public int FinalCard(Card c) {
		for (Card cards:cardsInDeck)
		{
			if (cards == c)
				return 1;
		}
		return 0;
	}
}
