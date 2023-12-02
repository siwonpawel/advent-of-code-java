package com.github.siwonpawel.y2023.day02;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeConundrumSolver
{

    public int doFinal(List<String> input)
    {
        return input.stream()
                .mapToInt(this::powerBalls)
                .sum();
    }

    private int powerBalls(String s)
    {
        var collect = Arrays.stream(s.split("[,;]"))
                .map(String::trim)
                .map(this::split)
                .flatMap(Optional::stream)
                .reduce(
                        new HashMap<String, Integer>(),
                        (map, entry) -> {
                            map.merge(entry.getKey(), entry.getValue(), Math::max);
                            return map;
                        },
                        (m1, m2) -> {
                            throw new UnsupportedOperationException("Combining not supported");
                        }
                );

        return collect.values().stream()
                .mapToInt(i -> i)
                .reduce(1, (a, b) -> a * b);
    }

    private Optional<Map.Entry<String, Integer>> split(String s)
    {

        Pattern compile = Pattern.compile("(\\d+) ([A-z]+)");

        Matcher matcher = compile.matcher(s);
        if (matcher.find())
        {
            String group = matcher.group(1);
            String group1 = matcher.group(2);

            return Optional.of(new AbstractMap.SimpleEntry<>(group1, Integer.parseInt(group)));
        }

        return Optional.empty();
    }
}
