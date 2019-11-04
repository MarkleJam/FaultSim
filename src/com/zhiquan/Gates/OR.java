package com.zhiquan.Gates;

public class OR extends Gates {

    public OR(int input1, int input2, int id) {
        this.inputId1 = input1;
        this.inputId2 = input2;
        this.controlValue = 1;
        this.inversionValue = 0;
        this.id = id;
        this.type = "OR";
    }

    @Override
    public int output(int s1, int s2) {
        output = (s1 | s2);
        return (s1 | s2);
    }

    @Override
    public String toString() {
        return inputId1 + " " + inputId2 + " " + id;
    }
}
