package part03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) throws IOException {
        Path logFile = Path.of("pizza-commits.txt");
        String fileContents = Files.readString(logFile, StandardCharsets.UTF_8);

        String[] rivit = fileContents.split("\n");
        String parent = "None";
        boolean jatkuu = true;

        while (jatkuu) {

            jatkuu = false;

            for (int i = 0; i < rivit.length; i++) {

                String rivi = rivit[i].trim();

                if (rivi.contains("(Parent: " + parent + ")")) {

                    System.out.println(rivi);
                    System.out.println(rivit[i + 1]);
                    System.out.println(rivit[i + 2]);
                    System.out.println();

                    String[] osat = rivi.split(" ");
                    parent = osat[1];

                    jatkuu = true;
                    break;
                }
            }
        }
    }
}