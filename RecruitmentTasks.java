package com.sabre.sswtest.devtest.defects.la;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class RecruitmentTasks
{
    @Test
    public void test()
    {
        /*rosettaStone("Hola Mundo\n"
                + "    \n"
                + "Mundo|World\n"
                + "    \n"
                + "Lunes|Monday\n"
                + "Hola|Hello");*/
        pascalsTriangle(6);
    }

    private void rosettaStone(String input)
    {
        List<String> sentenceToTranslate = Arrays
                .stream(input
                .split("\\n")[0]
                .split("\\s"))
                .collect(Collectors.toList());
        HashMap<String, String> dictionary = new HashMap<>();
        Arrays.stream(input
                .split("\n"))
                .collect(Collectors.toList())
                .stream()
                .filter(lst -> lst.contains("|"))
                .forEach(lst -> dictionary
                        .put(lst.split("\\|")[0],
                                lst.split("\\|")[1]));
        for(String s : sentenceToTranslate)
        {
            if(dictionary.containsKey(s))
                System.out.print(dictionary.get(s).trim() + " ");
        }
    }

    private void pascalsTriangle(int depth)
    {
        for (int i = 0; i < depth; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                printPascal(pascalsRecurrence(i,j));
            }
            System.out.println();
        }
    }

    private void printPascal(int number)
    {
        System.out.print(number + " ");
    }

    private int pascalsRecurrence(int v, int c)
    {
        if(c==v|| c==0)
            return 1;
        return pascalsRecurrence(v-1,c-1) + pascalsRecurrence(v-1,c);
    }
}
