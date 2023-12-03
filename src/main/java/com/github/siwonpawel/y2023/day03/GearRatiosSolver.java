package com.github.siwonpawel.y2023.day03;

import java.util.List;

public class GearRatiosSolver
{

    private static final char DOT = '.';

    public int doFinal(List<String> input)
    {
        char[][] parsedLines = parse(input);

        int sum = 0;
        for (int i = 0; i < parsedLines.length; i++)
        {
            int lineLength = parsedLines[i].length;
            for (int j = 0; j < lineLength; j++)
            {
                if (Character.isDigit(parsedLines[i][j]))
                {
                    int number = 0;

                    int start = j;
                    int end = j;
                    while (j < lineLength && Character.isDigit(parsedLines[i][j]))
                    {
                        number = number * 10 + Character.getNumericValue(parsedLines[i][j]);

                        end = j;
                        j++;
                    }

                    if (shouldBeSummed(parsedLines, i, start, end))
                    {
                        sum += number;
                    }
                }
            }
        }

        return sum;
    }

    private boolean shouldBeSummed(char[][] parsedLines, int row, int leftBoundary, int rightBoundary)
    {

        if (leftBoundary > 0)
        {
            leftBoundary--;
        }

        if (rightBoundary < parsedLines[row].length - 1)
        {
            rightBoundary++;
        }

        int upperBoundary = row;
        if (upperBoundary > 0)
        {
            upperBoundary--;
        }

        int lowerBoundary = row;
        if (lowerBoundary < parsedLines.length - 1)
        {
            lowerBoundary++;
        }

        for (int i = upperBoundary; i <= lowerBoundary; i++)
        {
            for (int j = leftBoundary; j <= rightBoundary; j++)
            {
                char c = parsedLines[i][j];
                if (c != DOT && !Character.isDigit(c))
                {
                    return true;
                }
            }
        }

        return false;
    }

    private char[][] parse(List<String> value)
    {
        char[][] c = new char[value.size()][];

        for (int i = 0; i < value.size(); i++)
        {
            c[i] = value.get(i).toCharArray();
        }

        return c;
    }
}
