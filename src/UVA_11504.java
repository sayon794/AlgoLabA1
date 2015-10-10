import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;


public class UVA_11504 {
	public UVA_11504() {
		FileReader file = null;
		try {
			file = new FileReader("11504.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int t,n,m,u,v,ans;
		Node nodes[];
		Scanner S = new Scanner(file);
		Stack<Integer> stk;
		t = S.nextInt();
		while(t--!=0) {
			n = S.nextInt();
			m = S.nextInt();
			
			nodes = new Node[n+1];
			for(int i=0;i<=n;i++)
				nodes[i] = new Node();
			
			for(int i=0;i<m;i++) {
				u = S.nextInt();
				v = S.nextInt();
				nodes[u].connect(v);
			}
			
			DFS D = new DFS(nodes);
			D.dfsAll();
			stk = D.getTopoSort();
			ans = 0;
			D = new DFS(nodes);
			
			while(!stk.isEmpty()) {
				u = stk.pop();
				if(!nodes[u].visited) {
					D.dfsFrom(u);
					ans++;
				}
			}
			
			System.out.println(ans);
		}
	}
}
