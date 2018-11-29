import java.util.Random;
import java.util.Set;
import java.util.HashSet;
//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=286608&page=1&authorid=268391
public class randomMine{

	public static void main(String[] args){
		int[][] res = RSgetGrid(5,10,25);
		//int[][] res = getGrid(5,10,9); //question 1
		//int[][] res = DrawMine(5,10,9); // follow up
		for(int i=0;i<res.length;i++){
			for(int j=0;j<res[0].length;j++){
				System.out.format("%4d",res[i][j]);
			}
			System.out.println();
		}
	}


	// Important: Reservior Sampling, time: O(M)
	public static int[][] RSgetGrid(int H, int W, int M){
		int mineCnt = 0;
		int[][] res = new int[H][W];
		int len = H*M;
		//put all the mine in the end of the array;
		for(int i=H*W-1;i>=H*W-M;i--){
			res[i/W][i%W] = -1;
		}
		//swap
		Random random = new Random();
		int k = H*W-M;
		for(int i=H*W-M;i<H*W;i++){
			int rnd = random.nextInt(i+1);//generate from [0,i]
			if(rnd<k){//swap(res, res[rnd/H][rnd%H],res[i/H][i%H]);
				int tmp = res[rnd/W][rnd%W];
				res[rnd/W][rnd%W] = res[i/W][i%W];
				res[i/W][i%W] = tmp;
			}
		}
		return res;
	}


	public static int[][] getGrid(int H, int W, int M){
		Random rand = new Random();
		int[][] res = new int[H][W];
		int remainMine = M;
		int remainBlock = H*M;
		Set<Integer> hs = new HashSet<>();
		while(hs.size()<M){
			int genRand = rand.nextInt(H*M);
			hs.add(genRand);
		}
		for(Integer i:hs){
			res[i/W][i%W]=-1;
		}
		return res;
	}


	public static int[][] DrawMine(int H, int W, int M){
		Random rand = new Random();
		int[][] res = new int[H][W];
		int remainMine = M;
		int remainBlock = H*M;
		Set<Integer> hs = new HashSet<>();
		while(hs.size()<M){
			int genRand = rand.nextInt(H*M);
			hs.add(genRand);
		}
		for(Integer i:hs){
			res[i/W][i%W]=-1;
		}

		for(Integer i:hs){
			int row = i/W;
			int col = i%W;
			if(row>0 && res[row-1][col]!=-1) res[row-1][col]++;
			if(col>0 && res[row][col-1]!=-1) res[row][col-1]++;
			if(row<H-1 && res[row+1][col]!=-1) res[row+1][col]++;
			if(col<W-1 && res[row][col+1]!=-1) res[row][col+1]++;
			if(col>0 && row>0 && res[row-1][col-1]!=-1) res[row-1][col-1]++;
			if(col>0 && row<H-1 && res[row+1][col-1]!=-1) res[row+1][col-1]++;
			if(col<W-1 && row>0 && res[row-1][col+1]!=-1) res[row-1][col+1]++;
			if(col<W-1 && row<H-1 && res[row+1][col+1]!=-1) res[row+1][col+1]++;
		}

		return res;
	}

}