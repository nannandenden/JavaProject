package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class W1Pre {

    public int coverPoints(int[] A, int[] B) {
        int count = 0;
        for (int i = 1; i < A.length; i++) {
            int diffA = Math.abs(A[i] - A[i-1]);
            int diffB = Math.abs(B[i] - B[i-1]);

            count += Math.max(diffA, diffB);
        }

        return count;
    }

    public int[] wave(int[] A) {
        Arrays.sort(A);
        int[] result = new int[A.length];
        int j = 1;
        for (int i = 0; i < A.length; i+=2) {
            if (j < A.length) {
                result[j] = A[i];
                result[i] = A[j];
            } else {
                result[i] = A[i];
            }
            j += 2;
        }
        return result;
    }

    public int isPalindrome(String A) {
        String lowerA = A.toLowerCase().replaceAll("\\s+","");
        int left = 0;
        int right = lowerA.length() - 1;
        while (left < right) {
            if (lowerA.charAt(left) == lowerA.charAt(right)) {
                left++;
                right--;
            } else {
                if (!isSpecialChar(lowerA.charAt(left)) && !isSpecialChar(lowerA.charAt(right))) {
                    return 0;
                }
                if (isSpecialChar(lowerA.charAt(left))) {
                    left++;
                }
                if (isSpecialChar(lowerA.charAt(right))) {
                     right--;
                }
            }
        }
        return 1;
    }

    private boolean isSpecialChar(char c) {
        if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
            return false;
        }
        return true;
    }

    public int lengthOfLastWord(final String A) {
        int count = 0;
        boolean didHitFirstChar = false;
        for(int i = A.length()-1; i >= 0; i--) {
            if (didHitFirstChar && A.charAt(i) == ' ') {
                break;
            }
            if (didHitFirstChar && A.charAt(i) != ' ') {
                count++;
            }
            if (!didHitFirstChar && A.charAt(i) != ' ') {
                didHitFirstChar = true;
                count++;
            }
        }
        return count;
    }
}
