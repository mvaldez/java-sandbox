package com.sandbox.exercises;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArraysAndStrings {
    public static void main(String[] args) {
        System.out.println("Are Permutations of each other? " + isPermFast("abc", "cbag"));
        System.out.println("Are Permutations of each other? " + isPermFast("abc", "cab"));
        System.out.println("Are Permutations of each other? " + isPermFast("abc", "abc"));
        System.out.println("Are Permutations of each other? " + isPermFast("abc", "aba"));
        System.out.println("Are Permutations of each other? " + isPermFast("abc", "bag"));
    }

//    private static List<String> findAllPerms(String s) {
//        char[] s_array = s.toCharArray();
//        for (int i=0; i<s_array.length; i++) {
//
//        }
//
//    }

    // O(n^2) with no binary search else O(n log n)
    private static boolean isPerm(String s1, String s2) {
        System.out.println("Comparing "  + s1 + " and " + s2);

        if (s1.length() != s2.length()) {   // O(1)
            return false;
        }

        // this depends on the definition of permutation
        if (s1.equals(s2)) {   // O(1)
            return false;
        }

        for (int i=0; i<s1.length(); i++) {    // O(n)
            if (!contains(s1.charAt(i), s2)) {   // if this was binary search then O(log n) else O(n)
                return false;
            }
        }
        return true;
    }

    // solution is O(n) time complexity; O(n) space complexity
    private static boolean isPermFast(String s1, String s2) {
        System.out.println("Comparing "  + s1 + " and " + s2);

        Set<Character> m = new HashSet<>();

        if (s1.length() != s2.length()) {  // O(1)
            return false;
        }

        int count = 0;
        for (int i=0; i<s1.length(); i++) {  // O(n)
            if (!m.contains(s1.charAt(i))) {
                m.add(s1.charAt(i));
                count++;
            } else {
                m.add(s1.charAt(i));
                count++;
            }
            if (!m.contains(s2.charAt(i))) {
                m.add(s2.charAt(i));
                count++;
            } else {
                m.add(s2.charAt(i));
                count--;
            }
        }
        System.out.println("Size=" + m.size());
        System.out.println("Count=" + count);
        return m.size() == s1.length() && count > 0;  // O(1)
    }

    // if you make this a binary search then O(log n)
    // else O(n) where n is the length of s
    private static boolean contains(char c, String s) {
        for (int j=0; j<s.length(); j++) {
            if (s.charAt(j) == c) {
                return true;
            }
        }
        return false;
    }
}
