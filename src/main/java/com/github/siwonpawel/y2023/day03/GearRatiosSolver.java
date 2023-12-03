package com.github.siwonpawel.y2023.day03;

import java.util.List;

public class GearRatiosSolver
{

    private static final char GEAR = '*';

    public int doFinal(List<String> input)
    {
        char[][] parsedLines = parse(input);

        int sum = 0;
        for (int i = 0; i < parsedLines.length; i++)
        {
            for (int j = 0; j < parsedLines[i].length; j++)
            {
                sum += getGearRatio(parsedLines, i, j);
            }
        }

        return sum;
    }

    private static int getGearRatio(char[][] parsedLines, int row, int col)
    {
        if (GEAR != parsedLines[row][col])
        {
            return 0;
        }

        if (!hasTwoPartNumbers(parsedLines, row, col))
        {
            return 0;
        }

        return computeGearRatio(parsedLines, row, col);
    }

    private static int computeGearRatio(char[][] parsedLines, int row, int col)
    {
        int upperBound = row;
        if (upperBound > 0)
        {
            upperBound--;
        }

        int lowerBound = row;
        if (lowerBound < parsedLines.length - 1)
        {
            lowerBound++;
        }

        int leftBound = col;
        if (leftBound > 0)
        {
            leftBound--;
        }

        int rightBound = col;
        if (rightBound < parsedLines[row].length - 1)
        {
            rightBound++;
        }

        int multi = 1;
        for (int i = upperBound; i <= lowerBound; i++)
        {
            for (int j = leftBound; j <= rightBound; j++)
            {
                if (Character.isDigit(parsedLines[i][j]))
                {

                    int start = j;
                    while (start > 0)
                    {
                        if (Character.isDigit(parsedLines[i][start - 1]))
                        {
                            start--;
                        }
                        else
                        {
                            break;
                        }
                    }

                    while (j < parsedLines[i].length)
                    {
                        if (!Character.isDigit(parsedLines[i][j]))
                        {
                            break;
                        }

                        j++;
                    }

                    int tmp = 0;
                    for (; start < j; start++)
                    {
                        tmp = tmp * 10 + Character.getNumericValue(parsedLines[i][start]);
                    }

                    multi *= tmp;
                }
            }

        }

        return multi;
    }

    private static boolean hasTwoPartNumbers(char[][] parsedLines, int row, int col)
    {
        int upperBound = row;
        if (upperBound > 0)
        {
            upperBound--;
        }

        int lowerBound = row;
        if (lowerBound < parsedLines.length - 1)
        {
            lowerBound++;
        }

        int leftBound = col;
        if (leftBound > 0)
        {
            leftBound--;
        }

        int rightBound = col;
        if (rightBound < parsedLines[row].length - 1)
        {
            rightBound++;
        }

        int numbersCount = 0;
        for (int i = upperBound; i <= lowerBound; i++)
        {
            boolean changed = false;
            for (int j = leftBound; j <= rightBound; j++)
            {
                boolean isDigit = Character.isDigit(parsedLines[i][j]);
                if (isDigit && !changed)
                {
                    numbersCount++;
                    changed = !changed;
                }
                else if (!isDigit && changed)
                {
                    changed = !changed;
                }
            }
        }

        return numbersCount == 2;
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
