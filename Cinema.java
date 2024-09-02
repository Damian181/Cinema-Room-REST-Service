package com.example.projectTest;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
    private int rows;
    private int columns;
    private List<Seats> seats;

    public Cinema(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new ArrayList<>();
        AvailableSeats();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    private void AvailableSeats() {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (i <= 4) {
                    seats.add(new Seats(i, j, 10));
                } else {
                    seats.add(new Seats(i, j, 8));
                }
            }
        }
    }
}
