import java.util.*;

//dfs to find a path and return
public class minimumPath{


	public static void main(String[] args){
		int[][] map = new int[][]{{0,0,1,0},{0,0,0,1},{1,0,0,0},{1,0,0,0}};
		minimumPath sol = new minimumPath();
		List<int[]> res = sol.findPath(map);
		for(int[] s : res){
			System.out.println(s[0]+","+s[1]);
		}

	}

	public List<int[]> findPath(int[][] map){
		List<int[]> res = new ArrayList<>();
		res.add(new int[]{0,0});
		helper(map,res,0,0,new boolean[map.length][map[0].length]);
		return res;

	}

	//dfs find one path
	private boolean helper(int[][] map, List<int[]> ls, int i, int j, boolean[][] visited){
		if(i<0 || j<0 || i>=map.length || j>=map[0].length || map[i][j]==1||visited[i][j]==true){		
			return false;
		}
		visited[i][j]=true;
		if(i==map.length-1 && j==map[0].length-1) return true;
		ls.add(new int[]{i-1,j});
		if(helper(map,ls,i-1,j,visited)) return true;
		ls.remove(ls.size()-1);
		ls.add(new int[]{i+1,j});
		if(helper(map,ls,i+1,j,visited)) return true;
		ls.remove(ls.size()-1);
		ls.add(new int[]{i,j-1});
		if(helper(map,ls,i,j-1,visited)) return true;
		ls.remove(ls.size()-1);
		ls.add(new int[]{i,j+1});
		if(helper(map,ls,i,j+1,visited)) return true;
		ls.remove(ls.size()-1);
		visited[i][j]=false;
		return false;
	}



}