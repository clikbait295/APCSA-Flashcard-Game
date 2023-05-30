public class Flashcard {
	private String question;
	private int points;
	private int difficulty;
	
	public Flashcard(String question, int points, int difficulty)
	{
		this.question = question;
		this.points = points;
		this.difficulty = difficulty;
	}
	
	public String getQuestion()
	{
		return(question);
	}
	
	public void setQuestion(String newQuestion)
	{
		question = newQuestion;
	}
	
	public int getPoints()
	{
		return(points);
	}
	
	public void setPoints(int newPoints)
	{
		points = newPoints;
	}
	
	public int getDifficulty()
	{
		return(difficulty);
	}
	
	public void setDifficulty(int newDifficulty)
	{
		difficulty = newDifficulty;
	}
}
