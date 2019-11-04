package com.zhiquan.Gates;

public class NOR extends Gates {
    public NOR(int input1, int input2, int id) {
        this.inputId1 = input1;
        this.inputId2 = input2;
        this.controlValue = 1;
        this.inversionValue = 1;
        this.id = id;
        this.type = "NOR";
    }

    @Override
    public int output(int s1, int s2) {
        output = 1 - (s1 | s2);
        return 1 - (s1 | s2);
    }

    @Override
    public String toString() {
        return inputId1 + " " + inputId2 + " " + id;
    }
}
