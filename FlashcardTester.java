// import needed classes to get user input and create ArrayLists
import java.util.Scanner;
import java.util.ArrayList;

// This is the tester class for the flashcard game
public class FlashcardTester 
{
	/*
	 * The main tester method for the flashcard game. 
	 * This is where all of the other classes are combined to create the flashcard game which can be played by the user.
	 * Preconditions: N/A
	 * Postconditions: N/A
	 */
	public static void main(String[] args) 
	{
		// Initialize Scanner input and create ArrayList to store all flashcard sets.
		ArrayList<CardSet> allCards = new ArrayList<CardSet>();
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the flashcard game!");
		
		// Use a while true loop to make sure the game goes on forever until the user decides to exit.
		while (true)
		{
			System.out.println("\nDo you want to make a [n]ew flashcard set or [p]ractice a set?");
			System.out.println("Enter e if you want to exit.");
			
			String userIntent = input.nextLine();
			
			// User wants to exit.
			if (userIntent.equals("e"))
			{
				input.close(); // Close the Scanner input to save memory and prevent memory leaks.
				System.exit(0); // Cleanly exit the program.
			}
			// User wants to practice a flashcard set.
			else if (userIntent.equals("p"))
			{
				// Check if at least 1 flashcard set is available to practice.
				if (allCards.size() == 0)
				{
					System.out.println("No flashcard sets created yet. Please make at least one set to practice.");
					continue;
				}

				// Iterate through all available flashcards and display their statistics to the user.
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
				
				/* Subtract 1 from practice because the number the user inputs 
				 * is 1 greater than the index of the corresponding flashcard set.
				 * Also, create a variable to store the total number of points earned 
				 * by the user during practice.
				*/
				CardSet practiceSet = allCards.get(practice - 1);
				int pointsEarned = 0;
				
				// Allow the user to practice until they decide to stop.
				while (true)
				{
					// Generate random index of the flashcard for the user to practice.
					int randomIndex = (int) (Math.random() * practiceSet.getNumCards());

					// Check if the flashcard is a MultipleChoice card.
					if (practiceSet.getCard(randomIndex) instanceof MultipleChoice)
					{
						MultipleChoice mcq = (MultipleChoice) practiceSet.getCard(randomIndex);
						System.out.println(mcq.getQuestion());
						String[] choices = mcq.getChoices();
						// Print out all of the answer choices.
						System.out.println("1. " + choices[0]);
						System.out.println("2. " + choices[1]);
						System.out.println("3. " + choices[2]);
						System.out.println("4. " + choices[3]);
						System.out.println("\nAnswer (1-4) or 5 to stop: ");
						int userAnswer = input.nextInt();
						input.nextLine();
						
						// User wants to stop practicing.
						if (userAnswer == 5)
						{
							System.out.println("\nYou earned: " + pointsEarned + " points!");
							System.out.println("Ending practice, going back to main menu.");
							break;
						}
						// User answer is correct.
						else if (userAnswer == mcq.getAnswerIndex() + 1)
						{
							System.out.println("Correct! +" + mcq.getPoints() + " points\n");
							pointsEarned += mcq.getPoints();
						}
						// User answer is incorrect.
						else
						{
							System.out.println("Incorrect. Try again next time!\n");
						}
					}
					// Check if the flashcard is a TrueFalse card.
					else if (practiceSet.getCard(randomIndex) instanceof TrueFalse)
					{
						TrueFalse tf = (TrueFalse) practiceSet.getCard(randomIndex);
						System.out.println(tf.getQuestion());
						System.out.println("Answer [t]rue, [f]alse, or e to exit.");
						String userAnswer = input.nextLine();
						
						//User wants to stop practicing.
						if (userAnswer.equals("e"))
						{
							System.out.println("\nYou earned: " + pointsEarned + " points!");
							System.out.println("Ending practice, going back to main menu.");
							break;
						}
						// User answer is correct, answer is true.
						else if (userAnswer.equals("t") && tf.getAnswer())
						{
							System.out.println("Correct! +" + tf.getPoints() + " points\n");
							pointsEarned += tf.getPoints();
						}
						// User answer is correct, answer is false.
						else if (userAnswer.equals("f") && !tf.getAnswer())
						{
							System.out.println("Correct! +" + tf.getPoints() + " points\n");
							pointsEarned += tf.getPoints();
						}
						// User answer is incorrect.
						else
						{
							System.out.println("Incorrect. Try again next time!\n");
						}
					}
					// Otherwise, the flashcard must be a Vocabulary card.
					else
					{
						Vocabulary vocab = (Vocabulary) practiceSet.getCard(randomIndex);
						System.out.println(vocab.getQuestion());
						System.out.println("Answer (e to exit): ");
						String userAnswer = input.nextLine();
						
						// User wants to stop practicing.
						if (userAnswer.equals("e"))
						{
							System.out.println("\nYou earned: " + pointsEarned + " points!");
							System.out.println("Ending practice, going back to main menu.");
							break;
						}
						// User answer is correct.
						else if (userAnswer.equals(vocab.getAnswer()))
						{
							System.out.println("Correct! +" + vocab.getPoints() + " points\n");
							pointsEarned += vocab.getPoints();
						}
						// User answer is incorrect.
						else
						{
							System.out.println("Incorrect. Try again next time!\n");
						}
					}
				}
			}
			// User wants to create new flashcard set.
			else if (userIntent.equals("n"))
			{
				// Get name of flashcard set.
				System.out.println("What would you like to name this flashcard set?");
				String name = input.nextLine();
				CardSet newSet = new CardSet(name);
				
				// Get number of flashcards in the new flashcard set.
				System.out.println("How many flashcards would you like to add to this flashcard set?");
				int numCards = input.nextInt();
				input.nextLine();
				
				// For every flashcard in the new flashcard set, ask the user what type of flashcard they would like to add.
				for (int i = 0; i < numCards; i++)
				{
					// Get the flashcard type.
					System.out.println("\nWhat type of flashcard do you want to add?");
					System.out.println("Options: [m]ultiple choice, [v]ocab, [t]rue/false");
					String type = input.nextLine();
					
					// Get the question on the flashcard.
					System.out.println("What question do you want on the flashcard?");
					String question = input.nextLine();
					
					// User wants to add multiple choice card.
					if (type.equals("m"))
					{
						System.out.println("Now you will enter each of the 4 answer choices.");
						String[] choices = new String[4];
						
						// Get 4 possible answer choices for the card.
						for (int j = 0; j < 4; j++)
						{
							System.out.println("Please enter answer choice #" + (j+1) + ": ");
							String option = input.nextLine();
							choices[j] = option;
						}
						
						// Get the correct answer for the card.
						System.out.println("Which option is the correct answer?");
						System.out.println("Enter an integer 1-4 matching the correct answer choice.");
						int answerIndex = input.nextInt() - 1;
						input.nextLine();
						
						// Get the card difficulty.
						System.out.println("How difficult is this question?");
						System.out.println("Enter an integer 1-10, 1 is easy, 10 is hard.");
						int difficulty = input.nextInt();
						input.nextLine();
						
						// Get the number of points the card is worth.
						System.out.println("How many points is this flashcard worth?");
						int points = input.nextInt();
						input.nextLine();
						
						// Create the new multiple choice flashcard.
						MultipleChoice newCardMCQ = new MultipleChoice(question, points, difficulty, choices, answerIndex);
						// Add the new multiple choice flashcard to the new flashcard set.
						newSet.addCard(newCardMCQ);
					}
					// User wants to add vocabulary card.
					else if (type.equals("v"))
					{
						// Get the correct answer for the card.
						System.out.println("Please enter the correct vocabulary word.");
						String answer = input.nextLine();
						
						// Get the card difficulty.
						System.out.println("How difficult is this question?");
						System.out.println("Enter an integer 1-10, 1 is easy, 10 is hard.");
						int difficulty = input.nextInt();
						input.nextLine();
						
						// Get the number of points the card is worth.
						System.out.println("How many points is this flashcard worth?");
						int points = input.nextInt();
						input.nextLine();
						
						// Create the new vocabulary flashcard.
						Vocabulary newCardVocab = new Vocabulary(question, points, difficulty, answer);
						// Add the new vocabulary flashcard to the new flashcard set.
						newSet.addCard(newCardVocab);
					}
					// User wants to add true or false card.
					else if (type.equals("t"))
					{
						// Get the correct answer for the card.
						System.out.println("Is the correct answer [t]rue or [f]alse?");
						String answerTF = input.nextLine();
						boolean answer = true;
						
						if (answerTF.equals("f"))
							answer = false;
						
						// Get the card difficulty.
						System.out.println("How difficult is this question?");
						System.out.println("Enter an integer 1-10, 1 is easy, 10 is hard.");
						int difficulty = input.nextInt();
						input.nextLine();
						
						// Get the number of points the card is worth.
						System.out.println("How many points is this flashcard worth?");
						int points = input.nextInt();
						input.nextLine();
						
						// Create the new true or false flashcard.
						TrueFalse newCardTF = new TrueFalse(question, points, difficulty, answer);
						// Add the new true of false flashcard to the new flashcard set.
						newSet.addCard(newCardTF);
					}
					// Otherwise, the input must be invalid.
					else
					{
						System.out.println("Input not recognized. Please try again!");
						// Decrease index by 1 to compensate for invalid input.
						i--;
					}
				}
				// Add the newly created flashcard set to the ArrayList of all created flashcard sets.
				allCards.add(newSet);
			}
			// User input is invalid.
			else
			{
				System.out.println("Input not recognized. Please try again!\n");
			}
		}
	}
}