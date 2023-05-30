public class TrueFalse extends Flashcard 
{
	private boolean answer;
	
	public TrueFalse(String question, int points, int difficulty, boolean answer)
	{
		super(question, points, difficulty);
		this.answer = answer;
	}
	
	public boolean getAnswer()
	{
		return(answer);
	}
	
	public void setAnswer(boolean newAnswer)
	{
		answer = newAnswer;
	}
}
