import java.util.ArrayList;


public class BellmanFord {
	public final static int inf = (1<<30);
	private Node nodes[];
	private int N;
	public ArrayList<Integer> neg = new ArrayList<Integer>();
	
	
	public BellmanFord(Node nodes[],int N) {
		this.nodes = nodes;
		this.N = N;
	}
	
	public BellmanFord(Node nodes[]) { this(nodes, nodes.length); }
	
	private void init() {
		for(int i=0;i<N;i++) {
			nodes[i].discovery = inf;
			nodes[i].parent = -1;
			neg.clear();
		}
	}
	
	public boolean shortestPath(int source) {
		init();
		boolean ans=true;
		nodes[source].discovery = 0;
		for(int i=1;i<N;i++) {
			for(int u=1;u<N;u++)
				for(int j=0;j<nodes[u].list.size();j++) {
					int v = nodes[u].list.get(j).to;
					int w = nodes[u].list.get(j).cost;
					if(nodes[u].discovery!=inf && nodes[v].discovery > nodes[u].discovery + w){
						nodes[v].discovery = nodes[u].discovery + w;
						nodes[v].parent = u;
					}
				}
		}
		for(int u=1;u<N;u++)
			for(int j=0;j<nodes[u].list.size();j++) {
				int v = nodes[u].list.get(j).to;
				int w = nodes[u].list.get(j).cost;
				if(nodes[u].discovery!=inf && nodes[v].discovery > nodes[u].discovery + w) {
					neg.add(u);
					ans = false;
				}
			}
		return ans;
	}
	
}
