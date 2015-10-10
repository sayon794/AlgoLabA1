
public class DisjointSet {
	private Node nodes[];
	
	public DisjointSet(Node nodes[]) { this.nodes = nodes; makeSet(); }
	
	public void makeSet() {
		for(int i=0;i<nodes.length;i++) {
			nodes[i].parent = i;
		}
	}
	
	public int find(int x) {
		if(nodes[x].parent==x) return x;
		return nodes[x].parent = find(nodes[x].parent);
	}
	
	public void union(int x,int y) {
		int u = find(x);
		int v = find(y);
		if(u!=v)
			nodes[u].parent = v;
	}
}
