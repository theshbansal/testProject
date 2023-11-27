package commonutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class commandLineHelper {

    public static String runCommand(List<String> command) {
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        StringBuilder stringBuilder = new StringBuilder();
        processBuilder.redirectErrorStream(true);
        String output = null;
        try {
            Process process = processBuilder.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println(line);
                System.exit(0);
            }
            output = stringBuilder.toString();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return output;
    }
}
