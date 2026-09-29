package oop_test.ch11;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== 평일 예매 ===");

        PricePolicy weekdayPolicy = new WeekdayPricePolicy();
        TicketService weekdayService = new TicketService(weekdayPolicy);

        weekdayService.reserve("오디세이", 20000);
        weekdayService.reserve("왕과 사는 남자", 18000);

        System.out.println();

        System.out.println("=== 주말 예매 ===");
        PricePolicy weekendPolicy = new WeekendPricePolicy();
        TicketService weekendService = new TicketService(weekendPolicy);

        weekendService.reserve("오디세이", 20000);
        weekendService.reserve("왕과 사는 남자", 18000);

    }
}
