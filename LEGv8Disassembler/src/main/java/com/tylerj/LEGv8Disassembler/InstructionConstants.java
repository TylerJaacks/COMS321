package com.tylerj.LEGv8Disassembler;

public class InstructionConstants {
    public static final int ADD    = 0b10001011_00000000_00000000_00000000;
    public static final int ADDI1  = 0b10010001_00000000_00000000_00000000;
    // TODO Not sure this is correct
    public static final int ADDI2  = 0b10010001_00100000_00000000_00000000;

    public static final int SUB    = 0b11001011_00000000_00000000_00000000;
    public static final int SUBI1  = 0b11010001_00000000_00000000_00000000;
    // TODO Not sure this is correct
    public static final int SUBI2  = 0b11010001_00100000_00000000_00000000;

    public static final int SUBS   = 0b11101011_00000000_00000000_00000000;
    public static final int SUBIS1 = 0b11110001_00000000_00000000_00000000;
    // TODO Not sure this is correct
    public static final int SUBIS2 = 0b11110001_00100000_00000000_00000000;

    public static final int AND    = 0b10001010_00000000_00000000_00000000;
    public static final int ANDI1  = 0b10010010_00000000_00000000_00000000;
    // TODO Not sure this is correct
    public static final int ANDI2  = 0b10010010_00010000_00000000_00000000;

    public static final int EOR    = 0b11001010_00000000_00000000_00000000;
    public static final int EORI1  = 0b11010010_00000000_00000000_00000000;
    // TODO Not sure this is correct
    public static final int EORI2  = 0b11010010_00100000_00000000_00000000;

    public static final int ORR    = 0b10101010_00000000_00000000_00000000;
    public static final int ORRI1  = 0b10110010_00000000_00000000_00000000;
    // TODO Not sure this is correct
    public static final int ORRI2  = 0b10110010_00100000_00000000_00000000;

    public static final int LSR    = 0b11010011_01100000_00000000_00000000;
    public static final int LSL    = 0b11010011_01000000_00000000_00000000;

    public static final int MUL    = 0b00000000_00000000_00000000_00000000;

    public static final int PRNT   = 0b11111111_10100000_00000000_00000000;
    public static final int DUMP   = 0b11111111_11000000_00000000_00000000;
    public static final int PRNL   = 0b11111111_10000000_00000000_00000000;
    public static final int HALT   = 0b11111111_11100000_00000000_00000000;

    public static final int B1     = 0b00010100_00000000_00000000_00000000;
    public static final int B2     = 0b10111111_00000000_00000000_00000000;

    public static final int BR     = 0b11010110_00000000_00000000_00000000;
    public static final int BL1    = 0b10010100_00000000_00000000_00000000;
    public static final int BL2    = 0b10010111_11100000_00000000_00000000;

    public static final int CBNZ   = 0b10110101_00000000_00000000_00000000;
    public static final int CBZ    = 0b10110100_00000000_00000000_00000000;

    public static int B_EQ;
    public static int B_NE;
    public static int B_NS;
    public static int B_LO;
    public static int B_MI;
    public static int B_PL;
    public static int B_VS;
    public static int B_VC;
    public static int B_HI;
    public static int B_LS;
    public static int B_GE;
    public static int B_LT;
    public static int B_GT;
    public static int B_LE;

    public static final int LDUR  = 0b11111000_01000000_00000000_00000000;
    public static final int STUR  = 0b11111000_00000000_00000000_00000000;
};
