package com.company;

import java.util.*;

public class W2Assignment {

    public void testW2Assignment() {
        System.out.print(lengthOfLongestSubstring(
                "Wnb9z9dMc7E8v1RTUaZPoDNIAXRlzkqLaa97KMWLzbitaCkRpiE4J4hJWhRcGnC8H6mwasgDfZ76VKdXhvEYmYrZY4Cfmf4HoSlchYWFEb1xllGKyEEmZOLPh1V6RuM7Mxd7xK72aNrWS4MEaUmgEn7L4rW3o14Nq9l2EN4HH6uJWljI8a5irvuODHY7A7ku4PJY2anSWnfJJE1w8p12Ks3oZRxAF3atqGBlzVQ0gltOwYmeynttUmQ4QBDLDrS4zn4VRZLosOITo4JlIqPD6t4NjhHThOjJxpMp9fICkrgJeGiDAwsb8a3I7Txz5BBKV9bEfMsKNhCuY3W0ZHqY0MhBfz1CbYCzwZZdM4p65ppP9s5QJcfjadmMMi26JKz0TVVwvNA8LP5Vi1QsxId4SI19jfcUH97wmZu0pbw1zFtyJ8GAp5yjjQTzFIboC1iRzklnOJzJld9TMaxqvBNBJKIyDjWrdfLOY8FGMOcPhfJ97Dph35zfxYyUf4DIqFi94lm9J0skYqGz9JT0kiAABQZDazZcNi80dSSdveSl6h3dJjHmlK8qHIlDsqFd5FMhlEirax8WA0v3NDPT8vPhwKpxcnVeu14Gcxr3h1wAXXV0y7Xy9qqB2NQ5HQLJ7cyXAckEYHsLCPSy28xcdNJatx1KLWohOQado4WywJbGvsFR17rKmvOPABweXnFD3odrbSMD4Na4nuBBswvMmFRTUOcf7jZi4z5JnJqXz6hitaPnaEtjoSEBq82a52nvqYy7hhldBoxen2et2OMadVEHeTYLL7GLsIhTP6UizHIuzcJMljo4lFgW5AyrfUlIBPAlhwaSiJtTvcbVZynDSM6RO1PqFKWKg2MHIgNhjuzENg2oFCfW7z5KJvEL9qWqKzZNc0o3BMRjS04NCHFvhtsteQoQRgz84XZBHBJRdekCdcVVXu9c01gYRAz7oIAxN3zKZb64EFKssfQ4HW971jv3H7x5E9dAszA0HrKTONyZDGYtHWt4QLhNsIs8mo4AIN7ecFKewyvGECAnaJpDn1MTTS4yTgZnm6N6qnmfjVt6ZU51F9BxH0jVG0kovTGSjTUkmb1mRTLQE5mTlVHcEz3yBOh4WiFFJjKJdi1HBIBaDL4r45HzaBvmYJPlWIomkqKEmQ4rLAbYG7C5rFfpMu8rHvjU7hP0JVvteGtaGn7mqeKsn7CgrJX1tb8t0ldaS3iUy8SEKAo5IZHNKOfEaij3nI4oRVzeVOZsH91pMsA4jRYgEohubPW8ciXwVrFi1qEWjvB8gfalyP60n1fHyjsiLW0T5uY1JzQWHKCbLVh7QFoJFAEV0L516XmzIo556yRH1vhPnceOCjebqgsmO78AQ8Ir2d4pHFFHAGB9lESn3OtJye1Lcyq9D6X93UakA3JKVKEt6JZDLVBMp4msOefkPKSw59Uix9d9kOQm8WCepJTangdNSOKaxblZDNJ5eHvEroYacBhd9UdafEitdF3nfStF7AhkSfQVC61YWWkKTNdx96OoJGTnxuqt4oFZNFtO7aMuN3IJAkw3m3kgZFRGyd3D3wweagNL9XlYtvZwejbjpkDOZz33C0jbEWaMEaUPw6BG49XqyQoUwtriguO0yvWyaJqD4ye3o0E46huKYAsdKAq6MLWMxF6tfyPVaoqOGd0eOBHbAF89XXmDd4AIkoFPXkAOW8hln5nXnIWP6RBbfEkPPbxoToMbV"));
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        a.next = b;
        b.next = c;
        a.random = new RandomListNode(3);
        b.random = new RandomListNode(1);
        c.random = new RandomListNode(1);

        copyRandomList(a);

        List<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("aaa");
        arrayList.add("aaa");
        arrayList.add("aaa");
        arrayList.add("aaa");

        findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", arrayList);
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(2);
        ListNode c1 = new ListNode(3);
        ListNode d = new ListNode(4);
        a1.next = b1;
        b1.next = c1;
        c1.next = d;
        d.next = c1;

        detectCycle(a1);

    }

    // Longest Substring Without Repeat
    public int lengthOfLongestSubstring(String a) {
        if(a == null) return -1;
        if(a.length() == 1) return 1;
        Map<Character, Integer> charMap = new HashMap<>();
        int max = 0;
        int repeatingPos = 0;
        for(int i = 0; i < a.length(); i++) {
            if(charMap.get(a.charAt(i)) != null) {
                // update the repeating position
                int distance = i - charMap.get(a.charAt(i)) + 1;
                max = Math.max(max, distance);
                repeatingPos = Math.max(repeatingPos, charMap.get(a.charAt(i)) + 1);
            } else {
                max = Math.max(max, i - repeatingPos);
            }
            charMap.put(a.charAt(i), i);
        }
        return max;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = new RandomListNode(head.label);

        RandomListNode runnerOriginal = head;
        RandomListNode runnerCopy = newHead;
        map.put(runnerOriginal, runnerCopy);

        runnerOriginal = runnerOriginal.next;
        while(runnerOriginal != null) {
            RandomListNode temp = new RandomListNode(runnerOriginal.label);
            map.put(runnerOriginal, temp);
            runnerCopy.next = temp;
            runnerCopy = temp;
            runnerOriginal = runnerOriginal.next;
        }
        runnerOriginal = head;
        runnerCopy = newHead;
        while(runnerOriginal != null) {
            if(runnerOriginal.random != null) {
                runnerCopy.random = map.get(runnerOriginal.random);
            } else {
                runnerCopy.random = null;
            }
        }
        return newHead;
    }

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        int wordSize = b.get(0).length();
        int subStringLength = b.size() * wordSize;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i + subStringLength <= a.length(); i++) {
            String substring = a.substring(i, i + subStringLength);
            List<String> dummy = new ArrayList<>();
            dummy.addAll(b);
            for(int j = 0; j < subStringLength; j += wordSize) {
                String subsubstring = substring.substring(j, j + wordSize);
                if(dummy.contains(subsubstring)) {
                    dummy.remove(subsubstring);
                    if(j + wordSize == subStringLength && dummy.isEmpty()) {
                        result.add(i);
                    }
                } else {
                    break;
                }
            }
        }
        return result;

    }

    public ListNode detectCycle(ListNode a) {
        if(a == null || a.next == null) return null;
        Set<ListNode> set = new HashSet<>();
        while(a != null) {
            if(set.contains(a)) {
                return a;
            } else {
                set.add(a);
            }
            a = a.next;
        }
        return null;
    }

    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }


}
