package com.tylerj.LEGv8Disassembler.utils;

public class BinaryUtils {
    public static String byteToBinaryString(Byte b) {
        return String.format("%8s", Integer.toBinaryString(b & 0xFF))
                .replace(' ', '0');
    }
}
