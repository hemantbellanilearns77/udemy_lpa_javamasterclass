package com.hb.study.udemylpajavamasterclass.section7_oop_part1.demostubs.allaboutstrings;

import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

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
            ConsoleStyler.styleOutput("Original Text Block:");
            ConsoleStyler.styleOutput(textBlock);

            // Using string manipulation methods
            // 1. Trimming whitespace
            String trimmedText = textBlock.trim();
            ConsoleStyler.styleOutput("\nTrimmed Text:");
            ConsoleStyler.styleOutput(trimmedText);

            // 2. Replacing a substring
            String replacedText = textBlock.replace("World", "Java");
            ConsoleStyler.styleOutput("\nReplaced Text:");
            ConsoleStyler.styleOutput(replacedText);

            // 3. Converting to uppercase
            String upperCaseText = textBlock.toUpperCase();
            ConsoleStyler.styleOutput("\nUppercase Text:");
            ConsoleStyler.styleOutput(upperCaseText);

            // 4. Extracting a substring
            String substring = textBlock.substring(0, 13); // "Hello, World!"
            ConsoleStyler.styleOutput("\nExtracted Substring:");
            ConsoleStyler.styleOutput(substring);
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
