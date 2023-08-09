
/**
 * Created by TANAYA on 09-08-2023.
 */

/*  Question :
                              NUMBER GAME

1. Generate a random number within a specified range, such as 1 to 100.
2. Prompt the user to enter their guess for the generated number.
3. Compare the user's guess with the generated number and
   provide feedback on whether the guess is correct, too high, or too low.
4. Repeat steps 2 and 3 until the user guesses the correct number.

You can incorporate additional details as follows:
5. Limit the number of attempts the user has to guess the number.
6. Add the option for multiple rounds, allowing the user to play again.
7. Display the user's score, which can be based on the number of attempts taken or rounds won.
* */

//answer :


import java.util.Random;
import java.util.Scanner;


public class numberGame {

	public static void main(String[] args) {




		// Create an instance of Random class
		Random random = new Random();

          //display all information
		System.out.println("---------------WELCOME IN THE NUMBER GAME-----------------");
		System.out.println();
		System.out.println(" You Have 3 Chances To Guess the number ");
		System.out.println();
		System.out.println("!!!! All The Best !!!!!");

		// Create an instance of Scanner class for user input
		Scanner sc = new Scanner(System.in);

		//loop for 3 trial of user
		for (int i = 1; i <= 3; i++) {

			// Generate a random number between 1 and 100
			int randomNumber = random.nextInt(100) + 1;

			//let user enter the number
            System.out.println();
			System.out.println("enter any number from 1 to 100");
			int num = sc.nextInt();

			//check number is equal or not
			if (num == randomNumber) {
				System.out.println("-----------CONGRATULATIONS------------");
				System.out.println("----------you are WINNER !!!--------------");
				System.out.println("------You guess the correct number----------");
				System.out.println("machine generated number is : "+randomNumber);
				System.out.println("your number is : "+num);
				System.out.println();

				//let use decide to continue play or not
				System.out.println("Want to Play Again?   \n Enter 1 if you want to continue OR 0 to exit");
				int c =sc.nextInt();
				      if(c==0)
					      System.exit(0);

			}  // check all condition of close the user guess of number if number is coser in difference of 5
			else if (((num + 5) == randomNumber) || ((num - 5) == randomNumber) || ((num + 4) == randomNumber)
					|| ((num - 4) == randomNumber) || ((num + 3) == randomNumber) || ((num - 3) == randomNumber) ||
					((num + 2) == randomNumber) || ((num - 2) == randomNumber) || ((num + 1) == randomNumber) ||
					((num - 1) == randomNumber)) {
				System.out.println("your are Quick closer");

				//let user decide to continue play or not
				System.out.println("Want To Continue ? press 1 Otherwise 0");
				int ch =sc.nextInt();
				      if(ch==0)
					System.exit(0);
			}
			else {
				System.out.println("You are too far !");
					      System.out.println("Want To Continue ? press 1 Otherwise 0");
					      int chh =sc.nextInt();
					      if(chh==0)
						      System.exit(0);
			}




		}



	}
}

