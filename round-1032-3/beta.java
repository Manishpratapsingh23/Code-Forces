import java.util.Scanner;

public class beta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while (test-- > 0) {
            int size_n = sc.nextInt();
            String xxx = sc.next();
            int left_count[] = new int[26];
            int right_count[] = new int[26];


            for (char c : xxx.toCharArray())    right_count[c - 'a']++;

            boolean result=false;

            for(int i=0;i<size_n;i++){
                int index_ch = xxx.charAt(i)-'a';
                right_count[index_ch]--;

                if(i>0 && i<size_n-1){
                    if(left_count[index_ch]>0 || right_count[index_ch]>0){
                        result=true;
                        break;
                    }

                }
                left_count[index_ch]++;
            }

            System.out.println(result ? "yes" : "No");
        }
    }
}