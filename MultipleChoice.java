public class MultipleChoice extends Flashcard
{
	private String[] choices;
	private int answerIndex;
	
	public MultipleChoice(String question, int points, int difficulty, String[] choices, int answerIndex)
	{
		super(question, points, difficulty);
		this.choices = choices;
		this.answerIndex = answerIndex;
	}
	
	public String[] getChoices()
	{
		return(choices);
	}
	
	public void setChoices(String[] newChoices)
	{
		choices = newChoices;
	}
	
	public int getAnswerIndex()
	{
		return(answerIndex);
	}
	
	public void setAnswerIndex(int newAnswerIndex)
	{
		answerIndex = newAnswerIndex;
	}
}
