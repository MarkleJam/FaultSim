package com.zhiquan.Gates;

public class AND extends Gates{
    public AND(int input1, int input2, int id) {
        this.inputId1 = input1;
        this.inputId2 = input2;
        this.controlValue = 0;
        this.inversionValue = 0;
        this.id = id;
        this.type = "AND";
    }

//    @Override
//    public HashSet<Fault> getFaults(HashMap<Integer, Gates> status){
//        HashSet<Fault> ret = new HashSet<>();
//        Gates input1 = status.get(this.inputId1);
//        Gates input2 = status.get(this.inputId2);
//        Fault f = new Fault(this.id);
//        if(input1.faultsComputed && input2.faultsComputed) {
//            f.value = this.controlValue ^ (1 - this.inversionValue);
//            if(input1.output != controlValue && input2.output != controlValue) {
//                ret.addAll(input1.faluts);
//                ret.addAll(input2.faluts);
//                f.value = this.controlValue ^ this.inversionValue;
//            } else if(input1.output == controlValue && input2.output != controlValue){
//                ret.addAll(input1.faluts);
//                ret.removeAll(input2.faluts);
//            } else if(input1.output != controlValue && input2.output == controlValue) {
//                ret.addAll(input2.faluts);
//                ret.removeAll(input1.faluts);
//            } else if(input1.output == controlValue && input2.output == controlValue) {
//                //ret.addAll();
//                //input2.faluts.retainAll(input1.faluts);
//                HashSet<Fault> temp = new HashSet<>();
//                temp.addAll(input1.faluts);
//                temp.retainAll(input2.faluts);
//                ret.addAll(temp);
//            }
//        }
//        ret.add(f);
//        return ret;
//    }

    @Override
    public int output(int s1, int s2) {
        output = s1 & s2;
        return s1 & s2;
    }

    @Override
    public String toString() {
        return inputId1 + " " + inputId2 + " " + id;
    }
}
