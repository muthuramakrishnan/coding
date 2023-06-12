package Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeypadProblem {

    public static void generateAllPossibilities(String ipString, int ipStringLen, Map<Integer, List<Character>> keyMap,
            char[] outputArr, int outputIdx) {
        if (outputIdx == ipStringLen) {
            for (int i = 0; i < ipStringLen; i++) {
                System.out.print(outputArr[i]);
            }
            System.out.println();
            return;
        }
        int key = Integer.parseInt(String.valueOf(ipString.charAt(outputIdx)));
        List<Character> charList = keyMap.get(key);
        for (char c : charList) {
            outputArr[outputIdx] = c;
            generateAllPossibilities(ipString, ipStringLen, keyMap, outputArr, outputIdx + 1);
        }

    }

    public static void mapKeysWithChars(Map<Integer, List<Character>> keyMap, int key, Character... args) {
        keyMap.put(key, new ArrayList<>(Arrays.asList(args)));
    }

    public static void main(String[] args) throws IOException {
        Map<Integer, List<Character>> keyMap = new HashMap<>();
        mapKeysWithChars(keyMap, 2, 'a', 'b', 'c');
        mapKeysWithChars(keyMap, 3, 'd', 'e', 'f');
        mapKeysWithChars(keyMap, 4, 'g', 'h', 'i');
        mapKeysWithChars(keyMap, 5, 'j', 'k', 'l');
        mapKeysWithChars(keyMap, 6, 'm', 'n', 'o');
        mapKeysWithChars(keyMap, 7, 'p', 'q', 'r', 's');
        mapKeysWithChars(keyMap, 8, 't', 'u', 'v');
        mapKeysWithChars(keyMap, 9, 'w', 'x', 'y', 'z');

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ipString = br.readLine();
        int ipStringLen = ipString.length();
        int outputIdx = 0;
        char[] outputArr = new char[ipStringLen];
        generateAllPossibilities(ipString, ipStringLen, keyMap, outputArr, outputIdx);
    }
}
