package source;

public class Deed {
	Property property;
	int buyPrice; // Price to buy property
	int rent[] = new int[6]; // Rent given number houses (index 0: no houses, index 1: 1 house ... index 5: hotel)
	int housePrice; // How much to buy a house
	int sellPrice; // Mortgage value
	
	public Deed(int buy, int[] rents, int house, Property property) {
		buyPrice = buy;
		rent = rents;
		housePrice = house;
		sellPrice = buy / 2;
		this.property = property;
	}
	
	public int getRent(int input) {
		System.out.println("Getting rent with input " + input);
		// If player has monopoly, rent is tripled on spaces without houses
		if(property.type == PropertyType.PROPERTY && property.group.checkMonopoly() && property.numHouses == 0) { return rent[0] * 3; }
		else if(property.type == PropertyType.UTILITY) { 
			System.out.println("Utility");
			// Rent on utilities is 4 times the die roll if one is owned, and 10 if both are
			if(property.group.checkMonopoly()) {
				System.out.println("Monopoly on utilities");
				return input * 10;
			} else {
				System.out.println("Player does not have a monopoly on " + property.group.name);
				return input * 4;
			}
		}
		else return rent[input];
	}
}
