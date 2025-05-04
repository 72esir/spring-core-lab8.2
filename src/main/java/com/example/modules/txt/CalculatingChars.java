package com.example.modules.txt;

import com.example.modules.Module;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CalculatingChars implements Module {
    @Override
    public boolean validateFormat(String format) {
        return format.equals("txt");
    }

    @Override
    public String functionDescription() {
        return "This function calculating frequency of all chars in your file";
    }

    @Override
    public String function(File file) {
        List<String> result = new ArrayList<>();
        Map<Character, Long> charsFrequency;
        try {
            charsFrequency = Files
                    .lines(file.toPath())
                    .flatMap(line -> line.chars()
                            .mapToObj(c -> (char) c))
                    .collect(Collectors
                            .groupingBy(c -> c, Collectors.counting()));

            charsFrequency.forEach((key,value) -> result.add("Символ '" + key + "': " + value + " раз"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }
}
