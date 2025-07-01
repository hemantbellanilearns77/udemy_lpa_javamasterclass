package com.hb.study.udemy.lpa.section7_oop_part1.misc_practice.allaboutstrings;

/*
    This is generated using Google Gemini.... for practice.
    Can i initialize a String variable in Java with a text block and then use string manipulation methods on it? Please show an example class in java to demonstrate if possible

    Yes, you can initialize a String variable in Java using a text block and then use string manipulation methods on it. Text blocks were introduced in Java 13 as a way to create multi-line strings more easily. You can perform various string manipulation operations such as trimming, replacing, or extracting substrings on a string initialized with a text block.

    Here’s an example class in Java that demonstrates this:
*/
    public class StringTextBlockManipulationExample {
        public static void main(String[] args) {
            // Initializing a String variable using a text block
            String textBlock = """
                Hello, World!
                This is a text block example.
                It can span multiple lines.
                """;

            // Display the original text block
            System.out.println("Original Text Block:");
            System.out.println(textBlock);

            // Using string manipulation methods
            // 1. Trimming whitespace
            String trimmedText = textBlock.trim();
            System.out.println("\nTrimmed Text:");
            System.out.println(trimmedText);

            // 2. Replacing a substring
            String replacedText = textBlock.replace("World", "Java");
            System.out.println("\nReplaced Text:");
            System.out.println(replacedText);

            // 3. Converting to uppercase
            String upperCaseText = textBlock.toUpperCase();
            System.out.println("\nUppercase Text:");
            System.out.println(upperCaseText);

            // 4. Extracting a substring
            String substring = textBlock.substring(0, 13); // "Hello, World!"
            System.out.println("\nExtracted Substring:");
            System.out.println(substring);
        }
    }
/**
 * ### Explanation:
 * 1. **Text Block Initialization**: The `textBlock` variable is initialized using a text block, which allows for multi-line string literals.
 * 2. **String Manipulation**:
 *             - **Trim**: Removes leading and trailing whitespace.
 *    - **Replace**: Replaces occurrences of "World" with "Java".
 *             - **Uppercase**: Converts the entire string to uppercase.
 *             - **Substring**: Extracts a specific portion of the string.
 *
 * ### Output:
 *     When you run the above code, you will see the original text block and the results of the string manipulation methods printed to the console.
 */
