package com.zhiquan.Gates;

import java.util.HashSet;

public class BUF extends Gates {
    public BUF(int input1, int id) {
        this.inputId1 = input1;
        this.inputId2 = input1;
        //this.controlValue = 0;
        //this.inversionValue = 0;
        this.id = id;
        this.type = "BUF";
        faluts = new HashSet<>();
    }

    @Override
    public int output(int s1, int s2) {
        output = s1;
        return s1;
    }

    @Override
    public String toString() {
        return inputId1 + " " + id;
    }
}
