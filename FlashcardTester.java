import java.util.Scanner;
import java.util.ArrayList;


public class FlashcardTester 
{
	public static void main(String[] args) 
	{
		ArrayList<CardSet> allCards = new ArrayList<CardSet>();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the flashcard game!");
		
		while (true)
		{
			System.out.println("\nDo you want to make a [n]ew flashcard set or [p]ractice a set?");
			System.out.println("Enter e if you want to exit.");
			
			String userIntent = input.nextLine();
			
			if (userIntent.equals("e"))
			{
				input.close();
				System.exit(0);
			}
			else if (userIntent.equals("p"))
			{
				if (allCards.size() == 0)
				{
					System.out.println("No flashcard sets created yet. Please make at least one set to practice.");
					continue;
				}
				//whatever
				for (int i = 0; i < allCards.size(); i++)
				{
					CardSet currentSet = allCards.get(i);
					System.out.print((i + 1) + ". " + currentSet.getName() + "\t");
					System.out.print(" | Difficulty: " + currentSet.getAvgDifficulty() + "\t");
					System.out.print(" | Total points: " + currentSet.getTotalPoints() + "\t");
					System.out.println(" | " + currentSet.getNumCards() + " card(s)");
				}
				
				System.out.println("Please enter an integer 1-" + (allCards.size()) + " to choose the set you want to practice.");
				int practice = input.nextInt();
				input.nextLine();
				
				CardSet practiceSet = allCards.get(practice - 1);
				int pointsEarned = 0;
				
				while (true)
				{
					int randomIndex = (int) (Math.random() * practiceSet.getNumCards());
					if (practiceSet.getCard(randomIndex) instanceof MultipleChoice)
					{
						MultipleChoice mcq = (MultipleChoice) practiceSet.getCard(randomIndex);
						System.out.println(mcq.getQuestion());
						String[] choices = mcq.getChoices();
						System.out.println("1. " + choices[0]);
						System.out.println("2. " + choices[1]);
						System.out.println("3. " + choices[2]);
						System.out.println("4. " + choices[3]);
						System.out.println("\nAnswer (1-4) or 5 to stop: ");
						int userAnswer = input.nextInt();
						input.nextLine();
						
						if (userAnswer == 5)
						{
							System.out.println("\nYou earned: " + pointsEarned + " points!");
							System.out.println("Ending practice, going back to main menu.");
							break;
						}
						else if (userAnswer == mcq.getAnswerIndex() + 1)
						{
							System.out.println("Correct! +" + mcq.getPoints() + " points\n");
							pointsEarned += mcq.getPoints();
						}
						else
						{
							System.out.println("Incorrect. Try again next time!\n");
						}
					}
					else if (practiceSet.getCard(randomIndex) instanceof TrueFalse)
					{
						TrueFalse tf = (TrueFalse) practiceSet.getCard(randomIndex);
						System.out.println(tf.getQuestion());
						System.out.println("Answer [t]rue, [f]alse, or e to exit.");
						String userAnswer = input.nextLine();
						
						if (userAnswer.equals("e"))
						{
							System.out.println("\nYou earned: " + pointsEarned + " points!");
							System.out.println("Ending practice, going back to main menu.");
							break;
						}
						else if (userAnswer.equals("t") && tf.getAnswer())
						{
							System.out.println("Correct! +" + tf.getPoints() + " points\n");
							pointsEarned += tf.getPoints();
						}
						else if (userAnswer.equals("f") && !tf.getAnswer())
						{
							System.out.println("Correct! +" + tf.getPoints() + " points\n");
							pointsEarned += tf.getPoints();
						}
						else
						{
							System.out.println("Incorrect. Try again next time!\n");
						}
					}
					else
					{
						Vocabulary vocab = (Vocabulary) practiceSet.getCard(randomIndex);
						System.out.println(vocab.getQuestion());
						System.out.println("Answer (e to exit): ");
						String userAnswer = input.nextLine();
						
						if (userAnswer.equals("e"))
						{
							System.out.println("\nYou earned: " + pointsEarned + " points!");
							System.out.println("Ending practice, going back to main menu.");
							break;
						}
						else if (userAnswer.equals(vocab.getAnswer()))
						{
							System.out.println("Correct! +" + vocab.getPoints() + " points\n");
							pointsEarned += vocab.getPoints();
						}
						else
						{
							System.out.println("Incorrect. Try again next time!\n");
						}
					}
				}
			}
			else if (userIntent.equals("n"))
			{
				//whatever
				// different types of flashcards
				// vocab
				// multiple choice
				// true or false
				// flashcard --> question, points, difficulty
				System.out.println("What would you like to name this flashcard set?");
				String name = input.nextLine();
				CardSet newSet = new CardSet(name);
				
				System.out.println("How many flashcards would you like to add to this flashcard set?");
				int numCards = input.nextInt();
				input.nextLine();
				
				for (int i = 0; i < numCards; i++)
				{
					System.out.println("\nWhat type of flashcard do you want to add?");
					System.out.println("Options: [m]ultiple choice, [v]ocab, [t]rue/false");
					String type = input.nextLine();
					
					System.out.println("What question do you want on the flashcard?");
					String question = input.nextLine();
					
					if (type.equals("m"))
					{
						System.out.println("Now you will enter each of the 4 answer choices.");
						String[] choices = new String[4];
						
						for (int j = 0; j < 4; j++)
						{
							System.out.println("Please enter answer choice #" + (j+1) + ": ");
							String option = input.nextLine();
							choices[j] = option;
						}
						
						System.out.println("Which option is the correct answer?");
						System.out.println("Enter an integer 1-4 matching the correct answer choice.");
						int answerIndex = input.nextInt() - 1;
						input.nextLine();
						
						System.out.println("How difficult is this question?");
						System.out.println("Enter an integer 1-10, 1 is easy, 10 is hard.");
						int difficulty = input.nextInt();
						input.nextLine();
						
						System.out.println("How many points is this flashcard worth?");
						int points = input.nextInt();
						input.nextLine();
						
						MultipleChoice newCardMCQ = new MultipleChoice(question, points, difficulty, choices, answerIndex);
						newSet.addCard(newCardMCQ);
					}
					else if (type.equals("v"))
					{
						System.out.println("Please enter the correct vocabulary word.");
						String answer = input.nextLine();
						
						System.out.println("How difficult is this question?");
						System.out.println("Enter an integer 1-10, 1 is easy, 10 is hard.");
						int difficulty = input.nextInt();
						input.nextLine();
						
						System.out.println("How many points is this flashcard worth?");
						int points = input.nextInt();
						input.nextLine();
						
						Vocabulary newCardVocab = new Vocabulary(question, points, difficulty, answer);
						newSet.addCard(newCardVocab);
					}
					else if (type.equals("t"))
					{
						System.out.println("Is the correct answer [t]rue or [f]alse?");
						String answerTF = input.nextLine();
						boolean answer = true;
						
						if (answerTF.equals("f"))
							answer = false;
						
						System.out.println("How difficult is this question?");
						System.out.println("Enter an integer 1-10, 1 is easy, 10 is hard.");
						int difficulty = input.nextInt();
						input.nextLine();
						
						System.out.println("How many points is this flashcard worth?");
						int points = input.nextInt();
						input.nextLine();
						
						TrueFalse newCardTF = new TrueFalse(question, points, difficulty, answer);
						newSet.addCard(newCardTF);
					}
					else
					{
						System.out.println("Input not recognized. Please try again!");
						i--;
					}
				}
				allCards.add(newSet);
			}
			else
			{
				System.out.println("Input not recognized. Please try again!\n");
			}
		}
	}
}