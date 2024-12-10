# README - Number Formatting Converter
**ID:** 208748368  
---
## Overview
This project implements a number formatting converter and calculator for bases 2 to 16 using the `<number>b<base>` format. It supports:
- Base conversions.
- Validation for formatted numbers.
- Numerical operations (sum, product).
---
## Functions
1. **`number2Int`**: Converts a formatted string to a decimal integer. Returns `-1` for invalid inputs.  
2. **`isNumber`**: Validates whether a string follows the `<number>b<base>` format.  
3. **`int2Number`**: Converts a decimal integer to a string in the specified base. Returns an empty string for invalid inputs.  
4. **`maxIndex`**: Finds the index of the largest valid number in an array.  
5. **`equals`**: Placeholder function that raises an exception if called, as per assignment instructions.  
6. **`main`**: Implements an interactive console program for number validation, conversion, and calculations.
---
## Testing
Comprehensive unit tests are provided in `Ex1Test.java`. These tests validate:
- Correct handling of valid inputs.
- Proper rejection of invalid inputs.
- Edge cases for all implemented functions.
---
