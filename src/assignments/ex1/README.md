# README - Number Formatting Converter

**ID**: 208748368

## Overview
This project implements a number formatting converter and calculator for bases 2 to 16 using the `<number>b<base>` format. It supports:

- Base conversions.
- Validation for formatted numbers.
- Numerical operations (sum, product).

## Functions

### `number2Int`
Converts a formatted string to a decimal integer. If the input is invalid, it returns -1.
- **Example**: `number2Int("101b2")` returns `5`.

### `isNumber`
Validates whether a string follows the `<number>b<base>` format. Returns `true` if valid, otherwise `false`.
- **Example**: `isNumber("101b2")` returns `true`, while `isNumber("123b18")` returns `false`.

### `int2Number`
Converts a decimal integer to a string in the specified base. If the base is invalid or the number is negative, it returns an empty string.
- **Example**: `int2Number(5, 2)` returns `"101b2"`.

### `maxIndex`
Finds the index of the largest valid number in an array of strings. If multiple numbers share the largest value, it returns the first index.
- **Example**: Given `{"5b10", "A1b16"}`, `maxIndex` returns `1`.

### `equals`
Checks if two numbers (in any valid base format) represent the same value. Returns `true` if they are equivalent, otherwise `false`.
- **Example**: `equals("101b2", "5b10")` returns `true`.

### `main`
Implements an interactive console program for number validation, conversion, and calculations. The program:
1. Prompts the user to enter two formatted numbers and a base.
2. Validates the numbers and the base.
3. Computes and displays the sum and product of the two numbers in the specified base.
4. Identifies the largest number among the inputs and results.

- **Example Interaction**:
  ```
  Enter a string as number#1 (or "quit" to end the program): 101b2
  num1= 101b2 is number: true , value: 5
  Enter a string as number#2 (or "quit" to end the program): 3b10
  num2= 3b10 is number: true , value: 3
  Enter a base for output: (a number [2,16]): 2
  101b2 + 3b10 = 1000b2
  101b2 * 3b10 = 1111b2
  Max number over [101b2,3b10,1000b2,1111b2] is: 1111b2
  ```

## Testing
Comprehensive unit tests are provided in `Ex1Test.java`. These tests validate:

- **Correct handling of valid inputs**: Ensures numbers in valid formats are processed accurately.
- **Proper rejection of invalid inputs**: Confirms incorrect formats are identified and rejected.
- **Edge cases**: Verifies behavior for extreme values and boundary conditions for all implemented functions.

- **Examples**:
    - Test `number2Int` with valid and invalid inputs.
    - Test `isNumber` with a variety of edge cases.
    - Test `maxIndex` with arrays containing valid and invalid numbers.
