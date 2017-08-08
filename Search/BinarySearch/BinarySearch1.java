import java.util.*;

public class BinarySearch1 {
	public static int rank(int key, int[] a) {
		int low = 0;
		int high = a.length - 1;
		int index;
		
		while (low <= high) {
			index = (low + high) / 2;
			
			if(key == a[index]) {
				return index;
			}
			else if(key < a[index]) {
				high = index - 1;
			}
			else {
				low = index + 1;
			}
		}
		
		return -1;
	}
	
	public static int lowRank(int key, int[] a) {
		int index = rank(key, a);
		
		if(index == -1) return -1;
		
		do {
			index--;
		}while(a[index] == key);
		
		return index + 1;
	}
	
	public static int count(int key, int[] a) {
		int index = rank(key, a);
		
		if(index == -1) return -1;
		
		int lowRank = lowRank(key, a);
		
		do {
			index++;
		}while(a[index] == key);
		
		return index - lowRank;
	}
	
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 3, 3, 3, 3, 3, 5, 6, 7};
		
		System.out.println(lowRank(3, a));
	}
}