/*
 * SHIVALI SINGH
 * Net ID- ssingh53
 * Assignment- Project2
 * LAB TR 11:05-12:20
 * I collaborated with Kashish Dewnani (kdewnani) (31366427)
 */
import java.util.Scanner;
public class Golf {
	//Main Method File
	protected static int myPar = 0;
	protected static Scanner input = new Scanner(System.in);//Scanner Instance
	public static void main(String[]args) {
		Instructions i = new Instructions();
		i.Instruction1();//Calls Instruction1 method in Instructions Class
		while (true) {
			//Prints the Main Menu of the Game
			System.out.println("\n Choose one of the options: \n 1.The King’s Course, \n 2.The Stadium Course at Sawgrasss \n 3.Quit Game");
			System.out.print("Please select your option [1-3]");
			int course = input.nextInt();
			//Uses a switch-statement to choose a course or quit the game
			switch (course) {
			//King's Course
			case 1:
				Courses KC = new Courses();
				KC.KingCourse();
				System.out.println("You're final score for the round is: "+myPar);
				break;
				//Sawgrass Course
			case 2:
				Courses SG =new Courses();
				SG.SawgrassCourse();
				System.out.println("You're final score for the round is: "+myPar);
				break;
			case 3: 
				System.out.println("You have quit the game.\nThank you for playing!");
				System.exit(1);//Quits the Game
			}
		}
	}
}