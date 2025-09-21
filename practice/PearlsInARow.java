import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class PearlsInARow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<int[]> lst = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i])){
                lst.add(new int[]{map.get(arr[i]), i+1});
                map.remove(arr[i]);
            } else map.put(arr[i],i+1);
        }
        if(lst.size()==0){
            System.out.println(-1);
            return;
        }
        System.out.println(lst.size());
        for(int a[] : lst){
            System.out.println(a[0]+" "+a[1]);
        }
        
       
    }
}
