public class LongestSubWithoutRepeat{

	public static void main(String[] args){
		LongestSubWithoutRepeat sol = new LongestSubWithoutRepeat();
		String s = "fwofapsanfuokxcpp42130f";
		System.out.println(sol.solution(s));
	}


	public String solution(String s){
		int[] tab = new int[256];
		int l = 0, r = 0, cnt =0;
		int max = 0, posL = 0, posR = 0;
		while(r<s.length()){
			if(tab[s.charAt(r++)]++ == 1) cnt++;
			while(cnt>0){
				if(tab[s.charAt(l++)]-- == 2) cnt--;
			}
			if(max < r-l){
				posL = l;
				posR = r;
				max= r-l;
			}

		}
		return s.substring(posL,posR);
	}
}