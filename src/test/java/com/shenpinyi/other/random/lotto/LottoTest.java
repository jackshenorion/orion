package com.shenpinyi.other.random.lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jack on 31/03/2017.
 */
public class LottoTest {

    @Test
    public void testGenerate() throws Exception {
        System.out.print(Lotto.generate(45, 6, 8145060));
    }
}