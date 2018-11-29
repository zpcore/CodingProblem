//http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=293752&highlight=facebook
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

public class TaskScheduler{
	public static void main(String[] args){
		String task = "ABABBBC";
		int k = 3;
		TaskScheduler sol = new TaskScheduler();
		System.out.println("No Reorder:"+sol.solution(task,k));
		System.out.println("Allow Reorder"+sol.solution2(task,k));
	}

	public String solution(String task, int k){
		int i = 0;
		Queue<Character> gap = new LinkedList<>();
		Set<Character> rdy = new HashSet<>();
		String res = "";
		for(char c:task.toCharArray()) rdy.add(c);
		while(i<task.length()){
			char c = task.charAt(i);
			if(rdy.contains(c)){
				res+=c;
				rdy.remove(c);
				gap.add(c);
				i++;
			}else{
				res+="#";
				gap.add('*');
			}
			while(gap.size()>k){
				char tmp = gap.remove();
				if(tmp!='*') rdy.add(tmp);
			}
		}
		return res;
	}

	public String solution2(String task, int k){
		return "";
	}


//TODO Complexity Analysis

} 