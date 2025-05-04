package com.example.modules.txt;

import com.example.modules.Module;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class CalculateWeight implements Module {
    @Override
    public boolean validateFormat(String format) {
        return format.equals("txt");
    }

    @Override
    public String functionDescription() {
        return "This function calculating weight of your file in carrots";
    }

    @Override
    public String function(File file) {
        int charsCount;
        double carrots = 0.0;
        try{
            charsCount = Files.lines(file.toPath()).flatMapToInt(String::chars).sum();
            carrots = (float)(charsCount / "carrot".length());
        }catch (IOException e){
            e.printStackTrace();
        }
        return "Your file weight: " + carrots + " carrots";
    }
}
