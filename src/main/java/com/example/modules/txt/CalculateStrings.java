package com.example.modules.txt;

import com.example.modules.Module;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class CalculateStrings implements Module {
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
        return "This function calculating count of strings in your file";
    }

    @Override
    public String function(File file) {
        int count = 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while(reader.readLine() != null){
                count ++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return "Strings count: " + count;
    }
}
