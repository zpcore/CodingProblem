/*
Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
*/
import java.util.ArrayList;
import java.util.List;

public class longestcommonsubstring {

    public static void main(String[] args) {
        String t = "sttstsssvagdfabae";
        String m = "abaestetsstttsss";
        List<String> res = solution(t, m);
        for (String str : res) {
            System.out.println(str);
        }
    }

	public static List<String> solution(String p, String q){
		//row:p, col:q
		int m = p.length();
		int n = q.length();
		int max = 1;
		List<Integer> pos = new ArrayList<>();
		int[][] tab = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(p.charAt(i)==q.charAt(j)){
					if(i==0 || j==0) tab[i][j] = 1;
					else tab[i][j] = tab[i-1][j-1]+1;
					if(tab[i][j]==max){ // add the point to the list
						pos.add(i);//only add the end point of string p
					}
					if(tab[i][j]>max){// clear the list and add the position to the new list
						max = tab[i][j];
						pos.clear();
						pos.add(i);
					} 
				}
			}
		}
		//construct the string for pos list
		List<String> res = new ArrayList<>();
		for(int i: pos) res.add(p.substring(i-max+1,i+1));
		return res;
	}
}