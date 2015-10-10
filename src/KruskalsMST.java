import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class KruskalsMST {
	private Node nodes[];
	private Edge edges[];
	private DisjointSet DS;
	private ArrayList<Edge> tree;
	
	public KruskalsMST(Node nodes[],int E) {
		this.nodes = nodes;
		edges = new Edge[E];
		tree = new ArrayList<Edge>();
		for(int i=1;i<nodes.length;i++) {
			for(Edge x: nodes[i].list) {
				edges[i] = new Edge(i,x.to,x.cost);
			}
		}
		DS = new DisjointSet(nodes);
		Arrays.sort(edges, new Comparator<Edge>() {
			public int compare(Edge a,Edge b) {
				return a.cost - b.cost;
			}
		});
	}
	
	public void makeTree() {
		nodes[edges[0].from].discovery = 0;
		for(Edge x: edges) {
			if(DS.find(x.from)==DS.find(x.to)) {
				DS.union(x.from,x.to);
				nodes[x.to].discovery = x.cost;
				tree.add(x);
			}
		}
	}
}
