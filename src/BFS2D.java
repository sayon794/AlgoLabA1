import java.util.ArrayDeque;
import java.util.Queue;


public class BFS2D {
	private int dist[][],dx[]={-1,0,1,-1,1,-1,0,1},dy[]={-1,-1,-1,0,0,1,1,1};
	private boolean visited[][];
	private boolean block[][];
	private int R,C;
	private Queue<Integer> Qx,Qy;
	
	public BFS2D(int R,int C) {
		this.R = R;
		this.C = C;
		visited = new boolean[R][C];
		dist = new int[R][C];
		block = new boolean[R][C];
	}
	
	public BFS2D(int R,int C,int dx[],int dy[]) {
		this(R,C);
		this.dx = dx;
		this.dy = dy;
	}
	
	public void bfs(int sx,int sy) {
		Qx = new ArrayDeque<Integer>();
		Qy = new ArrayDeque<Integer>();
		visited[sx][sy] = true;
		Qx.add(sx);
		Qy.add(sy);
		while(!Qx.isEmpty()) {
			int ux = Qx.peek();
			int uy = Qy.peek();
			for(int i=0;i<dx.length;i++) {
				int vx = ux + dx[i];
				int vy = uy + dy[i];
				if(vx>=0 && vx<C && vy>=0 && vy<R && !visited[vy][vx] && !block[vy][vx]) {
					dist[vy][vx] = dist[uy][ux] + 1;
					visited[vy][vx] = true;
					Qx.add(vx);
					Qy.add(vy);
				}
			}
			Qx.remove();
			Qy.remove();
		}
	}
	
	public void setobstruction(int x,int y) { block[y][x] = true; }
	
	public int getDistance(int x,int y) { return dist[y][x]; }
}
