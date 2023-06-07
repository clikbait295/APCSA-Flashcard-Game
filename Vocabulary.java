// Subclass of Flashcard that stores the extra data needed for a vocabulary question.
public class Vocabulary extends Flashcard 
{
	// The correct answer.
	private String answer;
	
	/* Constructor for the Vocabulary class.
	 * Precondition: question must be a String, points must be an integer, difficulty must be an integer, answer must be a String.
	 * Postcondition: question, points, difficulty, and answer are initialized.
	*/
	public Vocabulary(String question, int points, int difficulty, String answer)
	{
		super(question, points, difficulty);
		this.answer = answer;
	}
	
	/* Returns the correct answer.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public String getAnswer()
	{
		return(answer);
	}
	
	/* Updates the correct answer.
	 * Precondition: newAnswer is a String.
	 * Postcondition: answer stores the value of newAnswer.
	*/
	public void setAnswer(String newAnswer)
	{
		answer = newAnswer;
	}
}
