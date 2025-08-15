# Java Code Katas

A collection of Java coding challenges and algorithms practice using Test-Driven Development (TDD).

## Array & Data Structure Katas ([Problem](https://github.com/JonahSul/katas/tree/array-structure) and [Solution](https://github.com/JonahSul/katas/tree/array-structure-solution))

This branch contains a collection of Array & Data Structure katas designed to reinforce fundamental programming concepts.

The included katas cover a variety of topics such as:

* Array manipulation (e.g., filtering, mapping, sorting, searching)
* Basic data structure operations (e.g., stacks, queues, linked lists)
* Algorithmic challenges involving arrays (e.g., finding duplicates, merging arrays, rotating arrays)
* Implementation and usage of common data structures to solve practical problems

Each kata provides an opportunity to practice efficient data handling, algorithmic thinking, and mastery of core programming patterns.

## Project Structure

All the Array & Data Structure Katas are made available in the following location:

``` text
src/
├── main/java/com/katas/        # Implementation code
└── test/java/com/katas/        # Unit tests
```

**Array Rotation** (`ArrayRotation.java`)—Rotate array elements

* Implement multiple rotation algorithms (in-place, extra space)
* Handle edge cases (k > array length, empty arrays)
* Optimize for O(1) space complexity using array reversal technique

**Two Sum** (`TwoSum.java`)—Find pair of numbers that sum to target

* Brute force O(n²) approach
* Optimized O(n) HashMap solution
* Handle duplicate values and negative numbers

**Binary Tree** (`BinaryTree.java`)—Complete binary search tree implementation

* Tree traversals (inorder, preorder, postorder, level-order)
* Depth calculation and balance validation
* Binary search tree validation and lowest common ancestor

**Hash Table** (`HashTable.java`)—From-scratch hash table implementation

* Collision handling using chaining
* Dynamic resizing when load factor exceeds threshold
* Support for null keys/values and generic types

## Getting Started

### Prerequisites

* Java 17 or higher
* Maven 3.6 or higher

### Running Tests

```bash
mvn test
```

### Compiling

```bash
mvn compile
```

## Working with Branches

This repository uses separate branches for exercises and solutions:

* **Exercise branches** (e.g., `array-structure`) contain kata problems with failing tests
* **Solution branches** (e.g., `array-structure-solution`) contain complete implementations

### To practice array and data structure katas

1. Switch to the exercise branch:

   ```bash
   git checkout array-structure
   ```

2. Run tests to see failing cases:

   ```bash
   mvn test
   ```

3. Implement solutions to make tests pass

4. Compare with solutions (optional):

   ```bash
   git checkout array-structure-solution
   ```

### Creating New Katas

1. Copy `KataTemplate.java` and `KataTemplateTest.java`
2. Rename the files and classes appropriately
3. Update the problem description and implement your solution
4. Follow TDD approach: write failing tests first, then make them pass

### Testing Framework

This project uses:

* **JUnit 5** for unit testing
* **AssertJ** for fluent assertions

### Example Test Structure

```java
@Test
void shouldReturnExpectedResult() {
    assertThat(kata.solve("input")).isEqualTo("expected output");
}
```

## VS Code Tasks

* **Maven: Run Tests** - Executes all unit tests
* Use Ctrl+Shift+P → "Tasks: Run Task" to access available tasks

## Development Tips

### General TDD Approach
> Red, Green, Refactor: Make it fail, make it pass, make it beautiful.

1. Start with the simplest test case
2. Write only enough code to make the test pass
3. Refactor once tests are green
4. Use descriptive test method names
5. Test edge cases and boundary conditions

### Array & Data Structure Specific Tips

* **Array Rotation**: Consider multiple approaches (reversal, cyclic replacements, extra space)
* **Two Sum**: Start with brute force, then optimize with HashMap for O(n) solution
* **Binary Tree**: Practice both recursive and iterative approaches for traversals
* **Hash Table**: Focus on collision handling and load factor management for performance

### Algorithm Complexity Goals

* Array Rotation: Achieve O(1) space complexity
* Two Sum: Optimize from O(n²) to O(n) time complexity
* Binary Tree: Maintain O(log n) operations for balanced trees
* Hash Table: Target O(1) average time for basic operations

Happy coding! 🚀
