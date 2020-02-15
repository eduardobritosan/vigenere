package com.company;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int alphabetSize= alphabet.length;
        HashMap<Short, Character> alphabetMap = new HashMap<>();

        for (int i = 0; i < alphabetSize; i++) {
            alphabetMap.put((short) i, alphabet[i]);
        }

    }
}