import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class UVA_315 {
	public UVA_315() {
		FileReader file = null;
		try {
			file = new FileReader("315.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner S = new Scanner(file);
		Scanner sub = null;
		int N,u,v;
		String line;
		while((N = S.nextInt())!=0) {
			Node nodes[] = new Node[N+1];
			for(int i=0;i<=N;i++)
				nodes[i] = new Node();
			S.nextLine();
			
			while(true) {
				line = S.nextLine();
				sub = new Scanner(line);
				u = sub.nextInt();
				if(u==0) break;
				while(sub.hasNextInt()) {
					v = sub.nextInt();
					nodes[u].connect(v);
					nodes[v].connect(u);
				}
			}
			
			ArtPoint AP = new ArtPoint(nodes);
			System.out.println(AP.articulationPoints().length);
		}
	}
}
