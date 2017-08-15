class MergeSortBU {
	private static Comparable[] copy;
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		copy = new Comparable[N];
		
		for (int size = 1; size < N; size += size) {
			for (int low = 0; low < N - size; low += (2 * size)) {
				merge(a, low, low + size - 1, Math.min(low + 2 * size - 1, N - 1));
			}
		}
	}
	
	private static void merge(Comparable[] a, int low, int mid, int high) {
		int l = low;
		int h = mid + 1;
		
		for (int i = low; i <= high; i++) {
			copy[i] = a[i];
		}
		
		for (int i = low; i <= high; i++) {
			if (l > mid)                     a[i] = copy[h++];
			else if (h > high)               a[i] = copy[l++];
			else if (less(copy[l], copy[h])) a[i] = copy[l++];
			else                             a[i] = copy[h++];
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