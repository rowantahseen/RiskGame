package players;

import java.awt.Color;

import board.Territory;

public class PassivePlayer extends Player {

	public PassivePlayer(Color pColor) {
		super(pColor);
		// TODO Auto-generated constructor stub
	}
	
	public boolean takeTurn() {
		super.takeTurn();
		if(this.deployTroops())
			return this.attack();
		
		return false;
	}
	
	protected boolean deployTroops() {
		int min = Integer.MAX_VALUE;
		Territory minT = null;
		for(Territory t: myTerritories) {
			if(t.getTroops() < min) {
				min = t.getTroops();
				minT = t;
			}
		}
		minT.setTroops(minT.getTroops() + this.freeTroops);
		return true;
	}
	
	protected boolean attack() {
		
		return true;
	}

}
