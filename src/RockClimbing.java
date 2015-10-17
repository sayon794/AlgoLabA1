

public class RockClimbing {
	public static final int inf = (1<<30);
	public int A[][],dp[][];
	
	public RockClimbing(int A[][]) {
		this.A = A;
		dp = new int[A.length][A[0].length];
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				dp[i][j] = -1;
	}
	
	public int climb() {
		int mn=inf,temp;
		//System.out.println(A[0].length);
		for(int i=0;i<A[0].length;i++) {
			temp = call(0,i);
			mn = Math.min(mn, temp);
		}
		return mn;
	}
	
	public int call(int y,int x) {
		if(y>=A.length) return 0;
		if(x>=A[0].length||x<0) return inf;
		if(dp[y][x]!=-1) return dp[y][x];
		int ret1=inf,ret2=inf,ret3=inf;
		ret1 = A[y][x] + call(y+1,x-1);
		ret2 = A[y][x] + call(y+1,x);
		ret3 = A[y][x] + call(y+1,x+1);
		return dp[y][x] = Math.min(ret1, Math.min(ret2,ret3));
	}
}
