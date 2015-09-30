import java.util.Comparator;
import java.util.PriorityQueue;


public class Dijkstra {
	class Pair {
		public int node,disc;
		Pair(int n, int d) { node = n; disc = d; }
	}
	
	private Node nodes[];
	private int N,d[];
	private PriorityQueue<Pair> PQ;
	
	public Dijkstra(Node nodes[],int N) {
		this.nodes = nodes;
		this.N = N;
		PQ = new PriorityQueue<Pair>(N,new Comparator<Pair>() {
			public int compare(Pair u, Pair v) {
				return u.disc - v.disc;
			}
		});
	}
	
	public Dijkstra(Node nodes[]) { this(nodes,nodes.length); }
	
	public void shortestPath(int source) {
		init();
		nodes[source].discovery = 0;
		PQ.offer(new Pair(source, nodes[source].discovery));
		
		while(!PQ.isEmpty()) {
			int u = PQ.poll().node;
			if(nodes[u].visited)
				continue;
			
			nodes[u].visited = true;
			for(int i=0;i<nodes[u].list.size();i++) {
				int v = nodes[u].list.get(i).to;
				int w = nodes[u].list.get(i).cost;
				if(nodes[v].discovery==-1 || nodes[u].discovery+w < nodes[v].discovery) {
					nodes[v].discovery = nodes[u].discovery + w;
					PQ.offer(new Pair(v, nodes[v].discovery));
				}
			}
		}
	}
	
	private void init() {
		for(int i=0;i<N;i++)
			nodes[i].discovery = -1;
	}
}
