package testCodeSamples;

/**
 * Created by kent4 on 9/22/2017.
 */
import java.util.*;
public class NumbersBetween {

    public static void main(String args[]){
        /**
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Pleas input two numbers in two lines:");
	        int head = sc.nextInt();
	        int tail = sc.nextInt();
	        if(head>tail){
	            int tmp = head;
	            head = tail;
	            tail = tmp;
	        }
	        while(++head<tail)
	            System.out.println(head);

            */
        System.out.println(solution("aaaB"));
    }

    public static int solution(String S) {
        /**
         * write your code in Java SE 8
         */
        if(S.length()<1)    return -1;
        int i = -1;
        int j = 0;
        int[] re = new int[1];
        while(++i<S.length() && j<S.length()){
            j = i;
            countSub(S,i,j,re);
        }
        return re[0]==0? -1:re[0];
    }

    private static void countSub(String s, int i, int j, int[] re){
        boolean hasUpperCase = false;
        while(j<s.length()){
            char c =s.charAt(j);
            if(Character.isUpperCase(c)){
                hasUpperCase = true;
                j++;
            }
            else if(Character.isDigit(c))
                return;
            else{
                if(hasUpperCase)
                    re[0] = Math.max(j-i+1,re[0]);
                j++;
            }
        }
    }
}
