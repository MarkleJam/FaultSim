package com.zhiquan.Tools;

import com.zhiquan.Gates.Fault;
import com.zhiquan.Gates.Gates;

import java.util.*;

public class Simulation {
    CircuitConstructor cc;
    HashMap<Integer, Gates> status;
    List<Integer> inputArray;
    List<Integer> outputArray;
    List<String> config;

    public Simulation(List<String> s) {
        config = s;
        cc = new CircuitConstructor(s);
        status = cc.getMap();
        inputArray = cc.getInput();
        outputArray = cc.getOutput();
    }

    public void run(List<String> inputs) {
        for (String input : inputs) {
            run(input);
        }
    }

    public void run(String input) {
        cc = new CircuitConstructor(config);
        HashMap<Integer, Gates> status = cc.getMap();

        for (int i = 0; i < inputArray.size(); i++) {
            int inputId = inputArray.get(i);
            status.get(inputId).output = input.charAt(i) - '0';
            status.get(inputId).faultsComputed = true;
            Fault f = new Fault(inputId);
            f.value = 1 - status.get(inputId).output;
            status.get(inputId).faluts.add(f);
            //System.out.println(status.get(inputId).faluts);
        }

        for (Map.Entry<Integer, Gates> e1 : status.entrySet()) {
            Gates g = e1.getValue();
            int inputId1 = g.inputId1;
            int inputId2 = g.inputId2;
            if (status.get(inputId1).output == -1 || status.get(inputId2).output == -1) {
                continue;
            } else {
                g.output = g.output(status.get(inputId1).output, status.get(inputId2).output);
            }
            for (Map.Entry<Integer, Gates> e2 : status.entrySet()) {
                Gates g2 = e2.getValue();
                int g2inputId1 = g2.inputId1;
                int g2inputId2 = g2.inputId2;
                if (status.get(g2inputId1).output == -1 || status.get(g2inputId2).output == -1) {
                    continue;
                } else {
                    g2.output = g2.output(status.get(g2inputId1).output, status.get(g2inputId2).output);
                }
            }
        }

        for (Integer i : outputArray) {
            System.out.print(status.get(i).output + "");
        }
        System.out.println();

        deductiveFaultSimulation(status);
    }

    public void deductiveFaultSimulation(HashMap<Integer, Gates> status) {
        for (Map.Entry<Integer, Gates> e1 : status.entrySet()) {
//            Gates g = e1.getValue();
//            int inputId1 = g.inputId1;
//            int inputId2 = g.inputId2;
//            if(!g.faultsComputed) {
//                if ((!status.get(inputId1).faultsComputed) || (!status.get(inputId2).faultsComputed)) {
//                    continue;
//                } else {
//                    if(g.type.equals("INV") || g.type.equals("BUF")) g.faluts =  g.getInvBufFault(status);
//                    else g.faluts = g.getFaults(status);
//                    g.faultsComputed = true;
//                }
//            }

            for (Map.Entry<Integer, Gates> e2 : status.entrySet()) {
                Gates g2 = e2.getValue();
                int g2inputId1 = g2.inputId1;
                int g2inputId2 = g2.inputId2;
                if(!g2.faultsComputed) {
                    if ((!status.get(g2inputId1).faultsComputed) || (!status.get(g2inputId2).faultsComputed)) {
                        continue;
                    } else {
                        if(g2.type.equals("INV") || g2.type.equals("BUF")) g2.faluts =  g2.getInvBufFault(status);
                        else g2.faluts = g2.getFaults(status);
                        g2.faultsComputed = true;
                    }
                }
            }
        }

//        for (Map.Entry<Integer, Gates> e3 : status.entrySet()) {
//            if(e3.getValue().faluts.size() == 0) continue;
//            for(Fault f : e3.getValue().faluts) {
//                System.out.println(f);
//            }
//        }
        TreeSet<Fault> set = new TreeSet<Fault>((a,b) -> (a.id - b.id));
        for (Integer i : outputArray) {
            //System.out.print(status.get(i).output + "");
            for(Fault f : status.get(i).faluts) {
                set.add(f);
                //System.out.println(f);
            }
        }

        for(Fault f : set) {
            System.out.println(f);
        }
    }
}
