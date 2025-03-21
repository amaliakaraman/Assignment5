import java.util.*;

public class RadixSortStrings {
    public static void main(String[] args) {
        // input array of strings to sort
        String[] arr = {"google", "Gojo", "amazingly", "Jogo", "Luna", "pup", "Solas", "solo", "Pupperino", "Amaterasu",
                "Amazon", "puppy", "Hydra", "amazonia", "Vueltiao"};
        radixSort(arr); // sort the array using Radix Sort
        System.out.println(String.join(", ", arr)); // print sorted result
    }
    static void radixSort(String[] arr) {
        int maxLen = 0; // track max string length
        // find longest string in the array
        for (String s : arr) maxLen = Math.max(maxLen, s.length());
        // sort starting from last character to the first
        for (int i = maxLen - 1; i >= 0; i--) countingSort(arr, i);
    }
    static void countingSort(String[] arr, int index) {
        Map<Character, List<String>> buckets = new HashMap<>(); // HashMap for character buckets
        List<String> sortedArray = new ArrayList<>(arr.length); // store sorted result
        // initialize buckets for all ASCII characters
        for (char c = 0; c < 256; c++) {
            buckets.put(c, new ArrayList<>());
        }
        // places strings into their respective buckets based on the current index
        for (String s : arr) {
            char key = index < s.length() ? s.charAt(index) : 0; // use 0 for shorter strings
            // move lowercase letters after uppercase in sorting order
            if (key >= 'a' && key <= 'z') key = (char) (key - 32 + 128);
            buckets.get(key).add(s); // add string to the correct bucket
        }
        // collect sorted strings from the buckets
        for (char c = 0; c < 256; c++) {
            sortedArray.addAll(buckets.get(c));
        }
        // make sure all elements are present
        if (sortedArray.size() != arr.length) {
            throw new RuntimeException("Sorting error: sortedArray has incorrect size!");
        }
        // copy sorted data back into the original array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray.get(i);
        }
    }
}
