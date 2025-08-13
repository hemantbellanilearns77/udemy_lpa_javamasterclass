package com.hb.study.udemy_lpa_javamasterclass.section_practice.demo_stubs;

import com.hb.study.udemy_lpa_javamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemy_lpa_javamasterclass.global.utils.ConsoleStyler;

import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Set;

/**
 * created by : heman on 24-07-2025, 09:39 am, in the "udemy_lpa_javamasterclass" project
 **/
public class ColorGenerator {
    public static final SecureRandom secureRandom = new SecureRandom();
    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();
    private static final String COLOR_CODE_ESCAPE_SEQUENCE_ONE = "\u001B[38;2";
    private static final String COLOR_CODE_ESCAPE_SEQUENCE_TWO = "\\u001B[38;2;";
    private static final String FORMAT_SPECIFIER_STRING_ONE = ";%d;%d;%dm";
    private static final String FORMAT_SPECIFIER_STRING_TWO =  "%d;%d;%dm";
    public static final String ANSICOLORPREVIEWSUFFIX = "\u001B[0m";

    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional

        generateColors(false);
        ConsoleStyler.halfDivider();
        generateBrilliantColors(false);
        ConsoleStyler.halfDivider();
        generateSpecificTypeColors(true);
        ConsoleStyler.halfDivider();

        execution.finalizeExecution();
    }

    private static void generateBrilliantColors(boolean showColorPreview) {

        int count = 0;

        while (count < 270) {
            int r = secureRandom.nextInt(256);
            int g = secureRandom.nextInt(256);
            int b = secureRandom.nextInt(256);

            // 🎨 Skip overly dark tones (low luminance)
            // and
            // 🚫 Skip bland grays (low contrast between RGB channels)
            double luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;
            if ( (luminance < 100) || (Math.abs(r - g) < 10 && Math.abs(g - b) < 10) ) continue;

            // 🧵 Optional semantic prefix (can be expanded later)
            String prefix = (luminance > 200) ? "PASTEL" : getSemanticPrefix(r, g);
            String name = String.format("%s_%d_%d_%d", prefix, r, g, b);
            String code = COLOR_CODE_ESCAPE_SEQUENCE_TWO + String.format(FORMAT_SPECIFIER_STRING_ONE, r, g, b); // correctly escaped
            String completeString = name + "(\"" + code + "\"),";

            ConsoleStyler.styleOutput(null,completeString);
            // 🌈 Optional visual preview (uncomment to display while generating)
            if(showColorPreview) {
                String liveAnsi = COLOR_CODE_ESCAPE_SEQUENCE_ONE+ String.format(FORMAT_SPECIFIER_STRING_ONE, r, g, b);

                ConsoleStyler.styleOutput(null,liveAnsi + "█ " + name + ANSICOLORPREVIEWSUFFIX);
            }
            count++;
        }
    }
    private static void generateColors(boolean showColorPreview) {

        Set<String> seenPatterns = new HashSet<>();
        int count = 0;

        while (count < 630) {
            int r = secureRandom.nextInt(256);
            int g = secureRandom.nextInt(256);
            int b = secureRandom.nextInt(256);

            double luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;

            String prefix = (luminance > 200) ? "PASTEL" : getSemanticPrefix(r, g);

            String name = String.format("%s_%d_%d_%d", prefix, r, g, b);
            String literal = COLOR_CODE_ESCAPE_SEQUENCE_TWO + String.format(FORMAT_SPECIFIER_STRING_TWO, r, g, b);
            String enumLine = name + "(\"" + literal + "\"),";
            if (isSkippable(luminance, r, g, b, seenPatterns, enumLine) ) continue;

            ConsoleStyler.styleOutput(null,enumLine);

            // 🌈 Optional visual preview (uncomment to display while generating)
            if(showColorPreview) {
                String liveAnsi = COLOR_CODE_ESCAPE_SEQUENCE_ONE + String.format(FORMAT_SPECIFIER_STRING_ONE, r, g, b);

                ConsoleStyler.styleOutput(null,liveAnsi + "█ " + name + ANSICOLORPREVIEWSUFFIX);
            }
            count++;
        }
    }

    private static boolean isSkippable(double luminance, int r, int g, int b, Set<String> seenPatterns, String enumLine) {
        return (luminance < 100 ||
                (Math.abs(r - g) < 10 && Math.abs(g - b) < 10) ||
                // adds and checks uniqueness in one go
                !seenPatterns.add(enumLine));
    }


    public static void generateSpecificTypeColors(boolean showColorPreview) {
        generatePastels(showColorPreview);

        generateNeons(showColorPreview);

        generateMidnights(showColorPreview);
    }

    private static void generateMidnights(boolean showColorPreview) {
        // Midnights: Low-key, atmospheric tones
        for (int r = 0; r <= 80; r += 20) {
            for (int g = 0; g <= 80; g += 20) {
                for (int b = 20; b <= 100; b += 20) {
                    String name = String.format("MIDNIGHT_%d_%d_%d", r, g, b);
                    String code = COLOR_CODE_ESCAPE_SEQUENCE_ONE + String.format(FORMAT_SPECIFIER_STRING_ONE, r, g, b);
                    ConsoleStyler.styleOutput(null,name + "(\"" + code + "\"),");
                    if(showColorPreview) {
                        ConsoleStyler.styleOutput(null,code + "█ " + name + ANSICOLORPREVIEWSUFFIX);
                    }
                }
            }
        }
    }

    private static void generateNeons(boolean showColorPreview) {
        // Neons: Vivid tones, accent pops
        int[] neonValues = {255, 0, 128, 64, 192};
        for (int r : neonValues) {
            for (int g : neonValues) {
                for (int b : neonValues) {
                    if (isHeuristicSatisfied(r,g,b)) { // heuristics for punchy neons
                        String name = String.format("NEON_%d_%d_%d", r, g, b);
                        String code = COLOR_CODE_ESCAPE_SEQUENCE_ONE + String.format(FORMAT_SPECIFIER_STRING_ONE, r, g, b);
                        ConsoleStyler.styleOutput(null,name + "(\"" + code + "\"),");
                        if(showColorPreview) {
                            ConsoleStyler.styleOutput(null,code + "█ " + name + ANSICOLORPREVIEWSUFFIX);
                        }
                    }
                }
            }
        }
    }

    private static boolean isHeuristicSatisfied(int r, int g, int b) {

        return ( ((r + g + b) > 500 )|| (r == 255 && g == 20 && b == 147));
    }

    private static void generatePastels(boolean showColorPreview) {
        // Pastels: Soft, high-intensity tones
        for (int r = 180; r <= 255; r += 15) {
            for (int g = 180; g <= 255; g += 15) {
                for (int b = 180; b <= 255; b += 15) {
                    String name = String.format("PASTEL_%d_%d_%d", r, g, b);
                    String code = COLOR_CODE_ESCAPE_SEQUENCE_ONE + String.format(FORMAT_SPECIFIER_STRING_ONE, r, g, b);
                    ConsoleStyler.styleOutput(null,name + "(\"" + code + "\"),");
                    if(showColorPreview) {
                        ConsoleStyler.styleOutput(null,code + "█ " + name + ANSICOLORPREVIEWSUFFIX);
                    }
                }
            }
        }
    }

    private static String getSemanticPrefix(int r, int g) {
        return (r > 200 && g < 100) ? "NEON" : "DASH";
    }
}
