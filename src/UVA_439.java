import java.util.Scanner;


public class UVA_439 {
	public UVA_439() {
		Scanner S = new Scanner(System.in);
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
