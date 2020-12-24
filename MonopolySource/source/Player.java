package source;

public class Player {
	int playerNum;
	Space currentSpace;
	boolean inJail;
	int numProperties;
	int money;
	int[] dollarTypes = new int[6];
	int symbol;
	int numJailEscapeAttempts;
	double xCoord;
	double yCoord;
	
	public Player(int playerNum, int symbol) {
		this.playerNum = playerNum;
		currentSpace = GameEngine.spaces[0];
		inJail = false;
		numProperties = 0;
		money = 15000;
		dollarTypes = dollarCounter.dollarsCounts(money);
		this.symbol = symbol;
		numJailEscapeAttempts = 0;
	}
	
	public void move(int n) {
		System.out.println("Moving player " + n + " spaces.");
		int targetSpace = currentSpace.spaceNumber;
		currentSpace.occupiedByPlayer[playerNum] = false;
		if(targetSpace + n > 39) { // Player's roll causes them to pass go
			System.out.println("Player has passed GO.");
			int temp = 40 - targetSpace;
			int newN = n - temp;
			targetSpace = newN;
			editMoney(200);
		} else {
			targetSpace += n;
		}
		currentSpace = GameEngine.spaces[targetSpace];
		currentSpace.occupiedByPlayer[playerNum] = true;
	}
	
	//Gets invoked like player.editMoney(n);
	public void editMoney(int n) {
		if(money + n < 0) { money = 0; } else { money += n; }
		dollarTypes = dollarCounter.dollarsCounts(money);
		
	}
	
	public int trade(Property offer, Property wants, Player tradee) {
		// this = player who initiated trade (trader)
		// First make sure the properties on the table actually belong to their respective owners
		
		offer.owner = tradee;
		offer.group.checkMonopoly();
		wants.owner = this;
		wants.group.checkMonopoly();
		
		return 0;
	}
}