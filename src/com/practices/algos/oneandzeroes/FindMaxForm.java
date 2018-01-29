package com.practices.algos.oneandzeroes;


public class FindMaxForm {

    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxFormStartingWith(strs, m, n, 0);
    }

    private int findMaxFormStartingWith(String[] strs, int m, int n, int begin) {
        if ((begin==strs.length) || (m+n==0)) {
            return 0;
        }
        int countByAddingString = 0;
        String current = strs[begin];
        int zeroes = countZeroesIn(current);
        int ones = current.length()-zeroes;
        if (m>=zeroes && n>=ones) {
            countByAddingString = 1 + findMaxFormStartingWith(strs, m-zeroes, n-ones, begin+1);
        }
        int countBySkippingString = findMaxFormStartingWith(strs, m, n, begin+1);
        if (countByAddingString > countBySkippingString) {
            return countByAddingString;
        }
        return countBySkippingString;
    }

    private int countZeroesIn(String str) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '0') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){

        FindMaxForm obj = new FindMaxForm();
       /* String[] strs = {"0","11","1000","01","0","101","1",
                         "1","1","0","0","0","0","1","0","0110101",
                         "0","11","01","00","01111","0011","1","1000",
                         "0","11101","1","0","10","0111"};*/
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(obj.findMaxForm(strs, 5, 3));

    }
}
