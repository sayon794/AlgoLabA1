import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;


public class UVA_10278 {
	public UVA_10278() {
		FileReader file = null;
		try {
			file = new FileReader("10278.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner S = new Scanner(file);
		Scanner sub = null;
		ArrayList<Integer> F = new ArrayList<Integer>();
		int t,f,n,u,v,c;
		int d[],temp[];
		String str;
		Node nodes[];
		
		t = S.nextInt();
		while(t--!=0) {
			f = S.nextInt();
			n = S.nextInt();
			
			nodes = new Node[n+1];
			for(int i=0;i<=n;i++)
				nodes[i] = new Node();
			
			F.clear();
			for(int i=0;i<f;i++) {
				u = S.nextInt();
				F.add(u);
			}
			
			S.nextLine();
			
			while(S.hasNextLine()) {
				str = S.nextLine();
				if(str.length()==0) break;
				
				sub = new Scanner(str);
				u = sub.nextInt();
				v = sub.nextInt();
				c = sub.nextInt();
				
				nodes[u].connect(v,c);
				nodes[v].connect(u,c);
			}
			
			Dijkstra D = new Dijkstra(nodes);
			D.init();
			for(int i=0;i<F.size();i++)
				D.shortestPath(F.get(i),false);
			
			d = D.getDistances();
			
			int min=100000000,minindex=0;
			for(int i=1;i<=n;i++) {
				D = new Dijkstra(nodes);
				D.init();
				D.setDistances(d);
				D.shortestPath(i,false);
				temp = D.getDistances();
				int mx = 0;
				for(int j=1;j<temp.length;j++) {
					mx = Math.max(temp[j], mx);
				}
				if(mx<min) {
					min = mx;
					minindex = i;
				}
			}
			
			System.out.println(minindex);
		}
	}
}
