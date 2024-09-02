package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static Scanner sc = new Scanner(System.in);

    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int disposableCups = 9;
    public static int money = 550;

    public static void remaining() {
        System.out.println("The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffeeBeans + " g of coffee beans\n" +
                disposableCups + " disposable cups\n" +
                '$' + money + " of money");
        System.out.println();
    }

    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String chose = sc.next();
        String waterBreak = "Sorry, not enough water!";
        String milkBreak = "Sorry, not enough milk!";
        String coffeeBeansBreak = "Sorry, not enough coffee beans!";
        String disposableCupsBreak = "Sorry, not enough disposable cups!";


        switch (chose) {
            case "1": // espresso
                if (water - 250 > 0) {
                    water = water - 250;
                } else if (water - 250 < 0){
                    System.out.println(waterBreak);
                    break;
                }

                if (coffeeBeans - 16 > 0) {
                    coffeeBeans = coffeeBeans - 16;
                } else if (coffeeBeans - 16 < 0) {
                    System.out.println(coffeeBeansBreak);
                    break;
                }

                if (disposableCups - 1 > 0) {
                    disposableCups = disposableCups - 1;
                } else if (disposableCups - 1 < 0) {
                    System.out.println(disposableCupsBreak);
                    break;
                }

                money = money + 4;
                System.out.println("I have enough resources, making you a coffee!");
                break;

            case "2": // latte
                if (water - 350 > 0) {
                    water = water - 350;
                } else if (water - 350 < 0) {
                    System.out.println(waterBreak);
                    break;
                }

                if (milk - 75 > 0) {
                    milk = milk - 75;
                } else if (milk - 75 < 0) {
                    System.out.println(milkBreak);
                    break;
                }

                if (coffeeBeans - 20 > 0) {
                    coffeeBeans = coffeeBeans - 20;
                } else if (coffeeBeans - 20 < 0) {
                    System.out.println(coffeeBeansBreak);
                    break;
                }

                if (disposableCups - 1 > 0) {
                    disposableCups = disposableCups - 1;
                } else if (disposableCups - 1 < 0) {
                    System.out.println(disposableCupsBreak);
                    break;
                }

                money = money + 7;
                System.out.println("I have enough resources, making you a coffee!");
                break;

            case "3": // cappuccino
                if (water - 200 > 0) {
                    water = water - 200;
                } else if (water - 200 < 0) {
                    System.out.println(waterBreak);
                    break;
                }

                if (milk - 100 > 0) {
                    milk = milk - 100;
                } else if (milk - 100 < 0) {
                    System.out.println(milkBreak);
                    break;
                }

                if (coffeeBeans - 12 > 0) {
                    coffeeBeans = coffeeBeans - 12;
                } else if (coffeeBeans - 12 < 0) {
                    System.out.println(coffeeBeansBreak);
                    break;
                }

                if (disposableCups - 1 > 0) {
                    disposableCups = disposableCups - 1;
                } else if (disposableCups - 1 < 0) {
                    System.out.println(disposableCupsBreak);
                    break;
                }

                money = money + 6;
                System.out.println("I have enough resources, making you a coffee!");
                break;

            case "back":

        }
        System.out.println();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        System.out.println();
        money = 0;
    }

    public static void fill() {

        System.out.println("Write how many ml of water you want to add:");
        int addWater = sc.nextInt();
        water = water + addWater;

        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = sc.nextInt();
        milk = milk + addMilk;

        System.out.println("Write how many grams of coffee beans you want to add:");
        int addCoffee = sc.nextInt();
        coffeeBeans = coffeeBeans + addCoffee;

        System.out.println("Write how many disposable cups you want to add:");
        int addDisposableCups = sc.nextInt();
        disposableCups = disposableCups + addDisposableCups;
    }
    public static void main(String[] args) {

        boolean change = true;
        while (change) {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = sc.next();

            switch (action) {
                case "remaining":
                    remaining();
                    break;
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "exit":
                    change = false;
            }
        }
    }
}
