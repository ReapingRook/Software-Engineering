package source;

import java.util.Random;

public class GameEngine {
	static int numPlayers;
	static int currPlayerTurn;
	static int currPlayerStage; // 1: roll, 2: move, 3: tile action, 4: manage properties
	static int numTurns;
	static int currTurn;
	static Space[] spaces = new Space[40];
	Property[] properties = new Property[28];
	Player[] players;
	Player[] standings;
	static Random dice = new Random();
	
	public GameEngine(int numPlayers, int numTurns) {
	System.out.println("Initializing game engine...");
		int i, j;
		GameEngine.numPlayers = numPlayers;
		GameEngine.numTurns = numTurns;
	System.out.println(numPlayers);
	System.out.println(numTurns);
		
		// MARK: Create property groups
		System.out.println("Creating property groups...");
		PropertyGroup brown = new PropertyGroup("brown");
		PropertyGroup lBlue = new PropertyGroup("light blue");
		PropertyGroup pink = new PropertyGroup("pink");
		PropertyGroup orange = new PropertyGroup("orange");
		PropertyGroup red = new PropertyGroup("red");
		PropertyGroup yellow = new PropertyGroup("yellow");
		PropertyGroup green = new PropertyGroup("green");
		PropertyGroup dBlue = new PropertyGroup("dark blue");
		PropertyGroup railroads = new PropertyGroup("railroads");
		PropertyGroup utilities = new PropertyGroup("utility");
		
		// MARK: Create properties and deeds
		Property[] props = new Property[28];
		for(i = 0; i < 28; i++) {
			System.out.println("Initializing Property No. " + i + "...");
			switch(i) {
					/*
					Just clarify, for non-railroad, non-utilities properties, the array goes in this order:
					Base -> Monopoly -> 1 House -> 2 Houses -> 3 Houses -> 4 Houses -> Hotel
					
					*/
					
				case 0:
					props[i] = new Property(PropertyType.PROPERTY, "Mediterranian Avenue", brown);
					int[] rents1 = {2, 10, 30, 90, 160, 250};
					props[i].deed = new Deed(60, rents1, 50, props[i]);
					break;
				case 1:
					props[i] = new Property(PropertyType.PROPERTY, "Baltic Avenue", brown);
					int[] rents2 = {4, 20, 60, 180, 320, 450};
					props[i].deed = new Deed(60, rents2, 50, props[i]);
					break;
				case 2:
					props[i] = new Property(PropertyType.RAILROAD, "Reading RR", railroads);
					int[] rents3 = {0, 25, 50, 100, 200, 200};
					props[i].deed = new Deed(200, rents3, 0, props[i]);
					break;
				case 3:
					props[i] = new Property(PropertyType.PROPERTY, "Oriental Avenue", lBlue);
					int[] rents4 = {6, 30, 90, 270, 400, 550};
					props[i].deed = new Deed(100, rents4, 50, props[i]);
					break;
				case 4:
					props[i] = new Property(PropertyType.PROPERTY, "Vermont Avenue", lBlue);
					int[]rents5 = {6,30,90,270,400,550};
					props[i].deed = new Deed(100, rents5, 50, props[i]);
					break;
				case 5:
					props[i] = new Property(PropertyType.PROPERTY, "Connecticut Avenue", lBlue);
					int[]rents6 = {8,40,100,300,450,600};
					props[i].deed = new Deed(120, rents6, 50, props[i]);
					break;
				case 6:
					props[i] = new Property(PropertyType.PROPERTY, "St. Charles Place", pink);
					int[]rents7 = {10,50,150,450,625,750};
					props[i].deed = new Deed(140, rents7, 100, props[i]);
					break;
				case 7:
					props[i] = new Property(PropertyType.UTILITY, "Electric Company", utilities);
					int[]rents8 = {0,0,0,0,0,0};
					props[i].deed = new Deed(150, rents8, 0, props[i]);
					break;
				case 8:
					props[i] = new Property(PropertyType.PROPERTY, "State Avenue", pink);
					int[]rents9 = {10,50,150,450,625,750};
					props[i].deed = new Deed(140, rents9, 100, props[i]);
					break;
				case 9:
					props[i] = new Property(PropertyType.PROPERTY, "Virginia Avenue", pink);
					int[]rents10 = {12,60,180,500,700,900};
					props[i].deed = new Deed(160, rents10, 100, props[i]);
					break;
				case 10:
					props[i] = new Property(PropertyType.RAILROAD, "Pennsylvania RR", railroads);
					int[]rents11 = {0, 25,50,100,200,200};
					props[i].deed = new Deed(200, rents11, 0, props[i]);
					break;
				case 11:
					props[i] = new Property(PropertyType.PROPERTY, "St. James Place", orange);
					int[]rents12 = {14,70,200,550,750,950};
					props[i].deed = new Deed(180, rents12, 100, props[i]);
					break;
				case 12:
					props[i] = new Property(PropertyType.PROPERTY, "Tennessee Avenue", orange);
					int[]rents13 = {14,70,200,550,750,950};
					props[i].deed = new Deed(180, rents13, 100, props[i]);
					break;
				case 13:
					props[i] = new Property(PropertyType.PROPERTY, "New York Avenue", orange);
					int[]rents14 = {16,80,220,600,800,1000};
					props[i].deed = new Deed(200, rents14, 100, props[i]);
					break;
				case 14:
					props[i] = new Property(PropertyType.PROPERTY, "Kentucky Avenue", red);
					int[]rents15 = {18,90,250,700,875,1050};
					props[i].deed = new Deed(220, rents15, 150, props[i]);
					break;
				case 15:
					props[i] = new Property(PropertyType.PROPERTY, "Indiana Avenue", red);
					int[]rents16 = {18,90,250,700,825,1050};
					props[i].deed = new Deed(220, rents16, 150, props[i]);
					break;
				case 16:
					props[i] = new Property(PropertyType.PROPERTY, "Illinois Avenue", red);
					int[]rents17 = {20,100,300,750,925,1100};
					props[i].deed = new Deed(220, rents17, 150, props[i]);
					break;
				case 17:
					props[i] = new Property(PropertyType.RAILROAD, "B. & O. RR", railroads);
					int[] rents18 = {0, 25, 50, 100, 200, 200};
					props[i].deed = new Deed(200, rents18, 0, props[i]);
					break;
				case 18:
					props[i] = new Property(PropertyType.PROPERTY, "Atlantic Avenue", yellow);
					int[]rents19 = {22,110,330,800,975,1150};
					props[i].deed = new Deed(260, rents19, 150, props[i]);
					break;
				case 19:
					props[i] = new Property(PropertyType.PROPERTY, "Ventnor Avenue", yellow);
					int[]rents20 = {22,110,330,800,975,1150};
					props[i].deed = new Deed(260, rents20, 150, props[i]);
					break;
				case 20:
					props[i] = new Property(PropertyType.UTILITY, "Water Works", utilities);
					int[]rents21 = {0,0,0,0,0,0};
					props[i].deed = new Deed(150, rents21, 0, props[i]);
					break;
				case 21:
					props[i] = new Property(PropertyType.PROPERTY, "Marvin Gardens", yellow);
					int[]rents22 = {24,120,360,850,1025,1200};
					props[i].deed = new Deed(280, rents22, 150, props[i]);
					break;
				case 22:
					props[i] = new Property(PropertyType.PROPERTY, "Pacific Avenue", green);
					int[]rents23 = {26,130,390,900,1100,1275};
					props[i].deed = new Deed(300, rents23, 200, props[i]);
					break;
				case 23:
					props[i] = new Property(PropertyType.PROPERTY, "North Carolina Avenue", green);
					int[]rents24 = {26,130,390,900,1100,1275};
					props[i].deed = new Deed(300, rents24, 200, props[i]);
					break;
				case 24:
					props[i] = new Property(PropertyType.PROPERTY, "Pennsylvania Avenue", green);
					int[]rents25 = {28,150,450,1000,1200,1400};
					props[i].deed = new Deed(320, rents25, 200, props[i]);
					break;
				case 25:
					props[i] = new Property(PropertyType.RAILROAD, "Short Line", railroads);
					int[] rents26 = {0, 25, 50, 100, 200, 200};
					props[i].deed = new Deed(200, rents26, 0, props[i]);
					break;
				case 26:
					props[i] = new Property(PropertyType.PROPERTY, "Park Place", dBlue);
					int[]rents27 = {35,175,500,1100,1300,1500};
					props[i].deed = new Deed(350, rents27, 200, props[i]);
					break;
				case 27:
					props[i] = new Property(PropertyType.PROPERTY, "Boardwalk", dBlue);
					int[]rents28 = {50,200,600,1400,1700,2000};
					props[i].deed = new Deed(400, rents28, 200, props[i]);
					break;

			}
			
		}
		properties = props;
		
		// MARK: Initialize Board
		int pi = 0; // property array index
		for(i = 0; i < 40; i++) {
			System.out.println("Initializing Space No. " + i + "... (pi = " + pi + ")");
			Space temp = new Space();
			switch(i) {
			case 0:
				temp.type = SpaceType.GO;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = true; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 1:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 2:
				// This space is a community chest space. CC hasn't been implemented yet,
				// so instead this will be a free parking space.
				temp.type = SpaceType.PARKING;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 3:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 4:
				temp.type = SpaceType.INCOME;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 5:
				temp.type = SpaceType.RAILROAD;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 6:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 7:
				// This is a chance space. Chance hasn't been implemented yet, so
				// instead this will be a free parking space.
				temp.type = SpaceType.PARKING;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 8:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 9:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 10:
				temp.type = SpaceType.JAIL;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 11:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 12:
				temp.type = SpaceType.UTILITY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 13:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 14:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 15:
				temp.type = SpaceType.RAILROAD;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 16:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 17:
				// CC space
				temp.type = SpaceType.PARKING;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 18:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 19:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 20:
				temp.type = SpaceType.PARKING;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 21:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 22:
				// Chance space
				temp.type = SpaceType.PARKING;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 23:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 24:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 25:
				temp.type = SpaceType.RAILROAD;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 26:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 27:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 28:
				temp.type = SpaceType.UTILITY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 29:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 30:
				temp.type = SpaceType.GOTOJAIL;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 31:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 32:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 33:
				// CC space
				temp.type = SpaceType.PARKING;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 34:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 35:
				temp.type = SpaceType.RAILROAD;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 36:
				// Chance space
				temp.type = SpaceType.PARKING;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 37:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			case 38:
				temp.type = SpaceType.LUXURY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = null;
				temp.propertyGroup = null;
				break;
			case 39:
				temp.type = SpaceType.PROPERTY;
				for(j = 0; j < 4; j++) { temp.occupiedByPlayer[j] = false; }
				temp.spaceNumber = i;
				temp.property = properties[pi];
				temp.propertyGroup = properties[pi].group;
				break;
			}
			if(temp.type == SpaceType.PROPERTY || temp.type == SpaceType.RAILROAD || temp.type == SpaceType.UTILITY) {
				System.out.println("Space " + i + " is a property. Incrementing pi...");
				pi++;
			}
			spaces[i] = temp;
		}
		
		// MARK: Creating players
		players = new Player[numPlayers];
		for(i = 0; i < numPlayers; i++) {
			Player player = new Player(i, i);
			players[i] = player;
		}
	}
	
