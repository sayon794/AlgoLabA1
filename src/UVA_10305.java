import java.util.Scanner;
import java.util.Stack;


public class UVA_10305 {
	public UVA_10305() {
		int n,m,u,v;
		Scanner S = new Scanner(System.in);
		
		while(true) {
			n = S.nextInt();
			m = S.nextInt();
			
			if(n==0&&m==0) break;
			
			Node nodes[] = new Node[n+1];
			for(int i=0;i<=n;i++)
				nodes[i] = new Node();
		
			for(int i=0;i<m;i++) {
				u = S.nextInt();
				v = S.nextInt();
				nodes[u].connect(v);
			}
			
			DFS D = new DFS(nodes);
			D.dfsAll();
			Stack<Integer> stk = D.getTopoSort();
			
			while(!stk.isEmpty()) {
				System.out.print(stk.pop() + " ");
			}
			System.out.println();
		}
	}
}
