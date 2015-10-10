import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class UVA_439 {
	public UVA_439() {
		FileReader file = null;
		try {
			file = new FileReader("439.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner S = new Scanner(file);
		BFS2D B;
		String u,v;
		int dx[] = {-2,-1,1,2,-2,-1,1,2};
		int dy[] = {-1,-2,-2,-1,1,2,2,1};
		int sx,sy,desx,desy;
		
		while(S.hasNext()) {
			B = new BFS2D(8,8,dx,dy);
			
			u = S.next();
			v = S.next();
			sx = u.charAt(0) - 'a';
			sy = u.charAt(1) - '1';
			desx = v.charAt(0) - 'a';
			desy = v.charAt(1) - '1';
			
			B.bfs(sx,sy);
			System.out.println("To get from "+ u +" to "+v+" takes "+B.getDistance(desx, desy)+" knight moves.");
		}
	}
}
