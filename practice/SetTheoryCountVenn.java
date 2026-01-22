import java.util.*;

import java.util.*;
public class SetTheoryCountVenn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = {2,3,5};
        int n = 1000;
        int ans = venn_Diagram(arr,n);
        System.out.println(ans);
    }

    private static int venn_Diagram(int arr[], int n){
    	int count = 0;
    	int l = arr.length;
    	for(int i=1;i<(1<<l);i++){
    		int ans = Power_Set(arr,n,i);
    		if(setBit(i)%2==0) count-=ans;
    		else count+=ans;
    	}
    	return count;
    }

    private static int Power_Set(int arr[], int n, int i){
    	int ans = 1;
    	int idx = 0;
    	while(i>0){
    		if((i&1)!=0){
    			ans*=arr[idx];
    		}
    		idx++;
    		i>>=1;
    	}
    	return n/ans;
    }

    private static int setBit(int i){
    	int c = 0;
    	while(i>0){
    		i=(i&(i-1));
    		c++;
    	}
    	return c;
    }
}