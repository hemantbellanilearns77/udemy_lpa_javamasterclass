package com.hb.study.demo_stubs;

import com.hb.study.udemylpajavamasterclass.global.utils.ExcecutionUtil;
import com.hb.study.udemylpajavamasterclass.global.utils.ConsoleStyler;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * created by : heman on 24-07-2025, 09:39 am, in the "udemy_lpa_javamasterclass" project
 **/
public class ColorGenerator {
    public static final Random random = new Random();
    //Object level or Static declarations here...
    private static final ExcecutionUtil execution = new ExcecutionUtil();


    public static void main(String[] ignoredArgs) {
        execution.initialize();
        ConsoleStyler.styleInitializationInfo("This and this was initialized and will be used throughout this program demo"); // optional
        // main method initializations.... 
        /*
         *****************************************************
         */
        //your own code here; recommended to divide in function calls
        generateColors(false);
        ConsoleStyler.halfDivider();
        generateBrilliantColors(false);
        ConsoleStyler.halfDivider();
        generateSpecificTypeColors(true);
        ConsoleStyler.halfDivider();
        /*
         *****************************************************
         */
        execution.finalizeExecution();
    }

    private static void generateBrilliantColors(boolean showColorPreview) {


        int count = 0;

        while (count < 270) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);

            // 🎨 Skip overly dark tones (low luminance)
            double luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;
            if (luminance < 100) continue;

            // 🚫 Skip bland grays (low contrast between RGB channels)
            if (Math.abs(r - g) < 10 && Math.abs(g - b) < 10) continue;

            // 🧵 Optional semantic prefix (can be expanded later)
            String prefix = (luminance > 200) ? "PASTEL" :
                    (r > 200 && g < 100) ? "NEON" : "DASH";

            String name = String.format("%s_%d_%d_%d", prefix, r, g, b);
            //String code = String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
            String code = String.format("\\u001B[38;2;%d;%d;%dm", r, g, b); // correctly escaped
            String completeString = name + "(\"" + code + "\"),";

            System.out.println(completeString);
            // 🌈 Optional visual preview (uncomment to display while generating)
            if(showColorPreview) {
                String liveAnsi = String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
                System.out.println(liveAnsi + "█ " + name + "\u001B[0m");
            }
            count++;
        }
    }
    private static void generateColors(boolean showColorPreview) {
        Random random = new Random();
        Set<String> seenPatterns = new HashSet<>();
        int count = 0;

        while (count < 630) {
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);

            double luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;
            if (luminance < 100) continue;
            if (Math.abs(r - g) < 10 && Math.abs(g - b) < 10) continue;

            String prefix = (luminance > 200) ? "PASTEL" :
                    (r > 200 && g < 100) ? "NEON" : "DASH";

            String name = String.format("%s_%d_%d_%d", prefix, r, g, b);
            String literal = String.format("\\u001B[38;2;%d;%d;%dm", r, g, b);
            String enumLine = name + "(\"" + literal + "\"),";

            if (!seenPatterns.add(enumLine)) continue; // adds and checks uniqueness in one go

            System.out.println(enumLine);

            // 🌈 Optional visual preview (uncomment to display while generating)
            if(showColorPreview) {
                String liveAnsi = String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
                System.out.println(liveAnsi + "█ " + name + "\u001B[0m");
            }
            count++;
        }
    }

    public static void generateSpecificTypeColors(boolean showColorPreview) {
        // Pastels: Soft, high-intensity tones
        for (int r = 180; r <= 255; r += 15) {
            for (int g = 180; g <= 255; g += 15) {
                for (int b = 180; b <= 255; b += 15) {
                    String name = String.format("PASTEL_%d_%d_%d", r, g, b);
                    String code = String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
                    System.out.println(name + "(\"" + code + "\"),");
                }
            }
        }

        // Neons: Vivid tones, accent pops
        int[] neonValues = {255, 0, 128, 64, 192};
        for (int r : neonValues) {
            for (int g : neonValues) {
                for (int b : neonValues) {
                    if ((r + g + b) > 500 || (r == 255 && g == 20 && b == 147)) { // heuristics for punchy neons
                        String name = String.format("NEON_%d_%d_%d", r, g, b);
                        String code = String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
                        System.out.println(name + "(\"" + code + "\"),");
                    }
                }
            }
        }

// Midnights: Low-key, atmospheric tones
        for (int r = 0; r <= 80; r += 20) {
            for (int g = 0; g <= 80; g += 20) {
                for (int b = 20; b <= 100; b += 20) {
                    String name = String.format("MIDNIGHT_%d_%d_%d", r, g, b);
                    String code = String.format("\u001B[38;2;%d;%d;%dm", r, g, b);
                    System.out.println(name + "(\"" + code + "\"),");
                }
            }
        }
    }
}
