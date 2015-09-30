import java.util.ArrayList;
import java.util.Stack;


public class SCC {
	public ArrayList<ArrayList<Integer>> components = new ArrayList<ArrayList<Integer>>();
	private Node G[],Gt[];
	private DFS dfs;
	
	public SCC(Node G[],Node Gt[]) { this.G = G; this.Gt=Gt; }
	
	public SCC(Node G[]) { 
		this.G = G;
		Gt = transpose(G);
	}
	
	private Node[] transpose(Node G[]) {
		int N = G.length;
		Node nodes[] = new Node[N];
		for(int i=0;i<N;i++) 
			nodes[i] = new Node();
		
		for(int i=0;i<N;i++) 
			for(int j=0;j<G[i].list.size();j++)
				nodes[G[i].list.get(j).to].connect(i,G[i].list.get(j).cost);
		
		return nodes;
	}
	
	public void splitComponents() {
		dfs = new DFS(G);
		dfs.dfsAll();
		Stack<Integer> Stk1 = dfs.getTopoSort();
		Stack<Integer> temp;
		ArrayList<Integer> list;
		
		dfs = new DFS(Gt);
		while(!Stk1.isEmpty()) {
			int n = Stk1.pop();
			if(!Gt[n].visited) {
				dfs.dfsFrom(n);
				temp = dfs.getTopoSort();
				dfs.clearStack();
				
				list = new ArrayList<Integer>();
				while(!temp.isEmpty())
					list.add(temp.pop());
				components.add(list);
			}
		}
	}
}
