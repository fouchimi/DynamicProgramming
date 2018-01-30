package com.practices.algos.constructbinaryfrominorderandpostorder;

import com.practices.algos.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length, i = 0;
        for(int val : inorder) map.put(val, i++);
        return dfs(0, n-1, postorder, 0, n-1);
    }

    private TreeNode dfs( int ileft, int iright, int[] postorder, int pleft, int pright) {
        if(ileft > iright) return null;

        int val = postorder[pright]; // root value
        TreeNode root = new TreeNode(val);
        if(ileft == iright) return root;

        int iroot = map.get(val);
        int nleft = iroot - ileft; // length of left subtree
        root.right = dfs(iroot + 1, iright, postorder, pleft + nleft, pright - 1);
        root.left = dfs(ileft, iroot - 1, postorder, pleft, pleft + nleft - 1);

        return root;

    }

    public void printInorder(TreeNode x) {
        if(x == null) return;
        printInorder(x.left);
        System.out.print(x.val + " ");
        printInorder(x.right);
    }

    public void postOrder(TreeNode x) {
        if(x == null) return;
        postOrder(x.left);
        postOrder(x.right);
        System.out.print(x.val + " ");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {13, 9, 8, 3, 15, 20, 7};
        int[] postorder = {13, 8, 9, 15, 7, 20, 3};

        TreeNode x = solution.buildTree(inorder, postorder);
        solution.printInorder(x);
        System.out.println();
        solution.postOrder(x);
    }
}
