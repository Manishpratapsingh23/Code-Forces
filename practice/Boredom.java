import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boredom {
    private static void solve_kro(Scanner sc){
        int n = sc.nextInt();
        int nums[] = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();
        System.out.println(solveM(nums));
    }
    public static int solveM(int[] nums) {
        Arrays.sort(nums);
        Map<String, Integer> memo = new HashMap<>();
        return helperM(nums,0, -1, memo);
    }

    private static int helperM(int nums[], int idx, int prev, Map<String, Integer> memo){
        if(idx==nums.length) return 0;
        String key = idx+","+prev;
        if(memo.containsKey(key)) return memo.get(key);
        int sum = nums[idx];
        int j = idx+1;
        while(j<nums.length && nums[idx]==nums[j]) sum+=nums[j++];
        int op1 = Integer.MIN_VALUE;
        if(prev==-1 || (prev+1)!=nums[idx]){
            op1 = sum+helperM(nums,j,nums[idx], memo);
        }
        int op2 = helperM(nums,j,prev,memo);
        memo.put(key,Math.max(op1,op2));
        return Math.max(op1,op2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve_kro(sc);
    }
}