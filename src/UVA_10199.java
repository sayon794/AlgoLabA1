import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;


public class UVA_10199 {
	public UVA_10199() {
		FileReader file = null;
		try {
			file = new FileReader("10199.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int N,E,cas=0;
		Scanner S = new Scanner(file);
		HashMap<String,Integer> map;
		Node nodes[];
		String u,v;
		
		while((N = S.nextInt())!=0) {
			map = new HashMap<String,Integer>();
			S.nextLine();
			
			nodes = new Node[N+1];
			for(int i=0;i<=N;i++)
				nodes[i] = new Node();
			
			for(int i=1;i<=N;i++) {
				u = S.next();
				map.put(u, i);
				nodes[i].name = u;
			}
			
			E = S.nextInt();
			S.nextLine();
			
			for(int i=0;i<E;i++) {
				u = S.next();
				v = S.next();
				nodes[map.get(u)].connect(map.get(v));
				nodes[map.get(v)].connect(map.get(u));
			}
			
			ArtPoint AP = new ArtPoint(nodes);
			int ara[] = AP.articulationPoints();
			
			Node subnodes[] = new Node[ara.length];
			for(int i=0;i<ara.length;i++)
				subnodes[i] = nodes[ara[i]];
			
			Arrays.sort(subnodes, new Comparator<Node>() {
				public int compare(Node a, Node b) {
					return a.name.compareTo(b.name);
				}
			});

			if(cas>0)
				System.out.println();
			System.out.println("City map #"+(++cas)+": "+ara.length+" camera(s) found");
			for(Node x: subnodes)
				System.out.println(x.name);
		}
	}
}
