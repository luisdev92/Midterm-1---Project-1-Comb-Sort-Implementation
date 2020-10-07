// Programmer: Luis Santander
// Class: CS3310 - Analysis of Algorithms 
// Assignment: Midterm 1
// Description: Comb Sort Algorithm Implementation 

import java.util.Random;

public class Main {
	
	public static int[] generateRandomNumbers(int[] A, int upperBound) {
		Random rand = new Random(); 
		
		for (int i = 0; i < upperBound; i++) 
			A[i] = rand.nextInt(upperBound);
		
		return A;
	}
	
	public static int[] CombSort(int[] A, int upperBound) {
		
		int i; 
		double gap = upperBound;
		double shrink = 2; 
		boolean sorted = false; 
				
		while (sorted == false) {
			
			gap = Math.floor(gap / shrink);
			
			if (gap <= 1) {
				gap = 1; 
				sorted = true; 
			}
			
			i = 0; 
			
			while (i + gap < upperBound) {
				if (A[i] > A[(int)(i + gap)]) {
					// Swap
					int temp = A[i];
					A[i] = A[(int)(i + gap)];
					A[(int)(i + gap)] = temp; 
				
					sorted = false;
				}
				 
				i = i + 1; 
			}
			
		}
		
	
		return A; 
	}
	
	public static int[] sort(int[] A) {
		return CombSort(A, A.length); 
	}
	
	
	public static void displayList(int[] A) {
		for (int i = 0; i < A.length; i++) 
			System.out.print(A[i] + " ");
	}
	
	public static void main(String[] args) {
		int n = 100000; 
		
		int[] unsortedList = new int[n]; 
		
		unsortedList = generateRandomNumbers(unsortedList, n);
		
//		System.out.println("Unsorted List"); 
//		displayList(unsortedList);
//		System.out.println();
		
		// Start Timer 
        long start = System.currentTimeMillis(); 
        
        // start of function 
        // -----------------------------------------------------
        
        int[] sortedList = sort(unsortedList); 
  
        // end of function 
        // -----------------------------------------------------
        // ending time 
        long end = System.currentTimeMillis(); 
		
		
//        System.out.println("\nSorted List"); 
//		displayList(sortedList);
		
		
		System.out.println("\nSorting n = " + n + " integers using comb sort takes " + 
                (end - start) + "ms");
	}
}
