package com.example.projectTest;

public class Token {
    private String token;
    private Seats ticket;

    public Token(String token, Seats ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Seats getTicket() {
        return ticket;
    }

    public void setTicket(Seats ticket) {
        this.ticket = ticket;
    }

}
