package useful.ch04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileExceptionHandling {

    public static void main(String[] args) {

        FileInputStream fis = null;

        try {
            fis = new FileInputStream("test1.txt");
        } catch (FileNotFoundException e) {
            System.out.println("test1.txt 파일을 찾을 수 없음");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 반드시 수행 됨. (return 포함)
            System.out.println("finally 수행");
        }


    } // end of main
} // end of class
