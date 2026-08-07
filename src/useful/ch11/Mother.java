package useful.ch11;

public class Mother extends Thread{

    BankAccount bankAccount;

    public Mother(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        // 가정 .. 어머님은 5천원 출금
        bankAccount.withdraw(5_000);
    }
}
