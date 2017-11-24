package com.company;


import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        // CheckPoint Level 2: PRETTYPRINT
        int[][] level2 = prettyPrint(4);
        System.out.println("Answer for Level 2: ");
        for (int i = 0; i < level2.length; i++) {
            for (int j = 0; j < level2.length; j++) {
                System.out.print(level2[i][j] + " ");
            }
            System.out.println();
        }

        // CheckPoint Level 3: Kth Smallest Element in the ArrayBookmark Suggest Edit
        System.out.println("\nAnswer for Level 3: ");
        System.out.println(kthsmallest(new int[]{2,1, 4, 3, 2},3));

        // CheckPoint Level 4: NEXTGREATER
        System.out.println("\nAnswer for Level 4: ");
        int[] result = nextGreater(new int[]{4, 5, 2, 10});
        System.out.print("[ ");
        for (int i = 0; i < result.length; i++) {
            if (i != result.length-1) {
                System.out.print(result[i] +", ");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.println(" ]\n");

        // CheckPoint Level 5: Longest Consecutive SequenceBookmark Suggest Edit
        System.out.println("\nAnswer for Level 5: ");
        System.out.println(findLongestConseqSubseq(new int[]{100, 4, 200, 1, 3, 2}));

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

    // CheckPoint Level 3: Kth Smallest Element in the ArrayBookmark Suggest Edit
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
