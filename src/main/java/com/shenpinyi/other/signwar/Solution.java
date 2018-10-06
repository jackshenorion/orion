package com.shenpinyi.other.signwar;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    public void canWin() {
        Map<String, Boolean> wins = new TreeMap<>();
        canWin("000000000", wins, true);
        for(String s : wins.keySet()) {
            System.out.println(s + ":" + wins.get(s));
        }
    }

    private boolean canWin(String game, Map<String, Boolean> wins, boolean positive) {
        if (wins.containsKey(game)) {
            return wins.get(game);
        }
        char[] cells = game.toCharArray();
        int result = getResult(cells);
        if (result != Integer.MIN_VALUE) {
            return positive ? result > 0 : result < 0;
        }
        boolean canWin = false;
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == '0') {
                char[] newCells = cells.clone();
                newCells[i] = positive ? '1' : '-';
                canWin |= !canWin(new String(newCells), wins, !positive);
            }
        }
        wins.putIfAbsent(game, canWin);
        return canWin;
    }

    private int getResult(char[] cells) {

        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == '0') {
                return Integer.MIN_VALUE;
            }
        }
        int n11 = cells[0] == '1' ? 1 : -1;
        int n12 = cells[1] == '1' ? 1 : -1;
        int n13 = cells[2] == '1' ? 1 : -1;
        int n21 = cells[3] == '1' ? 1 : -1;
        int n22 = cells[4] == '1' ? 1 : -1;
        int n23 = cells[5] == '1' ? 1 : -1;
        int n31 = cells[6] == '1' ? 1 : -1;
        int n32 = cells[7] == '1' ? 1 : -1;
        int n33 = cells[8] == '1' ? 1 : -1;

        return n11*n12*n13 + n21*n22*n33 + n31*n32*n33 + n11*n21*n31 + n12*n22*n32 + n13*n23*n33;
    }

    public static void main(String[] args) {
        new Solution().canWin();
    }

}

