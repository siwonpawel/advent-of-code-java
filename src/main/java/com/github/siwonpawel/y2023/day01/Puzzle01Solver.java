package com.github.siwonpawel.y2023.day01;

import java.util.List;

import static java.util.function.Predicate.not;

public class Puzzle01Solver
{

    public int count(List<String> input) {
        return input.stream()
                .filter(not(String::isBlank))
                .mapToInt(this::countForLine)
                .sum();
    }

    private int countForLine(String s)
    {
        char[] charArray = s.toCharArray();

        int sum = 0;
        for(int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if(Character.isDigit(c)) {
                sum += Character.getNumericValue(c) * 10;
                break;
            }
        }

        for(int i = charArray.length-1; i >= 0; i--) {
            char c = charArray[i];

            if(Character.isDigit(c)) {
                sum += Character.getNumericValue(c);
                break;
            }
        }

        return sum;
    }

}
