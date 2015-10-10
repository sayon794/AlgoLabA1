import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class UVA_11721 {
	private Node G[], Gt[];
	private int comp[];
	private boolean ans[],possible=false;
	
	public UVA_11721() {
		FileReader file = null;
		try {
			file = new FileReader("11721.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int t,cas,u,v,c,n,m;
		Scanner S = new Scanner(file);
		t = S.nextInt();
		for(cas=1;cas<=t;cas++) {
			n = S.nextInt();
			m = S.nextInt();
			
			possible=false;
			comp = new int[n+1];
			ans = new boolean[n+1];
			G = new Node[n+1];
			Gt = new Node[n+1];
			for(int i=0;i<=n;i++) {
				G[i] = new Node();
				Gt[i] = new Node();
			}
			
			for(int i=0;i<m;i++) {
				u = S.nextInt();
				v = S.nextInt();
				c = S.nextInt();
				u++;v++;
				G[u].connect(v,c);
				Gt[v].connect(u);
			}
			
			SCC scc = new SCC(G);
			
			scc.splitComponents();
			for(int i=0;i<scc.components.size();i++) {
				for(int j=0;j<scc.components.get(i).size();j++) {
					comp[scc.components.get(i).get(j)] = i;
				}
			}
			
			BellmanFord B = new BellmanFord(G);
			for(int i=0;i<scc.components.size();i++) {
				B.shortestPath(scc.components.get(i).get(0));
				for(int j=0;j<B.neg.size();j++) {
					if(comp[B.neg.get(j)]==i) {
						dfs(B.neg.get(j));
						break;
					}
				}
			}
			if(!possible)
				System.out.print("Case "+cas+": impossible");
			else {
				System.out.print("Case "+cas+":");
				for(int i=1;i<=n;i++) 
					if(ans[i])
						System.out.print(" "+(i-1));
			}
			System.out.println();
		}
	}
	
	public void dfs(int u) {
		Gt[u].visited = true;
		possible=true;
		ans[u] = true;
		for(int i=0;i<Gt[u].list.size();i++) {
			int v = Gt[u].list.get(i).to;
			if(!Gt[v].visited) {
				dfs(v);
			}
		}
	}
}
