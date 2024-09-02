package com.example.projectTest;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Seats {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean taken;

    public Seats(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.taken = false;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isTaken() { return taken; }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }
}
