package com.github.siwonpawel.y2023.day01;

import java.util.List;

import static java.util.function.Predicate.not;

public class Puzzle02Solver implements Solver
{

    private static final String[] LETTER_DIGITS = new String[] {
            "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    @Override
    public int count(List<String> input)
    {
        return input.stream()
                .filter(not(String::isBlank))
                .mapToInt(this::countForLine)
                .sum();
    }

    private int countForLine(String s)
    {
        char[] charArray = s.toCharArray();

        int sum = 0;
        for (int i = 0; i < charArray.length; i++)
        {
            int spelledDigit = getSpelledDigit(s.substring(i));
            if(spelledDigit > 0) {
                sum += spelledDigit * 10;
                break;
            }

            char c = charArray[i];
            if (Character.isDigit(c))
            {
                sum += Character.getNumericValue(c) * 10;
                break;
            }
        }

        for (int i = charArray.length - 1; i >= 0; i--)
        {
            int spelledDigit = getSpelledDigit(s.substring(i, charArray.length));
            if(spelledDigit > 0) {
                sum += spelledDigit;
                break;
            }

            char c = charArray[i];
            if (Character.isDigit(c))
            {
                sum += Character.getNumericValue(c);
                break;
            }
        }

        return sum;
    }

    private int getSpelledDigit(String s) {
        for(int i = 0; i < LETTER_DIGITS.length; i++) {
            if(s.startsWith(LETTER_DIGITS[i])) {
                return i+1;
            }
        }

        return 0;
    }

}
