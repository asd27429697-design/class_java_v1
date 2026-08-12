package exercise.fileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileInputTest1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("문장을 입력하세요");
        String input = sc.nextLine();

        try (FileOutputStream fos = new FileOutputStream("assets/c.txt", true)) {

                fos.write(input.getBytes());
            fos.write("\n100".getBytes());
            fos.write("\n200".getBytes());
            fos.write("\n300".getBytes());


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sc.close();
    }
}
