package com.zhiquan.Tools;

import com.zhiquan.Gates.Gates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            status.get(inputArray.get(i)).output = input.charAt(i) - '0';
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
    }

    public void deductiveFaultSimulation(HashMap<Integer, Gates> status) {
        for (Map.Entry<Integer, Gates> e1 : status.entrySet()) {
            Gates g = e1.getValue();
            int inputId1 = g.inputId1;
            int inputId2 = g.inputId2;
            if(!g.faultsComputed) {
                if (!status.get(inputId1).faultsComputed || status.get(inputId2).faultsComputed) {
                    continue;
                } else {
                    if(g.type.equals("INV") || g.type.equals("BUF")) g.faluts =  g.getInvBufFault(status);
                    else g.faluts = g.getFaults(status);
                }
            }
            for (Map.Entry<Integer, Gates> e2 : status.entrySet()) {
                Gates g2 = e2.getValue();
                int g2inputId1 = g2.inputId1;
                int g2inputId2 = g2.inputId2;
                if(!g2.faultsComputed) {
                    if (status.get(g2inputId1).faultsComputed || status.get(g2inputId2).faultsComputed) {
                        continue;
                    } else {
                        g2.output = g2.output(status.get(g2inputId1).output, status.get(g2inputId2).output);
                    }
                }
            }
        }
    }
}
