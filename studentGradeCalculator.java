import java.util.Scanner;

/**
 * Created by TANAYA on 08-08-2023.
 */

/* Question :

Input                       : Take marks obtained (out of 100) in each subject.
Calculate Total Marks       : Sum up the marks obtained in all subjects.
Calculate Average Percentage: Divide the total marks by the total number of
                              subjects to get the average percentage.
Grade Calculation           : Assign grades based on the average percentage achieved.
Display Results             : Show the total marks, average percentage, and the corresponding
                              grade to the user
* */

//Answer :

// create a class for calculate the grade of student


public class studentGradeCalculator {

	public static void main(String[] args) {
		float total = 0, avg_per = 0;
		String grade;

		//take number of subjects from user and store it

		System.out.println("------------WELCOME INTO STUDENT GRADE CALCULATOR APPLICATION-------------");

		System.out.println("please enter how many subject you want to calculate :");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		//for loop for all subjects input
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter the marks obtain (out of 100) in subject number " + i + " :");
			float sub = sc.nextFloat();

			// calculate total of all subjects
			total = sub + total;

		}

		//calculate average percentage
		avg_per = total / n;


		//assign the grade based on average
		if (avg_per >= 90)
			grade = "A";
		else if (avg_per >= 80)
			grade="B";
		else if (avg_per>=70)
			grade="C";
		else if (avg_per>=60)
			grade="D";
		else if (avg_per>=40)
			grade="40";
		else
			grade="F";

		//printing the output

		System.out.println("Total marks of student obtain is : "+total);
		System.out.println("Average percentage of marks is "+avg_per);
		System.out.println("Grade is :"+grade);

	}
}
