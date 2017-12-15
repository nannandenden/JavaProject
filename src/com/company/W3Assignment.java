package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class W3Assignment {

    public void test() {

        TreeNode a = new TreeNode(5);
        TreeNode b = new TreeNode(4);
        TreeNode c = new TreeNode(8);
        TreeNode d = new TreeNode(11);
        TreeNode e = new TreeNode(4);
        a.left = b;
        a.right = c;
        b.left = d;
        d.left = new TreeNode(7);
        d.right = new TreeNode(2);
        c.left = new TreeNode(13);
        c.right = e;
        e.right = new TreeNode(1);

//        zigzagLevelOrder(a);
        // 2147483647
//        System.out.print(floorSqrt(2147483647));
        //A=[1, 2, 1, 3, 4, 3] and K = 3
        List<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(5);
        test.add(6);
        test.add(7);
        test.add(0);
        test.add(1);
        test.add(2);
//        System.out.print(search(test, 4));

//        dNums(test, 3);

//        System.out.print(hasPathSum(a, 22));

        ListNode a1 = new ListNode(5);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(6);
        ListNode a4 = new ListNode(7);
        ListNode a5 = new ListNode(8);
        ListNode a6 = new ListNode(2);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode a) {
        if(a == null) return null;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Stack<TreeNode> rightToLeft = new Stack<>();
        Stack<TreeNode> leftToRight = new Stack<>();
        leftToRight.push(a);
        ArrayList<Integer> newList = new ArrayList<>();
        newList.add(a.val);
        result.add(newList);

        while(!leftToRight.isEmpty() || !rightToLeft.isEmpty()) {
            newList = new ArrayList<>();
            if(!leftToRight.isEmpty()) {
                while(!leftToRight.isEmpty()) {
                    TreeNode node = leftToRight.pop();
                    if(node.right != null) {
                        newList.add(node.right.val);
                        rightToLeft.push(node.right);
                    }
                    if(node.left != null) {
                        newList.add(node.left.val);
                        rightToLeft.push(node.left);
                    }
                }
            } else {
                while(!rightToLeft.isEmpty()) {
                    TreeNode node = rightToLeft.pop();
                    if(node.left != null) {
                        newList.add(node.left.val);
                        leftToRight.push(node.left);
                    }
                    if(node.right != null) {
                        newList.add(node.right.val);
                        leftToRight.push(node.right);
                    }
                }
            }
            if(!newList.isEmpty()) {
                result.add(newList);
            }
        }
        return result;
    }

    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        if(A == null || B == 0) return null;
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        int count = 0;
        int removeCount = 0;

        for(Integer i : A) {
            if(numMap.containsKey(i)) {
                int c = numMap.get(i);
                numMap.put(i, c + 1);
            } else {
                numMap.put(i, 1);
            }
            count++;
            if(count >= B) {
                result.add(numMap.size());
                int r = numMap.get(A.get(removeCount));
                if(r > 1) {
                    numMap.put(A.get(removeCount), r - 1);
                } else {
                    numMap.remove(A.get(removeCount));
                }
                removeCount++;
            }
        }
        return result;
    }

    public int hasPathSum(TreeNode a, int b) {

        return hasPathSumHelper(a, b) ? 1 : 0;
    }

    private boolean hasPathSumHelper(TreeNode node, int sum) {
        if (node == null) {
            return (sum == 0);
        } else {
            boolean ans = false;

            /* otherwise check both subtrees */
            int subsum = sum - node.val;
            if (subsum == 0 && node.left == null && node.right == null)
                return true;
            if (node.left != null)
                ans = ans || hasPathSumHelper(node.left, subsum);
            if (node.right != null)
                ans = ans || hasPathSumHelper(node.right, subsum);
            return ans;
        }
    }

    public int search(final List<Integer> a, int b) {
        int pivot = findPivot(a, 0, a.size()-1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(a, 0, a.size()-1, b);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (a.get(pivot) == b)
            return pivot;
        if (a.get(0) <= b)
            return binarySearch(a, 0, pivot-1, b);
        return binarySearch(a, pivot+1, a.size()-1, b);
    }

    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    private int findPivot(final List<Integer> a, int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

       /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (mid < high && a.get(mid) > a.get(mid + 1))
            return mid;
        if (mid > low && a.get(mid) < a.get(mid - 1))
            return (mid-1);
        if (a.get(low) >= a.get(mid))
            return findPivot(a, low, mid-1);
        return findPivot(a, mid + 1, high);
    }

    /* Standard Binary Search function */
    private int binarySearch(final List<Integer> a, int low, int high, int key) {
        if (high < low)
            return -1;

       /* low + (high - low)/2; */
        int mid = (low + high)/2;
        if (key == a.get(mid))
            return mid;
        if (key > a.get(mid))
            return binarySearch(a, (mid + 1), high, key);
        return binarySearch(a, low, (mid -1), key);
    }

}
