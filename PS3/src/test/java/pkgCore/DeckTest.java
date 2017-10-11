package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.rules.ExpectedException;

import pkgEnum.eRank;

import pkgEnum.eSuit;

public class DeckTest {
	
	public ExpectedException newException = ExpectedException.none();

	@Test
	public void TestEmptyDeck() {
			Deck deck = new Deck();
			for (int i = 1; 
					i <= 52; 
					i++) {
				newException.expect(IndexOutOfBoundsException.class);
				deck.Draw();
				System.out.println("card " + i);
		}
	}
	
	@Test
	public void TestDrawSuit() {
		Deck deck = new Deck();
		for (int i = 1;
				i<= 4; 
				i++) {
			assertEquals(deck.Draw(eSuit.SPADES).geteSuit(), new Card(eSuit.SPADES,
					eRank.SEVEN).geteSuit());
		}
	}
	
	@Test
	public void TestDrawRank() {
		Deck deck = new Deck();
		for (int i = 1; 
				i <= 13; 
				i++) {
			assertEquals(deck.Draw(eRank.SEVEN).geteRank(), new Card(eSuit.CLUBS, eRank.SEVEN).geteRank());
		}
	}
	
	public void TestDeckRankCount() {
		Deck deck = new Deck();
		for (int i = 13; 
				i > 0; 
				i--) {
			assertEquals(deck.Count(eRank.JACK), i);
				deck.Draw(eRank.JACK);
		}
	}
	
	public void TestDeckSuitCount() {
		Deck deck = new Deck();
		for (int i = 4; 
				i > 0; 
				i--) {
			assertEquals(deck.Count(eSuit.DIAMONDS), i);
				deck.Draw(eSuit.DIAMONDS);
		}
	}
}
