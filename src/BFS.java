import java.util.ArrayDeque;
import java.util.Queue;


public class BFS {
	Node nodes[];
	Queue<Integer> Q = new ArrayDeque<Integer>();
	
	public BFS(Node nodes[]) { this.nodes = nodes; }
	
	public void bfs(int source) {
		init();
		nodes[source].visited = true;
		nodes[source].dist = 0;
		Q.add(source);
		while(!Q.isEmpty()) {
			int u = Q.peek();
			for(int i=0;i<nodes[u].list.size();i++) {
				int v = nodes[u].list.get(i).to;
				if(!nodes[v].visited) {
					nodes[v].visited = true;
					nodes[v].dist = nodes[u].dist+1;
					Q.add(v);
				}
			}
			Q.remove();
		}
	}
	
	public void init() {
		for(int i=0;i<nodes.length;i++) {
			nodes[i].visited = false;
			nodes[i].dist = -1;
		}
	}
}
