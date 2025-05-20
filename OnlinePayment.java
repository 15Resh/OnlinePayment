import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class PaymentDetails {
    String cardNumber;
    String cvv;
    String expiryDate;
    double amount;

    public PaymentDetails(String cardNumber, String cvv, String expiryDate, double amount) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.amount = amount;
    }

    public boolean isValid() {
        return cardNumber.length() == 16 &&
               cvv.length() == 3 &&
               expiryDate.matches("\\d{2}/\\d{2}") &&
               amount > 0;
    }

    @Override
    public String toString() {
        return "Card Ending: ****" + cardNumber.substring(12) + ", Amount: ₹" + amount;
    }
}

class PaymentProcessor {
    public boolean process(PaymentDetails details) {
        return details.amount <= 10000;
    }
}


public class OnlinePayment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentProcessor processor = new PaymentProcessor();

      
        List<PaymentDetails> transactionHistory = new ArrayList<>();

        System.out.println("=== Online Payment Gateway with Transaction History ===");

        boolean continuePayment = true;

        while (continuePayment) {
            System.out.print("Enter Card Number (16 digits): ");
            String cardNumber = scanner.nextLine();

            System.out.print("Enter CVV (3 digits): ");
            String cvv = scanner.nextLine();

            System.out.print("Enter Expiry Date (MM/YY): ");
            String expiryDate = scanner.nextLine();

            System.out.print("Enter Amount to Pay: ₹");
            double amount = 0;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Invalid amount format.");
                continue;
            }

            PaymentDetails details = new PaymentDetails(cardNumber, cvv, expiryDate, amount);

            if (details.isValid()) {
                boolean success = processor.process(details);
                if (success) {
                    System.out.println("Payment of ₹" + amount + " successful!");
                    transactionHistory.add(details); // Add to history
                } else {
                    System.out.println("Payment failed: Amount exceeds limit.");
                }
            } else {
                System.out.println(" Invalid payment details. Please check and try again.");
            }

           
            System.out.println("\n--- Transaction History ---");
            if (transactionHistory.isEmpty()) {
                System.out.println("No transactions yet.");
            } else {
                for (int i = 0; i < transactionHistory.size(); i++) {
                    System.out.println((i+1) + ". " + transactionHistory.get(i));
                }
            }
            System.out.println("---------------------------");

            
            System.out.print("Do you want to make another payment? (yes/no): ");
            String answer = scanner.nextLine();
            continuePayment = answer.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for using the payment gateway!");
        scanner.close();
    }
}
