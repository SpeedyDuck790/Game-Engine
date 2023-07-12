package Display;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Updating {

    public void Loading() {
        System.out.println("FileLoaded");
        String content = "";
        try (Scanner reader = new Scanner(new File("PlayerData/save1.txt"))) {
            while (reader.hasNextLine()) {
                content += reader.nextLine();
            }
            String[] GameData = content.split("#");
            for (String data : GameData) {
                System.out.println(data);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Reading failed");

        }
    }

    public void WritingNewLoad() {
        try (FileWriter writer = new FileWriter("PlayerData/save1.txt")) {
            writer.write("write#");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Writing failed");
        }
    }
}