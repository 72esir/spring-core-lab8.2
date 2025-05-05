package com.example.modules.txt;

import com.example.modules.Module;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Component
public class CalculateWeight implements Module {
    @Override
    public boolean validateFormat(File file) {
        try {
            return file.getName().split("\\.")[1].equals("txt");
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public String functionDescription() {
        return "This function calculating weight of your file in carrots";
    }

    @Override
    public String function(File file) {
        int charsCount;
        String carrot = "carrot";
        double carrots = 0.0;
        try{
            charsCount = Files.lines(file.toPath())
                    .mapToInt(String::length)
                    .sum();
            carrots = (double)(charsCount) / (carrot.length());
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Your file weight: " + carrots + " carrots";
    }
}
