class BinarySearch2 {
	public static int rank(int key, int[] a) {
		return rank(key, a, 0, a.length);
	}
	public static int rank(int key, int[] a, int low, int high) {
		if (low > high) {
			return -1;
		}
		int index = (low + high) / 2;
		
		if(key == a[index]) {
			return index;
		}
		else if(key < a[index]) {
			return rank(key, a, low, index - 1);
		}
		else {
			return rank(key, a, index + 1, high);
		}
	}
	public static void main(String[] args) {
		
	}
}