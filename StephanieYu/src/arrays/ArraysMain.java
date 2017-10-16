package arrays;

import java.util.Arrays;

public class ArraysMain {

	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
		suits = new String[4];
		suits[0] = "Clubs";
		suits[1] = "Hearts";
		suits[2] = "Diamonds";
		suits[3] = "Spades";
		values = new String[13];
		for(int i = 0; i < values.length; i++) {
			values[i] = ""+(i+1);
		}
		values[0] = "Ace";
		values[12] = "King";
		values[11] = "Queen";
		values[10] = "Jack";
		printDeck();
		
//		System.out.println(Arrays.toString(testArray));
	}
	private String[] printDeck() {
		for (String suit: suits) {
			for (String value: values) {
				System.out.println(value + " of " + suit);
				index++;
			}
		}
	}
	private void shuffle(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			swap(arr,i,(int)(Math.random()*arr.length));
		}
	}
	/**
	 * Swap elements at i and j
	 * @param arr
	 * @param i
	 * @param j
	 */
	private void swap(int[] arr, int i, int j) {
		int placeHolder = arr[i];
		arr[i] = arr[j];
		arr[j] = placeHolder;
	}

	/**
	 * Populate arr with numbers from 1 to arr.length, in order
	 * @param testArray2
	 */
	private void populate1ToN(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (i+1);
		}
		
	}

	private void countOccurences(int[] arr, int start, int end) {
		//why create an array with this length?
		int[] counter = new int[end - start + 1];
		for(int value: arr) {
			//why value - start?
			counter[value - start]++;
		}
		for(int i = 0; i < counter.length; i++) {
			System.out.println("The value " + (i+start) + " was rolled " + counter[i] + " times.");
		}
	}

	/**
	 *  This method populates arr with results from rolling 2 dice.
	 * @param arr
	 */
	
	private void populate(int[] arr) {
		//correct way:
		for(int i = 0; i < arr.length; i++) {
			arr[i] = diceRoll(2);
		}
		
		//incorrect way (does nothing): 
//		for(int value: arr) {
//			value = diceRoll(2);
//		}
	}
		
	public void arrayNotes() {
		//two ways to construct an array:
		int[] firstWay = {0,1,2,3,4,5};
		//this way will only work with the declaration. 
		//will not work:
//		firstWay = {6,7,8,9,10};
				
		String[] secondWay = new String[5];
		//you can go on like so, creating values at each index:
//		secondWay[0] = 1;
//		secondWay[1] = 10;
				
		//TWO WAYS TO ITERATE THROUGH AN ARRAY:
		for(int i = 0; i < secondWay.length; i++) {
		System.out.println("The # " + i + "element is " + secondWay[i]);
		}
		
		//for each int in secondWay
		for(String value: secondWay) {
			System.out.println("Element is " + value);
		}
		//NOTE: primitive arrays are not autom-populated with 0's
		//Object arrays are not populated (Null)		
	}

	public static void main(String[] args) {
		ArraysMain sample = new ArraysMain();
		//1. Arrays are collections of primitives and objects.
		//SPECIAL NOTE: This is the ONLY collection of primitives.
		//2. Size cannot be edited. 
		//3. Elements of an array are REFERENCES to objects. In other words, changing an element of an array changes the reference, not the object.
		
	}
	/**
	 * returns the result after rolling n number of dice
	 * @param n
	 * @return
	 */
	public int diceRoll(int n) {
		int sum = 0;
		for(int i = 0; i < n; i++) {
			int dieRoll = (int)(Math.random() * 6) + 1;
			sum += dieRoll;
		}
		return sum;
	}
}