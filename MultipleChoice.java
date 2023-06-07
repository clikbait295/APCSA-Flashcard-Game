// Subclass of Flashcard that stores the extra data needed for a multiple choice question.
public class MultipleChoice extends Flashcard
{
	// Array storing the answer choices of the question.
	private String[] choices;
	// Index of the correct answer choice.
	private int answerIndex;

	/* Constructor for the MultipleChoice class.
	 * Precondition: question must be a String, points must be an integer, difficulty must be an integer, 
	 *               choices is an array of String with length 4, answerIndex is an integer, 0 <= answerIndex < 4.
	 * Postcondition: question, points, difficulty, choices, and answerIndex are initialized.
	*/
	public MultipleChoice(String question, int points, int difficulty, String[] choices, int answerIndex)
	{
		super(question, points, difficulty);
		this.choices = choices;
		this.answerIndex = answerIndex;
	}
	
	/* Returns the answer choices on the flashcard.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public String[] getChoices()
	{
		return(choices);
	}
	
	/* Updates the answer choices on the flashcard.
	 * Precondition: newChoices is an array of String with length 4.
	 * Postcondition: choices stores the value of newChoices.
	*/
	public void setChoices(String[] newChoices)
	{
		choices = newChoices;
	}
	
	/* Returns the index of the correct answer.
	 * Precondition: N/A
	 * Postcondition: N/A
	*/
	public int getAnswerIndex()
	{
		return(answerIndex);
	}
	
	/* Updates the index of the correct answer choice.
	 * Precondition: 0 <= newAnswerIndex < 4
	 * Postcondition: answerIndex stores the value of newAnswerIndex.
	*/
	public void setAnswerIndex(int newAnswerIndex)
	{
		answerIndex = newAnswerIndex;
	}
}
