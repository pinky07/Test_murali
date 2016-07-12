package ConsoleDrone;

public class LandDrone {
int x;
int y;
public LandDrone(int x,int y){//x , y aixs
	this.x=x;
	this.y=y;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}

//public void LandDroneRun(String input){
//	int check = 0;
//	if (input.length() != 0) {
//		try {
//				input = input.replaceAll("\\s+", "");
//				String digits = input.replaceAll("[^0-9.]", "");
//				check = Integer.parseInt(digits);
////			int space[]= new int[check];
////			for(int i=0;i<space.length;i++){
////				int element = space[i];
////				System.out.println(element+'\t'  );
////			}
//				System.out.println(check+": LAND");
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//}
//
//}
}
