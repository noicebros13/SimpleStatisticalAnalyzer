
public class player {
	//local vars
	String myName;
	double myBA;
	
	public player(String name, double BA) {
		myName = name;
		myBA = BA;
	}
	
	public double getBA() {
		return myBA;
	}
	
	public void setBA(double newBA) {
		myBA = newBA;
	}
	
	public String getName() {
		return myName;
	}
	
	public void setName(String newName) {
		myName = newName;
	}
	
	public String toString() {
		System.out.println("Name:\t  BA:");
		return "" + myName + "\t  " + myBA;
	}
}
