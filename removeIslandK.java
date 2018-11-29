public class removeIslandK{
	//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=222973&highlight=facebook
	// remove the island size < K
	public static void main(String[] args){
		removeIslandK sol = new removeIslandK();
		int[][] map = new int[][]{
			{1,0,0,0,1,1},
			{1,1,1,0,1,0},
			{1,0,0,1,0,1},
			{0,1,0,1,0,1},
		};
		sol.solution(map,3);
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
			
	}

	public void solution(int[][] map, int k){
		if(map.length==0) return;
		boolean[][] visited = new boolean[map.length][map[0].length];
		for(int i=0;i<map.length;i++){
			for(int j=0;j<map[0].length;j++){
				if(visited[i][j]) continue;
				//int cnt = helper(map,i,j,visited);
				//System.out.println(cnt);
				if(helper(map,i,j,visited)<k) doRemove(map, i , j);
			}
		}
	}

	private int helper(int[][] map, int i, int j, boolean[][] visited){
		int r=map.length,c= map[0].length;
		if(i<0||j<0||i>=r||j>=c||visited[i][j]||map[i][j]==0) return 0;
		visited[i][j] = true;
		return (1+helper(map,i-1,j,visited)+helper(map,i+1,j,visited)+
			helper(map,i,j-1,visited)+helper(map,i,j+1,visited));
	}

	private void doRemove(int[][] map, int i, int j){
		int r=map.length,c= map[0].length;
		if(i<0||j<0||i>=r||j>=c||map[i][j]==0) return;
		map[i][j] = 0;
		doRemove(map,i+1,j);
		doRemove(map,i-1,j);
		doRemove(map,i,j+1);
		doRemove(map,i,j-1);
	}


}