	public int startGame() {
		System.out.println("-----STARTING GAME WITH " + numPlayers + " PLAYERS AND " + numTurns + " TURNS-----");
		for(int i = 0; i < numTurns; i++) {
			currTurn = i;
			for(int j = 0; j < numPlayers; j++) {
				System.out.println("---Turn " + i + ": Player " + (j+1) + "---");
				currPlayerTurn = j;
				takeTurn(players[j]);
			}
		}
		
		// End of game
		standings = declareWinners();
		String winnerMessage = "The game is over!\n\n1st Place: Player " + (standings[0].playerNum+1) + " with " + standings[0].numProperties + " properties and $" + standings[0].money + "\n";
		winnerMessage += "2nd Place: Player " + (standings[1].playerNum+1) + " with " + standings[1].numProperties + " properties and $" + standings[1].money + "\n";
		if(numPlayers > 2) { winnerMessage += "3rd Place: Player " + (standings[2].playerNum+1) + " with " + standings[2].numProperties + " properties and $" + standings[2].money + "\n"; }
		if(numPlayers > 3) { winnerMessage += "4th Place: Player " + (standings[3].playerNum+1) + " with " + standings[3].numProperties + " properties and $" + standings[3].money + "\n"; }
	
		System.out.println(winnerMessage);
//		InfoPopup.display("END OF GAME", winnerMessage);
		
		return 0;
	}
	
