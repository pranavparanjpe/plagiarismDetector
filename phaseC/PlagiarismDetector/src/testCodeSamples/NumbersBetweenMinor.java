package testCodeSamples;

/**
 * Created by kent4 on 9/22/2017.
 */
public class NumbersBetweenMinor {

    public static void main(String args[]){
       System.out.println(solve("wwsvcs"));
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
    
    public static int solve(String S) {
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

    
}
