package source;

public class Space {
	SpaceType type;
	int spaceNumber;
	boolean[] occupiedByPlayer = new boolean[4]; // 0: p1, 1: p2, 2: p3, 3: p4
	Property property;
	PropertyGroup propertyGroup;
	
	public Space() { }
	
	public void spaceAction(Player player, int roll, int playerChoice) {
		switch (type) {
		case GO:
			// case handled by GameEngine
			break;
		case PROPERTY:
		case RAILROAD:
		case UTILITY:
			property(player, roll, playerChoice);
			break;
		case PARKING:
			// do nothing
			break;
		case LUXURY:
			luxuryTax(player);
			break;
		case GOTOJAIL:
			goToJail(player);
			break;
		case JAIL:
			// case handled by GameEngine
			break;
		case INCOME:
			incomeTax(player, playerChoice);
			break;
		}
	}
	
	private void property(Player p, int roll, int choice) {
		// choice = 0: player does not want to buy property
		// choice = 1: player does want to buy property
		System.out.println("Player has landed on " + property.name + ".");
		if(property.owner != null && property.owner != p) {
			System.out.print("This property is owned by another player.");
			int debt = property.getRent(roll);
			p.editMoney(-debt);
			property.owner.editMoney(debt);
			System.out.println("Rent: $" + debt);
		}
		if(property.owner == null && choice == 1) {
			System.out.println("Player wants to buy property.");
			property.purchaseProperty(p);
		}
	}
	
	private void luxuryTax(Player p) {
		System.out.println("Player must pay luxury tax.");
		p.editMoney(-75);
	}
	
	private void goToJail(Player p) {
		System.out.println("Player has landed on Go To Jail.");
		p.currentSpace = GameEngine.spaces[10];
		p.inJail = true;
	}
	
	public void jail(Player p, int choice) {
		// choice = 0: player wants to pay to get out of jail
		// choice = 1: player wants to roll to get out of jail
		if(p.inJail == true) {
			if(choice == 1) {
				System.out.println("Player wants to roll out of jail.");
				if(p.numJailEscapeAttempts < 3) {
					p.numJailEscapeAttempts++;
					// Die rolls will be chosen for test cases
					int d1 = ChoiceEngine.getNextNumber();
					int d2 = ChoiceEngine.getNextNumber();
					// End test
					
//					int d1 = GameEngine.rollDice();
//					int d2 = GameEngine.rollDice();
					System.out.println("Roll: " + d1  + ", " + d2);
					if(d1 == d2) {
//						InfoPopup.display("ROLL ATTEMPT", "You rolled a " + d1 + " and a " + d2 + ".");
						System.out.println("Attempt successful!");
						p.inJail = false;
						p.numJailEscapeAttempts = 0;
					} else {System.out.println("Attempt failed."); }
				} else {
					System.out.println("...but they can't because they exceeded their number of attempts.");
					p.editMoney(-50);
					p.inJail = false;
					p.numJailEscapeAttempts = 0;
				}
			} else {
				System.out.println("Player wants to pay bail.");
				p.editMoney(-50);
				p.inJail = false;
				p.numJailEscapeAttempts = 0;
			}
		}
		// Prompt user to pay $50 or attempt to roll out of jail
	}
	
	private void incomeTax(Player p, int choice) {
		// choice = 0: player wants to pay $200
		// choice = 1: player wants to pay 10%
		System.out.println("Player has landed on Income Tax.");
		int amountOwed;
		if(choice == 1) {
			System.out.println("Player wants to pay 10%.");
			amountOwed = (int) Math.floor(p.money * 0.1);
		} else {
			System.out.println("Player wants to pay $200.");
			amountOwed = 200;
		}
		p.editMoney(-amountOwed);
	}
}