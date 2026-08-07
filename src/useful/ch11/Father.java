package useful.ch11;

public class Father extends Thread{

    BankAccount bankAccount;

    public Father(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public void run() {
        // 가정. 아버지가 1만원 입금 하겠다
        bankAccount.saveMoney(10_000);
    }
}
