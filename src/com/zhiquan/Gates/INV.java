package com.zhiquan.Gates;

public class INV extends Gates {
    public INV(int input1, int id) {
        this.inputId1 = input1;
        this.inputId2 = input1;
        this.id = id;
        this.type = "INV";
    }

    @Override
    public int output(int s1, int s2) {
        output = 1 - s1;
        return 1 - s1;
    }

    @Override
    public String toString() {
        return inputId1 + " " + id;
    }
}
