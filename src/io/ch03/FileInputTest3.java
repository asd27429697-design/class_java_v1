package io.ch03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest3 {

    public static void main(String[] args) {

        // in.read(byte[] b) 를 사용해서 코드를 완성해보세요
        long start = System.currentTimeMillis();

        // 데이터를 담아 둘 그릇(바구니)를 미리 만들어 둔다
        // 크기 10 - 한번에 최대 10바이트까지 읽어 오겠다라고 설정 함
        byte[] buffer = new byte[255];

        // read(bute[]) 는 읽은 바이트 수를 반환 합니다
        // read() 가 바이트 값 자체를 돌려주는 것 과는 다르다.
        int readCount;

        try (FileInputStream in = new FileInputStream("assets/b.txt")) {
            // [a][b][c][d][e][]
            // [a][b][c] <---
            // [d][e][c]
            while ( (readCount = in.read(buffer)) != -1 ) {
                // buffer.lenth ....
                for (int i = 0; i < readCount; i++) {
                    System.out.print((char) buffer[i]);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        // close() 자동 호출 됨.

        System.out.println( (end - start) + " ms" );


    } // end of main

}
