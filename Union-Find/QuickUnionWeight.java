class QuickUnionWeight {
	private int[] id;
	private int[] size;
	
	public QuickUnionWeight(int N) {
		id = new int[N];
		size = new int[N];
		
		for(int i = 0; i < N; i++){
			id[i] = i;
			size[i] = 1;
		}
	}
	
	public int root(int p) {
		while (id[p] != p) {
			id[p] = id[id[p]];
			p = id[p];
		}
		
		return p;
	}
	
	public boolean connect(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		
		if(i == j) return;
		
		if(size[i] <= size[j]){
			id[i] = j;
			size[i] += size[j];
		}else {
			id(j) = i;
			size[i] += size[j];
		}
	}
}