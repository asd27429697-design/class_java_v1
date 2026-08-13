package io.ch04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class TypingRecord2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========타자 연습 기록기 ==========");
        System.out.println("1. 문장 저장");
        System.out.println("2. 기록 보기");
        String choice = sc.nextLine();

        if (choice.equals("1")) {
            saveRecord(sc);
        } else if (choice.equals("2")) {
             printRecord();
        }


        sc.close();

    } // end of main

    public static void printRecord() {
        System.out.println("문자열\n 저장된 기록");
        try {
            FileInputStream fis = new FileInputStream("C:\\khs\\work_space\\java_class_1\\java_v1\\assets\\typing.txt");
            int data;
            while ( (data = fis.read()) != -1 ) {
                System.out.print((char) data);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void saveRecord(Scanner sc) {
        System.out.print("연습한 문장을 입력하세요 :  ");
        String input = sc.nextLine();
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = LocalDateTime.now();

        Duration result = Duration.between(start, end);
        long ms = result.toMillis();
        double sec = ms / 1000.0;


        String record = input + " | 소요시간 : " + sec + "초 " + ms + "(ms)";

        try (FileOutputStream fos = new FileOutputStream("assets/typing.txt", true)) {
            fos.write(record.getBytes());
            fos.write("\n".getBytes());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
