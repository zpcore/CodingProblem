import java.lang.StringBuilder;
import java.util.List;
import java.util.ArrayList;
public class ExpressionAdd{
	public static void main(String[] args){
		String s = "10501235510431";
		//String s = "000";
		int target = 5;
		ExpressionAdd sol = new ExpressionAdd();
		List<String> res=sol.solution(s,target);
		for(String ss:res) System.out.println(ss);

	}

	public List<String> solution(String s, int k){
		List<String> res = new ArrayList<>();
		//helper(res,s,"",0,0,false,k);//string
		helper(res,s,new StringBuilder(),0,0,false,k);//stringbuilder
		return res;
	}

	// //Using string
	// private void helper(List<String> res, String s, String sb, int pos, long sum, boolean sig, int k){
	// 	if(pos==s.length()){
	// 		//if(sum==k) res.add(sb.deleteCharAt(sb.length()-1).toString());//remove the last operator
	// 		if(sum==k) res.add(sb);//remove the last operator
	// 		return;
	// 	}
	// 	for(int i=pos;i<s.length();i++){
	// 		if(i==pos+1&&s.charAt(pos)=='0') return;
	// 		long j = Long.valueOf(s.substring(pos,i+1));
	// 		j=sig?-j:j;
	// 		if(i==s.length()-1) helper(res,s,sb+s.substring(pos,i+1),i+1,sum+j,false,k);
	// 		else{
	// 			helper(res,s,sb+s.substring(pos,i+1)+"+",i+1,sum+j,false,k);
	// 			helper(res,s,sb+s.substring(pos,i+1)+"-",i+1,sum+j,true,k);
	// 		}

	// 	}
	// }

	//Using StringBuilder
	private void helper(List<String> res, String s, StringBuilder sb, int pos, long sum, boolean sig, int k){
		if(pos==s.length()){
			//if(sum==k) res.add(sb.deleteCharAt(sb.length()-1).toString());//remove the last operator
			if(sum==k) res.add(sb.toString());//remove the last operator
			return;
		}
		for(int i=pos;i<s.length();i++){
			if(i==pos+1&&s.charAt(pos)=='0') return;
			long j = Long.valueOf(s.substring(pos,i+1));
			j=sig?-j:j;
			int len=sb.length();
			sb.append(s.substring(pos,i+1));
			int len2 = sb.length();
			if(i==s.length()-1) helper(res,s,sb,i+1,sum+j,false,k);
			else{
				helper(res,s,sb.append("+"),i+1,sum+j,false,k);
				sb.setLength(len2);
				helper(res,s,sb.append("-"),i+1,sum+j,true,k);
			}
			sb.setLength(len);

		}
	}


}