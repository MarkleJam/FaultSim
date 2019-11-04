package com.zhiquan.Gates;

public class NAND extends Gates {
    public NAND(int input1, int input2, int id) {
        this.inputId1 = input1;
        this.inputId2 = input2;
        this.controlValue = 0;
        this.inversionValue = 1;
        this.id = id;
        type = "NAND";
    }

    public int output(int s1, int s2) {
        output = 1 - (s1 & s2);
        return 1 - (s1 & s2);
    }

    @Override
    public String toString() {
        return inputId1 + " " + inputId2 + " " + id;
    }
}
