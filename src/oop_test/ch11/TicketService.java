package oop_test.ch11;

public class TicketService {

    private PricePolicy pricePolicy;

    public TicketService(PricePolicy pricePolicy) {
        this.pricePolicy = pricePolicy;
    }

    public void reserve(String movieTitle, int price) {
        int finalPrice = pricePolicy.calculate(price);

        Ticket ticket = new Ticket(movieTitle, finalPrice);

        System.out.println("영화: " + ticket.getMovieTitle() + " | 정가: " + price + "원 | 최종 결제 금액: " + ticket.getPrice() + "원");
    }
}
