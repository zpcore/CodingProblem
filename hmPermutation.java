import java.util.*;

public class hmPermutation{

	public static void main(String[] args){
		hmPermutation sol = new hmPermutation();
		Map<Character[], Character[]> hm = new HashMap<>();
		hm.put(new Character[]{'a','b'}, new Character[]{'c'});
		hm.put(new Character[]{'a'}, new Character[]{'z'});
		hm.put(new Character[]{'b'}, new Character[]{'x'});
		hm.put(new Character[]{'a','a'}, new Character[]{'w'});
		hm.put(new Character[]{'c'}, new Character[]{'u','u'});
		hm.put(new Character[]{'b','c'}, new Character[]{'?'});
		System.out.println(sol.cter2c(hm.get(new Character[]{'b','c'})));	
		//System.out.println(sol.cter2c(hm.get(new Character[]{'c'})));	
		String s = "caabc";
		
		List<String> res = new ArrayList<>();
		res = sol.solution(hm,s);
		for(String cur:res) System.out.println(cur);
	}

	public List<String> solution(Map<Character[], Character[]>hm, String s){
		List<String> res = new ArrayList<>();
		helper(hm,res,"",s,0);
		return res;
	}

	private void helper(Map<Character[], Character[]> hm, List<String> res, String cur, String s, int pos ){
		if(pos==s.length()){
			res.add(s);
			return;
		}
		for(int i=pos;i<s.length();i++){
			Character[] tmp = s.substring(pos,i+1).chars().mapToObj(c -> (char)c).toArray(Character[]::new);
			System.out.println("test"+s.substring(pos,i+1));

			//Character[] tmp = s.substring(pos,i+1).toCharArray();
			if(hm.containsKey(tmp)){
				System.out.println("test"+String.valueOf(hm.get(tmp)));				
				helper(hm, res, cur+String.valueOf(hm.get(tmp)), s, i+1);
			}
		}
	}

	private Character[] c2cter(char[] c){
		Character[] tmp = new Character[c.length];
		for(int i=0;i<c.length;i++){
			tmp[i] = (Character)c[i];
		}
		return tmp;
	}

	private char[] cter2c(Character[] c){
		System.out.println(c.length);
		char[] tmp = new char[c.length];
		for(int i=0;i<c.length;i++){
			tmp[i] = (char)c[i];
		}
		return tmp;
	}


}