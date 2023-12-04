package com.github.siwonpawel.y2023.day04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
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
        List<Card> cards = input.stream()
                .map(Card::new)
                .toList();

        Map<Integer, Integer> copiesOfCards = new HashMap<>();

        for (var c : cards)
        {
            int i = cards.indexOf(c);
            Integer numberOfCopies = copiesOfCards.getOrDefault(i, 0) + 1;
            int points = c.matches();

            while (points > 0)
            {
                copiesOfCards.merge(i + points, numberOfCopies, Integer::sum);
                points--;
            }
            copiesOfCards.merge(i, 1, Integer::sum);
        }

        return copiesOfCards.values().stream().mapToInt(i -> i).sum();
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

    public int matches()
    {
        return (int) numbers.stream()
                .filter(winning::contains)
                .count();
    }

    public int points()
    {
        int matches = matches();

        return matches <= 2 ? matches : (int) Math.pow(2, matches - 1D);
    }

}
