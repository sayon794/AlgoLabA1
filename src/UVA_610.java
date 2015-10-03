import java.util.Scanner;


public class UVA_610 {
	public UVA_610() {
		Node nodes[];
		int n,m,u,v;
		int edge[][];
		Scanner S = new Scanner(System.in);
		
		while(true) {
			n = S.nextInt();
			m = S.nextInt();
			if(n==0&&m==0) break;
			
			nodes = new Node[n+1];
			for(int i=0;i<=n;i++)
				nodes[i] = new Node();
			
			for(int i=0;i<m;i++) {
				u = S.nextInt();
				v = S.nextInt();
				nodes[u].connect(v);
				nodes[v].connect(u);
			}
			
			ArtPoint AP = new ArtPoint(nodes);
			AP.articulationPoints();
			
			edge = new int[n+1][n+1];
			
			int to,cost;
			for(int i=1;i<=n;i++) {
				for(int j=0;j<nodes[i].list.size();j++) {
					to = nodes[i].list.get(j).to;
					cost = nodes[i].list.get(j).cost;
					if(cost==-1) {
						edge[i][to] = 1;
						edge[to][i] = 1;
					}
					//else if(edge)
				}
			}
		}
	}
}
