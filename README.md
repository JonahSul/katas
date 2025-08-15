# Java Code Katas

A collection of Java coding challenges and algorithms practice using Test-Driven Development (TDD).

## Project Structure

```
src/
├── main/java/com/katas/        # Implementation code
└── test/java/com/katas/        # Unit tests
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running Tests
```bash
mvn test
```

### Compiling
```bash
mvn compile
```

### Available Katas

1. **FizzBuzz** (`FizzBuzz.java`) - Classic FizzBuzz implementation
   - Print numbers 1-100, replace multiples of 3 with "Fizz", multiples of 5 with "Buzz"
   - For multiples of both 3 and 5, print "FizzBuzz"
2. **Password Validation** ([Problem](https://github.com/JonahSul/katas/tree/password-verify) and [Solution](https://github.com/JonahSul/katas/tree/password-verify-solution))
- Validate password length
- Validate proper mix and count of characters
- Validate user-provided password matches securely hashed password from application storage

### Creating New Katas

1. Copy `KataTemplate.java` and `KataTemplateTest.java`
2. Rename the files and classes appropriately
3. Update the problem description and implement your solution
4. Follow TDD approach: write failing tests first, then make them pass

### Testing Framework

This project uses:
- **JUnit 5** for unit testing
- **AssertJ** for fluent assertions

### Example Test Structure

```java
@Test
void shouldReturnExpectedResult() {
    assertThat(kata.solve("input")).isEqualTo("expected output");
}
```

## VS Code Tasks

- **Maven: Run Tests** - Executes all unit tests
- Use Ctrl+Shift+P → "Tasks: Run Task" to access available tasks

## Development Tips

1. Start with the simplest test case
2. Write only enough code to make the test pass
3. Refactor once tests are green
4. Use descriptive test method names
5. Test edge cases and boundary conditions

Happy coding! 🚀
