import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;


public class UVA_11709 {
	public UVA_11709() {
		FileReader file = null;
		try {
			file = new FileReader("11709.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Node G[],Gt[];
		int n,m;
		Scanner S = new Scanner(file);
		HashMap<String,Integer> map;
		String str1,str2;
		
		while(true) {
			map = new HashMap<String,Integer>();
			n = S.nextInt();
			m = S.nextInt();
			G = new Node[n+1];
			Gt = new Node[n+1];
			for(int i=0;i<=n;i++) {
				G[i] = new Node();
				Gt[i] = new Node();
			}
			
			if(n==0&&m==0) break;
			S.nextLine();
			for(int i=1;i<=n;i++) {
				str1 = S.nextLine();
				map.put(str1, i);
			}
			
			for(int i=0;i<m;i++) {
				str1 = S.nextLine();
				str2 = S.nextLine();
				G[map.get(str1)].connect(map.get(str2));
				Gt[map.get(str2)].connect(map.get(str1));
			}
			
			SCC scc = new SCC(G,Gt);
			scc.splitComponents();
			System.out.println(scc.components.size());
		}
	}
}
