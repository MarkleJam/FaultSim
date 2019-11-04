package com.zhiquan.Gates;

import java.util.HashMap;
import java.util.HashSet;

public abstract class Gates {
    public int id;
    public String type;
    //input is the id of the gate
    public int inputId1;
    public int inputId2;
    public int controlValue;
    public int inversionValue;
    public boolean faultsComputed;
    public int output;
    public abstract int output(int s1, int s2);
    public HashSet<Fault> faluts;

    public HashSet<Fault> getFaults(HashMap<Integer, Gates> status) {
        HashSet<Fault> ret = new HashSet<>();
        Gates input1 = status.get(this.inputId1);
        Gates input2 = status.get(this.inputId2);
        Fault f = new Fault(this.id);
        if(input1.faultsComputed && input2.faultsComputed) {
            this.faultsComputed = true;

            f.value = this.controlValue ^ (1 - this.inversionValue);

            if(input1.output != controlValue && input2.output != controlValue) {
                ret.addAll(input1.faluts);
                ret.addAll(input2.faluts);

                f.value = this.controlValue ^ this.inversionValue;

            } else if(input1.output == controlValue && input2.output != controlValue){
                ret.addAll(input1.faluts);
                ret.removeAll(input2.faluts);
            } else if(input1.output != controlValue && input2.output == controlValue) {
                ret.addAll(input2.faluts);
                ret.removeAll(input1.faluts);
            } else if(input1.output == controlValue && input2.output == controlValue) {
                HashSet<Fault> temp = new HashSet<>();
                temp.addAll(input1.faluts);
                temp.retainAll(input2.faluts);
                ret.addAll(temp);
            }
        }
        ret.add(f);
        return ret;
    }

    public HashSet<Fault> getInvBufFault(HashMap<Integer, Gates> status) {
        this.faultsComputed = true;
        HashSet<Fault> ret = new HashSet<>();
        ret.addAll(status.get(this.inputId1).faluts);
        Fault f = new Fault(id);
        f.value = 1 - output;
        ret.add(f);
        return ret;
    }
}