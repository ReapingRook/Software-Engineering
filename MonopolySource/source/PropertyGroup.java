package source;


public class PropertyGroup {
	String name;
	Property[] properties = new Property[4];
	int tracker;
	boolean monopolyAchieved;
	Player monopolyOwner;
	
	public PropertyGroup(String name) {
		this.name = name;
		tracker = 0;
		monopolyAchieved = false;
		monopolyOwner = null;
	}
	
	public int numPropertiesOwned(Player player) {
		int out = 0;
		for(int i = 0; i < 4; i++) {
			if(properties[i] == null) { break; }
			if(properties[i].owner == null) { continue; }
			if(properties[i].owner == player) {	out++; }
		}
		
		return out;
	}
	
	public void addProperty(Property in) {
		in.group = this;
		properties[tracker] = in;
		tracker++;
	}
	
	public boolean checkMonopoly() {
		boolean out = true;
		Player ownerInQuestion = properties[0].owner;
		
		for(int i = 1; i < 4; i++) {
			if(properties[i] == null) { break; }
			if(properties[i].owner != ownerInQuestion) {
				out = false;
				break;
			}
		}
		monopolyAchieved = out;
		if(monopolyAchieved) { monopolyOwner = ownerInQuestion; } else { monopolyOwner = null; }
		return out;
	}
}