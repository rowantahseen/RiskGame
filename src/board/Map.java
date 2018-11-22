package board;

import java.awt.Color;
import java.util.ArrayList;
import players.*;

public class Map {
	
	private static Map INSTANCE;
	private static final boolean EGYPT = false;
	private static final boolean USA = true;
	
	private final Color[] colors = {Color.red, Color.blue, Color.green, Color.yellow, Color.cyan, Color.magenta};

	private ArrayList<Territory>[] map;
	private Pair[] playerTerritories;

	
	private Map() {}
	
	public static Map getInstance() {
		if(Map.INSTANCE == null) {
			Map.INSTANCE = new Map();
		}
		return Map.INSTANCE;
	}
	
	public void configure(boolean terrain, int[] playerModes) {
		this.setMap(terrain);
		
		playerTerritories = new Pair[playerModes.length];
		
		for(int i=0; i < playerModes.length; i++) {
			switch(playerModes[i]) {
				case (1): playerTerritories[i].player = new HumanPlayer(colors[i]);
					break;
				case (2): playerTerritories[i].player = new PassivePlayer(colors[i]);
					break;
				case (3): playerTerritories[i].player = new AggressivePlayer(colors[i]);
					break;
				case (4): playerTerritories[i].player = new SemiPassivePlayer(colors[i]);
					break;	
				case (5): playerTerritories[i].player = new GreedyAIPlayer(colors[i]);
					break;					
				case (6): playerTerritories[i].player = new AStarPlayer(colors[i]);
					break;
				case (7): playerTerritories[i].player = new RealTimeAStarPlayer(colors[i]);
					break;
				case (8): playerTerritories[i].player = new MinimaxPlayer(colors[i]);
					break;
			}
		}
	}
		
	public ArrayList<Territory>[] getMap(){
		return this.map;
	}
	
	public Player[] getPlayers() {
		return this.getPlayers();
	}
	
	public ArrayList<Territory> getPlayerTerritory(Player p){
		for(Pair pair : this.playerTerritories) {
			if(pair.player.equals(p)) {
				return pair.territories;
			}
		}
		return null;
	}
	
	public boolean adjacent(Territory t1, Territory t2) {
		return this.map[t1.getID()].contains(t2 /*.getID()*/);
	}
	
	private void setMap(boolean terrain) {
		if(terrain == Map.USA) {
			this.buildStates();
		}
		this.buildEgypt();
	}
	
	private void buildStates() {
		this.map = new ArrayList[51];
		
		Territory[] states = new Territory[51];

        for (int i = 1; i <= 50; i++) {
            states[i] = new Territory(i);
        }

        map[1].add(states[2]);map[1].add(states[5]);

        map[2].add(states[1]);map[2].add(states[3]);map[2].add(states[4]);map[2].add(states[5]);

        map[3].add(states[2]);map[3].add(states[4]);map[3].add(states[9]);

        map[4].add(states[2]);map[4].add(states[3]);map[4].add(states[5]);map[4].add(states[8]);
        map[4].add(states[9]);

        map[5].add(states[1]);map[5].add(states[2]);map[5].add(states[4]);map[5].add(states[6]);
        map[5].add(states[7]);map[5].add(states[8]);

        map[6].add(states[5]);map[6].add(states[7]);map[6].add(states[16]);map[6].add(states[17]);

        map[7].add(states[5]);map[7].add(states[6]);map[7].add(states[8]);map[7].add(states[10]);
        map[7].add(states[15]);map[7].add(states[16]);

        map[8].add(states[4]);map[8].add(states[5]);map[8].add(states[7]);map[8].add(states[9]);
        map[8].add(states[10]);

        map[9].add(states[3]);map[9].add(states[4]);map[9].add(states[8]);map[9].add(states[11]);

        map[10].add(states[7]);map[10].add(states[8]);map[10].add(states[11]);map[10].add(states[13]);
        map[10].add(states[14]);map[10].add(states[15]);

        map[11].add(states[9]);map[11].add(states[10]);map[11].add(states[12]);map[11].add(states[13]);

        map[12].add(states[11]);map[12].add(states[13]);map[12].add(states[21]);map[12].add(states[22]);

        map[13].add(states[10]);map[13].add(states[11]);map[13].add(states[12]);map[13].add(states[14]);
        map[13].add(states[20]);map[13].add(states[21]);

        map[14].add(states[10]);map[14].add(states[13]);map[14].add(states[15]);map[14].add(states[20]);

        map[15].add(states[7]);map[15].add(states[10]);map[15].add(states[14]);map[15].add(states[16]);
        map[15].add(states[19]);map[15].add(states[20]);

        map[16].add(states[6]);map[16].add(states[7]);map[16].add(states[15]);map[16].add(states[17]);
        map[16].add(states[18]);map[16].add(states[19]);

        map[17].add(states[6]);map[17].add(states[16]);map[17].add(states[18]);

        map[18].add(states[16]);map[18].add(states[17]);map[18].add(states[19]);map[18].add(states[34]);

        map[19].add(states[15]);map[19].add(states[16]);map[19].add(states[18]);map[19].add(states[20]);
        map[19].add(states[33]);map[19].add(states[34]);

        map[20].add(states[13]);map[20].add(states[14]);map[20].add(states[15]);map[20].add(states[19]);
        map[20].add(states[21]);map[20].add(states[31]);map[20].add(states[32]);map[20].add(states[33]);

        map[21].add(states[12]);map[21].add(states[13]);map[21].add(states[20]);map[21].add(states[22]);
        map[21].add(states[23]);map[21].add(states[31]);

        map[22].add(states[12]);map[22].add(states[21]);map[22].add(states[23]);

        map[23].add(states[21]);map[23].add(states[22]);map[23].add(states[24]);map[23].add(states[31]);

        map[24].add(states[23]);map[24].add(states[25]);map[24].add(states[26]);map[24].add(states[31]);

        map[25].add(states[24]);map[25].add(states[26]);
	}
	
	private void buildEgypt() {
		this.map = new ArrayList[29];
	}
	
	private class Pair {
		
		private Player player;
		private ArrayList<Territory> territories;
		
		private Pair() {}
		
		private void addTerritory(Territory t) {
			this.territories.add(t);
		}
		
		private void removeTerritory(Territory t) {
			this.territories.remove(t);
		}
		
	}
	
}
