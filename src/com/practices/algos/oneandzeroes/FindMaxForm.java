package com.practices.algos.oneandzeroes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMaxForm {

    private int max = 0;

    public int findMaxForm(String[] strs, int m, int n) {
        List<String> list = new ArrayList<>();
        List<Integer> indexes = new ArrayList<>();
        return findMaxFormUtil(strs, m, n, 0, list, indexes);
    }

    private int findMaxFormUtil(String[] strs, int m, int n, int index, List<String> list, List<Integer> indexes) {
        int length = strs.length;
        if(index == strs.length) {
            max = Math.max(max, list.size());
            return max;
        }
        else {
            for(int i = index; i < length; i++) {

                int n0 = count(strs[i], '0');
                int n1 = count(strs[i], '1');

                if(n0 <= m && n1 <= n && !indexes.contains(i)) {
                    indexes.add(i);
                    list.add(strs[i]);
                    findMaxFormUtil(strs, m-n0, n-n1, index+1, list, indexes);
                    list.remove(list.size()-1);
                    indexes.remove(indexes.size()-1);
                }
            }
        }
        return max;
    }

    private int count(String str, char ch) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ch) count++;
        }
        return count;
    }

    public static void main(String[] args){

        FindMaxForm obj = new FindMaxForm();
        String[] strs = {"0","11","1000","01","0","101","1",
                         "1","1","0","0","0","0","1","0","0110101",
                         "0","11","01","00","01111","0011","1","1000",
                         "0","11101","1","0","10","0111"};
        System.out.println(obj.findMaxForm(strs, 9, 80));

    }
}
