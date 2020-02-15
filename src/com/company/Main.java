package com.company;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int alphabetSize= alphabet.length;
        HashMap<Character, Short> alphabetMap = new HashMap<>();
        String M = new String("ESTE MENSAJE SE AUTODESTRUIRA").replaceAll("\\s+","");
        String K =  new String("SOL");
        int kLength = K.length();
        String C = new String();

        for (int i = 0; i < alphabetSize; i++) {
            alphabetMap.put(alphabet[i], (short) i);
        }

        for (int i = 0; i < M.length(); i++) {
            C += getKeyByValue(alphabetMap, sum(alphabetMap.get(M.charAt(i)),alphabetMap.get(K.charAt(i % kLength)),alphabetSize));
        }


    }

    public static <T, E> T getKeyByValue(HashMap<Character, Short> map, int value) {
        for (Map.Entry<Character, Short> entry : map.entrySet()) {
            if (Objects.equals((short) value, entry.getValue())) {
                return (T) entry.getKey();
            }
        }
        return null;
    }

    static int sum(int a, int b, int m)
    {
        int s = a + b;
        s = s % m;
        return s;
    }


    @NotNull
    public static List<String> splitEqually(@NotNull String text, int size) {
        // Give the list the right capacity to start with. You could use an array
        // instead if you wanted.
        List<String> ret = new ArrayList<String>((text.length() + size - 1) / size);

        for (int start = 0; start < text.length(); start += size) {
            ret.add(text.substring(start, Math.min(text.length(), start + size)));
        }
        return ret;
    }


}