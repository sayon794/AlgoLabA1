
import java.util.HashMap;
import java.util.Scanner;

public class UVA_336 {
	HashMap<Integer,Integer> map;
	Node nodes[];
	
	int N,a,b,cas=1,nc=0;
	
	public UVA_336() {
		Scanner S = new Scanner(System.in);
		
		while((N = S.nextInt())!=0) {
			nc = 0;
			map = new HashMap<Integer,Integer>();
			nodes = new Node[30];
			for(int i=0;i<30;i++)
				nodes[i] = new Node();
			
			for(int i=0;i<N;i++) {
				a = S.nextInt();
				b = S.nextInt();
				if(!map.containsKey(a)) {
					map.put(a, nc++);
					//System.out.println(a + ":" + (nc-1));
				}
				if(!map.containsKey(b)) {
					map.put(b, nc++);
					//System.out.println(b + ":" + (nc-1));
				}
				int u = map.get(a);
				int v = map.get(b);
				nodes[u].connect(v);
				nodes[v].connect(u);
			}
			
			BFS bfs = new BFS(nodes);
			
			while(true) {
				a = S.nextInt();
				b = S.nextInt();
				if(a==0&&b==0) break;
				int u = map.get(a);
				bfs.bfs(u);
				int cnt=0;
				for(int i=0;i<nc;i++) {
					if(!nodes[i].visited||nodes[i].dist>b)
						cnt++;
					//System.out.println(nodes[i].visited + " " + i + " " + nodes[i].dist);
				}
				System.out.println("Case "+ cas++ +": "+ cnt +" nodes not reachable from node "+ a +" with TTL = "+ b +".");
			}
		}
		
	}
}
