public class QuickSort {
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(Comparable[] a, int low, int high) {
		if (low >= high) return;
		
		int mid = partition(a, low, high);
		
		sort(a, low, mid - 1);
		sort(a, mid + 1, high);
	}
	
	private static int partition(Comparable[] a, int low, int high) {
		Comparable key = a[low];
		int l = low;
		int h = high + 1;
		
		for (; ; ) {
			while (less(a[++l], key))
				if (l > h)
					break;
			while (less(key, a[--h]))
				if (h < l)
					break;
			
			if (l >= h) break;
			
			exch(a, l, h);
		}
		
		exch(a, low, h);
		
		return h;
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
		Comparable[] a = {5.3, 3.9, 7.2, 2.4, 5.5, 4.2, 3.3, 4.6, 5.6, 8.5, 7.3, 6.2};
		QuickSort.sort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}