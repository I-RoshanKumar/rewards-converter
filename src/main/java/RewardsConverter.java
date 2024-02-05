import java.util.Scanner;

public class RewardsConverter {

    public static class RewardValue {
        private double cashValue;
        private double milesValue;

        // Constructor that accepts a cash value
        public RewardValue(double cashValue) {
            this.cashValue = cashValue;
            this.milesValue = cashToMiles(cashValue);
        }

        // Constructor that accepts a value in miles
        public RewardValue(double milesValue, boolean isMiles) {
            this.milesValue = milesValue;
            this.cashValue = milesToCash(milesValue);
        }

        // Method to convert cash to miles at a rate of 0.0035
        private double cashToMiles(double cashValue) {
            return cashValue / 0.0035;
        }

        // Method to convert miles to cash at a rate of 0.0035
        private double milesToCash(double milesValue) {
            return milesValue * 0.0035;
        }

        // Getter method for cashValue
        public double getCashValue() {
            return cashValue;
        }

        // Getter method for milesValue
        public double getMilesValue() {
            return milesValue;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Credit Card Rewards Converter!");
        System.out.print("Please enter a cash value to convert to airline miles: ");
        
        double cashValue;
        try {
            cashValue = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException exception) {
            System.out.println("Could not parse input value as a double, exiting");
            return;
        }

        System.out.println("Converting $" + cashValue + " to miles");
        RewardValue rewardsValue = new RewardValue(cashValue);
        System.out.println("$" + cashValue + " is worth " + rewardsValue.getMilesValue() + " miles");
    }
}
