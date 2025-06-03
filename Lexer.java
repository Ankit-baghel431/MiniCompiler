public class Lexer {
    private String input;
    private int pos;
    private char currentChar;

    public Lexer(String input) {
        this.input = input;
        this.pos = 0;
        this.currentChar = input.length() > 0 ? input.charAt(0) : '\0';
    }

    private void advance() {
        pos++;
        currentChar = pos < input.length() ? input.charAt(pos) : '\0';
    }

    private void skipWhitespace() {
        while (Character.isWhitespace(currentChar)) advance();
    }

    private double number() {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(currentChar) || currentChar == '.') {
            sb.append(currentChar);
            advance();
        }
        return Double.parseDouble(sb.toString());
    }

    private String identifier() {
        StringBuilder sb = new StringBuilder();
        while (Character.isLetter(currentChar)) {
            sb.append(currentChar);
            advance();
        }
        return sb.toString();
    }

    public TokenData getNextToken() {
        skipWhitespace();

        if (Character.isDigit(currentChar)) {
            return new TokenData(Token.NUMBER, number());
        }

        if (Character.isLetter(currentChar)) {
            String id = identifier();
            return new TokenData(Token.IDENTIFIER, id);
        }

        switch (currentChar) {
            case '+': advance(); return new TokenData(Token.PLUS, null);
            case '-': advance(); return new TokenData(Token.MINUS, null);
            case '*': advance(); return new TokenData(Token.MULTIPLY, null);
            case '/': advance(); return new TokenData(Token.DIVIDE, null);
            case '^': advance(); return new TokenData(Token.POWER, null);
            case '(': advance(); return new TokenData(Token.LPAREN, null);
            case ')': advance(); return new TokenData(Token.RPAREN, null);
            case '\0': return new TokenData(Token.EOF, null);
        }

        throw new RuntimeException("Unexpected character: " + currentChar);
    }

    public static class TokenData {
        public final Token token;
        public final Object value;

        public TokenData(Token token, Object value) {
            this.token = token;
            this.value = value;
        }
    }
}