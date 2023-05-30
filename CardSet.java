import java.util.ArrayList;

public class CardSet 
{
	private ArrayList<Flashcard> cardList;
	private int numCards;
	private double avgDifficulty;
	private int totalPoints;
	private String name;
	
	public CardSet(String name)
	{
		cardList = new ArrayList<Flashcard>();
		numCards = 0;
		avgDifficulty = 0;
		totalPoints = 0;
		this.name = name;
	}
	
	public void addCard(Flashcard newCard)
	{
		cardList.add(newCard);
		numCards++;
		totalPoints += newCard.getPoints();
		updateAvgDifficulty();
	}
	
	public Flashcard getCard(int index)
	{
		return(cardList.get(index));
	}
	
	public void updateAvgDifficulty()
	{
		int difficultySum = 0;
		
		for (Flashcard card : cardList)
		{
			difficultySum += card.getDifficulty();
		}
		
		avgDifficulty = (double) difficultySum / numCards;
	}
	
	public int getNumCards()
	{
		return(numCards);
	}
	
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
