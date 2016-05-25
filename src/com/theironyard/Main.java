package com.theironyard;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static final String SAVE_FILE = "specs.json";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Specs specs = loadSpecs(SAVE_FILE);

        if (specs == null) {
            specs = new Specs();

            System.out.println("Enter your laptop's brand: ");
            specs.brand = scanner.nextLine();
            System.out.println("Enter your laptop's screen size: ");
            String screenStr = scanner.nextLine();
            specs.screen = Double.valueOf(screenStr);
            System.out.println("Enter your laptop's weight: ");
            String weightStr = scanner.nextLine();
            specs.weight = Double.valueOf(weightStr);
            System.out.println("Enter your laptop's operating system: ");
            specs.OS = scanner.nextLine();
            System.out.println("Enter the year of your laptop's manufacture: ");
            String yearStr = scanner.nextLine();
            specs.year = Integer.valueOf(yearStr);

        } else {

            System.out.println(specs.toString());
            int end = 0;

            while (end == 0) {
                System.out.println("Enter the specification you wish to update: [Brand/Screen/Weight/OS/Year]");
                System.out.println("Enter /end when updating is complete. ");

                String update = scanner.nextLine();
                switch (update) {
                    case "Brand":
                        System.out.println("Enter your laptop's brand: ");
                        specs.brand = scanner.nextLine();
                        break;
                    case "Screen":
                        System.out.println("Enter your laptop's screen size: ");
                        String screenStr = scanner.nextLine();
                        specs.screen = Double.valueOf(screenStr);
                        break;
                    case "Weight":
                        System.out.println("Enter your laptop's weight: ");
                        String weightStr = scanner.nextLine();
                        specs.weight = Double.valueOf(weightStr);
                        break;
                    case "OS":
                        System.out.println("Enter your laptop's operating system: ");
                        specs.OS = scanner.nextLine();
                        break;
                    case "Year":
                        System.out.println("Enter the year of your laptop's manufacture: ");
                        String yearStr = scanner.nextLine();
                        specs.year = Integer.valueOf(yearStr);
                        break;
                    case "/end":
                        end = 1;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }


        System.out.println("Do you wish to save your updated specs? [y/n]");
        String save = scanner.nextLine();

        if (save.equalsIgnoreCase("y")) {
            saveSpecs(specs, SAVE_FILE);
        }



    }

    public static void saveSpecs (Specs specs, String filename) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(specs);

        File f = new File(filename);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(json);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Specs loadSpecs(String filename) {
        File f = new File(filename);
        try {
            Scanner scanner = new Scanner(f);
            scanner.useDelimiter("//Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Specs.class);
        } catch (FileNotFoundException e) {
            System.out.println("Parsing failed");
        }
        return null;
    }
}
