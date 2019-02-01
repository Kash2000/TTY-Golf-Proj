import java.util.Random;
public class Courses extends Golf{
	protected int dist;
	protected int pdist;
	protected int stroke;

	//1st Course
	public int KingCourse() {

		System.out.println("\n\t\tWelcome to the King's Course!\nYou are at the tee.");
		System.out.println("There are hazards in Holes- 1,10,13,16");
		//For loop starts with Hole 1 and ends on Hole 18
		for (int i = 0; i <= 17; i++) {		
			System.out.println("Hole " + (i+1));
			int[] yard= {379, 562, 232, 513, 327, 465, 184, 426, 434, 453, 188, 460, 332, 601, 163, 442, 412, 501};//Array holding the values for yardage
			int[] par = {4, 5, 3, 5, 4, 4, 3, 4, 4, 4, 3, 4, 4, 5, 3, 4, 4, 5};//Array holding the values for par
			//Uses hazard method at Hole 1,Hole 10,Hole 13,Hole 16
			if(i==0) {
				myPar += hazard(yard[0], par[0]);
			}else if(i==9) {
				myPar += hazard(yard[9], par[9]);
			}else if(i==13) {
				myPar += hazard(yard[12], par[12]);
			}else if(i==15) {
				myPar += hazard(yard[15], par[15]);
			}else {
				myPar += hole(yard[i], par[i]);
			}
			System.out.println("Your score for this round  is: " + (myPar) + "\n");//Prints the score of the user
			//Prints statements according to the User's score
			if (stroke-1 == 1) {
				System.out.println("Ace! Well done!\n");
			}else if ((par[i] - stroke -1) == 3 ) {
				System.out.println("Albatross! A rare occurence!\n");
			}else if ((par[i] - stroke -1) == 1) {
				System.out.println("Birdie!\n");
			}else if ((par[i] - stroke -1) == -1) {
				System.out.println("Bogey!\n");
			}else if((par[i] - stroke - 1) == -2){
				System.out.println("Double Bogey!\n");
			}else if ((par[i] - stroke - 1) == 2) {
				System.out.println("Eagle!\n");
			}
		}
		return myPar;
	}


