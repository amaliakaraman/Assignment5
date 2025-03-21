import java.util.*;
import java.util.regex.Pattern;

public class WordPattern {
    public static boolean followsPattern(String pattern, char delimiter, String s) {
        // split s into words
        String[] words = s.split(Pattern.quote(String.valueOf(delimiter)));
        if (pattern.length() != words.length) return false; // checks for length mismatch
        Map<Character, String> charToWord = new HashMap<>(); // char -> word
        Map<String, Character> wordToChar = new HashMap<>(); // word -> char
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) return false; // mismatch
            } else {
                charToWord.put(c, word); // assign
            }
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != c) return false; // mismatch other way
            } else {
                wordToChar.put(word, c); // assign
            }
        }

        return true; // passed all checks
    }
    public static void main(String[] args) {
        System.out.println(followsPattern("abba", '?', "dog?cat?cat?dog"));
        System.out.println(followsPattern("abba", '|', "apple|banana|grape|apple"));
        System.out.println(followsPattern("aaaa", ',', "dog,cat,cat,dog"));
        System.out.println(followsPattern("aaaa", ' ', "ice cream taco day"));
        System.out.println(followsPattern("adxp", ' ', "ice cream taco day"));
    }
}
