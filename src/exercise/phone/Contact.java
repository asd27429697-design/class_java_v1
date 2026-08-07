package exercise.phone;

public class Contact {

    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void showInfo() {
        System.out.println(">>> 정보 <<<");
        System.out.println("이름: " + name);
        System.out.println("전화번호: " + phoneNumber);
    }
}
