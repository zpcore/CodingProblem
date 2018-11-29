public class stringBlockCompare{

	public static void main(String[] args){
		String s1 = "2rjewnr";
		check(s1);
		System.out.println(s1);
	}

	public boolean compare(String s1, String s2){
		while(i<s1.length()&&j<s2.length()){
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(j);
			if(Character.isDigit(s1.charAt(i))){
				ii=i+1;
				while(ii<s1.length()&&Character.isDigit(s1.charAt(ii))) ii++;
			}
			if(Character.isDigit(s2.charAt(j))){
				jj=j+1;
				while(ii<s1.length()&&Character.isDigit(s1.charAt(jj))) jj++;
			}
			
			if(Character.isDigit(s1.charAt(i))&&Character.isDigit(s2.charAt(j))){
				int i = compareDigit(s1.substring(i,ii),s2.substring(j,jj));
				if(i>0) return true;
				if(i<0) return false;
			}
			else if(Character.isLetter(s1.charAt(i))&&Character.isLetter(s2.charAt(j))){
				int i = compareLetter(s1.substring(i,ii),s2.substring(j,jj));
				if(i>0) return true;
				if(i<0) return false;
			}else{
				if(Character.isDigit(s1.charAt(i))) return 
			}

			i=ii;
			j=jj;

		}
	}

	private int compareDigit(String s1, String s2){
		if(s1.length()==0) return -1;
		if(s2.length()==0) return 1;
		// -1 <, 1 >
		int i=0;
		while(s1.charAt(i)=='0') i++;
		s1=s1.substring(i,s1.length());
		i=0;
		while(s2.charAt(i)=='0') i++;
		s2=s2.substring(i,s2.length());
		if(s1.length()<s2.length()) return -1;
		else if(s1.length()>s2.length()) return 1;
		else{
			for(int i=0;i<s1.length();i++){
				if(s1.charAt(i)>s2.charAt(i)) return 1;
				else if(s1.charAt(i)<s2.charAt(i)) return -1;
			}
		}
		return 0;
	}

	private boolean compareLetter(String s1, String s2){
		if(s1.length()==0) return -1;
		if(s2.length()==0) return 1;		
		int i = s1.compareTo(s2);
		if(i<0) i = -1;
		else if(i>0) i = 1;
		else i = 0;
		return i;
	}
	

}