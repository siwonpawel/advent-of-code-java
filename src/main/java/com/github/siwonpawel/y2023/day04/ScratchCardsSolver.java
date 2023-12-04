package com.github.siwonpawel.y2023.day04;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.github.siwonpawel.Day;

import static java.util.function.Predicate.not;

public class ScratchCardsSolver extends Day
{

    @Override
    public int solvePart1(List<String> input)
    {
        return input.stream()
                .map(Card::new)
                .mapToInt(Card::points)
                .sum();
    }

    @Override
    public int solvePart2(List<String> input)
    {
        return 0;
    }
}

class Card
{

    private Set<Integer> winning;
    private Set<Integer> numbers;

    public Card(String cardText)
    {
        String[] winningAndRandomNumbers = cardText
                .replaceFirst("^Card\\s+\\d+:\\s+", "")
                .split("\\s+\\|\\s+");

        var winningNumbers = Arrays.stream(winningAndRandomNumbers[0].split("\\s+"))
                .map(String::trim)
                .filter(not(String::isBlank))
                .map(Integer::valueOf)
                .sorted()
                .toList();

        var randomNumbers = Arrays.stream(winningAndRandomNumbers[1].split("\\s+"))
                .map(String::trim)
                .filter(not(String::isBlank))
                .map(Integer::valueOf)
                .sorted()
                .toList();

        this.winning = new LinkedHashSet<>(winningNumbers);
        this.numbers = new LinkedHashSet<>(randomNumbers);
    }

    public int points()
    {
        long matches = numbers.stream()
                .filter(winning::contains)
                .count();

        return matches <= 2 ? (int) matches : (int) Math.pow(2, matches - 1D);
    }

}
