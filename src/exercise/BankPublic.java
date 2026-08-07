package exercise;

// 수입하다/ 가지고 오다. * <- oop5 폴더(패키지)안에 모든 파일을 가지고 와

import com.oop6.Bank; // 직접 해당하는 파일만 가져올 수 있다.

public class BankPublic {

    public static void main(String[] args) {

        // public은 어디서나 접근 가능
        Bank bank1 = new Bank();
        // bank1.name = "우리은행";
        // System.out.println(bank1.name);


    } // end of main

} // end of class
