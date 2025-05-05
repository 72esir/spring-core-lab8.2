package com.example.modules.catalog;

import com.example.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class GetDirSize implements Module {
    @Override
    public boolean validateFormat(File file) {
        return file.isDirectory();
    }

    @Override
    public String functionDescription() {
        return "This function return total weight of your directory";
    }

    @Override
    public String function(File file) {
        File[] files = file.listFiles();
        long totalWeight = 0;
        String res = "";
        try{
            for (File f : files){
                totalWeight += f.length();
            }
            res = formatedSize(totalWeight);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return "Total weight of your directory: " + res;
    }

    private String formatedSize(Long l){
        return l < 1024 ? l + " B" :
                l < (1024 * 1024) ? l / 1024 + " KB" :
                        l < (1024 * 1024 * 1024) ? l / (1024 * 1024) + " MB" :
                                l / (1024 * 1024 * 1024) + " GB";
    }
}
