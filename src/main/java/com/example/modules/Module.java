package com.example.modules;

import java.io.File;

public interface Module {
    boolean validateFormat(File file);
    String functionDescription();
    String function(File file);
}
