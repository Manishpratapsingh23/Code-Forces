import java.util.Scanner;

public class pattern {
    //int length;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solve(sc);
    }

    private static void solve(Scanner sc){
        int n = sc.nextInt();
        String arr[] = new String[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
        }
        //int l  =arr.length;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr[0].length();i++){
            char ch = arr[0].charAt(i);
            boolean isAllQuestionMark = true;
            if(ch!='?') isAllQuestionMark = false;
            boolean isDiff = false;
            for(int j=1;j<n;j++){
                if(arr[j].charAt(i)!='?'){
                    //isAllQuestionMark = false;
                    if(isAllQuestionMark){
                        ch = arr[j].charAt(i);
                        isAllQuestionMark = false;
                    }
                    else if(arr[j].charAt(i)!=ch) isDiff = true;
                }
            }

            if(isDiff) sb.append('?');
            else if(isAllQuestionMark) sb.append('x');
            else sb.append(ch);
            
        }
        System.out.println(sb.toString());
    }
}



