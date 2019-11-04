package com.zhiquan.Tools;

import com.zhiquan.Gates.*;

import java.util.*;

public class CircuitConstructor {

    public HashMap<Integer, Gates> map;
    public List<Integer> input;
    public List<Integer> output;
    public CircuitConstructor(List<String> strs) {
        map = new HashMap<>();
        input = new ArrayList<>();
        output = new ArrayList<>();
        for(String s : strs) {
            String[] splitted = s.split(" ");
            int len = splitted.length;
            String type = splitted[0];
            if(type.equals("")) continue;
            int inputId1 = 0; int inputId2 = 0; int outputId = 0;
            if(!(type.equals("INPUT") || type.equals("OUTPUT"))) {
                //System.out.println(Arrays.toString(splitted));
                inputId1 = Integer.valueOf(splitted[1]);
                inputId2 = Integer.valueOf(splitted[2]);
                outputId = Integer.valueOf(splitted[splitted.length - 1]);
            }

            if(type.equals("AND")) {

                AND g = new AND(inputId1, inputId2, outputId);
                g.output = -1;
                map.put(outputId, g);

            } else if(type.equals("INV")) {

                INV g = new INV(inputId1, outputId);
                g.output = -1;
                map.put(outputId, g);

            } else if(type.equals("BUF")) {

                BUF g = new BUF(inputId1, outputId);
                g.output = -1;
                map.put(outputId, g);

            } else if(type.equals("NOR")) {

                NOR g = new NOR(inputId1, inputId2, outputId);
                g.output = -1;
                map.put(outputId, g);

            } else if(type.equals("NAND")) {

                NAND g = new NAND(inputId1, inputId2, outputId);
                g.output = -1;
                map.put(outputId, g);

            } else if(type.equals("OR")) {

                OR g = new OR(inputId1, inputId2, outputId);
                g.output = -1;
                map.put(outputId, g);

            } else if(type.equals("INPUT")) {
                for(int i = 1; i < splitted.length - 1; i++) {
                    if(splitted[i].equals("")) continue;
                    int temp = Integer.valueOf(splitted[i]);
                    Gates g = new BUF(temp, temp);
                    input.add(temp);
                    map.put(temp, g);
                }
            } else if(type.equals("OUTPUT")) {
                for(int i = 1; i < splitted.length - 1; i++) {
                    if(splitted[i].equals("")) continue;
                    int temp = Integer.valueOf(splitted[i]);
                    output.add(temp);
                }
            }
        }
    }

    public HashMap<Integer, Gates> getMap() {
        return map;
    }

    public List<Integer> getInput() {
        return input;
    }

    public List<Integer> getOutput() {
        return output;
    }
}
