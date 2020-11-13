package com.tylerj.LEGv8Disassembler.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtils {
    /**
     * Loads a binary file with a given fileName String into a byte[].
     * @param fileName The file name of the binary file.
     * @return The byte[] of the binary file.
     */
    public static byte[] loadBinaryFileAsByteBuffer(String fileName) {
        FileChannel fileChannel = null;
        Path filePath = (Paths.get(fileName));
        ByteBuffer byteBuffer = null;

        try {
            fileChannel = (FileChannel) Files.newByteChannel(filePath, StandardOpenOption.READ);
            byteBuffer = ByteBuffer.allocate((int) fileChannel.size());
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            fileChannel.read(byteBuffer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (byteBuffer != null) {
            return ((ByteBuffer) byteBuffer.flip()).array();
        }

        return null;
    }
}
