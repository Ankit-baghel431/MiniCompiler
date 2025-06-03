public class Parser {
    private final Lexer lexer;
    private Lexer.TokenData currentToken;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        this.currentToken = lexer.getNextToken();
    }

    private void eat(Token tokenType) {
        if (currentToken.token == tokenType) {
            currentToken = lexer.getNextToken();
        } else {
            throw new RuntimeException("Unexpected token: " + currentToken.token + ", expected: " + tokenType);
        }
    }

    public double parse() {
        return expression();
    }

    private double expression() {
        double result = term();

        while (currentToken.token == Token.PLUS || currentToken.token == Token.MINUS) {
            if (currentToken.token == Token.PLUS) {
                eat(Token.PLUS);
                result += term();
            } else {
                eat(Token.MINUS);
                result -= term();
            }
        }

        return result;
    }

    private double term() {
        double result = factor();

        while (currentToken.token == Token.MULTIPLY || currentToken.token == Token.DIVIDE) {
            if (currentToken.token == Token.MULTIPLY) {
                eat(Token.MULTIPLY);
                result *= factor();
            } else {
                eat(Token.DIVIDE);
                result /= factor();
            }
        }

        return result;
    }

    private double factor() {
        double result = power();
        return result;
    }

    private double power() {
        double base = atom();
        while (currentToken.token == Token.POWER) {
            eat(Token.POWER);
            base = Math.pow(base, atom());
        }
        return base;
    }

    private double atom() {
        if (currentToken.token == Token.NUMBER) {
            double value = (double) currentToken.value;
            eat(Token.NUMBER);
            return value;
        } else if (currentToken.token == Token.IDENTIFIER) {
            String func = (String) currentToken.value;
            eat(Token.IDENTIFIER);
            eat(Token.LPAREN);
            double arg = expression();
            eat(Token.RPAREN);
            return applyFunction(func, arg);
        } else if (currentToken.token == Token.LPAREN) {
            eat(Token.LPAREN);
            double result = expression();
            eat(Token.RPAREN);
            return result;
        }

        throw new RuntimeException("Unexpected token in atom: " + currentToken.token);
    }

    private double applyFunction(String func, double arg) {
        return switch (func.toLowerCase()) {
            case "sin" -> Math.sin(Math.toRadians(arg));
            case "cos" -> Math.cos(Math.toRadians(arg));
            case "tan" -> Math.tan(Math.toRadians(arg));
            case "log" -> Math.log10(arg);
            case "ln" -> Math.log(arg);
            case "sqrt" -> Math.sqrt(arg);
            case "exp" -> Math.exp(arg);
            default -> throw new RuntimeException("Unknown function: " + func);
        };
    }
}