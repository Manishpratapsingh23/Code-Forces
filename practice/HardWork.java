
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HardWork{
    public static  String s1;
    public static String s2;
    public static String s3;
    private static List<String> lst = new ArrayList<>();
    private static int maxLen=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc);
    }

    private static void solve(Scanner sc){
        s1 = sc.next();
        s2 = sc.next();
        s3 = sc.next();
        String arr[] = {compute(s1), compute(s2), compute(s3)};
        
        //maxLen = Math.max(s1.length(), Math.max(s2.length(), s3.length()));
        permutation(arr, 0);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            String s = sc.next();
            s = compute(s);
            if(check(s)) System.out.println("ACC");
            else System.out.println("WA");
        }

    }

    private static String compute(String s){
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch!='_' && ch!=';' && ch!='-') sb.append(ch);
        }
        return sb.toString().toLowerCase();
    }

    private static boolean check(String s){
        for(String st : lst.toArray(new String[0])){
            if(s.equals(st)) return true;
        }
        return false;
    }

    private static void permutation(String arr[], int i){
        if(i>=arr.length){
            StringBuilder sb = new StringBuilder();
            for(String s : arr) sb.append(s);
            lst.add(sb.toString());
            return;
        }
        int t = i;
        while(t<arr.length){
            swap(arr,i,t);
            permutation(arr, i+1);
            swap(arr,i,t);
            t++;
        }
    }

    private static void swap(String arr[], int a, int b){
        String s = arr[a];
        arr[a] = arr[b];
        arr[b] = s;
    }
}