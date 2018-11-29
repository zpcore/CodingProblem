// Recite the program!


public class kthSmallestTwoSort{
	public static void main(String args[]){
		kthSmallestTwoSort sol = new kthSmallestTwoSort();
		int[] a = new int[]{2,3,5,11,13};
		int[] b = new int[]{1,2,6,9,14,21,22};
		// int[] a = new int[]{2};
		// int[] b = new int[]{0};
		int k = 4;
		int result = sol.solution(a,b,k);
		System.out.println("result:"+result);
	}
// 0
// 1

	public int solution(int[] a, int[] b, int k){
		return helper(a,b,0,0,a.length-1,b.length-1,k);
	}

	private int helper(int[] a, int[] b, int st1, int st2, int ed1, int ed2, int k){
		if(st1>ed1) return b[st2+k-1];
		if(st2>ed2) return a[st1+k-1];
		int mid1 = (ed1+st1)/2;
		int mid2 = (ed2+st2)/2;
		if(mid1+mid2-st1-st2>=k-1){//////////
			if(a[mid1]<b[mid2]){
				return helper(a,b,st1,st2,ed1,mid2-1,k);
			}else{
				return helper(a,b,st1,st2,mid1-1,ed2,k);
			}
		}
		else{
			if(a[mid1]<b[mid2]){
				return helper(a,b,mid1+1,st2,ed1,ed2,k-mid1-st1-1);
			}else{
				return helper(a,b,st1,mid2+1,ed1,ed2,k-mid2-st2-1);
			}
		}
	}

// 	public int solution(int[] a, int[] b, int k){
// 		return helper(a,b,0,0,a.length,b.length,k);
// 	}
// // 0 , 1 
// 	private int helper(int[] a, int[] b, int st1, int st2, int ed1, int ed2, int k){
// 		if(st1==ed1) return b[st2+k-1];
// 		if(st2==ed2) return a[st1+k-1];
// 		int mid1 = (ed1+st1)/2;
// 		int mid2 = (ed2+st2)/2;
// 		System.out.println("mid1:"+mid1);
// 		System.out.println("mid2:"+mid2);
// 		if(mid1+mid2-st1-st2>=k-1){
// 			if(a[mid1]<b[mid2]){
// 				return helper(a,b,st1,st2,ed1,mid2,k);
// 			}else{
// 				return helper(a,b,st1,st2,mid1,ed2,k);
// 			}
// 		}
// 		else{
// 			if(a[mid1]<b[mid2]){
// 				return helper(a,b,mid1+1,st2,ed1,ed2,k-mid1-st1-1);
// 			}else{
// 				return helper(a,b,st1,mid2+1,ed1,ed2,k-mid2-st2-1);
// 			}
// 		}
// 	}


// most simplify version
	// public int solution(int[] a, int[] b, int k){
	// 	return helper(a,b,0,0,a.length,b.length,k-1);
	// }

	// private int helper(int[] a, int[] b, int st1, int st2, int ed1, int ed2, int k){
	// 	if(st1==ed1) return b[st2+k];
	// 	if(st2==ed2) return a[st1+k];
	// 	int mid1 = (ed1+st1)/2;
	// 	int mid2 = (ed2+st2)/2;
	// 	if(mid1+mid2-st1-st2>=k){
	// 		if(a[mid1]<b[mid2]){
	// 			return helper(a,b,st1,st2,ed1,mid2,k);
	// 		}else{
	// 			return helper(a,b,st1,st2,mid1,ed2,k);
	// 		}
	// 	}
	// 	else{
	// 		if(a[mid1]<b[mid2]){
	// 			return helper(a,b,mid1+1,st2,ed1,ed2,k-mid1-st1-1);
	// 		}else{
	// 			return helper(a,b,st1,mid2+1,ed1,ed2,k-mid2-st2-1);
	// 		}
	// 	}
	// }


}