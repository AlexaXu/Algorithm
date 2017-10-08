import java.security.*;

public class PriorityQueue<Temp extends Comparable<Temp>>{
	private Temp[] binaryHeap;
	private int N;
	
	public PriorityQueue(int maxNum){
		binaryHeap = (Temp[]) new Comparable[maxNum + 1];
		N = 0;
	}
	
	private boolean less(int i, int j){
		return binaryHeap[i].compareTo(binaryHeap[j]) < 0;
	}
	
	private void exch(int i, int j){
		Temp temp = binaryHeap[i];
		binaryHeap[i] = binaryHeap[j];
		binaryHeap[j] = temp;
	}
	
	private void swim(int key){
		while(key > 1 && less(key / 2, key)){
			exch(key / 2, key);
			key /=2;
		}
	}
	
	private void sink(int key){
		while(key * 2 <= N){
			int next = key * 2;
			if(next < N && less(next, next + 1))
				next++;
			if(less(next, key))
				break;
			exch(key, next);
			key = next;
		}
	}
	
	public boolean isEmpty(){
		return N == 0;
	}
	
	public int size(){
		return N;
	}
	
	public void insert(Temp m){
		binaryHeap[++N] = m;
		swim(N);
	}
	
	public Temp delMax(){
		Temp max = binaryHeap[1];
		exch(1, N);
		binaryHeap[N] = null;
		N--;
		sink(1);
		return max;
	}
	
	public static void main(String[] args){
		
	}
}