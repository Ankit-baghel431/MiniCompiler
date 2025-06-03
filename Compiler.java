import java.util.Scanner;

public class Compiler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an expression (e.g., sin(30) + log(100)):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            try {
                Lexer lexer = new Lexer(input);
                Parser parser = new Parser(lexer);
                double result = parser.parse();
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}