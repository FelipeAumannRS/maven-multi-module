package org.example;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class LoadViewBUtils {

    public static void loadViewB() {
        try {
            String javaHome = System.getProperty("java.home");
            String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
            String classpath = System.getProperty("java.class.path");
            String className = MainB.class.getCanonicalName();

            ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp", classpath, className);

            Process process = builder.start();

            // Read and log the error stream in a separate thread
            Thread errorReader = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Log the error line
                        System.err.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            errorReader.start();

            // Read and log the input stream in a separate thread
            Thread outputReader = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Log the output line
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outputReader.start();

            // Wait for the process to complete
            process.waitFor();

            // Wait for the output and error readers to complete
            errorReader.join();
            outputReader.join();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
