package com.example.modules;

import java.io.File;

public interface Module {
    boolean validateFormat(String format);
    String functionDescription();
    String function(File file);
}
