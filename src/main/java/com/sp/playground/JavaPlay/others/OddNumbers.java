package com.sp.playground.JavaPlay.others;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class OddNumbers {



    // Complete the oddNumbers function below.
    static List<Integer> oddNumbers(int l, int r) {
        List<Integer> oddList = new LinkedList<>();
        if(l%2 == 0) l += 1;
        while(l <= r){
            oddList.add(l);
            l += 2;
        }
        return  oddList;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        int r = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> res = oddNumbers(l, r);
        System.out.println(res.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

//        bufferedWriter.write(
//                res.stream()
//                        .map(Object::toString)
//                        .collect(joining("\n"))
//                        + "\n"
//        );

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
