import java.util.Arrays;
import java.util.HashMap;

public class ParkingLot {
	/*A hashmap that maps the number that represents each car to its position in the parking lot. */
	public static HashMap<Integer, Integer> positions = new HashMap<Integer, Integer>();
	/*A pointer to the position of the empty slot */
	public static int emptySlot=-1;
	
	/**
	* This method is used to print a series of moves that transform the first in the second array by 
	* swapping any integer with 0. The integers represent the numbers of each car in a parking lot.
	* @param initialArrangement This is the starting arrangement of the integers.
	* @param targetArrangement  This is the the target arrangement of the integers.
	*/	
	public static void rearrange(int [] initialArrangement, int [] targetArrangement) {
		if (initialArrangement.length!=targetArrangement.length) {
			throw new IllegalArgumentException("Number of slots in initial and target configurations don't match!");
		}
		for (int i = 0; i < targetArrangement.length; i++) {
			if (initialArrangement[i] == 0) {
				emptySlot=i;
				break;
			}
		}
		if (emptySlot == -1) {
			throw new IllegalArgumentException("There is no empty park space!");	
		}
		/* create a hashmap that has for keys the numbers of the cars and for values their current positions in the parking lot */
		for (int i = 0; i<initialArrangement.length; i++) {
			positions.put(initialArrangement[i], i);
		}
		/* check if a parking space doesn't have the correct car parked in it. */
		for (int i = 0; i < targetArrangement.length; i++) {
			/* the car that has to be parked in slot i */
			int targetCar=targetArrangement[i];
			/* the car that is actually parked in the slot i */
			int currCar=initialArrangement[i];
			/* if slot i isn't empty, empty it */
			if (currCar != targetCar) {
				if (currCar != 0) {
					//enter the new positions in the map
					positions.put(currCar, emptySlot);
					positions.put(0, i);
					//swap the car with the empty space
					swap(i, emptySlot, initialArrangement);
					//move the pointer of the empty empty slot
					emptySlot=i;
					System.out.println(Arrays.toString(initialArrangement));
				}
				/* if the target for slot i isn't the empty slot, move the correct car at i */
				if (targetCar!=0) {
					int currPosTargetCar = positions.get(targetCar); 
					//enter the new positions in the map
					positions.put(targetCar, emptySlot);
					positions.put(0, currPosTargetCar);
					//swap the target car with the empty slot
					swap(emptySlot, currPosTargetCar, initialArrangement);
					//move the empty slot pointer
					emptySlot=currPosTargetCar;
					System.out.println(Arrays.toString(initialArrangement));
				}
			}
		}
	}
	
	/**
	* This method is used to swap the positions of two elements in an array of integers.
	* @param i This is the position of the first integer to be swapped in the array.
	* @param j This is the position of the second integer to be swapped in the array.
	*/	
	private static void swap(int i, int j, int [] arrangement) {
		int temp=arrangement[i];
		arrangement[i]=arrangement[j];
		arrangement[j]=temp;
	}
}
