package com.company;

import java.util.*;

public class W3Pre {

    public void test() {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        a.left = b;
        a.right = new TreeNode(3);
        b.left = new TreeNode(4);
        b.right = new TreeNode(5);

        TreeNode x = new TreeNode(1);
        TreeNode y = new TreeNode(2);
        x.left = y;
        x.right = new TreeNode(3);
        y.left = new TreeNode(4);
        y.right = new TreeNode(5);
//        inorderTraversal(a);

        /**
         * [1,3,5,6], 5 → 2
         [1,3,5,6], 2 → 1
         [1,3,5,6], 7 → 4
         [1,3,5,6], 0 → 0
         */
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2147483647);
        list.add(2000000014);
        list.add(2147483647);
//        list.add(6);

        /**
         * K = 3
         N = 2
         A = 6 5
         */

        System.out.print(nchoc(10, list));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode a) {
        if(a == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode current = a;
        while(current != null) {

            stack.push(current);
            current = current.left;
        }

        while(stack.size() > 0) {
            current = stack.pop();
            result.add(current.val);

            if(current.right != null) {
                current = current.right;
                while(current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }
        }
        return result;
    }

    public int isSameTree(TreeNode a, TreeNode b) {
        if(a == null && b ==  null) return 1;
        if(a == null || b == null) return 0;
        // at this point both are not null'

        return preOrder(a, b) == true ? 1 : 0;
    }

    private boolean preOrder(TreeNode a, TreeNode b) {
        if(a == null || b == null) {
            if(a == null && b == null) return true;
            return false;
        }
        if(a.val != b.val) return false;

        return preOrder(a.left, b.left) && preOrder(b.right, b.right);
    }

    public int searchInsert(ArrayList<Integer> a, int b) {

        return searchInsert(a, 0, a.size()-1, b);
    }

    private int searchInsert(ArrayList<Integer> a, int start, int end, int b) {
        if(start <= end) {
            int center = (start + end)/2;
            if(a.get(center) == b) return center;
            if(a.get(center) > b) {
                return searchInsert(a, start, center-1, b);
            } else {
                return searchInsert(a, center + 1, end, b);
            }
        }
        return end + 1;
    }

    public int nchoc(int A, ArrayList<Integer> B) {
        PriorityQueue<Integer> chocolate = new PriorityQueue<>(A, Collections.reverseOrder());
        for(Integer num : B) {
            chocolate.offer(num);
        }
        long total = 0;
        for(int i = 0; i < A; i++) {
            long max = chocolate.poll();
            // modulo 10^9+7
            long mod = (long)(Math.pow(10, 9) + 7);
            total = (total + max) % mod;
            int next = (int)max/2;
            chocolate.offer(next);
        }
        return (int)total;
    }
}
