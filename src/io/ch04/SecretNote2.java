package io.ch04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SecretNote2 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("------- 비밀 메모장 --------");
        System.out.println("1.문장 저장");
        System.out.println("2.기록 보기");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveNote(sc);
        } else if (choice.equals("2")) {

        }
        sc.close();


    } // end of main

    public static void saveNote(Scanner sc) {
        // 1. 암호화 파일에 쓰는 기능 까지만 진행
        // 비밀 메모장 기능을 구현하세요.
        System.out.print("저장할 메모를 입력하세요: ");
        String input = sc.nextLine();

        try (FileOutputStream fos = new FileOutputStream("assets/secret.txt")) {
            byte[] original = input.getBytes();
            byte[] encrypted = new byte[original.length];

            for (int i = 0; i < original.length; i++) {
                encrypted[i] = (byte)(original[i] + 3);
            }
            fos.write(encrypted);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);

            // 코드바꾸자
        }
    }
}
