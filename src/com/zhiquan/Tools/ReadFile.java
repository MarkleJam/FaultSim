package com.zhiquan.Tools;

import sun.misc.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ReadFile {

    public List<String> readFile(File file) throws Exception {
        List<String> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {
            stream.forEach(list::add);
            //stream.forEach(e -> System.out.println(e));
        }
        return list;
    }

}
