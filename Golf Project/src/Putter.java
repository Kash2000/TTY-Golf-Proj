import java.util.Random;
import java.util.Scanner;
public class Putter {
	private static Random random = new Random();
	private static Scanner s = new Scanner(System.in);

	//Putter Method
	public int Putter1(int power){ 
		int Distance1, Distance2, Distance3, Distance4, Distance5, Distance6, Distance7;
		int Distance8, Distance9, Distance10;
		System.out.println("You are now within 20 yards(60 feet) from the hole so you are using a putter. " + "\n"
				+ "You are in the green! Enter your power here (1-10)");
		power = s.nextInt();
		//Switch Break statement for the Club Values given in the Question
		switch (power) {
		case 0:
			System.out.println("You Quit the Game");
			System.exit(1);//Quits the Program
			break;
		case 1:
			Distance1 = nextDistance(1, 1, power);
			System.out.println("You hit the ball "+Distance1*3+ " feet.");
			return Distance1;
		case 2:
			Distance2 = nextDistance(2, 1, power);
			System.out.println("You hit the ball "+Distance2*3+ " feet.");
			return Distance2;
		case 3:
			Distance3 = nextDistance(4, 2, power);
			System.out.println("You hit the ball "+Distance3*3+ " feet.");
			return Distance3;
		case 4:
			Distance4 = nextDistance(8, 2, power);
			System.out.println("You hit the ball "+Distance4*3+ " feet.");
			return Distance4;
		case 5:
			Distance5 = nextDistance(12, 3, power);
			System.out.println("You hit the ball "+Distance5*3+ " feet.");
			return Distance5;
		case 6:
			Distance6 = nextDistance(16, 3, power);
			System.out.println("You hit the ball "+Distance6*3+ " feet.");
			return Distance6;
		case 7:
			Distance7 = nextDistance(20, 4, power);
			System.out.println("You hit the ball "+Distance7*3+ " feet.");
			return Distance7;
		case 8:
			Distance8 = nextDistance(25, 4, power);
			System.out.println("You hit the ball "+Distance8*3+ " feet.");
			return Distance8;
		case 9:
			Distance9 = nextDistance(30, 5, power);
			System.out.println("You hit the ball "+Distance9*3+ " feet.");
			return Distance9;
		case 10:
			Distance10 = nextDistance(40, 5, power);
			System.out.println("You hit the ball "+Distance10*3+ " feet.");
			return Distance10;
		default:
			System.out.println("Please enter a valid number.");
			break;
		}return 0;
	}

	//NextDistance method from the Question
	public static int nextDistance(int mean, int std, int power){
		double mean2 = mean * power / 10.0;
		double std2 = std * power / 10.0;
		double distance = Math.abs(random.nextGaussian() * std2 + mean2);
		return (int) Math.ceil(distance/3);
	}	
}