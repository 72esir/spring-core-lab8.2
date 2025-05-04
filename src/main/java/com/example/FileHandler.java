package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.example.modules.Module;

import javax.tools.DiagnosticListener;

@Component
public class FileHandler {
    private File file;
    private final List<Module> modules;

    public void setFile(File file){
        this.file = file;
    }
    @Autowired
    public FileHandler(List<Module> modules){
        this.modules = modules;
    }

    private String getFormat(String fileName){
        return fileName.split("\\.")[1];
    }

    public String chooseModule(){
        System.out.println("Choose function:");
        int i = 0;
        List<Module> validateModules = new ArrayList<>();
        for(Module module : modules){
            if (module.validateFormat(getFormat(file.getPath()))){
                i++;
                System.out.println(i + ") " + module.functionDescription());
                validateModules.add(module);
            }
        }
        String input = System.console().readLine();
        int num =  Integer.parseInt(input.strip());
        String res = validateModules.get(num-1).function(file);
        return res;
    }

    public void execute(){
        System.out.println(chooseModule());
    }
}
