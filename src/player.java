
public class player {
	//local vars
	String myName;
	double myBA;
	String myPosition;
	
	public player(String name, double BA, String position) {
		myName = name;
		myBA = BA;
		myPosition = position;
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
	
	public String getPosition() {
		return myPosition;
	}
	
	public void setPosition(String position) {
		myPosition = position;
	}
	
	public String toString() {
		return "" + myName + "\t  " + myBA;
	}
}
