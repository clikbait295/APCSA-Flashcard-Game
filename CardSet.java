import java.util.ArrayList;

// Stores different types of flashcards together in one class.
public class CardSet 
{
	// ArrayList to store all the flashcards.
	private ArrayList<Flashcard> cardList;
	// Number of flashcards in the set.
	private int numCards;
	// Average difficulty of the set.
	private double avgDifficulty;
	// Total points of all the cards in the set.
	private int totalPoints;
	// Name of the flashcard set.
	private String name;
	
	/* Constructor for the CardSet class.
	 * Precondition: name must be a String.
	 * Postcondition: cardList, numCards, avgDifficulty, totalPoints, and name are initialized.
	*/
	public CardSet(String name)
	{
		cardList = new ArrayList<Flashcard>();
		numCards = 0;
		avgDifficulty = 0;
		totalPoints = 0;
		this.name = name;
	}
	
	/* Adds a new flashcard to the CardSet.
	 * Precondition: newCard must be a Flashcard.
	 * Postcondition: newCard is added to cardList, numCards increases by 1, totalPoints and avgDifficulty are updated accordingly.
	*/
	public void addCard(Flashcard newCard)
	{
		cardList.add(newCard);
		numCards++;
		totalPoints += newCard.getPoints();
		updateAvgDifficulty();
	}
	
	/* Get a flashcard stored in the CardSet.
	 * Precondition: 0 <= index < numCards, index must be an integer.
	 * Postcondition: N/A
	*/
	public Flashcard getCard(int index)
	{
		return(cardList.get(index));
	}
	
	/* Calculates the average difficulty of the CardSet by adding up the 
	 * difficulties of each of the flashcards and then dividing the sum by numCards.
	 * Precondition: numCards != 0
	 * Postcondition: N/A
	*/
	public void updateAvgDifficulty()
	{
		int difficultySum = 0;
		
		for (Flashcard card : cardList)
		{
			difficultySum += card.getDifficulty();
		}
		
		avgDifficulty = (double) difficultySum / numCards;
	}
	
	/* Returns the number of cards in the CardSet.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public int getNumCards()
	{
		return(numCards);
	}
	
	/* Returns the average difficulty of the CardSet.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public double getAvgDifficulty()
	{
		return(avgDifficulty);
	}
	
	public int getTotalPoints()
	{
		return(totalPoints);
	}
	
	public String getName()
	{
		return(name);
	}
	
	public void setName(String newName)
	{
		name = newName;
	}
}
