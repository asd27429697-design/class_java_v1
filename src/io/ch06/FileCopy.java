package io.ch06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {


    }

    // 파일 복사 기능을 만들어 주세요.
    // 단... 파일은

    // 1. InputStream 필요
    // 2. OutputStream 필요
    //

    FileInputStream fis;

    {
        try {
            fis = new FileInputStream("C:\\Users\\user\\Pictures\\Pictures.zip\"");

            try (FileOutputStream fos = new FileOutputStream("C:\\Users\\user\\Pictures\\Pictures_copy.zip\"")) {
                int data;
                while ((data = fis.read()) != -1) {
                    fos.write(data);
                    fos.flush();
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
