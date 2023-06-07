// Provides the superclass for all types of Flashcards.
public class Flashcard {
	// The question on the flashcard.
	private String question;
	// How many points the flashcard is worth.
	private int points;
	// Difficulty of the flashcard on a scale of 1-10.
	private int difficulty;
	
	/* Constructor for the FlashCard class.
	 * Precondition: question must be a String, points must be an integer, difficulty must be an integer.
	 * Postcondition: question, points, and difficulty are initialized.
	*/
	public Flashcard(String question, int points, int difficulty)
	{
		this.question = question;
		this.points = points;
		this.difficulty = difficulty;
	}
	
	/* Returns the question on the flashcard.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public String getQuestion()
	{
		return(question);
	}
	
	/* Updates the question on the flashcard.
	 * Precondition: newQuestion is a String.
	 * Postcondition: question stores the value of newQuestion.
	*/
	public void setQuestion(String newQuestion)
	{
		question = newQuestion;
	}
	
	/* Returns how many points the flashcard is worth.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public int getPoints()
	{
		return(points);
	}
	
	/* Updates how many points the flashcard is worth.
	 * Precondition: newPoints is an integer.
	 * Postcondition: points stores the value of newPoints.
	*/
	public void setPoints(int newPoints)
	{
		points = newPoints;
	}
	
	/* Returns the difficulty of the flashcard.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public int getDifficulty()
	{
		return(difficulty);
	}

	/* Updates how the difficulty of the flashcard.
	 * Precondition: newDifficulty is an integer.
	 * Postcondition: difficulty stores the value of newDifficulty.
	*/
	public void setDifficulty(int newDifficulty)
	{
		difficulty = newDifficulty;
	}
}
