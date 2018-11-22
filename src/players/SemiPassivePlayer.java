package players;

import java.awt.Color;
import java.util.Arrays;
import java.util.Collections;

import board.Territory;

public class SemiPassivePlayer extends PassivePlayer {

	public SemiPassivePlayer(Color pColor) {
		super(pColor);
		// TODO Auto-generated constructor stub
	}
	
	protected boolean attack() {
		
		super.attack();
		
		// Sorting Ascendingly
		Territory[] toArray = (Territory[]) enemyTerritories.toArray();
		Arrays.sort(toArray);
		
		for (Territory t: toArray) {
			for(Territory myT: myTerritories) {
				if(this.map.adjacent(t, myT) && myT.getTroops() > 1) {
					return myT.attackTerritory(t);
				}
			}
		}
		return false;
	}

}
