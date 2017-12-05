package com.company;

import java.util.*;
import java.util.stream.StreamSupport;

public class W2Pre {

    public void testW2() {

        ListNode a = new ListNode(28);
        ListNode b = new ListNode(34);
        ListNode c = new ListNode(48);
        ListNode d = new ListNode(74);
        ListNode e = new ListNode(42);
        ListNode f = new ListNode(49);
        ListNode g = new ListNode(41);
        ListNode h = new ListNode(45);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;

        swapPairs(a);
    }

    public int colorful(int a) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new LinkedList<>();
        while (a > 0) {
            if (list.contains(a % 10)) {
                return 0;
            }
            list.add(a % 10);
            a = a / 10;
        }
        Integer[] intArray = list.toArray(new Integer[list.size()]);
        System.out.println(intArray.length);
        for (int i = intArray.length - 1; i >= 0; i--) {
            int product = intArray[i];
            for (int j = i-1; j >= 0; j--) {
                product *= intArray[j];
                if (list.contains(product)) {
                    return 0;
                }
                list.add(product);
            }
            product = 1;
        }
        return 1;
    }

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<String> sortedList = new ArrayList<>();
        // sort all the item in the list
        for (String item : a) {
            char[] currentChar = item.toCharArray();
            Arrays.sort(currentChar);
            sortedList.add(new String(currentChar));
        }
        Set<String> uniqueStr = new HashSet<>();
        for (int i = 0; i < sortedList.size(); i++) {
            String currentStr = sortedList.get(i);
            ArrayList<Integer> currentIndex = new ArrayList<>();
            currentIndex.add(i + 1);
            if (!uniqueStr.contains(currentStr)) {
                uniqueStr.add(currentStr);
                for (int j = i + 1; j < sortedList.size(); j++) {
                    if (currentStr.equals(sortedList.get(j))) {
                        currentIndex.add(j + 1);
                    }
                }
                result.add(currentIndex);
            }

        }
        return result;
    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode deleteDuplicates(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode head = a;
        while (a.next != null) {
            if (a.val == a.next.val) {
                if (a.next.next == null) {
                    a.next = null;
                } else {
                    a.next = a.next.next;
                }
            } else {
                a = a.next;
            }
        }
        return head;
    }

    public ListNode swapPairs(ListNode a) {
        if (a == null || a.next == null) return a;
        ListNode odd = a;
        ListNode even = a.next;
        ListNode runner = new ListNode(even.val);
        ListNode head = runner;
        runner.next = new ListNode(odd.val);
        runner = runner.next;

        while (even.next != null && odd.next != null) {
            odd = odd.next.next;
            even = even.next.next;
            if (even != null && odd != null) {
                runner.next = new ListNode(even.val);
                runner = runner.next;
                runner.next = new ListNode(odd.val);
                runner = runner.next;
            } else {
                if (odd != null) {
                    runner.next = new ListNode(odd.val);
                }
                break;
            }
        }
        return head;
    }
}
