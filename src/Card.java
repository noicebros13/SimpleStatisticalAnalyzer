public class Card {
	//local variables
	String myName, myTeam, myType;
	int myYear;
	
	//constructor
	public Card(String name, int year, String team, String type) {
		myName = name;
		myYear = year;
		myTeam = team;
		myType = type;
	}//end of card constructor
	
	public String getName() {
		return myName;
	}//end of getName method: returns name of player on card
	
	public int getYear() {
		return myYear;
	}//end of getYear method: returns year of card creation
	
	public String getTeam() {
		return myTeam;
	}//end of getTeam method: returns team of player on card
	
	public String getType() {
		return myType;
	}//end of getType method: returns card type
	
}//end of card class