	//Course2
	public int SawgrassCourse() {
		System.out.println("\n\t\tWelcome to the Sawgrass Course! \nYou are at the tee.");
		System.out.println("There are hazards in Holes- 2,5,7,16");
		//For loop starts with Hole 1 and ends on Hole 18
		for (int i = 0; i <= 17; i++) {
			System.out.println("Hole " + (i+1));
			int[] yard= {423, 532, 177, 384, 471, 393, 451, 237, 583, 424, 558, 302, 181, 481, 470, 523, 137, 462};
			int[] par = {4, 5, 3, 4, 4, 4, 4, 3, 5, 4, 5, 4, 3, 4, 4, 5, 3, 4};

			//Uses hazard method at Hole 1,Hole 10,Hole 13,Hole 16
			if(i==1) {
				myPar += hazard(yard[1], par[1]);
			}else if(i==4) {
				myPar += hazard(yard[4], par[4]);
			}else if(i==6) {
				myPar += hazard(yard[6], par[6]);
			}else if(i==15) {
				myPar += hazard(yard[15], par[15]);
			}else {
				myPar += hole(yard[i], par[i]);
			}
			System.out.println("Your score for this round  is: " + (myPar) + "\n");	//Prints the score of the user
			//Prints statements according to the User's score
			if (stroke-1 == 1) {
				System.out.println("Ace! Well done!\n");
			}else if ((par[i] - stroke -1) == 3 ) {
				System.out.println("Albatross! A rare occurence!\n");
			}else if ((par[i] - stroke -1) == 1) {
				System.out.println("Birdie!\n");
			}else if ((par[i] - stroke -1) == -1) {
				System.out.println("Bogey!\n");
			}else if((par[i] - stroke - 1) == -2){
				System.out.println("Double Bogey!\n");
			}else if ((par[i] - stroke - 1) == 2) {
				System.out.println("Eagle!\n");
			}
		}
		return myPar;
	}
	//Hole method
	public int hole(int yards, int par) {
		dist= yards;
		stroke = 1;
		System.out.println("Yards= " + yards + " Par " + par);//Prints the yards and par for every hole
		//Runs as long as the absolute distance between ball and hole is greater than 1 foot 
		while (Math.abs(dist*3) > 1) {
			//If and else-statement according to the distance of the ball from the hole

			if (dist > 20) { //Uses fairway method if distance is greater than 20 yards	
				System.out.println("Your ball is currently " + dist + " yards from the hole.");
				System.out.println("\nThis is stroke " + stroke + " at this hole.");
				dist = fairway();

			} else if (dist*3 > -60 && dist*3 <-1) {//Uses green method if distance is greater than -60 feet and less than -1 feet (ball is beyond the hole)
				dist = Math.abs(dist);
				System.out.println("Your ball went past the hole and is currently " + dist*3 + " feet from the hole.");
				System.out.println("\nThis is stroke " + stroke + " at this hole.");
				dist = green();

			} else if (dist*3 < 60 && dist*3 > 1) {//Uses green method if distance is greater than 1 foot and less than 60 feet
				System.out.println("Your ball is currently " + dist*3 + " feet from the hole.");
				System.out.println("\nThis is stroke " + stroke + " at this hole.");
				dist = green();
			} else {
				dist = Math.abs(dist);//Uses fairway method 
				System.out.println("Your ball went past the hole and is currently " + dist + " yards from the hole.");
				System.out.println("\nThis is stroke " + stroke + " at this hole.");
				dist = fairway();
			}
			stroke++;// Increments stroke by 1 until the user hits the ball in the hole
			myPar = stroke-par;
		}
		return myPar;
	}
	//hazard Method
	public int hazard(int yards, int par) {
		Random yard = new Random();//Uses Random to create random yard values for the hazard
		int yard1 = yard.nextInt(20)+170;//Generates minimum value for sand Bunker b/w 170-189
		int yard2 = yard.nextInt(20)+195;//Generates maximum value for sand Bunker b/w 195-214
		int yard3 = yard.nextInt(15)+90;//Generates minimum value for sand Bunker b/w 90-104
		int yard4 = yard.nextInt(15)+110 ;//Generates minimum value for sand Bunker b/w 110-124
		dist= yards;
		stroke = 1;
		System.out.println("Yards= " + yards + " Par " + par);
		while (Math.abs(dist*3) > 1) {
			if(dist != pdist){
				System.out.println("\nThis is stroke " + stroke + " at this hole.");
			}
			if (dist > 20) {//Runs if and else-statements if distance is greater than 20 yards	
				if (dist > yard1 && dist < yard2) {//Calls bunkerfairway method if the ball is in the sand bunker
					System.out.println("Your ball is currently in a sand bunker and is " + dist + " yards from the hole.");
					dist = bunkerfairway();
				}else if(dist > yard3 && dist < yard4) {//If the ball is in the river, you go back to the previous distance of stroke
					System.out.println("Your ball is currently in a river. You will go back " + pdist + " yards from the hole.");
					stroke--;
					dist= pdist;
				}else {
					System.out.println("Your ball is currently " + dist + " yards from the hole.");
					dist = fairway();//C
				}
			} else if (dist*3 > -60 && dist*3 <-1) {
				dist = Math.abs(dist);
				System.out.println("Your ball went past the hole and is currently " + dist*3 + " feet from the hole.");
				dist = green();
			} else if (dist*3 < 60 && dist*3 > 1) {
				System.out.println("Your ball is currently " + dist*3 + " feet from the hole.");
				dist = green();
			} else {
				dist = Math.abs(dist);
				System.out.println("Your ball went past the hole and is currently " + dist + " yards from the hole.");
				dist = fairway();
			}
			stroke++;
			myPar = stroke-par;
		}
		return myPar;
	}

	//Fairway Method 
	public int fairway() {
		Club object = new Club();//declares a new object in class Club
		pdist=dist;//sets previous distance equal to distance
		dist=dist-object.Clubs(0, 0);//Calculates the distance from the hole after the current stroke
		return dist;
	}
	//Green Method
	public int green() {
		Putter object = new Putter();//declares a new object in class Putter 
		dist = dist-object.Putter1(0);//Calculates the distance from the hole after the current stroke
		return dist;
	}
	//BunkerFairway method
	public int bunkerfairway() {
		Club object = new Club();//declares a new object in class Club
		dist=(dist-object.bunkerclubs(50, 10, 0));//Calculates the distance from the hole after the current stroke
		return dist;
	}


}