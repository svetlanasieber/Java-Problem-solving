package RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftuniBarIncome_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<customerName>[A-Z][a-z]+)%[^\\|$%\\.]*<(?<product>\\w+)>[^\\|\\$%\\.]*\\|(?<count>[0-9]+)\\|[^\\|\\$%\\.]*?(?<price>[0-9]+\\.?[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex); 

        double totalIncome = 0; 

        String input = scanner.nextLine(); 
        while (!input.equals("end of shift")) {
           
           
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
               
               
                String customerName = matcher.group("customerName"); //"George"
                String product = matcher.group("product"); //"Croissant"
                int count = Integer.parseInt(matcher.group("count")); //"2" -> parse -> 2
                double price = Double.parseDouble(matcher.group("price")); //"10.3" -> parse -> 10.3

                double totalPricePerOrder = count * price; 
                totalIncome += totalPricePerOrder;
                System.out.printf("%s: %s - %.2f%n", customerName, product, totalPricePerOrder);
            }
            input = scanner.nextLine();
        }

        System.out.printf("Total income: %.2f", totalIncome);
    }
}
