package com.zhiquan.Gates;

public class Fault {
    public int id;
    public int value;

    public Fault(int id) {
        this.id = id;

    }
    @Override
    public int hashCode() {
        return id * 102943 + value * 283;
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof Fault) {
            return id == ((Fault)o).id && value == ((Fault)o).value;
        }
        return false;
    }

    @Override
    public String toString(){
        return id + "stuck at " + value;
    }
}
