public class SelectSort {
	public static void sort(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			
			exch(a, i, min);
		}
	}
	
	private  static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			if (less(i + 1, i)) {
				return false;
			}
		}
		
		return true;
	}
	public static void main(String[] args) {
		Comparable[] a = {2.4, 1.2, 5.4, 9.2, 4.2};
		SelectSort.sort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}