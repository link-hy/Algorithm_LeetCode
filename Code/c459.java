package code;

import java.util.Arrays;

public class c459 {
    public static void main(String[] args) {
        String s = "abaababaab";
        System.out.println(Solution459.repeatedSubstringPattern(s));
    }
}


/*class Solution459 {
    public static boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}*/


//KMP
class Solution459 {
    public static boolean repeatedSubstringPattern(String s) {
        return kmp(s + s, s);
    }

    public static boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int[] fail = new int[m];
        Arrays.fill(fail, -1);
        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int match = -1;
        for (int i = 1; i < n - 1; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}



/*
class Solution459 {
    public static boolean repeatedSubstringPattern(String s) {
        if(s.length()==1)
            return false;
        boolean tag=false;
        int sublen;
        for(int i=1;i<=s.length()/2;i++){//间隔
            if(s.length()%i!=0)
                continue;

            for(int j=0;j+i<s.length();j++){
                if(s.charAt(j)!=s.charAt(j+i))
                    break;
                if((j+i==s.length()-1)&&(s.charAt(j)==s.charAt(j+i)))
                    tag=true;
            }
            if(tag==true)
                break;
        }
        return tag;
    }
}*/
