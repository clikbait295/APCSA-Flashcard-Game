public class Vocabulary extends Flashcard 
{
	private String answer;
	
	public Vocabulary(String question, int points, int difficulty, String answer)
	{
		super(question, points, difficulty);
		this.answer = answer;
	}
	
	public String getAnswer()
	{
		return(answer);
	}
	
	public void setAnswer(String newAnswer)
	{
		answer = newAnswer;
	}
}
