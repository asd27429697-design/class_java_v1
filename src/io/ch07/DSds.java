package io.ch07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DSds {

    public static void main(String[] args) throws IOException {

        try (BufferedReader bf =
                     new BufferedReader(new FileReader("assets/a.txt"))) {

            String line;

            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}