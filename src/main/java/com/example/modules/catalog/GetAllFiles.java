package com.example.modules.catalog;

import com.example.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class GetAllFiles implements Module {
    @Override
    public boolean validateFormat(File file) {
        return file.isDirectory();
    }

    @Override
    public String functionDescription() {
        return "This function list all files in your directory";
    }

    @Override
    public String function(File file) {
        File[] files = file.listFiles();
        StringBuilder filesToStr = new StringBuilder();
        try{
        for (File f : files){
            filesToStr.append(f.getName());
            filesToStr.append("\n");
        }
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return "List files of your directory:\n" + filesToStr;
    }
}
