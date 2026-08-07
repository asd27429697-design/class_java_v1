package exercise.phone;

import java.util.Scanner;

public class PhoneBook {

    static int indexNumber = 0;
    // 1. 저장하기
    public static void save(Scanner sc, Contact[] contact) {
        if (indexNumber >= contact.length) {
            System.out.println("전화번호가 가득 찾습니다");
            return;
        }
        System.out.println("이름을 입력하세요");
        String name = sc.nextLine();
        System.out.println("전화번호를 입력하세요");
        String phoneNumber = sc.nextLine();

        Contact contact1 = new Contact(name, phoneNumber);
        contact[indexNumber] = contact1;
        indexNumber++;
        System.out.println("연락처가 저장되었습니다");
    }

    // 2. 조회하기
    public static void search(Contact[] contact) {
        System.out.println("-----전체 조회가 호출되었습니다------");
        if (indexNumber == 0) {
            System.out.println("아직 저장된 이름과 전화번호가 없습니다");
            return;
        }
        for (int i = 0; i < contact.length; i++) {
            if (contact[i] != null ) {

                System.out.println(contact[i].getName() + " " + contact[i].getPhoneNumber());
            }
        }
    }

    // 3. 수정하기
    public static void current(Contact[] contacts, Scanner sc) {
        if (indexNumber == 0) {
            System.out.println("수정된 이름과 전화번호가 없습니다");
            return;
        }
        System.out.println("수정할 전화번호의 이름을 입력하세요");
        String name = sc.nextLine();
        boolean isFine = false;
        for (int i = 0; i < indexNumber; i++) {
            if (contacts != null) {
                System.out.println("수정할 전화번호를 입력하세요");
                String phoneNumber = sc.nextLine();
                contacts[i] = new Contact(name, phoneNumber);
                System.out.println("전화번호를 바꿨습니다");
                isFine = true;
                break;
            }
        }
        if (!isFine) {
            System.out.println("연락처를 찾지 못했습니다");
        }
    }

    // 4. 삭제하기
    public static void delete(Contact contacts, Scanner sc) {
        if (indexNumber == 0) {
            System.out.println("삭제할 연락처가 없습니다");
            return;
        }
        System.out.println("삭제할 전화번호의 이름을 입력하세요");
        String name = sc.nextLine();
        boolean isFine = false;
        for (int i = 0; i < indexNumber; i++) {
            if (contacts != null) {
                System.out.println("삭제할 전화번호를 입력하세요");
            }
        }
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contact[] contacts = new Contact[100];

        contacts[0] = new Contact("손흥민", "010-1234-5678");
        contacts[1] = new Contact("박지성", "010-4241-4365");
        contacts[2] = new Contact("차범근", "010-9743-1362");
        contacts[3] = new Contact("이강인", "010-2141-5544");
        contacts[4] = new Contact("황희찬", "010-2521-1361");

        indexNumber = 5;

        boolean flag = true;

        final String SAVE = "1";
        final String SEARCH = "2";
        final String CURRENT = "3";
        final String DELETE = "4";
        final String SEARCH_BY_TITLE = "5";
        final String END = "0";

        while (flag) {
            System.out.println("1.저장 2.전체 조회 3.수정 4.삭제 5.선택 조회 0.종료");
            String selectedNumber = sc.nextLine();
            if (selectedNumber.equals(SAVE)) {
               save(sc, contacts);
            } else if (selectedNumber.equals(SEARCH)) {
                search(contacts);
            } else if (selectedNumber.equals(CURRENT)) {
                current(contacts, sc);
            } else if (selectedNumber.equals(DELETE)) {
                delete(contacts[2], sc);
            } else if (selectedNumber.equals("5")) {
                System.out.println("---선택 조회 호출---");
            } else if (selectedNumber.equals("0")) {
                System.out.println("---프로그램 종료---");
                flag = false;
            } else {
                System.out.println("잘못 된 선택입니다. 다시 선택하세요");
            }

        }


    }
}
