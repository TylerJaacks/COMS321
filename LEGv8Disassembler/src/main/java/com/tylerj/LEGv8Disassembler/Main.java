package com.tylerj.LEGv8Disassembler;

import com.tylerj.LEGv8Disassembler.utils.FileUtils;

public class Main {
    public static void main(String[] args) {
        verifyProgramArguments(args);

        String filePath = args[1];

        byte[] programBytes = FileUtils.loadBinaryFileAsByteBuffer(filePath);

        if (programBytes == null) {
            System.out.println("The file was empty, closing program.\n");

            System.exit(0);
        } else {
            System.out.println("Disassembling " + filePath + ".\n");

            Disassembler.disassemble(programBytes);
        }

        System.out.println("Exiting");
    }

    public static void verifyProgramArguments(String[] args) {
        String helpText = "Use -f or -file plus the file path to disassemble.\n";

        if (args.length != 2) {
            System.out.println("File not specified. " + helpText);

            System.exit(1);
        } else {
            // TODO check if -f is being used.
            if (!args[0].equals("-file")) {
                System.out.println(args[1] + " is not a supported parameter. " + helpText);

                System.exit(1);
            }
            // TODO Check that the -file or -f is used.
        }
    }
}
