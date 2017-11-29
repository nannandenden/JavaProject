package com.company;


import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        W1Pre w1 = new W1Pre();
        System.out.println("********* Arrays problems **********");

        System.out.println("\nMin Steps in Infinite Grid");
        System.out.println(w1.coverPoints(new int[]{0,1,1}, new int[]{0,1,2}));

        System.out.println("\nWave Array");
        int[] result = w1.wave(new int[]{5, 1, 3, 2, 4});
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        System.out.println("\n\n********* Strings problems **********");
        System.out.println("\nPalindrome String");
        System.out.println(w1.isPalindrome("1a2"));

        System.out.println("\nLength of Last Word");
        System.out.println(w1.lengthOfLastWord("Hello World  "));

    }

    // CheckPoint Level 2: PRETTYPRINT
    static int[][] prettyPrint(int A) {
        int dim = 1 + (A-1)*2;
        int[][] result = new int[dim][dim];
        int increasePoint = dim-1;
        int minValueForTheRow = A;
        int value;
        for(int i = 0; i < dim; i++) {
            value = A;
            for(int j = 0; j < dim; j++) {
                if(j > dim/2) {
                    if(j > increasePoint) {
                        value++;
                    }
                }
                result[i][j] = value;
                if(j < dim/2) {
                    if(value > minValueForTheRow) {
                        value--;
                    }
                }
            }
            if(i < dim/2) {
                increasePoint--;
                minValueForTheRow--;
            } else {
                increasePoint++;
                minValueForTheRow++;
            }
        }
        return result;
    }

    // CheckPoint Level 3: Kth Smallest Eleme nt in the ArrayBookmark Suggest Edit
    static int kthsmallest(final int[] A, int B) {
        int kthPos = B-1; // kth smallest in the array position
        int nextLeft = kthPos - 1; // left next of the kth position
        int nextRight = kthPos + 1; // right next of the kth position

        int[] result = new int[A.length];
        result[kthPos] = A[0];
        for(int i = 1; i < A.length; i++) {
            if (A[i] >= result[kthPos]) {
                if (nextRight < A.length) {
                    result[nextRight] = A[i];
                    nextRight++;
                } else {
                    result[nextLeft] = result[kthPos];
                    result[kthPos] = A[i];
                    nextLeft--;
                    if(kthPos < A.length - 1) {
                        for(int a = kthPos + 1; a < A.length; a++) {
                            if(result[kthPos] > result[a]) {
                                int temp = result[kthPos];
                                result[kthPos] = result[a];
                                result[a] = temp;
                            }
                        }
                    }
                }
            } else {
                if (nextLeft >= 0) {
                    result[nextLeft] = A[i];
                    nextLeft--;
                } else {
                    result[nextRight] = result[kthPos];
                    result[kthPos] = A[i];
                    nextRight++;
                    if(kthPos > 0) {
                        for(int a = kthPos - 1; a >= 0; a--) {
                            if(result[kthPos] < result[a]) {
                                int temp = result[kthPos];
                                result[kthPos] = result[a];
                                result[a] = temp;
                            }
                        }
                    }
                }
            }
        }
        return result[kthPos];
    }

    // CheckPoint Level 4: NEXTGREATER
    static int[] nextGreater(int[] A) {
        for(int i = 0; i < A.length; i++) {
            if (i == A.length-1) {
                A[i] = -1;
            }
            for (int j = i+1; j < A.length; j++) {
                if (A[i] < A[j]) {
                    A[i] = A[j];
                    break;
                } else if (j == A.length-1) {
                    A[i] = -1;
                }
            }
        }
        return A;
    }

    // CheckPoint Level 5: Longest Consecutive SequenceBookmark Suggest Edit
    static int findLongestConseqSubseq(int A[]) {
        HashSet<Integer> S = new HashSet<Integer>();
        int ans = 0;

        // Hash all the array elements
        for (int i = 0; i < A.length; ++i)
            S.add(A[i]);

        // check each possible sequence from the start
        // then update optimal length
        for (int i = 0; i < A.length; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!S.contains(A[i] - 1)) {
                // Then check for next elements in the
                // sequence
                int j = A[i];
                while (S.contains(j))
                    j++;

                // update  optimal length if this length
                // is more
                if (ans < j - A[i])
                    ans = j - A[i];
            }
        }
        return ans;

    }

}
