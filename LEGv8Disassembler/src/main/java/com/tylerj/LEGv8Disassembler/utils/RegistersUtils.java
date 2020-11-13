package com.tylerj.LEGv8Disassembler.utils;

import java.util.HashMap;
import java.util.Map;

public class RegistersUtils {
    private static final Map<Integer, String> registerMap = new HashMap<>();

    public static Map<Integer, String> getRegisterMap() {
        registerMap.put(0b00000, "X0");
        registerMap.put(0b00001, "X1");
        registerMap.put(0b00010, "X2");
        registerMap.put(0b00011, "X3");
        registerMap.put(0b00100, "X4");
        registerMap.put(0b00101, "X5");
        registerMap.put(0b00110, "X6");
        registerMap.put(0b00111, "X7");
        registerMap.put(0b01000, "X8");
        registerMap.put(0b01001, "X9");
        registerMap.put(0b01010, "X10");
        registerMap.put(0b01011, "X11");
        registerMap.put(0b01100, "X12");
        registerMap.put(0b01101, "X13");
        registerMap.put(0b01110, "X14");
        registerMap.put(0b01111, "X15");
        registerMap.put(0b10000, "X16");
        registerMap.put(0b10001, "X17");
        registerMap.put(0b10010, "X18");
        registerMap.put(0b10011, "X19");
        registerMap.put(0b10100, "X20");
        registerMap.put(0b10101, "X21");
        registerMap.put(0b10110, "X22");
        registerMap.put(0b10111, "X23");
        registerMap.put(0b11000, "X24");
        registerMap.put(0b11001, "X25");
        registerMap.put(0b11010, "X26");
        registerMap.put(0b11011, "X27");
        registerMap.put(0b11100, "SP");
        registerMap.put(0b11101, "FR");
        registerMap.put(0b11110, "LR");
        registerMap.put(0b11111, "XZR");

        return registerMap;
    }
}