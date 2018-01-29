package com.practices.algos;

import java.util.Arrays;
import java.util.Comparator;

public class AbouSolution {

    public int findMaxForm(String[] strs, int m, int n) {

        Arrays.sort(strs, (s1, s2) -> s1.length() - s2.length());

        for(String str : strs) {
            System.out.print(str + " ");
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str + "#");
        }

        System.out.println("\n");
        System.out.println(sb);
        return findMaxFormUtil(sb.toString(), m, n);
    }

    private int findMaxFormUtil(String str, int m, int n) {
        int maxNum = 0;
        int s = str.length(), i = 0;
        while (i < s){
            if(str.charAt(i) == '0'){
                if(m == 0){
                    break;
                }
                m--;

            }
            else if(str.charAt(i) == '1'){
                if(n == 0){
                    break;
                }
                n--;

            }
            else if(str.charAt(i) == '#'){

                if( m == 0 && n == 0){
                    maxNum++;
                    break;
                }
                maxNum ++;

            }
            i++;
        }
        return maxNum;
    }

    public static void main(String[] args) {
        AbouSolution obj = new AbouSolution();
        String[] strs = {"111","1000","1000","1000"};
        System.out.println(obj.findMaxForm(strs, 9, 3));
    }
}
