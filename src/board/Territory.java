package board;

import dice.*;
import players.Player;

public class Territory implements Comparable{
	
	private final int id;
	private int troops;
	private Player holder;
	
	protected Territory(int id) {
		this.id = id;
		this.troops = 0;
	}
	
	public void setTroops(int troops) {
		this.troops = troops;
	}
	
	public int getTroops() {
		return this.troops;
	}
	
	public int getID() {
		return this.id;
	}
	
	///// MAY REMOVE THIS - MAP KEEPS TRACK OF TERRITORY HOLDERS /////
	public void setHolder(Player holder) {
		this.holder = holder;
	}
	
	public Player getHolder() {
		return this.holder;
	}
	
	///// Attack an adjacent Territory /////

	public boolean attackTerritory(Territory t) {
	// Returns true if attack was successful	
		
		// Attacking Logic (Die and stuff)
		int myDies, enemyDies;
		int[] losses;
		while (this.getTroops()>1 && t.getTroops() > 0) {
			myDies = Math.min(this.getTroops(), 3);
			enemyDies = Math.min(t.getTroops(), 2);
			losses = Die.throwDice(myDies, enemyDies);
			// decrement mT by losses[0]
			this.setTroops(this.getTroops()-losses[0]);
			// decrement t by losses[1]
			t.setTroops(t.getTroops()-losses[1]);
		}
		if(t.getTroops() == 0) { // Attack successful
			return true;
		}
		return false;
	}
	
	
    @Override
    public boolean equals(Object me) {
        if (me.getClass() != Territory.class) {
            return false;
        }

        return (this.id == ((Territory) me).id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public int compareTo(Object o) {
        if (this.troops == ((Territory) o).troops) {
            return 0;
        } else if (this.troops > ((Territory) o).troops) {
            return 1;
        } else {
            return -1;
        }
    }

}
