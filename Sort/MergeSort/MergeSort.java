class MergeSort {
	private static Comparable[] copy;
	
	public static void sort(Comparable[] a) {
		copy = new Comparable[a.length];
		
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(Comparable[] a, int low, int high) {
		if (low >= high) return;
		
		int mid = (low + high) / 2;
		sort(a, low, mid);
		sort(a, mid + 1, high);
		if (less(a[mid], a[mid + 1])) return;
		merge(a, low, high);
	}
	
	private static void merge(Comparable[] a, int low, int high) {
		int mid = (low + high) / 2;
		int l = low; 
		int h = mid + 1;
		
		for (int i = low; i <= high; i++) {
			copy[i] = a[i];
		}
		
		for (int i = low; i <= high; i++) {
			if (l > mid)                     a[i] = copy[h++];
			else if (h > high)               a[i] = copy[l++];
			else if (less(copy[h], copy[l])) a[i] = copy[h++];
			else                             a[i] = copy[l++];
		}
	}
	
	private  static boolean less(Comparable x, Comparable y) {
		return x.compareTo(y) < 0;
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
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}