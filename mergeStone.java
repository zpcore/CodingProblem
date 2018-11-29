public class Solution {
  int[] sumArr;
  public int minCost(int[] stones) {
    // Write your solution here
    //dp[i] represent min merge from stone[0] to stone[i]
    // X X X X | X   X X... X X X A
    //       k   k+1              i
    // sum(0,k)+dp[0,k]+dp[k+1,i]+sum(k+1,i), k=0,...,i-1
    // X X X X | X X - X ... X X X A
    //       k     j   j+1         i 
    // dp[k+1,i] = sum(k+1,j)+dp[k+1,j]+dp[j+1,i]+sum(j+1,i) j=i,...k+1
    int len = stones.length;
    if(len==0) return 0;
    
    sumArr = new int[len+1];
    for(int i=0; i<len; i++) {
      sumArr[i+1] = sumArr[i]+stones[i];
    }
    // X|A
    //    k | k+1
    //         j   j+1
    //              i
    int[][] dp = new int[len][len];
    for(int i=1; i<len; i++) {
      int outMin = Integer.MAX_VALUE;//stone[i]
      for(int k=i-1; k>=0; k--) {
        int min = Integer.MAX_VALUE;
        if(k==i-1) min = 0;
        for(int j=i-1; j>=k+1; j--) {
          min = Math.min(min,sum(k+1,j)+dp[k+1][j]+dp[j+1][i]+sum(j+1,i));
        }
        dp[k+1][i] = min;
        outMin = Math.min(outMin,sum(0,k)+dp[0][k]+dp[k+1][i]+sum(k+1,i));
      }
      dp[0][i] = outMin;
    }
    return dp[0][len-1];
    
  }
  public int sum(int i, int j) {
    return sumArr[j+1]-sumArr[i];
  }
  
}
