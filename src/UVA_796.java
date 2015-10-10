import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class UVA_796 {
	public UVA_796() {
		FileReader file = null;
		try {
			file = new FileReader("796.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int N;
		Node nodes[];
		Scanner S = new Scanner(file);
		PriorityQueue<Pair> PQ;
		while(S.hasNext()) {
			N=S.nextInt();
			
			if(N==0) {
				System.out.println("0 critical links\n");
				continue;
			}
			
			nodes = new Node[N+1];
			for(int i=0;i<=N;i++)
				nodes[i] = new Node();
			
			String str;
			int u,v,e;
			
			for(int i=1;i<=N;i++) {
				u = S.nextInt();
				str = S.next();
				e = Integer.parseInt(str.substring(1, str.length()-1));
				//System.out.println(e);
				for(int j=0;j<e;j++) {
					v = S.nextInt();
					nodes[u+1].connect(v+1);
					//nodes[v+1].connect(u+1);
				}
			}
			
			ArtPoint AP = new ArtPoint(nodes, new Comparator<Pair>() {
				public int compare(Pair a, Pair b) {
					return a.x - b.x;
				}
			});
			
			PQ = AP.bridges();
			
			System.out.println(AP.bridgeCount+" critical links");
			
			while(!PQ.isEmpty()) {
				Pair temp = PQ.poll();
				System.out.println((temp.x-1)+" - "+(temp.y-1));
			}
			System.out.println();
		}
	}
}
