import java.util.Stack;


public class DFS {
	private Node nodes[];
	private int N,time;
	private Stack<Integer> Stk = new Stack<Integer>();
	
	public DFS(Node nodes[],int n) { this.nodes = nodes; N = n; init(); }
	
	public DFS(Node nodes[]) { this(nodes,nodes.length); }
	
	public void init() {
		for(int i=1;i<N;i++) {
			nodes[i].visited = false;
			nodes[i].discovery = -1;
			nodes[i].finishing = -1;
		}
		time=0;
	}
	
	private void dfs(int u) {
		nodes[u].visited = true;
		nodes[u].discovery = ++time;
		for(int i=0;i<nodes[u].list.size();i++) {
			int v = nodes[u].list.get(i).to;
			if(!nodes[v].visited) {
				nodes[v].parent = u;
				dfs(v);
			}
		}
		Stk.push(u);
		nodes[u].finishing = ++time;
	}
	
	public void dfsFrom(int source,boolean reset) {
		if(reset)
			init();
		dfs(source);
	}
	
	public void dfsFrom(int source) { dfsFrom(source,false); }
	
	public void dfsAll() {
		init();
		for(int i=1;i<N;i++)
			if(!nodes[i].visited)
				dfs(i);
	}
	
	public Stack<Integer> getTopoSort() { return Stk; }
	
	public void clearStack() { Stk = new Stack<Integer>(); }
}
