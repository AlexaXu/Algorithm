class InsertionSort {
	public static void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				}
			}
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
		InsertionSort.sort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}