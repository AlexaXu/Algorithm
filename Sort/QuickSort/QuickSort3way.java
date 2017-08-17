public class QuickSort3way {
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(Comparable[] a, int low, int high) {
		if (low >= high) return;
		
		int l = low;
		int m = low + 1;
		int h = high;
		Comparable v = a[low];
		
		while (m <= h) {
			int cmp = a[m].compareTo(v);
			
			if (cmp < 0) exch(a, l++, m++);
			else if (cmp > 0) exch(a, m, h--);
			else m++;
		}
		
		sort(a, low, l);
		sort(a, h + 1, high);
	}
	
	private static boolean less(Comparable x, Comparable y) {
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
		Comparable[] a = {5.3, 3.9, 7.2, 2.4, 5.5, 4.2, 5.3, 3.3, 4.6, 5.3, 5.6, 8.5, 7.3, 6.2};
		QuickSort3way.sort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}