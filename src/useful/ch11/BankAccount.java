package useful.ch11;

public class BankAccount {

   private int money = 100_000;

   public int getMoney() {
      return money;
   }

   public void setMoney(int money) {
      this.money = money;
   }
   // synchronized <-- 동기화 처리 (순차적으로 코드를 수행하도록 보장)
   // 입금
   public synchronized void saveMoney(int money) {
      int currentMoney = getMoney();
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
      setMoney(currentMoney + money);
      System.out.println("입금 후 계좌 잔액 : " + getMoney());
   }

   // 출금
   public synchronized int withdraw(int money) {
      int currentMoney = getMoney();
      try {
         Thread.sleep(1000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
      if (currentMoney >= money) {
         setMoney(currentMoney - money);
         System.out.println("출금 후 계좌 잔액 : " + getMoney());
         return money;
      } else {
         System.out.println("잔액 부족");
      }
      return 0;
   }

}

