package com.example.modules.mp3;

import com.example.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class GetTitle implements Module {
    @Override
    public boolean validateFormat(File file) {
        try {
            return file.getName().split("\\.")[1].equals("mp3");
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public String functionDescription() {
        return "This function return title of your mp3";
    }

    @Override
    public String function(File file) {
        return file.getName();
    }
}
