import java.util.Comparator;
import java.util.PriorityQueue;


public class MST {
	private Node nodes[];
	private int N;
	private PriorityQueue<Node> PQ;
	
	public MST(Node nodes[],int N) {
		this.nodes = nodes;
		this.N = N;
		PQ = new PriorityQueue<Node>(N,new Comparator<Node>() {
			public int compare(Node u, Node v) {
				return u.dist - v.dist;
			}
		});
	}
	
	public MST(Node nodes[]) { this(nodes,nodes.length); }
	
	public void makeTree() {
		nodes[1].dist = 0;
		PQ.offer(nodes[1]);
		
		while(!PQ.isEmpty()) {
			int u = PQ.poll().number;
			if(nodes[u].visited)
				continue;
			
			nodes[u].visited = true;
			for(int i=0;i<nodes[u].list.size();i++) {
				int v = nodes[u].list.get(i).to;
				int w = nodes[u].list.get(i).cost;
				if(!nodes[v].visited && nodes[v].dist>w) {
					nodes[v].dist =  w;
					nodes[v].parent = u;
					PQ.offer(nodes[v]);
				}
			}
		}
	}
}
