import java.util.Scanner;


public class UVA_721 {
	public UVA_721() {
		int t,N,E,u,v,c;
		Node nodes[],tnodes[];
		Scanner S = new Scanner(System.in);
		t = S.nextInt();
		while(t-- >0) {
			N = S.nextInt();
			E = S.nextInt();
			
			nodes = new Node[N+1];
			tnodes = new Node[N+1];
			for(int i=0;i<=N;i++) {
				nodes[i] = new Node();
				tnodes[i] = new Node();
			}
			
			for(int i=0;i<E;i++) {
				u = S.nextInt();
				v = S.nextInt();
				c = S.nextInt();
				nodes[u].connect(v,c);
				tnodes[v].connect(u,c);
			}
			int sum=0;
			
			Dijkstra D = new Dijkstra(nodes);
			D.shortestPath(1);
			for(int i=1;i<=N;i++)
				sum += nodes[i].discovery;
			
			D = new Dijkstra(tnodes);
			D.shortestPath(1);
			for(int i=1;i<=N;i++)
				sum += tnodes[i].discovery;
			
			System.out.println(sum);
		}
	}
}
