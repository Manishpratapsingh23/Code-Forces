//package KotlinHerosPractice13;

import java.util.Scanner;

public class spyDetected{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0) solve(sc);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)     arr[i] = sc.nextInt();
        
        if(arr[0]!=arr[1] && arr[1]==arr[2]) {
            System.out.println(1);
            return;
        }
        for(int i=1;i<n;i++){
            if(arr[0]!=arr[i]){
                System.out.println(i+1);
            }
        }

    }
}