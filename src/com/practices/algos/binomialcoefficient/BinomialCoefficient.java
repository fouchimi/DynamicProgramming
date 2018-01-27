package com.practices.algos.binomialcoefficient;

public class BinomialCoefficient {

    public int binomialCoeff(int n, int k) {
        if(k == 0 || k == n) return 1;
        else return binomialCoeff(n-1, k-1) + binomialCoeff(n-1, k);
    }
}
