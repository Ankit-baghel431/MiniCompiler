
# MiniLang Compiler

A Java-based compiler project for a custom language called **MiniLang**, featuring:
- A lexer and parser for MiniLang syntax
- Support for scientific expressions (e.g., `sin`, `cos`, `log`, `^`)
- A compiler that translates MiniLang into executable instructions
- A graphical user interface (GUI) built with **JavaFX** for user interaction and scientific expression evaluation

---

## 📁 Project Structure

```
.
├── Compiler.java                 # Coordinates parsing and compilation
├── Lexer.java                    # Tokenizes MiniLang code
├── Parser.java                   # Parses token stream and builds syntax tree
├── Token.java                    # Token type definitions
├── ScientificCalculatorFX.java   # JavaFX GUI for scientific calculations
└── README.md                     # Project documentation
```

---

## 🛠️ Features

- **Lexer:** Identifies tokens including numbers, variables, operators, and scientific functions.
- **Parser:** Recognizes arithmetic expressions, function calls, control flow (if/else), and variable declarations.
- **Compiler:** Performs semantic checks and executes or transforms MiniLang code.
- **Scientific Calculator GUI:** JavaFX interface for evaluating expressions using the MiniLang language and displaying results.

---

## 🚀 Getting Started

### Requirements

- Java 8 or later
- JavaFX SDK

### Compilation & Run

1. **Compile**
   ```sh
   javac *.java
   ```

2. **Run GUI**
   ```sh
   java ScientificCalculatorFX
   ```

3. **Run via Console**
   ```sh
   java Compiler
   ```

---

## 📌 Example MiniLang Input

```mini
x = 5;
y = sin(x) + log(10);
if (y > 0) {
    print y;
}
```

---

## 🧪 Supported Scientific Functions

- `sin(x)`, `cos(x)`, `tan(x)`
- `log(x)`, `ln(x)`
- `sqrt(x)`
- Exponentiation with `^`

---

## 📚 License

This project is licensed under the MIT License.
