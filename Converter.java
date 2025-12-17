import java.util.Scanner;

public class Converter {
    public static void main (String[] args) {
        //get input from user\
        try ( //instantiate scanner
                Scanner scanner = new Scanner(System.in)) {
            //get input from user\
            System.out.println("Enter a value (eg. 200.00): ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); //consume newline

            //1. check if amount is less than 0
            while (amount <= 0) {
                System.err.println("Error: Amount must be greater than 0!!");
                System.out.println("Enter a value (eg. 200.00): ");
                amount = scanner.nextDouble();
                scanner.nextLine(); //consume newline
            }
            
            System.out.println("Choose from-currency (USD/EUR/KES): ");
            String fromCurrency = scanner.nextLine();
            fromCurrency = fromCurrency.toUpperCase();  // Convert to uppercase for case-insensitive matching
            
            System.out.println("Choose to-currency (USD/EUR/KES): ");
            String toCurrency = scanner.nextLine();
            toCurrency = toCurrency.toUpperCase();  // Convert to uppercase for case-insensitive matching
            
            double finalCurrency;
            
            
            //input validation            
            //check if fromCurrency is selected from the listed
            String[] availableCurrencies = {"USD", "EUR", "KES"};
            boolean fromValid = false;
            boolean toValid = false;
            
            for (String val : availableCurrencies) {
                if (val.equals(fromCurrency)) {
                    fromValid = true;
                }
                if (val.equals(toCurrency)) {
                    toValid = true;
                }
            }
            
            if (!fromValid) {
                System.err.println("Error: Currency Nor supported");
            }
            if (!toValid) {
                System.err.println("Error: Currency not supported!");
            }
            
            //convert from one currency to another - switch-case is better
            switch (toCurrency) {
                case "USD" -> {
                    switch (fromCurrency) {
                        case "KES" -> {
                            finalCurrency = (int) (amount * 0.0078);
                            System.out.println(finalCurrency);
                            break;
                        }
                        case "EUR" -> {
                            finalCurrency = (int) (amount * 1.17);
                            System.out.println(finalCurrency);
                            break;
                        }
                        default -> System.out.println("Currency not supported");
                    }
                }

                case "EUR" -> {
                    switch (fromCurrency) {
                        case "KES" -> {
                            finalCurrency = (int) (amount * 0.0066);
                            System.out.println(finalCurrency);
                            break;
                        }
                        case "USD" -> {
                            finalCurrency = (int) (amount * 0.85);
                            System.out.println(finalCurrency);
                            break;
                        }
                        default -> System.out.println("Currency not supported");
                    }
                }

                case "KES" -> {
                    switch (fromCurrency){
                        case "EUR" -> {
                            finalCurrency = (int) (amount * 151.69);
                            System.out.println(finalCurrency);
                            break;
                        }
                        case "USD" -> {
                            finalCurrency = (int) (amount * 128.95);
                            System.out.println(finalCurrency);
                            break;
                        }
                        default -> System.out.println("Currency not supported");
                    }
                }
            default -> System.out.println("Currency not supported");

            }
        }

    }
}