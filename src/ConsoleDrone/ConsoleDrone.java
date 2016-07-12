package ConsoleDrone;

import java.util.Scanner;

public class ConsoleDrone {
	
	public static void main(String[] args) {
		System.out.println("Please enter direction for Drone,as T,N,S,E,W,L,X");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine().toUpperCase();
		int  output = Takeoff(input);
		AirDrone ad = (air) -> System.out.println(output + ": AIR");// use java 8 with lambda
		ad.AirDroneRun("AIR");
		LandDrone ld = (land) -> System.out.println(output + ": LAND");//lambda expression
		ld.LandDroneRun("LAND");
		
	}
	
	public static int Takeoff(String input) {
		int check = 0;
		if (input.length() != 0) {
			try {
				int lenght1=input.length();
				char letter = 0;
				for(int j=0;j<lenght1;j++){
					letter = input.charAt(j);
					if (letter == 'T' )
						if(( letter == 'N' || letter == 'S' || letter == 'E' || letter == 'W' || letter == 'X') ) {
						//AirDrone ad = (land)->System.out.println("Flying drone");
							AirExecute();
				    } if(letter == 'L') {//landing is ignoring N,S,E,W direction because its landing
				    	LandExecute();
				    }
					
				}
				
				input = input.replaceAll("\\s+", "");
				String digits = input.replaceAll("[^0-9.]", "");//ignoring all char except integer 
				check = Integer.parseInt(digits);
			} catch (NumberFormatException e) {//handling numberformatexception to conver "123"-->123
				e.printStackTrace();
			}
			return check;
	}
		 else {
			return check;
		}
	}
	public static void LandExecute(){
	System.out.println("LAnding drone");
	}
	public static void AirExecute(){
		System.out.println("Flying drone");
		}
	public interface AirDrone {
		public void AirDroneRun(String air);
	}

	public interface LandDrone {
		public void LandDroneRun(String land);
	}
}