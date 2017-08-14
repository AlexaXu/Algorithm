public class ShellSort {
	public static void sort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		
		while (h < N / 3) h = 3 * h + 1;
		
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h; j -= h) {
					if (less(a[j], a[j - h])) {
						exch(a, j, j - h);
					}
				}
			}
			
			h /= 3;
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
		ShellSort.sort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}