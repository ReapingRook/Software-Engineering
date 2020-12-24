package source;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MonopolyTestSuite {
	
	@Test
	void InitTest() {
		// Initialization test: 4 player game, 10 turns. This test ensures the board is correctly made.
		GameEngine game = new GameEngine(4, 10);
		assertEquals(4, game.numPlayers);
		assertEquals(10, game.numTurns);
		
		// First check space types and associated properties are correct
		assertEquals(SpaceType.GO, GameEngine.spaces[0].type);
		assertNull(GameEngine.spaces[0].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[1].type);
		assertSame(GameEngine.spaces[1].property, game.properties[0]);
		assertEquals(SpaceType.PARKING, GameEngine.spaces[2].type);
		assertNull(GameEngine.spaces[2].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[3].type);
		assertSame(GameEngine.spaces[3].property, game.properties[1]);
		assertEquals(SpaceType.INCOME, GameEngine.spaces[4].type);
		assertNull(GameEngine.spaces[4].property);
		assertEquals(SpaceType.RAILROAD, GameEngine.spaces[5].type);
		assertSame(GameEngine.spaces[5].property, game.properties[2]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[6].type);
		assertSame(GameEngine.spaces[6].property, game.properties[3]);
		assertEquals(SpaceType.PARKING, GameEngine.spaces[7].type);
		assertNull(GameEngine.spaces[7].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[8].type);
		assertSame(GameEngine.spaces[8].property, game.properties[4]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[9].type);
		assertSame(GameEngine.spaces[9].property, game.properties[5]);
		assertEquals(SpaceType.JAIL, GameEngine.spaces[10].type);
		assertNull(GameEngine.spaces[10].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[11].type);
		assertSame(GameEngine.spaces[11].property, game.properties[6]);
		assertEquals(SpaceType.UTILITY, GameEngine.spaces[12].type);
		assertSame(GameEngine.spaces[12].property, game.properties[7]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[13].type);
		assertSame(GameEngine.spaces[13].property, game.properties[8]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[14].type);
		assertSame(GameEngine.spaces[14].property, game.properties[9]);
		assertEquals(SpaceType.RAILROAD, GameEngine.spaces[15].type);
		assertSame(GameEngine.spaces[15].property, game.properties[10]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[16].type);
		assertSame(GameEngine.spaces[16].property, game.properties[11]);
		assertEquals(SpaceType.PARKING, GameEngine.spaces[17].type);
		assertNull(GameEngine.spaces[17].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[18].type);
		assertSame(GameEngine.spaces[18].property, game.properties[12]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[19].type);
		assertSame(GameEngine.spaces[19].property, game.properties[13]);
		assertEquals(SpaceType.PARKING, GameEngine.spaces[20].type);
		assertNull(GameEngine.spaces[20].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[21].type);
		assertSame(GameEngine.spaces[21].property, game.properties[14]);
		assertEquals(SpaceType.PARKING, GameEngine.spaces[22].type);
		assertNull(GameEngine.spaces[22].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[23].type);
		assertSame(GameEngine.spaces[23].property, game.properties[15]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[24].type);
		assertSame(GameEngine.spaces[24].property, game.properties[16]);
		assertEquals(SpaceType.RAILROAD, GameEngine.spaces[25].type);
		assertSame(GameEngine.spaces[25].property, game.properties[17]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[26].type);
		assertSame(GameEngine.spaces[26].property, game.properties[18]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[27].type);
		assertSame(GameEngine.spaces[27].property, game.properties[19]);
		assertEquals(SpaceType.UTILITY, GameEngine.spaces[28].type);
		assertSame(GameEngine.spaces[28].property, game.properties[20]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[29].type);
		assertSame(GameEngine.spaces[29].property, game.properties[21]);
		assertEquals(SpaceType.GOTOJAIL, GameEngine.spaces[30].type);
		assertNull(GameEngine.spaces[30].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[31].type);
		assertSame(GameEngine.spaces[31].property, game.properties[22]);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[32].type);
		assertSame(GameEngine.spaces[32].property, game.properties[23]);
		assertEquals(SpaceType.PARKING, GameEngine.spaces[33].type);
		assertNull(GameEngine.spaces[33].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[34].type);
		assertSame(GameEngine.spaces[34].property, game.properties[24]);
		assertEquals(SpaceType.RAILROAD, GameEngine.spaces[35].type);
		assertSame(GameEngine.spaces[35].property, game.properties[25]);
		assertEquals(SpaceType.PARKING, GameEngine.spaces[36].type);
		assertNull(GameEngine.spaces[36].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[37].type);
		assertSame(GameEngine.spaces[37].property, game.properties[26]);
		assertEquals(SpaceType.LUXURY, GameEngine.spaces[38].type);
		assertNull(GameEngine.spaces[38].property);
		assertEquals(SpaceType.PROPERTY, GameEngine.spaces[39].type);
		assertSame(GameEngine.spaces[39].property, game.properties[27]);
		
		// Next, check each property is the correct group
		// Brown properties
		assertEquals(game.properties[0].group, game.properties[1].group);
		
		// Light blue properties
		assertEquals(game.properties[3].group, game.properties[4].group);
		assertEquals(game.properties[3].group, game.properties[5].group);
		
		// Pink properties
		assertEquals(game.properties[6].group, game.properties[8].group);
		assertEquals(game.properties[6].group, game.properties[9].group);
		
		// Orange properties
		assertEquals(game.properties[11].group, game.properties[12].group);
		assertEquals(game.properties[11].group, game.properties[13].group);
		
		// Red properties
		assertEquals(game.properties[14].group, game.properties[15].group);
		assertEquals(game.properties[14].group, game.properties[16].group);
		
		// Yellow properties
		assertEquals(game.properties[18].group, game.properties[19].group);
		assertEquals(game.properties[18].group, game.properties[21].group);
		
		// Green properties
		assertEquals(game.properties[22].group, game.properties[23].group);
		assertEquals(game.properties[22].group, game.properties[24].group);
		
		// Dark blue properties
		assertEquals(game.properties[26].group, game.properties[27].group);
		
		// Railroads
		assertEquals(game.properties[2].group, game.properties[10].group);
		assertEquals(game.properties[2].group, game.properties[17].group);
		assertEquals(game.properties[2].group, game.properties[25].group);
		
		// Utilities
		assertEquals(game.properties[7].group, game.properties[20].group);
	}

	@Test
	void diceTest() {
		int die = 0;
		for(int i = 0; i < 100; i++) {
			die = GameEngine.rollDice();
			assertTrue(die > 0);
			assertTrue(die < 7);
		}
	}
	
	@Test
	void propertyTest() {
		Player testPlayer = new Player(1, 1);
		PropertyGroup testGroup = new PropertyGroup("t1");
		PropertyGroup testGroup2 = new PropertyGroup("t2");
		PropertyGroup testUtilGroup = new PropertyGroup("t3");
		PropertyGroup testRRGroup = new PropertyGroup("t4");
		int rent1[] = {1, 2, 3, 4, 5, 6};
		int rent2[] = {7, 8, 9, 10, 11, 12};
		int RRRent[] = {0, 25, 50, 100, 200, 200};
		int noRent[] = {0,0,0,0,0,0};
		Property testProperty = new Property(PropertyType.PROPERTY, "Test Property", testGroup);
		Deed testDeed1 = new Deed(100, rent1, 100, testProperty);
		testProperty.deed = testDeed1;
		Property testProperty2 = new Property(PropertyType.PROPERTY, "Second Test Property", testGroup);
		Deed testDeed2 = new Deed(200, rent2, 200, testProperty2);
		testProperty2.deed = testDeed2;
		Property testRR1 = new Property(PropertyType.RAILROAD, "Test RR 1", testRRGroup);
		Deed testRRDeed1 = new Deed(100, RRRent, 0, testRR1);
		testRR1.deed = testRRDeed1;
		Property testRR2 = new Property(PropertyType.RAILROAD, "Test RR 2", testRRGroup);
		Deed testRRDeed2 = new Deed(100, RRRent, 0, testRR2);
		testRR2.deed = testRRDeed2;
		Property testUtil1 = new Property(PropertyType.UTILITY, "Test Utility 1", testUtilGroup);
		Deed testUtilDeed1 = new Deed(100, noRent, 0, testUtil1);
		testUtil1.deed = testUtilDeed1;
		Property testUtil2 = new Property(PropertyType.UTILITY, "Test Utility 2", testUtilGroup);
		Deed testUtilDeed2 = new Deed(100, noRent, 0, testUtil2);
		testUtil2.deed = testUtilDeed2;
		Property veryExpensiveProperty = new Property(PropertyType.PROPERTY, "Very Expensive Property", testGroup2);
		Deed veryExpensiveDeed = new Deed(999999, rent1, 999999, veryExpensiveProperty);
		veryExpensiveProperty.deed = veryExpensiveDeed;
		
		assertEquals(0, testRRGroup.numPropertiesOwned(testPlayer));
		
		// Test: Player tries to purchase a property they cannot afford
		assertEquals(veryExpensiveProperty.purchaseProperty(testPlayer), 1);
		
		// Test: Player tries to purchase a house on a non-property (RR or Util)
		assertEquals(1, testRR1.buyHouse(), 1);
		assertEquals(1, testUtil1.buyHouse(), 1);
		
		// Test: Player purchases a property.
		testProperty.purchaseProperty(testPlayer);
		assertEquals(4, testProperty.buyHouse()); // Subtest: Player tries to purchase a house on a property group without a monopoly
		assertSame(testProperty.owner, testPlayer); // Owner is set to testPlayer
		assertEquals(14900, testPlayer.money); // testPlayer's money is decremented the correct amount
		assertEquals(1, testGroup.numPropertiesOwned(testPlayer)); // testGroup's numPropertiesOwned field updates correctly
		assertFalse(testGroup.checkMonopoly()); // One property is not enough for a monopoly
		assertEquals(1, testProperty.getRent(testProperty.numHouses)); // getRent functions properly
		
		// Test: Player earns a monopoly through purchasing all properties
		testProperty2.purchaseProperty(testPlayer);
		assertSame(testProperty2.owner, testPlayer);
		assertEquals(14700, testPlayer.money);
		assertEquals(2, testGroup.numPropertiesOwned(testPlayer));
		assertTrue(testGroup.checkMonopoly()); // After buying all properties in testGroup, testPlayer has monopoly over testGroup 
		assertEquals(3, testProperty.getRent(testProperty.numHouses)); // Rent is tripled on groups that are monopolized with no houses
		
		// Test: Player tries to buy a house they cannot afford
		veryExpensiveProperty.owner = testPlayer;
		assertNotNull(veryExpensiveProperty.type);
		assertEquals(3, veryExpensiveProperty.buyHouse());
		
		// Test: Player trues to buy a house that has a hotel on it (max number of houses reached)
		int temp = testProperty.numHouses;
		testProperty.numHouses = 4;
		testProperty.hasHotel = true;
		assertEquals(2, testProperty.buyHouse());
		// Reset test
		testProperty.numHouses = temp;
		testProperty.hasHotel = false;
		
		// Test: getRent works for all houses=
		// The case of numHouses = 0 is tested in an earlier test
		assertEquals(0, testProperty.buyHouse()); // buy house and make sure the function returns correct value
		assertEquals(1, testProperty.numHouses);
		assertEquals(2, testProperty.getRent(testProperty.numHouses));
		testProperty.buyHouse();
		assertEquals(2, testProperty.numHouses);
		assertEquals(3, testProperty.getRent(testProperty.numHouses));
		testProperty.buyHouse();
		assertEquals(3, testProperty.numHouses);
		assertEquals(4, testProperty.getRent(testProperty.numHouses));
		testProperty.buyHouse();
		assertEquals(4, testProperty.numHouses);
		assertEquals(5, testProperty.getRent(testProperty.numHouses));
		
		// Test: Player earns a hotel through buying houses
		assertFalse(testProperty.hasHotel);
		testProperty.buyHouse();
		assertTrue(testProperty.hasHotel);
		assertEquals(6, testProperty.getRent(testProperty.numHouses));
		
		// Test: getRent on Utilities
		testUtil1.purchaseProperty(testPlayer);
		assertFalse(testUtilGroup.checkMonopoly());
		assertEquals(4, testUtil1.getRent(1));
		testUtil2.purchaseProperty(testPlayer);
		assertTrue(testUtilGroup.checkMonopoly());
		assertEquals(10, testUtil1.getRent(1));
		
		// Test: getRent on Railroads
		assertEquals(0, testRR1.getRent(0));
		testRR1.purchaseProperty(testPlayer);
		assertEquals(25, testRR1.getRent(0));
		testRR2.purchaseProperty(testPlayer);
		assertEquals(50, testRR1.getRent(0));
	}
	
	@Test
	void playerMoveTest() {
		@SuppressWarnings("unused")
		GameEngine game = new GameEngine(4, 10);
		Player testPlayer = new Player(1, 0);
		
		// Test: Player starts on GO
		assertEquals(testPlayer.currentSpace, GameEngine.spaces[0]);
		assertTrue(GameEngine.spaces[0].occupiedByPlayer[testPlayer.playerNum]);
		
		// Test: Player moves one space
		testPlayer.move(1);
		assertEquals(testPlayer.currentSpace, GameEngine.spaces[1]);
		assertFalse(GameEngine.spaces[0].occupiedByPlayer[testPlayer.playerNum]);
		assertTrue(GameEngine.spaces[1].occupiedByPlayer[testPlayer.playerNum]);
		
		// Test: Player moves eight spaces
		testPlayer.move(8);
		assertEquals(testPlayer.currentSpace, GameEngine.spaces[9]);
		assertFalse(GameEngine.spaces[1].occupiedByPlayer[testPlayer.playerNum]);
		assertTrue(GameEngine.spaces[9].occupiedByPlayer[testPlayer.playerNum]);
		
		// Test: Player passes GO and collects $200
		testPlayer.move(30);
		assertEquals(testPlayer.currentSpace, GameEngine.spaces[39]);
		assertFalse(GameEngine.spaces[9].occupiedByPlayer[testPlayer.playerNum]);
		assertTrue(GameEngine.spaces[39].occupiedByPlayer[testPlayer.playerNum]);
		int temp = testPlayer.money;
		testPlayer.move(1);
		assertEquals(testPlayer.currentSpace, GameEngine.spaces[0]);
		assertEquals(testPlayer.money, temp + 200);
	}
	
	@Test
	void spaceActionTest() {
		@SuppressWarnings("unused")
		GameEngine game = new GameEngine(4, 10);
		Player testPlayer = new Player(1, 0);
		Player testPlayer2 = new Player(2, 1);
		int startingMoney = testPlayer.money;
		int moneyBefore = testPlayer.money;
		int targetMoney;
		
		// Testing spaceAction on the following spaces: 1 (prop), 4 (income), 5 (rr),
		// 12 (util), 30 (go to jail), 38 (luxury)
		
		// Test: Player lands on unowned property, does not want to buy
		GameEngine.spaces[1].spaceAction(testPlayer, 0, 0);
		assertEquals(moneyBefore, testPlayer.money);
		assertNull(GameEngine.spaces[1].property.owner);
		
		// Test: Player lands on unowned property, wants to buy
		GameEngine.spaces[1].spaceAction(testPlayer, 0, 1);
		targetMoney = startingMoney - GameEngine.spaces[1].property.deed.buyPrice;
		assertEquals(targetMoney, testPlayer.money);
		assertEquals(GameEngine.spaces[1].property.owner, testPlayer);
		
		// Test: Player lands on owned property
		GameEngine.spaces[1].spaceAction(testPlayer2, 0, 0);
		targetMoney = startingMoney - GameEngine.spaces[1].property.getRent(0);
		assertEquals(targetMoney, testPlayer2.money);
		
		// Test: Player lands on income tax and wants to pay $200
		moneyBefore = testPlayer2.money;
		GameEngine.spaces[4].spaceAction(testPlayer2, 0, 0);
		assertEquals(moneyBefore - 200, testPlayer2.money);
		
		// Test: Player lands on income tax and wants to pay 10%
		moneyBefore = testPlayer.money;
		GameEngine.spaces[4].spaceAction(testPlayer, 0, 1);
		moneyBefore -= (int) Math.floor(moneyBefore * 0.1);
		assertEquals(moneyBefore, testPlayer.money);
		
		// Test: Player lands on unowned railroad, does not want to buy
		targetMoney = testPlayer.money;
		GameEngine.spaces[5].spaceAction(testPlayer, 0, 0);
		assertEquals(targetMoney, testPlayer.money);
		assertNull(GameEngine.spaces[5].property.owner);
		
		// Test: Player lands on unowned railroad, wants to buy
		targetMoney = testPlayer.money;
		GameEngine.spaces[5].spaceAction(testPlayer, 0, 1);
		targetMoney -= GameEngine.spaces[5].property.deed.buyPrice;
		assertEquals(targetMoney, testPlayer.money);
		assertEquals(GameEngine.spaces[5].property.owner, testPlayer);
		
		// Test: Player lands on owned railroad
		targetMoney = testPlayer2.money;
		GameEngine.spaces[5].spaceAction(testPlayer2, 0, 0);
		targetMoney -= GameEngine.spaces[5].property.getRent(0);
		assertEquals(targetMoney, testPlayer2.money);
		
		// Test: Player lands on unowned utility, does not want to buy
		targetMoney = testPlayer.money;
		GameEngine.spaces[12].spaceAction(testPlayer, 0, 0);
		assertEquals(targetMoney, testPlayer.money);
		assertNull(GameEngine.spaces[12].property.owner);
		
		// Test: Player lands on unowned utility, wants to buy
		targetMoney = testPlayer.money;
		GameEngine.spaces[12].spaceAction(testPlayer, 0, 1);
		targetMoney -= GameEngine.spaces[12].property.deed.buyPrice;
		assertEquals(targetMoney, testPlayer.money);
		assertEquals(GameEngine.spaces[12].property.owner, testPlayer);
		
		// Test: Player lands on owned utilty (roll: 3, so rent: 12)
		targetMoney = testPlayer2.money;
		GameEngine.spaces[12].spaceAction(testPlayer2, 3, 0);
		targetMoney -= 12;
		assertEquals(targetMoney, testPlayer2.money);
		
		// Test: Player lands on Go To Jail
		GameEngine.spaces[30].spaceAction(testPlayer, 0, 0);
		assertTrue(testPlayer.inJail);
		assertEquals(GameEngine.spaces[10], testPlayer.currentSpace);
		
		// Test: Player lands on luxury tax
		targetMoney = testPlayer.money;
		GameEngine.spaces[38].spaceAction(testPlayer, 0, 0);
		assertEquals(targetMoney - 75, testPlayer.money);
		
	}
	
	@Test
	void jailTest() {
		Player testPlayer = new Player(1, 0);
		Space jail = new Space();
		jail.type = SpaceType.JAIL;
//		ChoiceEngine choice = new ChoiceEngine();
		
		// Test: Player starts not in jail
		assertFalse(testPlayer.inJail);
		
		// Test: Player is in jail and pays the fine to leave jail
		testPlayer.inJail = true;
		int temp = testPlayer.money;
		jail.jail(testPlayer, 0);
		assertEquals(temp - 50, testPlayer.money);
		assertFalse(testPlayer.inJail);
		
		// Test: Player is in jail and wants to roll to leave jail. Roll successful
		testPlayer.inJail = true;
		temp = testPlayer.money;
		ChoiceEngine.changeChoice(0, 3);
		ChoiceEngine.changeChoice(1, 3);
		jail.jail(testPlayer, 1);
		assertFalse(testPlayer.inJail);
		assertEquals(testPlayer.money, temp);
		ChoiceEngine.counter = 0;
		
		// Test: Player is in jail and wants to roll to leave jail. Roll unsuccessful.
		testPlayer.inJail = true;
		temp = testPlayer.money;
		ChoiceEngine.changeChoice(1, 6);
		jail.jail(testPlayer, 1);
		assertTrue(testPlayer.inJail);
		assertEquals(testPlayer.money, temp);
		ChoiceEngine.counter = 0;
		
		// Test: Player is in jail and wants to roll to leave jail for the second time. Roll unsuccessful
		assertTrue(testPlayer.inJail);
		jail.jail(testPlayer, 1);
		assertTrue(testPlayer.inJail);
		assertEquals(testPlayer.money, temp);
		ChoiceEngine.counter = 0;
		
		// Test: Player is in jail and wants to roll to leave jail for the third time. Roll unsuccessful
		assertTrue(testPlayer.inJail);
		jail.jail(testPlayer, 1);
		assertTrue(testPlayer.inJail);
		assertEquals(testPlayer.money, temp);
		ChoiceEngine.counter = 0;
		
		// Test: Player leaves jail after three failed doubles attempts
		temp = testPlayer.money;
		assertTrue(testPlayer.inJail);
		jail.jail(testPlayer, 1);
		assertFalse(testPlayer.inJail);
		assertEquals(testPlayer.money, temp - 50);
	}
	
	@Test
	void declareWinnersTest() {
		GameEngine game = new GameEngine(4, 10);
		Player p1 = new Player(0, 0);
		Player p2 = new Player(1, 1);
		Player p3 = new Player(2, 2);
		Player p4 = new Player(3, 3);
		
		game.players[0] = p1;
		game.players[1] = p2;
		game.players[2] = p3;
		game.players[3] = p4;
		
		System.out.println("p1 = " + game.players[0]);
		System.out.println("p2 = " + game.players[1]);
		System.out.println("p3 = " + game.players[2]);
		System.out.println("p4 = " + game.players[3]);
		
		p1.numProperties = 0;
		p1.money = 200;
		
		p2.numProperties = 999;
		p2.money = 1000;
		
		p3.numProperties = 999;
		p3.money = 999999;
		
		p4.numProperties = 999;
		p4.money = 0;
		
		game.standings = game.declareWinners();
		
		assertEquals(game.standings[0], p3);
		assertEquals(game.standings[1], p2);
		assertEquals(game.standings[2], p4);
		assertEquals(game.standings[3], p1);
	}
	
	
	@Test
	void testGame() {
		@SuppressWarnings("unused")
		ChoiceEngine c = new ChoiceEngine();
		String testInputs = "1 2 1 0 1 3 0 1 1 5 6 1 0 3 1 1 0 0 5 6 0 0 1 0 4 9 0 2 2 1 0 1 0 7 9 1 3 3 1 0 0 3 3 0 0 6 6 1 0 0 1 3 1 1 -1 1 0 0 1 0 1 1 9 0 0 1 1 2 0 0 3 4 0 0 1 1 2 0 0 1 1 0 0 3 4 0 0 1 1 2 0 0 4 4 0 0 0 2 3 0 0 5 5 0 0 6 6 1 0 0 2 4 0 0 1 1 2 0 0 1 1 0 0 1 3 1 0";
		String[] splitArray = testInputs.split(" ");
		int[] choices = new int[255];
		for(int i = 0; i < 126; i++) {
			choices[i] = Integer.parseInt(splitArray[i]);
		}
		ChoiceEngine.choices = choices;
		GameEngine game = new GameEngine(2, 4);
		
		// 2 Players, 4 turns
		// Turn 1 P1: lands on Baltic and buys property
		System.out.println("---TURN 1 P1---");
		game.takeTurn(game.players[0]);
		assertEquals(game.properties[1].owner, game.players[0]);
		assertEquals(game.players[0].money, 14940);
		assertEquals(game.properties[1], game.getPlayerProperties(game.players[0])[0]);
		
		// Turn 1 P2: lands on Income Tax
		System.out.println("---TURN 1 P2---");
		game.takeTurn(game.players[1]);
		assertEquals(game.players[1].money, 14800);
		
		// Turn 2 P1: lands on Virginia and buys property
		System.out.println("---TURN 2 P1---");
		game.takeTurn(game.players[0]);
		assertEquals(game.properties[9].owner, game.players[0]);
		assertEquals(game.players[0].money, 14780);
		
		// Turn 2 P2: lands on Vermont and buys property
		System.out.println("---TURN 2 P2---");
		game.takeTurn(game.players[1]);
		assertEquals(game.properties[4].owner, game.players[1]);
		assertEquals(game.players[1].money, 14700);
		
		// Turn 3 P1: lands on B&O
		System.out.println("---TURN 3 P1---");
		game.takeTurn(game.players[0]);
		assertNull(game.properties[17].owner);
		
		// Turn 3 P2: offers Vermont for Virigina, offer denied. Rolls doubles.
		// Lands on electric company and buys property.
		// Offers electric for virigina. Offer accepted. Rolls doubles.
		// Lands on tennessee and buys property. Rolls doubles and goes to jail.
		System.out.println("---TURN 3 P2---");
		game.takeTurn(game.players[1]);
		assertEquals(game.properties[9].owner, game.players[1]);
		assertEquals(game.properties[7].owner, game.players[0]);
		assertTrue(game.players[1].inJail);
		assertEquals(game.players[1].money, 14370);
		
		// Turn 4 P1: Rolls doubles. Lands on park place and buys property.
		// Rolls doubles. Lands on mediterranian and buys property.
		// Buys house on mediterranian
		System.out.println("---TURN 4 P1---");
		game.takeTurn(game.players[0]);
		assertEquals(game.properties[26].owner, game.players[0]);
		assertEquals(game.players[0].money, 14520);
		assertEquals(game.properties[0].owner, game.players[0]);
		assertEquals(game.properties[0].numHouses, 1);
		
		// Turn 4 P2: Attempts to roll out of jail, fails.
		System.out.println("---TURN 4 P2---");
		game.takeTurn(game.players[1]);
		assertTrue(game.players[1].inJail);
		
		// Turn 5 P1: Player lands on Vermont, pays P2 $%6
		System.out.println("---TURN 5 P1---");
		game.takeTurn(game.players[0]);
		assertEquals(game.players[0].money, 14514);
		assertEquals(game.players[1].money, 14376);
		
		// Turn 5 P2: Attempts to roll out of jail, fails
		System.out.println("---TURN 5 P2---");
		game.takeTurn(game.players[1]);
		assertTrue(game.players[1].inJail);
		
		// Turn 6 P1: Rolls a 2 and lands in jail. Rolls a 2 and lands on free parking.
		System.out.println("---TURN 6 P1---");
		game.takeTurn(game.players[0]);
		assertEquals(game.spaces[17], game.players[0].currentSpace);
		
		// Turn 6 P2: Attempts to roll out of jail, fails
		System.out.println("---TURN 6 P2---");
		game.takeTurn(game.players[1]);
		assertTrue(game.players[1].inJail);
		
		// Turn 7 P1: Rolls and 8 and lands on B&O RR. Does not buy. Rolls a 5 and goes to jail.
		System.out.println("---TURN 7 P1---");
		game.takeTurn(game.players[0]);
		assertTrue(game.players[0].inJail);
		
		// Turn 7 P2: Must pay $50 to get out of jail. Rolls a 10 and lands on free parking.
		// Lands on NC Ave and buys property. Lands on luxury tax
		System.out.println("---TURN 7 P2---");
		game.takeTurn(game.players[1]);
		assertFalse(game.players[1].inJail);
		assertEquals(game.properties[23].owner, game.players[1]);
		assertEquals(game.players[1].money, 13951);
		
		// Turn 8 P1: Attempts to roll out of jail and fails
		System.out.println("---TURN 8 P1---");
		game.takeTurn(game.players[0]);
		assertTrue(game.players[0].inJail);
		
		// Turn 8 P2: Rolls a 2 and lands on GO. Rolls a 4 and lands on income tax. Pays 10%
		System.out.println("---TURN 8 P2---");
		game.takeTurn(game.players[1]);
		assertEquals(game.players[1].money, 12736);
	}
	
	@Test
	void startGameTest() {
		ChoiceEngine c = new ChoiceEngine();
		String testInputs = "1 2 1 0 1 3 0 1 1 5 6 1 0 3 1 1 0 0 5 6 0 0 1 0 4 9 0 2 2 1 0 1 0 7 9 1 3 3 1 0 0 3 3 0 0 6 6 1 0 0 1 3 1 1 -1 1 0 0 1 0 1 1 9 0 0 1 1 2 0 0 3 4 0 0 1 1 2 0 0 1 1 0 0 3 4 0 0 1 1 2 0 0 4 4 0 0 0 2 3 0 0 5 5 0 0 6 6 1 0 0 2 4 0 0 1 1 2 0 0 1 1 0 0 1 3 1 0";
		String[] splitArray = testInputs.split(" ");
		int[] choices = new int[255];
		for(int i = 0; i < 126; i++) {
			choices[i] = Integer.parseInt(splitArray[i]);
		}
		ChoiceEngine.choices = choices;
		GameEngine game = new GameEngine(2, 8);
		
		game.startGame();
		assertEquals(game.players[0], game.standings[0]);
		assertEquals(game.players[1], game.standings[1]);
	}
}
