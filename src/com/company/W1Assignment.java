package com.company;

import java.util.*;

public class W1Assignment {

    // Implement StrStr
    public int strStr(final String haystack, final String needle) {
        if (!haystack.contains(needle)) return -1;

        String result = haystack.replace(needle, " ");
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == ' ') return i;
        }
        return -1;
    }

    // Roman To Integer
    public int romanToInt(String a) {
        int total = 0;
        int prevValue = Integer.MAX_VALUE;
        int currValue = 0;
        for (char current : a.toCharArray()) {
            switch (current) {
                case 'M' : {
                    currValue = 1000;
                    if (prevValue < currValue) {
                        total += currValue - prevValue - prevValue;
                    } else {
                        total += currValue;
                    }
                    prevValue = currValue;
                }
                break;
                case 'D' : {
                    currValue = 500;
                    if (prevValue < currValue) {
                        total += currValue - prevValue - prevValue;
                    } else {
                        total += currValue;
                    }
                    prevValue = currValue;
                }
                break;
                case 'C' : {
                    currValue = 100;
                    if (prevValue < currValue) {
                        total += currValue - prevValue - prevValue;
                    } else {
                        total += currValue;
                    }
                    prevValue = currValue;
                }
                break;
                case 'L' : {
                    currValue = 50;
                    if (prevValue < currValue) {
                        total += currValue - prevValue  - prevValue;
                    } else {
                        total += currValue;
                    }
                    prevValue = currValue;
                }
                break;
                case 'X' : {
                    currValue = 10;
                    if (prevValue < currValue) {
                        total += currValue - prevValue - prevValue;
                    } else {
                        total += currValue;
                    }
                    prevValue = currValue;
                }
                break;
                case 'V' : {
                    currValue = 5;
                    if (prevValue < currValue) {
                        total += currValue - prevValue - prevValue;
                    } else {
                        total += currValue;
                    }
                    prevValue = currValue;
                }
                break;
                case 'I' : {
                    currValue = 1;
                    if (prevValue < currValue) {
                        total += currValue - prevValue - prevValue;
                    } else {
                        total += currValue;
                    }
                    prevValue = currValue;
                }
                break;
                default:
                    break;

            }
        }
        return total;
    }

    // First Missing Integer
    public int firstMissingPositive(ArrayList<Integer> a) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer item : a) {
            if (item > -1) {
                set.add(item);
                if (item < min) {
                    min = item;
                }
                if (item > max) {
                    max = item;
                }
            }
        }
        // integers were all negative number
        if (set.isEmpty()) return 1;
        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) return i;
        }
        return max + 1;
    }

    // Pascal Triangle
    public ArrayList<ArrayList<Integer>> generate(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            ArrayList<Integer> newRow = new ArrayList<>();
            ArrayList<Integer> needRow = null;
            if (i > 0) {
                needRow = result.get(i - 1);
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    newRow.add(1);
                } else {
                    int left = needRow.get(j-1) == null ? 0 : needRow.get(j-1);
                    int right = needRow.get(j) == null ? 0 : needRow.get(j);
                    newRow.add(left + right);
                }
            }
            result.add(newRow);
        }
        return result;
    }
}
