package com.zhiquan;

import com.zhiquan.Tools.ReadFile;
import com.zhiquan.Tools.Simulation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        /*
        * This part for reading files
        * */
        String path = "/Users/zzq/SecondGradYearCourse/ECE6140/Proj1Requirements/";
        //String fileName = "s298f_2.txt";
        String fileName = "s349f_2.txt";
        File file = new File(path + fileName);
        ReadFile readFile = new ReadFile();
        List<String> s = readFile.readFile(file);


        /*
         * This part for set up inputs
         * */
        List<String> inputs = new ArrayList<>();
//        String inputSample1 = "1110101";
//        String inputSample2 = "0001010";
//        String inputSample3 = "1010101";
//        String inputSample4 = "0110111";
//        String inputSample5 = "1010001";
//        String inputSample1 = "10101010101010101";
//        String inputSample2 = "01011110000000111";
//        String inputSample3 = "11111000001111000";
//        String inputSample4 = "11100001110001100";
//        String inputSample5 = "01111011110000000";
//        inputs.add(inputSample1);inputs.add(inputSample2);inputs.add(inputSample3);
//        inputs.add(inputSample4);inputs.add(inputSample5);
        String s3 = "101010101010101011111111 010111100000001110000000 111110000011110001111111 111000011100011000000000 011110111100000001111111";
        String[] splittedS3 = s3.split(" ");
        for(int i = 0; i < splittedS3.length; i++) inputs.add(splittedS3[i]);

//        String s4 = "101010101010101011111111 010111100000001110000000 111110000011110001111111 111000011100011000000000 011110111100000001111111";
//        String[] splittedS4 = s4.split(" ");
//        for(int i = 0; i < splittedS4.length; i++) inputs.add(splittedS4[i]);


        Simulation simulation = new Simulation(s);
        simulation.run(inputs);
    }
}
