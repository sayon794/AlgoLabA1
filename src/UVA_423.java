import java.util.Scanner;


public class UVA_423 {
	public UVA_423() {
		Node nodes[];
		int N,u,v,c;
		String str;
		Scanner S = new Scanner(System.in);
		N = S.nextInt();
		
		nodes = new Node[N+1];
		for(int i=0;i<=N;i++)
			nodes[i] = new Node();
		for(u=2;u<=N;u++) 
			for(v=1;v<u;v++)
				if(S.hasNextInt()) {
					c = S.nextInt();
					nodes[u].connect(v,c);
					nodes[v].connect(u,c);
				}
				else 
					S.next();
		
		Dijkstra D = new Dijkstra(nodes);
		D.shortestPath(1);
		int time = 0;
		
		for(int i=2;i<=N;i++)
			time = (nodes[i].discovery>time)? nodes[i].discovery : time;
		
		System.out.println(time);
	}
}
