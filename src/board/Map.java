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
	private ArrayList<Player> players;
	private ArrayList<Territory>[] playerTerritories;

	
	private Map() {}
	
	public static Map getInstance() {
		if(Map.INSTANCE == null) {
			Map.INSTANCE = new Map();
		}
		return Map.INSTANCE;
	}
	
	public void configure(boolean terrain, int[] playerModes) {
		this.setMap(terrain);
		
		players = new ArrayList(playerModes.length);
		playerTerritories = new ArrayList[playerModes.length];
		
		for(int i=0; i < playerModes.length; i++) {
			switch(playerModes[i]) {
				case (1): players.add(new HumanPlayer(colors[i]));
					break;
				case (2): players.add(new PassivePlayer(colors[i]));
					break;
				case (3): players.add(new AggressivePlayer(colors[i]));
					break;
				case (4): players.add(new SemiPassivePlayer(colors[i]));
					break;	
				case (5): players.add(new GreedyAIPlayer(colors[i]));
					break;					
				case (6): players.add(new AStarPlayer(colors[i]));
					break;
				case (7): players.add(new RealTimeAStarPlayer(colors[i]));
					break;
				case (8): players.add(new MinimaxPlayer(colors[i]));
					break;
			}
		}
	}
		
	public ArrayList<Territory>[] getMap(){
		return this.map;
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	public ArrayList<Territory> getPlayerTerritory(Player p){
		for(Player player : this.players) {
			if(player.equals(p)) {
				return playerTerritories[players.indexOf(player)];
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
        
        map[26].add(states[24]);map[26].add(states[25]);map[26].add(states[27]);map[26].add(states[28]);
        map[26].add(states[31]);
        
        map[27].add(states[26]);map[27].add(states[28]);
        
        map[28].add(states[26]);map[28].add(states[27]);map[28].add(states[29]);map[28].add(states[31]);
        
        map[29].add(states[28]);map[29].add(states[30]);map[29].add(states[31]);map[29].add(states[32]);
        map[29].add(states[48]);
        
        map[30].add(states[29]);map[30].add(states[32]);map[30].add(states[37]);map[30].add(states[38]);
        map[30].add(states[48]);
        
        map[31].add(states[20]);map[31].add(states[21]);map[31].add(states[23]);map[31].add(states[24]);
        map[31].add(states[26]);map[31].add(states[28]);map[31].add(states[29]);map[31].add(states[32]);
        
        map[32].add(states[20]);map[32].add(states[29]);map[32].add(states[30]);map[32].add(states[31]);
        map[32].add(states[33]);map[32].add(states[35]);map[32].add(states[37]);
        
        map[33].add(states[19]);map[33].add(states[20]);map[33].add(states[32]);map[33].add(states[34]);
        map[33].add(states[35]);
        
        map[34].add(states[18]);map[34].add(states[19]);map[34].add(states[33]);map[30].add(states[36]);
        
        map[35].add(states[32]);map[35].add(states[33]);map[35].add(states[36]);map[35].add(states[37]);
        
        map[36].add(states[34]);map[36].add(states[35]);map[36].add(states[37]);
        
        map[37].add(states[30]);map[37].add(states[32]);map[37].add(states[35]);map[37].add(states[36]);
        map[37].add(states[38]);
        
        map[38].add(states[30]);map[38].add(states[37]);map[38].add(states[39]);map[38].add(states[46]);
        map[38].add(states[47]);map[38].add(states[48]);
        
        map[39].add(states[38]);map[39].add(states[40]);map[39].add(states[43]);map[39].add(states[45]);
        map[39].add(states[46]);
        
        map[40].add(states[39]);map[40].add(states[41]);map[40].add(states[43]);
        
        map[41].add(states[40]);map[41].add(states[42]);map[41].add(states[43]);
        
        map[42].add(states[41]);
        
        map[43].add(states[39]);map[43].add(states[40]);map[43].add(states[41]);map[43].add(states[44]);
        map[43].add(states[45]);
        
        map[44].add(states[43]);map[44].add(states[45]);
        
        map[45].add(states[39]);map[45].add(states[43]);map[45].add(states[44]);
        
        map[46].add(states[38]);map[46].add(states[39]);map[46].add(states[47]);
        
        map[47].add(states[38]);map[47].add(states[46]);map[47].add(states[48]);
        
        map[48].add(states[29]);map[48].add(states[30]);map[48].add(states[38]);map[48].add(states[47]);
          
	}
	
	private void buildEgypt() {
		this.map = new ArrayList[29];
	}
		
}
