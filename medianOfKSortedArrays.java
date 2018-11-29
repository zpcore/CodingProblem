import java.util.*;

public class medianOfKSortedArrays{

	public static void main(String[] args){
		//int[] nums1 = new int[]{3};
		int[] nums1 = new int[]{3,4,4,5,8,10};
		int[] nums2 = new int[]{1,1,1,2,5,11};
		int[] nums3 = new int[]{2,3,4,5,13,14};
		List<int[]> ls = new ArrayList<>();
		ls.add(nums1);
		ls.add(nums2);
		ls.add(nums3);
		medianOfKSortedArrays sol = new medianOfKSortedArrays();
		System.out.println(sol.solution(ls));

	}

//time complexity n(lgk)
	public double solution(List<int[]> ls){
		int[] ptr = new int[ls.size()];
		//total element n
		int k=0;
		for(int[] n:ls){
			k+=n.length;
		}
		
		//using a min heap, we need to pop odd(n/2:1),even(n/2-1:2) element
		//Map(content->array number)
		Queue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((m1,m2)->m1.getValue()-m2.getValue());
		Map<Integer,Integer> hm = new HashMap<>();
		for(int i=0;i<ls.size();i++){
			hm.put(i,ls.get(i)[0]);
			ptr[i]++;
		}
		pq.addAll(hm.entrySet());
		int needPop = k/2+1;
		boolean isOdd = k%2==0?false:true;
		double res = 0;
		while(needPop>0){
			Map.Entry<Integer,Integer> tmp = pq.remove();
			int arryNum = tmp.getKey();
			if(needPop==1){
				res+=tmp.getValue();
				if(!isOdd) res/=2.0;
			}
			if(needPop==2&&!isOdd) res+=tmp.getValue();
			if(ptr[arryNum]>=ls.get(arryNum).length){
				//the array is empty, remove the entry
			}
			else{
				Map.Entry<Integer,Integer> me = new HashMap.SimpleEntry<>(arryNum,ls.get(arryNum)[ptr[arryNum]]);
				pq.add(me);
				ptr[arryNum]++;
			}
			needPop--;
		}
		return res;

	}
}