package proj;
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];
        int[] result = new int[num];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = num - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= array[i])
                stack.pop();
            
            if(stack.isEmpty())
                result[i] = -1;
            else
                result[i] = stack.peek();
            
            stack.push(array[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < num; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
