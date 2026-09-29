package oop_test.ch11;

public class Ticket {
    private String movieTitle;
    private int price;

    public Ticket(String movieTitle, int price) {
        this.movieTitle = movieTitle;
        this.price = price;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getPrice() {
        return price;
    }
}
