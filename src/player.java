
public class player {
	//local vars
	String myName;
	double myBA;
	
	public player(String name, double BA) {
		myName = name;
		myBA = BA;
	}
	
	public double getMyBA() {
		return myBA;
	}
	
	public void setMyBA(double newBA) {
		myBA = newBA;
	}
	
	public String getName() {
		return myName;
	}
	
	public void setName(String newName) {
		myName = newName;
	}
	
	public String toString() {
		return "" + myName + "\t" + myBA;
	}
}
