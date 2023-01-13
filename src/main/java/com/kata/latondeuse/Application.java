package com.kata.latondeuse;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        BufferedReader reader = null;
        List<Tondeuse> tondeuses = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader("src/main/resources/input_tondeuse.txt"));
            String line = reader.readLine();
            if (line == null) throw new UnsupportedOperationException("The file is empty.");
            Scanner lineScan = new Scanner(line);
            int max_x = lineScan.nextInt();
            int max_y = lineScan.nextInt();

            line = reader.readLine();
            while (line != null && !line.equals("")) {
                //read origin
                lineScan = new Scanner(line);
                int x = lineScan.nextInt();
                int y = lineScan.nextInt();
                String orientation = lineScan.next();
                Tondeuse tondeuse = new Tondeuse(new Position(new Coordinate(x,y,max_x,max_y), Orientation.valueOf(orientation)));
                line = reader.readLine();
                if (line != null && !line.equals("")) {
                    List<Command> commands = new ArrayList<>();
                    for (String s : line.split("")) {
                        commands.add(Command.valueOf(s));
                    }
                    tondeuse.setCommands(commands);
                } else {
                    throw new UnsupportedOperationException("mower commands are missing");
                }
                tondeuses.add(tondeuse);
                line = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        tondeuses.stream().forEach(tondeuse -> {
            System.out.println( tondeuse.executeCommands());
        });

    }
}
