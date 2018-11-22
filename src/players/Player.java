package players;

import java.awt.Color;
import java.util.ArrayList;

import board.Territory;
import board.Map;

public abstract class Player {

	protected final Color playerColor; // Check if JavaFX have different colors
	protected int freeTroops;
	
	protected ArrayList<Territory> myTerritories;
	protected ArrayList<Territory> enemyTerritories;
	protected Map map;
	
	public Player(Color pColor) {
		this.playerColor = pColor;
		this.freeTroops = 20;
		this.myTerritories =  new ArrayList<>();
		this.enemyTerritories =  new ArrayList<>();
		this.map = Map.getInstance();
	}
	
	public boolean takeTurn() {
		this.freeTroops = Integer.max(this.myTerritories.size()/3, 3);
		return true;
	}
	
	protected boolean deployTroops() {
		return true;
	}
	
	protected boolean attack() {
		return true;
	}
	
	protected void setEnemyTerritories(){
		
		// based on fact there are only 2 players
		// For more we gotta add each opponents to Arraylist
		for(Player p: map.getInstance().getPlayers()) {
			if(!p.equals(this)) {
				this.enemyTerritories = p.myTerritories;
			}
		}
	}
	
}
