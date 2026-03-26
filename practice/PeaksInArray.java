import java.io.*;
import java.util.*;

public class PeaksInArray {

	static int segement[];
	static int n;
	static boolean prev[];
	static List<Integer> ans;
   	public static List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        n = nums.length;
        ans = new ArrayList<>();
        segement = new int[4*n]; 
        prev = new boolean[n];
        for(int i=0;i<n;i++) prev[i] = compare(i, nums);
        build(0,0,n-1);
        for(int q[] : queries){
        	int type = q[0];
        	if(type==1){
        		int l = q[1];
        		int r = q[2]-1;
        		ans.add(query(0,0,n-1,l,r));
        	}else{
        		int i = q[1];
        		int val = q[2];
        		nums[i]=val;
        		if(prev[i]!=compare(i, nums)){
        			prev[i]=!prev[i];
        			update(0,0,n-1,i);
        		}
        		if(i-1>=0 && prev[i-1]!=compare(i-1, nums)){
        			prev[i-1]=!prev[i-1];
        			update(0,0,n-1,i-1);
        		}
        		if(i+1<n && prev[i+1]!=compare(i+1, nums)){
        			prev[i+1]=!prev[i+1];
        			update(0,0,n-1,i+1);
        		}
        	}
        }
        return ans;
    }

    static boolean compare(int i, int nums[]){
    	if(i<1 || i>=n-1) return false;
    	boolean res = nums[i]>nums[i-1] && nums[i]>nums[i+1];
    	return res;
    }

    static void build(int idx, int start, int end){
    	if(start==end){
    		if(prev[start]) segement[idx]=1;
    		else segement[idx]=0;
    		return;
    	}
    	int mid = start+(end-start)/2;
    	build(2*idx+1, start, mid);
    	build(2*idx+2, mid+1, end);
    	segement[idx]=segement[2*idx+1]+segement[2*idx+2];
    }

    static void update(int idx, int start, int end, int i){
    	if(start==end){
    		if(prev[start]) segement[idx]=1;
    		else segement[idx]=0;
    		return;
    	}
    	int mid = start+(end-start)/2;
    	if(i<=mid) update(2*idx+1, start, mid, i);
    	else update(2*idx+2, mid+1, end, i);
    	segement[idx]=segement[2*idx+1]+segement[2*idx+2];
    }


    static int query(int idx, int start, int end, int l, int r){
    	if(start>r || end<l) return 0;
    	if(start>=l && end<=r) return segement[idx];
    	int mid = start+(end-start)/2;
    	int left = query(2*idx+1, start, mid, l, r);
    	int right = query(2*idx+2, mid+1, end, l, r);
    	return left+right;
    
    }

    public static void main(String[] args) {
    	int[] nums = {4, 1, 4, 2, 1, 5};	
		int[][] queries = {{2, 2, 4},{1, 0, 2},{1, 0, 4}};
		System.out.println(countOfPeaks(nums, queries));
    }
}