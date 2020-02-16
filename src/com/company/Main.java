package com.company;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int alphabetSize= alphabet.length;
        HashMap<Character, Short> alphabetMap = new HashMap<>();
        System.out.print("Introducir el mensaje : ");
        Scanner scanner = new Scanner(System. in);
        String M = scanner. nextLine().replaceAll("\\s+","");
        System.out.print("Introducir la clave : ");
        Scanner scanner2 = new Scanner(System. in);
        String K = scanner. nextLine();
        int kLength = K.length();
        String C = new String();

        for (int i = 0; i < alphabetSize; i++) {
            alphabetMap.put(alphabet[i], (short) i);
        }

//        for (int i = 0; i < M.length(); i++) {
//            C += getKeyByValue(alphabetMap, sum(alphabetMap.get(M.charAt(i)),alphabetMap.get(K.charAt(i % kLength)),alphabetSize));
//        }
        C = cipher(C, K, M, alphabetMap, alphabetSize, kLength);
        String DC = new String();
        DC = decrypt(DC, K, C, alphabetMap, alphabetSize, kLength);

        System.out.println("El mensaje cifrado es " + C + " y el mensaje descifrado es: " + DC);


    }

    public static <T, E> T getKeyByValue(HashMap<Character, Short> map, int value) {
        for (Map.Entry<Character, Short> entry : map.entrySet()) {
            if (Objects.equals((short) value, entry.getValue())) {
                return (T) entry.getKey();
            }
        }
        return null;
    }

    public static String cipher(String C, String K, String M, HashMap<Character, Short> alphabetMap, int alphabetSize, int kLength){
        for (int i = 0; i < M.length(); i++) {
            C += getKeyByValue(alphabetMap, sum(alphabetMap.get(M.charAt(i)),alphabetMap.get(K.charAt(i % kLength)),alphabetSize));
        }
        return C;
    }

    public static String decrypt(String C, String K, String M, HashMap<Character, Short> alphabetMap, int alphabetSize, int kLength){
        for (int i = 0; i < M.length(); i++) {
            C += getKeyByValue(alphabetMap, sub(alphabetMap.get(M.charAt(i)),alphabetMap.get(K.charAt(i % kLength)),alphabetSize));
        }
        return C;
    }



    static int sum(int a, int b, int m)
    {
        int s = a + b;
        s = s % m;
        return s;
    }

    static int sub(int a, int b, int m){
        int s = a - b;
        if (s < 0) s += m;
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