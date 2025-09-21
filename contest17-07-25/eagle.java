import java.util.Scanner;

public class eagle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int prefix[]  =new int[n];
            int suffix[] = new int[n];
            for(int i=0;i<n;i++){
                prefix[i] = sc.nextInt();
            }
            for(int i=0;i<n;i++){
                suffix[i] = sc.nextInt();
            }
            boolean check = true;
            
            for(int i=0;i<n;i++){
                int a =prefix[i],b=suffix[i];
               if(a%b!=0 && b%a!=0){
                check = false;
                break;
               }
               int g = Math.min(a,b);
               if(i>0 && prefix[i+1]%g!=0){
                check = false;
                break;
               }
               if(i<n-1 && suffix[i+1]%g!=0){
                check = false;
                break;
               }
            }
            
            if(!check) System.out.println("No");
            else System.out.println("Yes");
        }
       
    }
}