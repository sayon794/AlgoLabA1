
public class FloydWarshall {
	public static final int inf=(1<<29);
	private int nodes,D[][],parent[][];
	private boolean pathFound;
	
	public FloydWarshall(WeightedGraph G) {
		this.nodes = G.getNodes();
		D = new int[nodes+1][nodes+1];
		parent = new int[nodes+1][nodes+1];
		for(int i=0;i<D.length; i++)
			for(int j=0;j<D[i].length;j++)
				if(G.isConnected(i, j))
					D[i][j]=G.getDist(i, j);
				else
					D[i][j]=inf;

		for(int i=0;i<parent.length; i++)
			for(int j=0;j<parent[i].length;j++)
				if(i!=j&&D[i][j]<inf)
					parent[i][j]=i;
				else
					parent[i][j]=inf;
	}
	
	public void APSP() {
		for(int k=1;k<=nodes;k++)
			for(int i=1;i<=nodes;i++)
				for(int j=1;j<=nodes;j++)
					if(D[i][k]+D[k][j]<D[i][j]) {
						D[i][j]=D[i][k]+D[k][j];
						parent[i][j]=parent[k][j];
					}
	}
	
	public void printPath(int src,int dst) {
		pathFound=true;
		print(src,dst);
		if(pathFound)
			System.out.println(dst);
	}
	
	private void print(int src,int dst) {
		if(parent[src][dst]==inf) {
			pathFound=false;
			System.out.println("Path doesn't exist");
		}
		else if(parent[src][dst]==src) {
			System.out.print(src+" ");
		}
		else {
			print(src,parent[src][dst]);
			print(parent[src][dst],dst);
		}
	}
	
	public int getDist(int u,int v) {
		return D[u][v];
	}
}
