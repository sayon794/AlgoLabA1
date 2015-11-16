
public class WeightedGraph extends Graph {
	
	private int dist[][];
	
	public WeightedGraph(int nodes) {
		super(nodes);
		dist = new int[nodes+1][nodes+1];
	}
	
	public void connect(int n1,int n2,int cost) {
		super.connect(n1, n2, false);
		dist[n1][n2] = cost;
	}
	
	public int getDist(int n1,int n2) { 
		if(!isConnected(n1,n2))
			return -1;
		return dist[n1][n2];
	}
}