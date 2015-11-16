
public class Graph {
    private boolean adjMat[][];
    private int nodes;
	public int componentFlag[];
    
    public Graph(int nodes) {
        this.nodes = nodes;
        adjMat = new boolean[nodes+1][nodes+1];
    }
    
    public boolean isConnected(int n1,int n2) { return adjMat[n1][n2]; }
    
    public void connect(int n1,int n2,boolean bidirectional) {
        adjMat[n1][n2] = true;
        if(bidirectional)
            adjMat[n2][n1] = true;
    }
    
    public String toString() {
        String result = "Given Graph:\n";
        for(int i=1;i<=nodes;i++)
        	for(int j=i;j<=nodes;j++)
                if(isConnected(i,j))
                    result = result + i +" - " + j + "\n";
        return result;
    }
    
    public int getNodes() { return nodes; }
    
    public boolean[][] getMat() { return adjMat; }
    
    public Graph transpose() {
    	Graph Gt = new Graph(this.nodes);
    	for(int i=1;i<=nodes;i++) {
    		for(int j=1;j<=nodes;j++) {
    			if(this.isConnected(i,j))
    				Gt.connect(j,i,false);
    		}
    	}
    	/*for(int i=1;i<=nodes;i++) {
    		for(int j=1;j<=nodes;j++)
    			System.out.print((Gt.isConnected(i, j)?1:0));
    		System.out.println();
    	}*/
    	return Gt;
    }
    
    /*public void init() {
        int nodes,edges;
        Scanner S = new Scanner(System.in);
        nodes = S.nextInt();
        edges = S.nextInt();
        Graph G = new Graph(nodes);
        int a,b;
        for(int i=0;i<edges;i++) {
            a = S.nextInt();
            b = S.nextInt();
            G.connect(a, b,true);
        }
    }*/
    
}

