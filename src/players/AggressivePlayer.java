package players;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;

import board.Territory;

public class AggressivePlayer extends Player {

	public AggressivePlayer(Color pColor) {
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
		
		super.deployTroops();
		
		int max = Integer.MIN_VALUE;
		Territory maxT = null;
		for(Territory t: myTerritories) {
			if(t.getTroops() < max) {
				max = t.getTroops();
				maxT = t;
			}
		}
		maxT.setTroops(maxT.getTroops() + this.freeTroops);
		return true;
	}
	
	protected boolean attack() {
		
		super.attack();
		
		// Sorting Descendingly
		Territory[] toArray = (Territory[]) enemyTerritories.toArray();
        Arrays.sort(toArray, Collections.reverseOrder());
	
		// attack first eligible territory
        // Still need to accommodate attacking multiple territories
		for (Territory t: toArray) {
			for(Territory myT: myTerritories) {
				if(this.map.adjacent(t, myT) && myT.getTroops() > 1) {
					
				}
			}
		}

		return true;
	}


}