	public void takeTurn(Player p) {
		int d1, d2, doublesCounter = 0, playerChoice = 0;
		boolean willRepeatTurn = false;
		
		do {
			willRepeatTurn = false;
//			InfoPopup.display("PLAYER " + (p.playerNum+1), "Player " + (p.playerNum+1) + ", you're up!\nYou have $" + p.money);
			// Phase 1: Trade
			if(p.numProperties != 0) {
				System.out.println("Prompting player for trade.");
				playerChoice = ChoiceEngine.getNextNumber();
				//playerChoice = TradeInfo.display("TRADE", "Would you like to trade?");
			}
			// Ask if player would like to trade
			// Get player choice: 0 = no, 1 = yes
			if(playerChoice == 1) {
				System.out.println("Player wants to trade.");
				int tradee = ChoiceEngine.getNextNumber();
//				int tradee = PlayerPopup.display("TRADE WITH PLAYER", "Select which player to trade with.", p.playerNum);
				if(tradee >= 0) {
					System.out.println("Player wants to trade with Player " + (tradee+1));
					if(players[tradee].numProperties > 0) {
						Property offer = properties[ChoiceEngine.getNextNumber()];
						Property wants = properties[ChoiceEngine.getNextNumber()];
						if(offer != null && wants != null) {
							System.out.println("Player is offering " + offer.name + " for " + wants.name);
//							Property offer = ManagePopup.display("OFFER", "Which property are you offering?", getPlayerProperties(p));
//							Property wants = ManagePopup.display("TRADE FOR...", "Which property do you want?", getPlayerProperties(players[tradee]));
							
							playerChoice = ChoiceEngine.getNextNumber();
//							playerChoice = YesNoPopup.display("ACCEPT OFFER?", "Player " + (tradee+1) + ", Player " + (p.playerNum+1) + " is offering " + offer.name + " for " + wants.name +".\nDo you accept?");
							if(playerChoice == 1) {
								System.out.println("Offer accepted.");
								p.trade(offer, wants, players[tradee]);
								System.out.println("Trade complete. " + offer.name + " now belongs to P" + (offer.owner.playerNum+1) + " and " + wants.name + " now belongs to P"  + (wants.owner.playerNum+1));
//								InfoPopup.display("TRADE COMPLETE", "Trade complete! Player " + (p.playerNum+1) + ", you now own " + wants.name + "!\nPlayer " + (tradee+1) + ", you now own " + offer.name + "!");
							} else {
								System.out.println("Trade denied. No properties have changed hands.");
//								InfoPopup.display("TRADE DENIED", "The trade was declined! No properties have changed hands.");
							}
						}
					} else {
						System.out.println("Tradee has no properties to trade.");
						//InfoPopup.display("CAN'T TRADE!", "Player " + (tradee+1) + " doesn't have any properties to trade!");
					}
					
				}
			}
			// Phase 2: Roll
			if(p.inJail) { 
				System.out.println("Player is in jail.");
				if(p.numJailEscapeAttempts >= 3) {
//					InfoPopup.display("JAIL", "You've served your time in jail and are now free.");
					System.out.println("Player has served sentence and is out of jail.");
					playerChoice = 0;
				} else {
					playerChoice = ChoiceEngine.getNextNumber();
//					playerChoice = YesNoPopup.display("JAIL", "You are in jail!\nDo you want to try to roll doubles?\nYou have "
//							+ (3-p.numJailEscapeAttempts) + " roll(s) left before you must pay $50.");
				}
				p.currentSpace.jail(p, playerChoice);
			}
			if(!p.inJail) {
				playerChoice = 0;
				System.out.println("Player is not in jail.");
				// Testing
				
				d1 = ChoiceEngine.getNextNumber();
				d2 = ChoiceEngine.getNextNumber();
				
				// End Testing
//				d1 = rollDice();
//				d2 = rollDice();
				System.out.println("d1 = " + d1 + ", d2 = " + d2);
//				InfoPopup.display("DICE ROLL", "You rolled a " + d1 + " and a " + d2 + ".\nAdvance " + (d1 + d2) + " spaces!");
				if(d1 == d2) {
					System.out.println("Player has rolled doubles.");
					doublesCounter++;
					if(doublesCounter == 3) {
						System.out.println("Player has rolled three doubles in a row.");
						p.currentSpace = spaces[10];
						p.inJail = true;
					}
					else {
						willRepeatTurn = true;
						p.move(d1 + d2);
						// Get player choice
						// If space type is GO, parking, luxury, go to jail, or jail, choice doesn't matter
						// If space type is UNOWNED property, RR, or utility, 0 = no buy, 1 = buy
						// If space type is OWNED property, choice doesn't matter
						// If space type is income, 0 = $200, 1 = 10%
						switch(p.currentSpace.type) {
						case PROPERTY:
						case UTILITY:
						case RAILROAD:
							if(p.currentSpace.property.owner == null) {
								System.out.println("Player has landed on " + p.currentSpace.property.name + ", which is currently unowned.");
								playerChoice = ChoiceEngine.getNextNumber();
//								playerChoice = YesNoPopup.display(p.currentSpace.property.name, "You have landed on " + p.currentSpace.property.name
//										+ ".\nThis property is AVAILABLE! Would you like to buy it?\nBuy Price: $"
//										+ p.currentSpace.property.deed.buyPrice);
							} else {
								System.out.println("Player has landed on " + p.currentSpace.property.name + " and must pay rent.");
//								InfoPopup.display(p.currentSpace.property.name, "You have landed on " + p.currentSpace.property.name
//										+ ".\nThis property is owned by Player " + (p.currentSpace.property.owner.playerNum+1)
//										+ ". You owe them $" + p.currentSpace.property.getRent(d1+d2));
							}
							break;
							
						case INCOME:
							System.out.println("Player has landed on income tax.");
							playerChoice = ChoiceEngine.getNextNumber();
							//playerChoice = YesNoPopup.display("INCOME TAX", "You must pay income tax!\nPress yes to pay 10% of your money, or no to pay $200.");
							break;
						case GO:
							System.out.println("Player has landed on GO.");
//							InfoPopup.display("GO", "You've landed on GO. Collect $200!");
							break;
						case PARKING:
							System.out.println("Player has landed on a free parking space.");
//							InfoPopup.display("FREE PARKING", "You've landed on Free Parking!");
							break;
						case GOTOJAIL:
							System.out.println("Player has landed on Go To Jail.");
//							InfoPopup.display("GO TO JAIL", "You've landed on Go To Jail! Off to jail with you!");
							break;
						case JAIL:
							System.out.println("Player has landed on jail.");
//							InfoPopup.display("JAIL", "You're visiting jail!");
							break;
						case LUXURY:
							System.out.println("Player has landed on luxury tax.");
//							InfoPopup.display("LUXURY TAX", "You must pay a $75 luxury tax!");
							break;
						}
						p.currentSpace.spaceAction(p, d1 + d2, playerChoice);
					}
				}
				else {
					System.out.println("Player did not roll doubles.");
					p.move(d1 + d2);
					System.out.println("Player is on space " + p.currentSpace.spaceNumber);
					// Get player choice, same formula as last comment
					switch(p.currentSpace.type) {
					case PROPERTY:
					case UTILITY:
					case RAILROAD:
						if(p.currentSpace.property.owner == null) {
							System.out.println("Player has landed on " + p.currentSpace.property.name + ", which is currently unowned.");
							playerChoice = ChoiceEngine.getNextNumber();
//							playerChoice = YesNoPopup.display(p.currentSpace.property.name, "You have landed on " + p.currentSpace.property.name
//									+ ".\nThis property is AVAILABLE! Would you like to buy it?\nBuy Price: $"
//									+ p.currentSpace.property.deed.buyPrice);
						} else {
							System.out.println("Player has landed on " + p.currentSpace.property.name + " and must pay rent.");
//							InfoPopup.display(p.currentSpace.property.name, "You have landed on " + p.currentSpace.property.name
//									+ ".\nThis property is owned by Player " + (p.currentSpace.property.owner.playerNum+1)
//									+ ". You owe them $" + p.currentSpace.property.getRent(d1+d2));
						}
						break;
						
					case INCOME:
						System.out.println("Player has landed on income tax.");
						playerChoice = ChoiceEngine.getNextNumber();
						//playerChoice = YesNoPopup.display("INCOME TAX", "You must pay income tax!\nPress yes to pay 10% of your money, or no to pay $200.");
						break;
					case GO:
						System.out.println("Player has landed on GO.");
//						InfoPopup.display("GO", "You've landed on GO. Collect $200!");
						break;
					case PARKING:
						System.out.println("Player has landed on a free parking space.");
//						InfoPopup.display("FREE PARKING", "You've landed on Free Parking!");
						break;
					case GOTOJAIL:
						System.out.println("Player has landed on Go To Jail.");
//						InfoPopup.display("GO TO JAIL", "You've landed on Go To Jail! Off to jail with you!");
						break;
					case JAIL:
						System.out.println("Player has landed on jail.");
//						InfoPopup.display("JAIL", "You're visiting jail!");
						break;
					case LUXURY:
						System.out.println("Player has landed on luxury tax.");
//						InfoPopup.display("LUXURY TAX", "You must pay a $75 luxury tax!");
						break;
					}
					p.currentSpace.spaceAction(p, d1+d2, playerChoice);
				}
			}
			// Ask player if they would like to buy houses on properties
			// Get player choice. 0 = no, 1 = yes
			if(p.numProperties > 0) {
				playerChoice = ChoiceEngine.getNextNumber();
//				playerChoice = YesNoPopup.display("PROPERTY MANAGEMENT", "Would you like to buy houses for your properties?\nYou have $" + p.money);
				if(playerChoice == 1) {
					System.out.println("Player wants to manage properties.");
					Property manage;
					while(playerChoice == 1) {
						System.out.println("Player is managing properties.");
						int nextChoice = ChoiceEngine.getNextNumber();
						if(nextChoice == -1) { manage = null; } else { manage = properties[nextChoice]; }
						
//						manage = ManagePopup.display("SELECT PROPERTY", "Select the property you want to buy a house for.", getPlayerProperties(p));
						if(manage == null) { System.out.println("Player has cancelled managing properties."); }
						else {
							System.out.println("Player wants to manage " + manage.name);
							if(manage.group.checkMonopoly()) {
								playerChoice = ChoiceEngine.getNextNumber();
//								playerChoice = YesNoPopup.display("CONFIRM PURCHASE", "You're about to buy a house on "
//										+ manage.name + ". Are you sure?\nThe price for a house is $" + manage.deed.housePrice + ". ");
								if(playerChoice == 1) {
									manage.buyHouse();
								} else { System.out.println("Player has changed their mind."); }
							} else {
								System.out.println("...but can't because they don't have a monopoly in that group.");
//								InfoPopup.display("NO MONOPOLY", "You don't have a monopoly on that color group yet, so you can't buy a house.");
							}
						}
						playerChoice = ChoiceEngine.getNextNumber();
//						playerChoice = YesNoPopup.display("CONTINUE?", "Would you like to keep buying houses?\nYou have $" + p.money + " left.");
					}
				}
			}
			// Trade again
			if(willRepeatTurn) {
				System.out.println("Player goes again.");
//				InfoPopup.display("DOUBLES", "You rolled doubles this turn, so you can go again!");
			}
			playerChoice = 0;
		} while(willRepeatTurn);
		
	}

