// Subclass of Flashcard that stores the extra data needed for a true or false question.
public class TrueFalse extends Flashcard 
{
	// The correct answer.
	private boolean answer;
	
	/* Constructor for the TrueFalse class.
	 * Precondition: question must be a String, points must be an integer, difficulty must be an integer, answer must be a boolean.
	 * Postcondition: question, points, difficulty, and answer are initialized.
	*/
	public TrueFalse(String question, int points, int difficulty, boolean answer)
	{
		super(question, points, difficulty);
		this.answer = answer;
	}
	
	/* Returns the correct answer.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public boolean getAnswer()
	{
		return(answer);
	}
	
	/* Updates the correct answer.
	 * Precondition: newAnswer is a boolean.
	 * Postcondition: answer stores the value of newAnswer.
	*/
	public void setAnswer(boolean newAnswer)
	{
		answer = newAnswer;
	}
}
