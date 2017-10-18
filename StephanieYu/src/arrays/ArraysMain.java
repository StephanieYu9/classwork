package arrays;

import java.util.Arrays;

public class ArraysMain {

	private String[] suits;
	private String[] values;
	
	public ArraysMain() {
		wednesdayMethods();
//		System.out.println(Arrays.toString(testArray));
	}
	
	private void wednesdayMethods() {
		int[] diceRolls = new int[10000];
		populate(diceRolls);
		int[] data = longestConsecutiveSeqAndIndex(diceRolls);
		int longest = data[0];
		System.out.println("The longest sequence is " + longest + " rolls." + " It happened on roll #" + data[1] + " the sequence was: " + Arrays.toString(subArray(diceRolls, data[1], data[0])) + ".");
		
	}

	/**
	 * BIG IDEA:
	 * Usually a method returns ONE piece of data (i.e. 'int', 'boolean', etc)
	 * IF we ever want more than one piece of data, one way of doing that is 
	 * by using an array, as you see here, a method that returns the LENGTH
	 * of the sequence and its START position (both ints)
	 * @param arr
	 * @return
	 */
	private int[] longestConsecutiveSeqAndIndex(int[] arr) {
		//use an int[] to store the data
		int[] data = new int[2];
		
		data[0] = 1;
		int count = 1;
		for(int i = 0; i < arr.length; i++) {
			while(i + count < arr.length && isConsecutive(arr, i, i + count)) {
				count++;
			}
			if(count > data[0]) {
				data[0] = count;
				//also store the index where this sequence started.
				data[1] = i;
			}
			i = i + count - 1;
			count = 1;
		}
		return data;
	}

	private void tuesdayMethods() {
		int[] orderTest = {1,2,3,4,5,1,6,7,8,9,10,11,12};
//		cycleThrough(orderTest, 5);
//		frontToBack(orderTest);
//		System.out.println(Arrays.toString(orderTest));
		
		System.out.println(longestConsecutiveSequence(orderTest) + " is the l.s.c.");
	}
	
	private boolean isConsecutive (int[] arr, int start, int end) {
		for(int i = start; i < end; i++) {
			if(arr[i] + 1 != arr[i+1]) {
				return false;
			}
		}
		return true;
	}
	
	private int longestConsecutiveSequence(int[] arr) {
		int maxLength = 1;
		int count = 1;
		for(int i = 0; i < arr.length; i++) {
			while(i + count < arr.length && isConsecutive(arr, i, i + count)) {
				count++;
			}
			if(count > maxLength) {
				maxLength = count;
			}
			i = i + count - 1;
			count = 1;
		}
		return maxLength;
	}
	
	private void cycleThrough(int[] arr, int n) {
		for(int i = 0; i < n; i++) {
			frontToBack(arr);
		}
	}

	/** 
	 * removes the element at index 0, pushes all other elements forward.
	 * @param arr
	 * @return 
	 */
	private void frontToBack(int[] arr) {
		int x = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = x;
	}

	private void warmUpMethods() {
		int[] orderTest = {1,2,3,4,5,6,7,8,9,10};
		reverseOrder(orderTest);
		System.out.println(Arrays.toString(orderTest));
		System.out.println(Arrays.toString(subArray(orderTest,3,4)));
	}

	private int[] subArray(int[] arr, int psn, int length) {
		int[] sub = new int[length];
		for(int i = 0; i < length; i++) {
			sub[i] = arr[i+psn];
		}
		return sub;
	}

	public void reverseOrder(int[] arr) {
		for(int i = 0; i < arr.length/2; i++) {
			swap(arr,i,arr.length-1-i);
		}
	}
	
	public void cardMethod() {
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
	}
	
	private String[] printDeck() {
		for (String suit: suits) {
			for (String value: values) {
				System.out.println(value + " of " + suit);
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
