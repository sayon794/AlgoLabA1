

public class LCS {
	public String str1,str2;
	public int dp[][];
	
	public LCS(String str1,String str2) {
		this.str1 = str1;
		this.str2 = str2;
		dp = new int[str1.length()][str2.length()];
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[i].length;j++)
				dp[i][j] = -1;
	}
	
	public int call(int pos1,int pos2) {
		if(pos1>=str1.length()||pos2>=str2.length()) return 0;
		if(dp[pos1][pos2]!=-1) return dp[pos1][pos2];
		int ret1=0,ret2=0;
		if(str1.charAt(pos1)==str2.charAt(pos2)) {
			return dp[pos1][pos2] = 1 + call(pos1+1,pos2+1);
		}
		ret1 = call(pos1+1,pos2);
		ret2 = call(pos1, pos2+1);
		return dp[pos1][pos2] = Math.max(ret1, ret2);
	}
}
