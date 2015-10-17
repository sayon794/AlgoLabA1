

public class Knapsack {
	public int wt[],val[];
	public int dp[][];
	public Knapsack(int max,int wt[],int val[]) { 
		this.wt = wt;
		this.val = val;
		dp = new int[val.length][max];
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				dp[i][j] = -1;
	}
	
	public int call(int pos,int make)  {
		if(pos>=val.length||make<0) return 0;
		if(dp[pos][make]!=-1) return dp[pos][make];
		int ret1=0,ret2=0;
		ret1 = val[pos] + call(pos+1,make-wt[pos]);
		ret2 = call(pos+1,make);
		return dp[pos][make] = Math.max(ret1, ret2);
	}
}
