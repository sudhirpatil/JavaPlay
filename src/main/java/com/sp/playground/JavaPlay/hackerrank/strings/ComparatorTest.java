package com.sp.playground.JavaPlay.hackerrank.strings;

import java.util.*;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

/**
 * To compare 2 objects implement Comparator & override compare method
 */
class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
        int retVal = 0;
        if(a.score < b.score ) retVal = 1;
        else if (a.score == b.score) {
            retVal = a.name.compareTo(b.name);
        }
        else if (a.score > b.score) retVal = -1;

        return retVal;
    }
}


public class ComparatorTest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        // Sort array using Arrays & comparator
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
