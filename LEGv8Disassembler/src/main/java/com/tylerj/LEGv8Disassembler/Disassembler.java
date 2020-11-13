package com.tylerj.LEGv8Disassembler;

import com.tylerj.LEGv8Disassembler.utils.RegistersUtils;

import static com.tylerj.LEGv8Disassembler.InstructionConstants.*;

public class Disassembler {
    public static void disassemble(byte[] bytes) {
        for (int i = 3; i < bytes.length; i += 4)
        {
            int i1 = Byte.toUnsignedInt(bytes[i - 3]);
            int i2 = Byte.toUnsignedInt(bytes[i - 2]);
            int i3 = Byte.toUnsignedInt(bytes[i - 1]);
            int i4 = Byte.toUnsignedInt(bytes[i]);

            int instruction = i4;

            instruction |= (i3 << 8);
            instruction |= (i2 << 16);
            instruction |= (i1 << 24);

            // TODO MUL Instruction
            switch (instruction & MaskConstants.R_TYPE_OPCODE_MASK)
            {
                case ADD:
                    int addRd = (instruction & MaskConstants.RD_MASK);
                    int addRn = (instruction & MaskConstants.RM_MASK) >> 16;
                    int addRm = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String addRdRegister = RegistersUtils.getRegisterMap().get(addRd);
                    String addRmRegister = RegistersUtils.getRegisterMap().get(addRm);
                    String addRnRegister = RegistersUtils.getRegisterMap().get(addRn);

                    System.out.printf("ADD %s, %s, %s\n", addRdRegister, addRmRegister, addRnRegister);

                    break;
                case SUB:
                    int subRd = (instruction & MaskConstants.RD_MASK);
                    int subRn = (instruction & MaskConstants.RM_MASK) >> 16;
                    int subRm = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String subRdRegister = RegistersUtils.getRegisterMap().get(subRd);
                    String subRmRegister = RegistersUtils.getRegisterMap().get(subRm);
                    String subRnRegister = RegistersUtils.getRegisterMap().get(subRn);

                    System.out.printf("SUB %s, %s, %s\n", subRdRegister, subRmRegister, subRnRegister);

                    break;
                case SUBS:
                    int subsRd = (instruction & MaskConstants.RD_MASK);
                    int subsRn = (instruction & MaskConstants.RM_MASK) >> 16;
                    int subsRm = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String subsRdRegister = RegistersUtils.getRegisterMap().get(subsRd);
                    String subsRmRegister = RegistersUtils.getRegisterMap().get(subsRm);
                    String subsRnRegister = RegistersUtils.getRegisterMap().get(subsRn);

                    System.out.printf("SUBS %s, %s, %s\n", subsRdRegister, subsRmRegister, subsRnRegister);

                    break;
                case AND:
                    int andRd = (instruction & MaskConstants.RD_MASK);
                    int andRn = (instruction & MaskConstants.RM_MASK) >> 16;
                    int andRm = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String andRdRegister = RegistersUtils.getRegisterMap().get(andRd);
                    String andRmRegister = RegistersUtils.getRegisterMap().get(andRm);
                    String andRnRegister = RegistersUtils.getRegisterMap().get(andRn);

                    System.out.printf("AND %s, %s, %s\n", andRdRegister, andRmRegister, andRnRegister);

                    break;
                case ORR:
                    int orrRd = (instruction & MaskConstants.RD_MASK);
                    int orrRn = (instruction & MaskConstants.RM_MASK) >> 16;
                    int orrRm = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String orrRdRegister = RegistersUtils.getRegisterMap().get(orrRd);
                    String orrRmRegister = RegistersUtils.getRegisterMap().get(orrRm);
                    String orrRnRegister = RegistersUtils.getRegisterMap().get(orrRn);

                    System.out.printf("ORR %s, %s, %s\n", orrRdRegister, orrRmRegister, orrRnRegister);

                    break;
                case(EOR):
                    int eorRd = (instruction & MaskConstants.RD_MASK);
                    int eorRn = (instruction & MaskConstants.RM_MASK) >> 16;
                    int eorRm = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String eorRdRegister = RegistersUtils.getRegisterMap().get(eorRd);
                    String eorRmRegister = RegistersUtils.getRegisterMap().get(eorRm);
                    String eorRnRegister = RegistersUtils.getRegisterMap().get(eorRn);

                    System.out.printf("EOR %s, %s, %s\n", eorRdRegister, eorRmRegister, eorRnRegister);

                    break;
                case BR:
                    int brRm = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String brRmRegister = RegistersUtils.getRegisterMap().get(brRm);

                    System.out.printf("BR %s\n", brRmRegister);

                    break;
                case InstructionConstants.MUL:
                    break;
                case PRNT:
                    System.out.printf("PRNT %s\n", RegistersUtils.getRegisterMap()
                            .get((instruction & MaskConstants.RD_MASK)));
                    break;
                case PRNL:
                    System.out.println("PRNL");
                    break;
                case DUMP:
                    System.out.println("DUMP");
                    break;
                case HALT:
                    System.out.println("HALT");
                    break;
            }

            switch (instruction & MaskConstants.I_TYPE_OPCODE_MASK) {
                case ADDI1, ADDI2 -> {
                    int addiAluImmediate = (instruction & MaskConstants.ALU_IMMEDIATE_MASK) >> 10;
                    int addiRd = (instruction & MaskConstants.RD_MASK);
                    int addiRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String addiRdRegister = RegistersUtils.getRegisterMap().get(addiRd);
                    String addiRnRegister = RegistersUtils.getRegisterMap().get(addiRn);

                    System.out.printf("ADDI %s, %s, #%s\n", addiRdRegister, addiRnRegister, addiAluImmediate);
                }
                case ANDI1, ANDI2 -> {
                    int andiAluImmediate = (instruction & MaskConstants.ALU_IMMEDIATE_MASK) >> 8;
                    int andiRd = (instruction & MaskConstants.RD_MASK);
                    int andiRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String andiRdRegister = RegistersUtils.getRegisterMap().get(andiRd);
                    String andiRnRegister = RegistersUtils.getRegisterMap().get(andiRn);

                    System.out.printf("ANDI %s, %s, #%s\n", andiRdRegister, andiRnRegister, andiAluImmediate);
                }
                case SUBI1, SUBI2 -> {
                    int subiAluImmediate = ((instruction & MaskConstants.ALU_IMMEDIATE_MASK) >> 10);
                    int subiRd = (instruction & MaskConstants.RD_MASK);
                    int subiRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String subiRdRegister = RegistersUtils.getRegisterMap().get(subiRd);
                    String subiRnRegister = RegistersUtils.getRegisterMap().get(subiRn);

                    System.out.printf("SUBI %s, %s, #%s\n", subiRdRegister, subiRnRegister, subiAluImmediate);
                }
                case SUBIS1, SUBIS2 -> {
                    int subisAluImmediate = (instruction & MaskConstants.ALU_IMMEDIATE_MASK) >> 10;
                    int subisRd = (instruction & MaskConstants.RD_MASK);
                    int subisRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String subisRdRegister = RegistersUtils.getRegisterMap().get(subisRd);
                    String subisRnRegister = RegistersUtils.getRegisterMap().get(subisRn);

                    System.out.printf("SUBIS %s, %s, #%s\n", subisRdRegister, subisRnRegister, subisAluImmediate);
                }
                case EORI1, EORI2 -> {
                    int eoriAluImmediate = (instruction & MaskConstants.ALU_IMMEDIATE_MASK) >> 8;
                    int eoriRd = (instruction & MaskConstants.RD_MASK);
                    int eoriRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String eoriRdRegister = RegistersUtils.getRegisterMap().get(eoriRd);
                    String eoriRnRegister = RegistersUtils.getRegisterMap().get(eoriRn);

                    System.out.printf("EORI %s, %s, #%s\n", eoriRdRegister, eoriRnRegister, eoriAluImmediate);
                }
                case ORRI1, ORRI2 -> {
                    int orriAluImmediate = (instruction & MaskConstants.ALU_IMMEDIATE_MASK) >> 8;
                    int orriRd = (instruction & MaskConstants.RD_MASK);
                    int orriRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;

                    String orriRdRegister = RegistersUtils.getRegisterMap().get(orriRd);
                    String orriRnRegister = RegistersUtils.getRegisterMap().get(orriRn);

                    System.out.printf("OORI %s, %s, #%s\n", orriRdRegister, orriRnRegister, orriAluImmediate);
                }
                case LSL -> {
                    int lslRd = (instruction & MaskConstants.RD_MASK);
                    int lslRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;
                    int lslShamt = ((instruction & MaskConstants.SHAMT_MASK)) / 1024;

                    String lslRdRegister = RegistersUtils.getRegisterMap().get(lslRd);
                    String lslRnRegister = RegistersUtils.getRegisterMap().get(lslRn);

                    System.out.printf("LSL %s, %s, #%s\n", lslRdRegister, lslRnRegister, lslShamt);
                }
                case LSR -> {
                    int lsrRd = (instruction & MaskConstants.RD_MASK);
                    int lsrRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;
                    int lsrShamt = ((instruction & MaskConstants.SHAMT_MASK));

                    String lsrRdRegister = RegistersUtils.getRegisterMap().get(lsrRd);
                    String lsrRnRegister = RegistersUtils.getRegisterMap().get(lsrRn);

                    System.out.printf("LSR %s, %s, #%s\n", lsrRdRegister, lsrRnRegister, lsrShamt);
                }
            }

            // TODO BL and B not working.
            switch (instruction & MaskConstants.B_TYPE_OPCODE_MASK) {
                case B1, B2 -> {
                    int b1BranchLocation = (instruction & MaskConstants.BR_ADDRESS_MASK);

                    System.out.printf("B #%s\n", b1BranchLocation);
                }
                case BL1, BL2 -> {
                    int blBranchLocation = (instruction & MaskConstants.BR_ADDRESS_MASK);

                    System.out.printf("BL #%s\n", blBranchLocation);
                }
            }

            // TODO DT_ADDRESS is wrong.
            switch (instruction & MaskConstants.D_TYPE_OPCODE_MASK) {
                case LDUR -> {
                    int ldurDtAddress = (instruction & MaskConstants.DT_ADDRESS_MASK);
                    int ldurRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;
                    int ldurRt = (instruction & MaskConstants.RT_MASK);

                    String ldurRnRdRegister = RegistersUtils.getRegisterMap().get(ldurRn);
                    String ldurRtRegister = RegistersUtils.getRegisterMap().get(ldurRt);

                    System.out.printf("LDUR %s, [%s, #%s]\n", ldurRtRegister, ldurRnRdRegister, ldurDtAddress);
                }
                case STUR -> {
                    int sturDtAddress = (instruction & MaskConstants.DT_ADDRESS_MASK) >> 16;
                    int sturRn = ((instruction & MaskConstants.RN_MASK) << 3) >> 8;
                    int sturRt = (instruction & MaskConstants.RT_MASK);

                    String sturRnRdRegister = RegistersUtils.getRegisterMap().get(sturRn);
                    String sturRtRegister = RegistersUtils.getRegisterMap().get(sturRt);

                    System.out.printf("STUR %s, [%s, #%s]\n", sturRtRegister, sturRnRdRegister, sturDtAddress);
                }
            }

            // case(InstructionConstants.B_PL):
            //     break;
            // case(InstructionConstants.B_VS):
            //     break;
            // case(InstructionConstants.B_VC):
            //     break;
            // case(InstructionConstants.B_HI):
            //     break;
            // case(InstructionConstants.B_LS):
            //     break;
            // case(InstructionConstants.B_GE):
            //     break;
            // case(InstructionConstants.B_LT):
            //     break;
            // case(InstructionConstants.B_GT):
            //     break;
            // case(InstructionConstants.B_LE):
            //     break;

            switch (instruction & MaskConstants.CB_TYPE_OPCODE_MASK) {
                case (InstructionConstants.B_EQ) -> {
                    int beqCondBrAddress = (instruction & MaskConstants.COND_BR_ADDRESS_MASK);

                    System.out.printf("B.EQ #%s\n", beqCondBrAddress);
                }
//                case (InstructionConstants.B_NE) -> {
//                    int bneCondBrAddress = (instruction & MaskConstants.COND_BR_ADDRESS_MASK);
//
//                    System.out.printf("B.NE #%s\n", bneCondBrAddress);
//                }
//                case (InstructionConstants.B_NS) -> {
//                    int beqCondBrAddress = (instruction & MaskConstants.COND_BR_ADDRESS_MASK);
//
//                    System.out.printf("B.NS #%s\n", beqCondBrAddress);
//                }
//                case (InstructionConstants.B_LO) -> {
//                    int bneCondBrAddress = (instruction & MaskConstants.COND_BR_ADDRESS_MASK);
//
//                    System.out.printf("B.LO #%s\n", bneCondBrAddress);
//                }
//                case (InstructionConstants.B_MI) -> {
//                    int beqCondBrAddress = (instruction & MaskConstants.COND_BR_ADDRESS_MASK);
//
//                    System.out.printf("B.MI #%s\n", beqCondBrAddress);
//                }
//                case(InstructionConstants.B_PL) {
//                    break;
//                }
//                case(InstructionConstants.B_VS):
//                    break;
//                case(InstructionConstants.B_VC):
//                    break;
//                case(InstructionConstants.B_HI):
//                    break;
//                case(InstructionConstants.B_LS):
//                    break;
//                case(InstructionConstants.B_GE):
//                    break;
//                case(InstructionConstants.B_LT):
//                    break;
//                case(InstructionConstants.B_GT):
//                    break;
//                case(InstructionConstants.B_LE):
//                    break;
                case (InstructionConstants.CBNZ) -> {
                    int cbnzRt = (instruction & MaskConstants.RT_MASK);
                    int cbnzCondBrAddress = (instruction & MaskConstants.COND_BR_ADDRESS_MASK);
                    String cbnzRnRdRegister = RegistersUtils.getRegisterMap().get(cbnzRt);
                    System.out.printf("CBNZ %s #%s\n", cbnzRnRdRegister, cbnzCondBrAddress);
                }
                case (InstructionConstants.CBZ) -> {
                    int cbzRt = (instruction & MaskConstants.RT_MASK);
                    int cbzCondBrAddress = (instruction & MaskConstants.COND_BR_ADDRESS_MASK);
                    String cbzRnRdRegister = RegistersUtils.getRegisterMap().get(cbzRt);
                    System.out.printf("CBZ %s #%s\n", cbzRnRdRegister, cbzCondBrAddress);
                }
            }
        }
    }
}
