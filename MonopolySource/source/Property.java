package source;


public class Property {
	PropertyType type;
	String name;
	Player owner;
	PropertyGroup group;
	boolean hasHotel;
	int numHouses;
	int housePrice;
	Deed deed;
	
	public Property(PropertyType t, String n, PropertyGroup g) {
		type = t;
		owner = null;
		hasHotel = false;
		numHouses = 0;
		name = n;
		g.addProperty(this);
		deed = null; // will be added later
	}
	
	public int purchaseProperty(Player p) {
		// Return value key:
		// 0: purchase successful
		// 1: player cannot afford property
		
		if(p.money >= deed.buyPrice) {
			p.editMoney(-deed.buyPrice);
			owner = p;
			p.numProperties++;
			group.checkMonopoly();
			return 0;
		} else {
			return 1;
		}
	}
	
	public int buyHouse() {
		// Return Values key:
		// 0: purchase successful
		// 1: property is a railroad or utility, and does not have houses to buy
		// 2: property has max number of houses
		// 3: player cannot afford to build a house
		// 4: player doesn't have a monopoly and can't buy houses
		
		if(type != PropertyType.PROPERTY) { return 1; }
		if(hasHotel) { return 2; }
		
		if(group.checkMonopoly()) {
			if(owner.money >= deed.housePrice) {
				if(numHouses >= 4) { hasHotel = true; }
				if(numHouses > 5) { return 2; }
				else {
					owner.money -= deed.housePrice;
					numHouses++;
					return 0;
				}
			} else {
				return 3;
			}
		} else { return 4; }
	}
	
	public int getRent(int input) {
		if(type == PropertyType.UTILITY) { return deed.getRent(input); }
		if(type == PropertyType.RAILROAD) { return deed.getRent(group.numPropertiesOwned(owner)); }
		else { return deed.getRent(numHouses); }
	}
}