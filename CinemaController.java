package com.example.projectTest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class CinemaController {

    Cinema cinema = new Cinema(9, 9);
    private Map<String, Token> tokenMap = new HashMap<>();

    @GetMapping("/seats")
    public Cinema getAvailableSeats() {
        return cinema;
    }

    @PostMapping("/purchase")
    public ResponseEntity<?> checkAvailableSeats(@RequestBody Map<String, Integer> request) {
        int row = request.get("row");
        int column = request.get("column");

        for (Seats seat : cinema.getSeats()) {
            if (seat.getRow() == row && seat.getColumn() == column) {
                if (!seat.isTaken()) {
                    seat.setTaken(true);
                    String generatedToken = UUID.randomUUID().toString();
                    Token token = new Token(generatedToken, seat);
                    tokenMap.put(generatedToken, token);

                    Token tokenTicket = new Token(generatedToken, new Seats(row, column, seat.getPrice()));
                    return ResponseEntity.ok(tokenTicket);
                } else {
                    return ResponseEntity.badRequest().body(Map.of("error", "The ticket has been already purchased!"));
                }
            }
        }
        return ResponseEntity.badRequest().body(Map.of("error", "The number of a row or a column is out of bounds!"));
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody Map<String, String> request) {
        String tokenStr = request.get("token");

        if (tokenMap.containsKey(tokenStr)) {
            Token token = tokenMap.remove(tokenStr);
            Seats seat = token.getTicket();
            seat.setTaken(false);

            return ResponseEntity.ok(Map.of("ticket", seat));
        } else {
            return ResponseEntity.badRequest().body(Map.of("error", "Wrong token!"));
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStatusList(@RequestParam(required = false) String password) {
        String correctPassword = "super_secret";
        int incomeCount = 0;
        int available = getAvailableSeats().getColumns() * getAvailableSeats().getRows();
        int purchasedCount = 0;

        for (Seats seats : cinema.getSeats()) {
            if (seats.isTaken()) {
                incomeCount += seats.getPrice();
                purchasedCount++;
                available--;
            }
        }
        if (password == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "The password is wrong!"));
        } else if (!password.equals(correctPassword)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "The password is wrong!"));
        }

        Stats stats = new Stats(incomeCount, available, purchasedCount);
        return ResponseEntity.ok().body(stats);
    }
}
