class Solution {
    public int balancedStringSplit(String s) {
        int numOfBalancedString = 0;
        int i = 0;
        while (i < s.length()) {
            i = greedyBalancedString(i, s);
            ++numOfBalancedString;
        }
        return numOfBalancedString;
    }

    int greedyBalancedString(int i, String s) {
        int numOfL = 0, numOfR = 0;
        if (s.charAt(i) == 'L')
            numOfL++;
        else
            numOfR++;

        while (numOfL != numOfR && i < s.length()) {
            ++i;
            if (s.charAt(i) == 'L')
                numOfL++;
            else
                numOfR++;
        }
        return ++i;
    }
}

public class BalancedStrings {
    public static void main(String[] args){
        System.out.println(new Solution().balancedStringSplit(args[0]));
    }
}