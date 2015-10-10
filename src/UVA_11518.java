import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class UVA_11518 {
	public UVA_11518() {
		FileReader file = null;
		try {
			file = new FileReader("11518.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int t,n,m,l,u,v,ans;
		Node nodes[];
		Scanner S = new Scanner(file);
		t = S.nextInt();
		while(t--!=0) {
			n = S.nextInt();
			m = S.nextInt();
			l = S.nextInt();
			
			nodes = new Node[n+1];
			for(int i=0;i<=n;i++)
				nodes[i] = new Node();
			
			for(int i=0;i<m;i++) {
				u = S.nextInt();
				v = S.nextInt();
				nodes[u].connect(v);
			}
			DFS D = new DFS(nodes);
			for(int i=0;i<l;i++) {
				u = S.nextInt();
				D.dfsFrom(u);
			}
			ans = 0;
			for(int i=1;i<=n;i++) {
				if(nodes[i].visited)
					ans++;
			}
			
			System.out.println(ans);
		}
	}
}
