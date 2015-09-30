

public class ArtPoint {
	private Node nodes[];
	private int N,time,artCount;
	private int currentRoot,rootChildren;
	private boolean AP[];
	
	public ArtPoint(Node nodes[],int N) { 
		this.nodes = nodes;
		this.N = N;
		AP = new boolean[N];
	}
	
	public void init() {
		for(int i=1;i<N;i++) {
			nodes[i].visited = false;
			nodes[i].discovery = -1;
			nodes[i].finishing = -1;
			nodes[i].low = -1;
		}
		time=0;
		artCount=0;
	}
	
	public ArtPoint(Node nodes[]) {
		this(nodes,nodes.length);
	}
	
	public int[] articulationPoints() {
		dfsAll();
		int ara[] = new int[artCount];
		for(int i=1,j=0;i<N;i++)
			if(AP[i])
				ara[j++] = i;
		return ara;
	}
	
	public void dfsAll() {
		init();
    	for(int i=1;i<N;i++)
            if(!nodes[i].visited) {
            	rootChildren = 0;
            	currentRoot = i;
                dfs(i);
                if(rootChildren>1&&!AP[i]) {
                	AP[i] = true;
                	artCount++;
                }
            }
    }
	
	private void dfs(int u) {
		nodes[u].visited = true;
		nodes[u].discovery = ++time;
		nodes[u].low = nodes[u].discovery;
		for(int i=0;i<nodes[u].list.size();i++) {
			int v = nodes[u].list.get(i).to;
			if(!nodes[v].visited) {
				dfs(v);
				if(u == currentRoot)
                	rootChildren++;
                if(nodes[v].low < nodes[u].low)
                	nodes[u].low = nodes[v].low;
                if(nodes[v].low >= nodes[u].discovery && u != currentRoot && !AP[u]) {
                	AP[u] = true;
                	artCount++;
                }
			}
        	else if(nodes[v].discovery < nodes[u].low)
        		nodes[u].low = nodes[v].discovery;
		}
		nodes[u].finishing = ++time;
	}
}
