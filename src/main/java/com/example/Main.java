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
    private final FileHandler moduleService;

    @Autowired
    public Main(FileHandler moduleService) {
        this.moduleService = moduleService;
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
        moduleService.setFile(new File(args[0]));
        moduleService.execute();
    }
}