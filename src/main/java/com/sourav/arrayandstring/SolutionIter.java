package com.sourav.arrayandstring;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionIter implements Iterable<Integer> {
    Reader input;
    List<Integer> list;
    int currentIndex = 0;

    public SolutionIter(Reader inp) {
        this.input = inp;
        list = new ArrayList<>();
        BufferedReader br = new BufferedReader(input);
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while (line != null) {
            line = line.trim();
            try {
                int elem = Integer.parseInt(line);
                if (elem < 1e9 && elem > -1* 1e9){
                    list.add(elem);
                }
            } catch (NumberFormatException e) {
//                System.out.println("Invalid Input");
            }
            try {
                line = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iterator = new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return currentIndex < list.size();
            }

            @Override
            public Integer next() {
                return list.get(currentIndex++);
            }
        };
        return iterator;
    }


    public static void main(String[] args) throws IOException {
        FileReader input = null;
        input = new FileReader("/Users/300068923/Personal/codingPractice/src/test/java/com/sourav/arrayandstring/input.txt");
        SolutionIter iter = null;
        iter = new SolutionIter(input);

        for (Integer ele : iter) {
            System.out.println(ele);
        }
        input.close();
    }
}
