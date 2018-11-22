package dice;

import java.util.Arrays;
import java.util.Collections;

public class Die {

	private static Integer[] values1;
	private static Integer[] values2;
	
	public Die() {
		
	}
	
	public static int[] throwDice(int dice1, int dice2) {
	// Returns losses[] where:
	// losses[0] = Attacker's losses
	// losse[1] = Defender's losses		
		
		values1 = new Integer[dice1];
		values2 = new Integer[dice2];
		int[] losses = new int[2];
		
		for(int i=0; i<dice1; i++) {
			values1[i] = (int)Math.random() * 6 + 1;
		}
		for(int i=0; i<dice2; i++) {
			values2[i] = (int)Math.random() * 6 + 1;
		}
		
		Arrays.sort(values1, Collections.reverseOrder());
		Arrays.sort(values2, Collections.reverseOrder());
		
		for(int i=0; i<dice2; i++) { // We know that for all dice1,dice2, dice2<=dice1
			if(values2[i] >= values1[i]) {
				losses[0] += 1;
			}
			else {
				losses[1] += 1;
			}
			
		}
		return losses;
	}
}
