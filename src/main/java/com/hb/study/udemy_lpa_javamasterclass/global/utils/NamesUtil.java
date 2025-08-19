package com.hb.study.udemy_lpa_javamasterclass.global.utils;

import com.hb.study.udemy_lpa_javamasterclass.global.constants.CommonConstants;
import com.hb.study.udemy_lpa_javamasterclass.global.models.Name;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

/**
 * created by : heman on 15-08-2025, 12:39 pm, in the "run-pmd.bat" project
 **/
public class NamesUtil {

    private static final SecureRandom secureRandom = new SecureRandom();

    private final List<Name> namesList;

    private final String[] defaultFirstNames = {
            "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
            "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh","Arijit","Aishwarya","Anamika","Amarjot","Amritpal"
    };
    private final String[] defaultLastNames = {
            "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
            "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
    };

    public NamesUtil(int sizeOfNamesList) {
        this.namesList = new ArrayList<>(sizeOfNamesList);
        for (int namesCounter = 0; namesCounter < sizeOfNamesList; namesCounter++) {
            this.namesList.add(generateRandomName());
        }
    }

    public NamesUtil() {
        this(CommonConstants.MAX_ITERATION_COUNT);
    }

    public List<Name> getNamesList() {
        return namesList;
    }

    public static Name generateRandomName(String[]... arrays) {
        final String[] firstNames = {
                "ArjunDev", "Anshuman", "Aryavardhan", "Aarav", "Vihaan", "Ishaan", "Kabir", "Aryan", "Hemant",
                "Anaya", "Myra", "Siya", "Aanya", "Kiara", "Shahrukh","Arijit","Aishwarya","Anamika","Amarjot","Amritpal"
        };
        final String[] lastNames = {
                "Sharma", "Verma", "Patel", "Reddy", "Mehta", "Bellani",
                "Kapoor", "Chopra", "Singh", "Gupta", "Joshi", "Khan"
        };

        String firstName;
        String lastName;
        Name generatedFullName;
        switch (arrays.length) {
            case 1 -> {
                firstName = arrays[0][secureRandom.nextInt(arrays[0].length)];
                lastName = lastNames[secureRandom.nextInt(lastNames.length)];

            }
            case 2 -> {
                firstName = arrays[0][secureRandom.nextInt(arrays[0].length)];
                lastName = arrays[1][secureRandom.nextInt(arrays[1].length)];
            }
            default -> {
                firstName = firstNames[secureRandom.nextInt(firstNames.length)];
                lastName = lastNames[secureRandom.nextInt(lastNames.length)];
            }
        }
        generatedFullName = new Name(firstName, lastName);
        return generatedFullName;
    }

    public static String generateRandomName(int nameMaxLength) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < nameMaxLength; i++) {
            int index = secureRandom.nextInt(CommonConstants.ALBPHABETCARSALLUPPERCASE.length());
            sb.append(CommonConstants.ALBPHABETCARSALLUPPERCASE.charAt(index));
        }
        return sb.toString();
    }

    public String[] getDefaultFirstNames() {
        return defaultFirstNames;
    }

    public String[] getDefaultLastNames() {
        return defaultLastNames;
    }
}
