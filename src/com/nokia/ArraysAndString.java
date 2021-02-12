package com.nokia;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraysAndString {

    public static void main(String[] args) {
        System.out.println(findUniqueChars("asyalin"));

        System.out.println(checkPermutation("doge", "godf"));

        System.out.println(urlify("Mr John Smith", 13));

        System.out.println(palindromePermutation("abb"));

        System.out.println(oneAway("pale", "ple"));

        System.out.println(compression("aabbcccaaa"));
    }

    //N time, N space
    public static boolean findUniqueChars(String word) {
        Set<Character> wordMap = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!wordMap.contains(c)) {
                wordMap.add(c);
            } else {
                return false;
            }
        }
        return true;
    }

    //Nlong time from sort, n+m space
    public static boolean checkPermutation(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        char[] s1Chars = s1.toCharArray();
        Arrays.sort(s1Chars);

        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s2Chars);

        return Arrays.equals(s1Chars, s2Chars);
    }

    //N time iterator, n space
    public static String urlify(String url, int realLength) {
        StringBuilder s = new StringBuilder(realLength);
        CharacterIterator it = new StringCharacterIterator(url);

        for (char ch = it.first(); ch != CharacterIterator.DONE; ch = it.next()) {
            switch (ch) {
                case ' ':
                    s.append("%20");
                    break;
                default:
                    s.append(ch);
                    break;
            }
        }

        return s.toString();
    }

    //n time, n space
    public static boolean palindromePermutation(String s) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characterSet.contains(c)) {
                characterSet.remove(c);
            } else {
                characterSet.add(c);
            }
        }

        return characterSet.size() <= 1;
    }

    //n time, n space
    public static boolean oneAway(String s1, String s2) {
        HashSet<Character> characters = new HashSet<>();
        boolean iss1Longer = false;
        if (s1.length() >= s2.length()) {
            for (int i = 0; i < s1.length(); i++) {
                characters.add(s1.charAt(i));
            }
            iss1Longer = true;
        } else {
            for (int i = 0; i < s2.length(); i++) {
                characters.add(s2.charAt(i));
            }
        }

        int count = 0;
        if (iss1Longer) {
            for (int i = 0; i < characters.size(); i++) {
                if (!characters.contains(s2.charAt(i))) {
                    count++;
                }
            }
        }
        // else missing
        return count <= 1;
    }

    //n time, n space
    public static String compression(String string) {
        StringBuilder resultString = new StringBuilder();

        int runningLength = 1;
        for (int i = 1; i < string.length(); i++) {
            char curChar = string.charAt(i);
            char prevChar = string.charAt(i - 1);

            if (curChar != prevChar) {
                resultString.append(runningLength);
                resultString.append(prevChar);
                runningLength = 0;
            }
            runningLength++;
        }

        resultString.append(runningLength);
        resultString.append(string.charAt(string.length() - 1));
        return resultString.toString();
    }

    //TODO
    public static void rotateMatrix(int[][] matrix) {
        /*
        1002
        0000
        0000
        3004
         */
    }

    //TODO
    public static void zeroMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
    }

    //n space, n time
    public static boolean stringRotation(String s1, String s2) {
        int len = s1.length();

        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return s1s1.contains(s2);
        }

        return false;
    }
}
