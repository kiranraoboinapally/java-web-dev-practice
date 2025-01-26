# Java Practice Programs

This repository contains a collection of Java practice programs and coding challenges aimed at helping learners strengthen their problem-solving and Java programming skills. The programs cover a range of topics from basic to intermediate levels, including loops, recursion, arrays, sorting algorithms, pattern generation, and much more.

> **Note**: The **`ques.md`** file, located in the `java/` folder, contains a complete list of all the questions and problems in this repository. It serves as a central reference point for all the challenges.

## Table of Contents

- [Folder Structure](#folder-structure)
- [Basic Programs](#basic-programs)
- [Loops](#loops)
- [Patterns](#patterns)
- [Arrays](#arrays)
- [Additional Information](#additional-information)
- [How to Use](#how-to-use)
- [Contributing](#contributing)
- [License](#license)

---

## Folder Structure

At the root of the `java/` folder, you'll find a **`ques.md`** file, which contains a comprehensive list of all the questions and problems included in this repository. This file serves as the primary reference for navigating the collection of problems.

The rest of the folder structure is organized as follows:

```
java/
├── ques.md          # A Markdown file listing all the questions/problems (Top Priority)
├── arrays/
│   └── (Java files related to array-based problems)
├── basics/
│   └── (Java files for basic programs)
├── loops/
│   ├── for/
│   ├── do-while/
│   └── while/
├── patterns/
│   └── (Java files for generating patterns)
├── recursion/
│   └── (Java files for recursive problems)
├+(-_-)+

```

Each folder contains Java files corresponding to specific problems or categories.

- **ques.md**: The file that contains a complete list of all the questions/problems available in this repository.
- **arrays/**: Contains solutions to problems involving arrays.
- **basics/**: Includes fundamental Java programs covering basic concepts.
- **loops/**: Contains programs categorized by different types of loops:
  - **for/**: Programs using the `for` loop.
  - **do-while/**: Programs using the `do-while` loop.
  - **while/**: Programs using the `while` loop.
- **patterns/**: Programs for generating various patterns.

---

## Basic Programs

These are fundamental programs that will help beginners get acquainted with the core concepts of Java. Some of the basic programs included are:

- **Swapping Numbers** - Examples of swapping two numbers using various methods (third variable, bitwise XOR).
- **FizzBuzz** - A simple program to print "Fizz" for multiples of 3, "Buzz" for multiples of 5, and "FizzBuzz" for multiples of both.
- **Even or Odd** - Program to check if a number is even or odd.
- **Largest Among Three Numbers** - Program to find the largest of three numbers.
- **Eligibility Based on Age** - Program to check job eligibility based on age.

Each program is stored in a separate file, and the filenames generally follow the structure of the problem statement (e.g., `swapThird.java`, `fizzBuzz.java`, etc.).

---

## Loops

The **Loops** section contains practice programs that help you understand and work with different types of loops in Java (while loop, for loop, etc.). The loop programs are further categorized into:

### for

Programs that utilize the `for` loop to solve problems such as:

- **Prime Numbers in a Range** - Program to print prime numbers from 1 to 100.
- **Fibonacci Sequence** - Print Fibonacci series using a `for` loop.

### do-while

Programs that utilize the `do-while` loop, such as:

- **Collatz Conjecture** - Implement the Collatz conjecture using a `do-while` loop.
- **Menu-driven Program** - Implement a menu-driven program using a `do-while` loop.

### while

Programs that utilize the `while` loop to solve problems like:

- **Sum of Digits** - Calculate the sum of digits of a number using a `while` loop.
- **Factorial of a Number** - Calculate the factorial of a number using a `while` loop.

---

## Patterns

This section focuses on generating various patterns using nested loops. Pattern generation is a key exercise to improve your understanding of loops and problem-solving. Some of the patterns include:

- **Rectangle Patterns** - Simple rectangle patterns using characters (e.g., `#` or `$`).
- **Triangle Patterns** - Programs that print different types of triangles (e.g., star triangles, number pyramids).
- **Diamond Patterns** - Programs that print diamond shapes with stars or numbers.

---

## Arrays

The **Arrays** section includes practice problems related to arrays, covering tasks like searching, sorting, and manipulating array elements. Example programs:

- **Array Rotation** - Rotate an array to the left or right by a given number of positions.
- **Array Search** - Implement linear search and binary search on arrays.
- **Merge Two Arrays** - Merge two arrays into one.
- **Find Maximum and Minimum Elements in an Array** - Program to find the largest and smallest elements in an array.

---

## Additional Information

- **File Names**: Each problem has an associated Java file for the solution. For example, `arrayTransformation.java` corresponds to the solution for the 10th problem.
  
- **Test Cases**: For each problem, test cases are provided to help validate the solution and understand the expected behavior. These test cases will allow you to check the correctness of your implementation and ensure that edge cases are handled properly.

- **Implementation Notes**: Some problems may require specific handling, such as boundary conditions or edge cases. These details have been included in the respective test cases, so be sure to review them for a better understanding of how to tackle different situations.

Feel free to refer to the respective Java files for the implementation of each problem. If any problem requires additional clarification or modification, don't hesitate to ask for help.

---

## How to Use

To run the Java programs in this repository:

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kiranraoboinapally/java-practice-problems.git
   ```
   
2. **Navigate to the Program Directory**:
   Go into the folder that contains the Java program you want to run.

3. **Compile and Run the Program**:
   To compile and run any program, use the following commands in the terminal:
   ```bash
   javac programName.java    # Compile the program
   java programName          # Run the program
   ```
   For example:
   ```bash
   javac fizzBuzz.java
   java fizzBuzz
   ```

---

## Contributing

Contributions are welcome! If you have any suggestions or new practice programs to add, feel free to fork the repository, create a new branch, and submit a pull request.

Steps for contributing:

1. Fork this repository.
2. Create a new branch: `git checkout -b feature-name`
3. Make your changes.
4. Commit your changes: `git commit -m 'Add new feature'`
5. Push to your branch: `git push origin feature-name`
6. Open a pull request to the main repository.

---

## License

This repository is open-source and available under the [MIT License](LICENSE).

---