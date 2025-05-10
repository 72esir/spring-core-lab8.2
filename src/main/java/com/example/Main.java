package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class Main implements CommandLineRunner {
    private final FileHandler fileHandler;

    @Autowired
    public Main(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        if (args.length != 1) {
            System.out.println("Incorrect number of arguments.");
            System.out.println("Please enter filename.");
            return;
        }
        fileHandler.setFile(new File(args[0]));
        fileHandler.execute();
    }
}