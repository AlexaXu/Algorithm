class QuickFind {
	private int[] id;
	private int i;
	
	public QuickFind(int N) {
		id = new int[N];
		
		for(i = 0; i < N; i++){
			id[i] = i;
		}
	}
	
	public bolean connect(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q){
		int pId = id[p];
		int qId = id[q];
		
		for(i = 0; i < id.length; i++){
			if(id[i] == pId) id[i] = qId;
		}
	}
}