	// This function is retired, being replaced with takeTurn()
//	private void playGame() {
//		// Each turn goes as follows: Move, Space action, Trading, End
//		int d1, d2, doublesCounter = 0, playerChoice = 0;
//		boolean willRepeatTurn;
//		for(int i = 0; i < numTurns; i++) { //A new round of player's turns begins
//			for(int j = 0; j < numPlayers; j++) { //A specific player's turn begins.
//				
//				//At the very beginning of their turn, need to have some kind of pop-up prompt to ask player if they want to roll dice, or trade.
//				//The trade button is always available, but roll button must only be available at the start of a players turn or if theyve rolled doubles.
//				//Also have a "close" button that's available whenever the roll button is not.
//				
//				willRepeatTurn = false;
//				// Trade
//				// Roll and move
//				// Space action
//				// Trade
//				// End
//				// TODO: initialize trade
//				if(players[j].inJail) { players[j].currentSpace.jail(players[j], playerChoice); } // attempt to roll out of jail BEFORE moving
//				d1 = rollDice();
//				d2 = rollDice(); //DO NOT DISCARD THESE for sake of the rent of utilities properties.
//				if(d1 == d2) {
//					
//					//Make player no
//					if(doublesCounter == 3) {
//						//How are we passing the jail method? Is it like below?
//						// see line 520
//						doublesCounter = 0;
//					} else { willRepeatTurn = true; }
//				}
//			}
//		}
//	}
	
	public static int rollDice() {
		return dice.nextInt(6) + 1;
	}
	
	public Player[] declareWinners() {
		Player[] out = new Player[numPlayers];
		Player temp;
		for(int i = 0; i < numPlayers; i++) { out[i] = players[i]; }
		
		for(int i = 0; i < numPlayers; i++) {
			for(int j = i+1; j < numPlayers; j++) {
				if(out[j].numProperties > out[i].numProperties) {
					temp = out[j];
					out[j] = out[i];
					out[i] = temp;
				} else if(out[j].numProperties == out[i].numProperties) {
					if(out[j].money > out[i].money) {
						temp = out[j];
						out[j] = out[i];
						out[i] = temp;
					}
				}
			}
		}
		
		return out;
	}


	public Property[] getPlayerProperties(Player selected){
		Property ownedProperties[] = new Property[selected.numProperties];
		int arrLocation = 0;
		for(int i = 0; i < 28; i++){
			if(properties[i].owner == null) { continue; }
			if(properties[i].owner.equals(selected)){
				ownedProperties[arrLocation] = properties[i];
				arrLocation++;
			}
		}
		return ownedProperties;
	}
}