package com.tylerj.LEGv8Disassembler;

public class MaskConstants {
    public static final int R_TYPE_OPCODE_MASK  = 0b11111111_11100000_00000000_00000000;
    public static final int I_TYPE_OPCODE_MASK  = 0b11111111_11000000_00000000_00000000;
    public static final int D_TYPE_OPCODE_MASK  = 0b11111111_11100000_00000000_00000000;
    public static final int B_TYPE_OPCODE_MASK  = 0b11111111_00000000_00000000_00000000;
    public static final int CB_TYPE_OPCODE_MASK = 0b11111111_00000000_00000000_00000000;

    public static final int RM_MASK =    0b00000000_00011111_00000000_00000000;
    public static final int SHAMT_MASK = 0b00000000_00000000_11111100_00000000;
    public static final int RN_MASK =    0b00000000_00000000_00000011_11100000;
    public static final int RD_MASK =    0b00000000_00000000_00000000_00011111;

    // TODO Doesn't work
    public static final int ALU_IMMEDIATE_MASK = 0b00000000_00011111_11111000_00000000;

    // TODO Doesn't work
    public static final int BR_ADDRESS_MASK = 0b00000011_11111111_11111111_11111111;

    // TODO Doesn't work
    public static final int DT_ADDRESS_MASK = 0b00000000_00011111_11110000_00000000;
    public static final int OP_MASK = 0b00000000_00000000_00001000_00000000;
    public static final int RT_MASK = 0b00000000_00000000_00000000_00011111;


    public static final int COND_BR_ADDRESS_MASK = 0b00000011_11111111_11111111_11110000;
}
