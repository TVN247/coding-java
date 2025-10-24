# Problem 5: Print String in a Box

## Description
Write a method, `printInBox`, that takes a string representation of a number and prints it to the console formatted inside a rectangular box. The box size should be dynamic based on the length of the input string.

## Constraints and Edge Cases
- The box must be constructed using `+` (corners), `-` (horizontal lines), and `|` (vertical lines)
- The number string content must be padded with one space on the left and one space on the right
- If the input string is null or empty, the method should print a minimal box for an empty string

## Examples

input N = 5
output
 ```
 +---+
 + 5 +
 +---+
```

 input N = 99
 output
 ```
 +----+
 + 99 +
 +----+
```
### Function Signature (Java)
```java
public static void printInBox(String numberString)
```

## Problem 5.1: Print 2D Matrix

### Description
Write a method that prints a 2D matrix from an array of 9 strings. The output should be formatted as a table with dynamic column widths.

### Example
Given an array of strings: `["1", "2", "3", "1234", "5", "6", "45", "8", "9"]`

Output:
```
+------+---+---+
| 1    | 2 | 3 |
+------+---+---+
| 1234 | 5 | 6 |
+------+---+---+
| 45   | 8 | 9 |
+------+---+---+
```

### Requirements
- Each cell should be separated by vertical lines (`|`)
- Rows should be separated by lines made of dashes (`-`) and plus signs (`+`)
- Content should be left-aligned within cells
- Column width should adjust to the longest string in that column