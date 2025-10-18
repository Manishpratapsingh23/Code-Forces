import java.util.*;

public class PermutationTransformation {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            solve(sc);
        }
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int arr[] = new int[n];
        int ans[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = sc.nextInt();
        helper(arr, 0, n-1, ans,0);
        for(int i : ans) System.out.print(i+" ");
        System.out.println();
    }

    private static void helper(int arr[], int start, int end, int ans[], int depth){
        if(start>end) return;
        int mid = findMid(arr, start, end);
        ans[mid] = depth;
        helper(arr, start, mid-1, ans, depth+1);
        helper(arr, mid+1, end, ans, depth+1);
    }

    private static int findMid(int arr[], int start, int end){
        //int highest = arr[start];
        int ans = start;
        for(int i = start+1;i<=end;i++){
            if(arr[i]>arr[ans]) ans = i;
        }
        return ans;
    }
}
h