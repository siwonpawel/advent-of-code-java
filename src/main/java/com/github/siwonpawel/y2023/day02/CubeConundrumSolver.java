package com.github.siwonpawel.y2023.day02;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CubeConundrumSolver
{

    private static final String RED = "red";
    private static final String GREEN = "green";
    private static final String BLUE = "blue";

    private static final Map<String, Integer> MAX_NUMBERS = Map.of(
            RED, 12,
            GREEN, 13,
            BLUE, 14
    );

    public int doFinal(List<String> input)
    {
        return input.stream()
                .filter(this::isGameCorrect)
                .mapToInt(this::getGameId)
                .sum();
    }

    private boolean isGameCorrect(String s)
    {
        return Arrays.stream(s.split(":")[1].split(";"))
                .noneMatch(this::isSetIncorrect);
    }

    private boolean isSetIncorrect(String s)
    {
        var collect = Arrays.stream(s.split(","))
                .map(String::trim)
                .map(this::split)
                .flatMap(Optional::stream)
                .toList();

        for(var e : collect) {
            var maxValue = MAX_NUMBERS.get(e.getKey());

            if(maxValue < e.getValue()) {
                return true;
            }
        }

        return false;
    }

    private Optional<Map.Entry<String, Integer>> split(String s)
    {

        Pattern compile = Pattern.compile("(\\d+) ([A-z]+)");

        Matcher matcher = compile.matcher(s);
        if(matcher.find()) {
            String group = matcher.group(1);
            String group1 = matcher.group(2);

            return Optional.of(new AbstractMap.SimpleEntry<>(group1, Integer.parseInt(group)));
        }

        return Optional.empty();
    }

    private int getGameId(String s)
    {
        Pattern compile = Pattern.compile("Game (\\d+).+");
        Matcher matcher = compile.matcher(s);
        if(matcher.find())
        {
            String group = matcher.group(1);

            return Integer.valueOf(group);
        }

        return 0;
    }
}
