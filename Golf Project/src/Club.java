import java.util.Scanner;
import java.util.Random;
public class Club extends Golf {
	protected int mean;
	protected int std;
	private static Random random = new Random();//Random Class
	private static Scanner s = new Scanner(System.in);

	//Club method
	public int Clubs(int club, int power) {
		int Distance1, Distance2, Distance3, Distance4, Distance5, Distance6, Distance7;
		int Distance8, Distance9, Distance10;
		System.out.println("You are in the fairway. \nPlease enter a number corresponding to the club you would like to"
				+ " use (1-10)."+"\n");
		club = s.nextInt();
		System.out.print("Please enter the power that you want the ball to be hit (1-10):");
		power = s.nextInt();

		//Switch Break statement for the Club Values given in the Question
		switch (club) {
		case 0:
			System.out.println("You Quit the Game");
			System.exit(1);//Quits the Program
			break;
		case 1:
			Distance1 = nextDistance(230, 30, power);
			System.out.println("You hit the ball "+Distance1+ " yards." + "\n");
			return Distance1;
		case 2:
			Distance2 = nextDistance(215, 20, power);
			System.out.println("You hit the ball "+Distance2+ " yards." + "\n");
			return Distance2;
		case 3:
			Distance3 = nextDistance(180, 20, power);
			System.out.println("You hit the ball "+Distance3+ " yards." + "\n");
			return Distance3;
		case 4:
			Distance4 = nextDistance(170, 17, power);
			System.out.println("You hit the ball "+Distance4+ " yards." + "\n");
			return Distance4;
		case 5:
			Distance5 = nextDistance(155, 15, power);
			System.out.println("You hit the ball "+Distance5+ " yards." + "\n");
			return Distance5;
		case 6:
			Distance6 = nextDistance(145, 15, power);
			System.out.println("You hit the ball "+Distance6+ " yards." + "\n");
			return Distance6;
		case 7:
			Distance7 = nextDistance(135, 15, power);
			System.out.println("You hit the ball "+Distance7+ " yards." + "\n");
			return Distance7;
		case 8:
			Distance8 = nextDistance(125, 15, power);
			System.out.println("You hit the ball "+Distance8+ " yards." + "\n");
			return Distance8;
		case 9:
			Distance9 = nextDistance(110, 10, power);
			System.out.println("You hit the ball "+Distance9+ " yards." + "\n");
			return Distance9;
		case 10:
			Distance10 = nextDistance(50, 10, power);
			System.out.println("You hit the ball "+Distance10+ " yards." + "\n");
			return Distance10;
		default:
			System.out.println("Please enter a valid number.");
			break;
		}

		return 0;
	}
	//Bunker Club method 
	public int bunkerclubs(int mean, int std, int power) {
		System.out.print("You are using a wedge(10). \nPlease enter the power that you want the ball to be hit (1-10):");
		power = input.nextInt();
		int Distance = nextDistance(50, 10, power);//Uses the given values for the Wedge in the nextDistance method to calculate stroke distance
		System.out.println("You hit the ball "+Distance+ " yards." + "\n");
		return Distance;
	}
	//NextDistance method from the Question
	public static int nextDistance(int mean, int std, int power){
		double mean2 = mean * power / 10.0;
		double std2 = std * power / 10.0;
		double distance = Math.abs(random.nextGaussian() * std2 + mean2);
		return (int) distance;
	}

}