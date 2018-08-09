package com.shenpinyi.lorica;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class SolutionTest {

    private Solution mSolution = new Solution();

    @Test
    public void testInputs() {
        Solution.main(new String[] {"17/08/2017", "17/09/2018"});
        Solution.main(new String[] {"17/08/2018", "17/09/2017"});
        Solution.main(new String[] {"17/08/2017", "17/08/2017"});
        Solution.main(new String[] {"17/08/2017", "18/08/2017"});
        Solution.main(new String[] {"17/08/2017", "19/08/2017"});
        Solution.main(new String[] {"02/06/1983", "22/06/1983"});
        Solution.main(new String[] {"04/07/1984", "25/12/1984"});
        Solution.main(new String[] {"03/01/1989", "03/08/1983"});
    }

    @Test
    public void testMissingParams() {
        assertEquals(-1, mSolution.run(new String[]{}));
        assertEquals(-1, mSolution.run(new String[]{"01/01/1901"}));
        assertEquals(-1, mSolution.run(new String[]{"01/01/1901", "31/12/2999", "31/12/2999"}));
    }

    @Test
    public void testDateRange() {
        assertCorrectResultByDates("01/01/1901", "31/12/2999");
        assertFalse( mSolution.getElapsedDays("31/12/1900", "31/12/2999").isPresent());
        assertFalse( mSolution.getElapsedDays("01/01/1900", "01/01/3000").isPresent());
    }

    @Test
    public void testInvalidDateFormat() {
        assertFalse( mSolution.getElapsedDays("17/08/2018", "17/08/3018").isPresent());
        assertFalse( mSolution.getElapsedDays("17/08/2018", "17/08/3018").isPresent());
        assertFalse( mSolution.getElapsedDays("10/032018", "10032018").isPresent());
        assertFalse( mSolution.getElapsedDays("10/03/18", "10/03/18").isPresent());
        assertFalse( mSolution.getElapsedDays("10/20/18", "10/20/18").isPresent());
        assertFalse( mSolution.getElapsedDays("10//03/2018", "10/03/2018").isPresent());
        assertFalse( mSolution.getElapsedDays("10//03/2018", null).isPresent());
    }

    @Test
    public void testSameYearDates() {
        assertCorrectResultByDates("17/08/2018", "17/08/2018");
        assertCorrectResultByDates("17/08/2018", "18/08/2018");
        assertCorrectResultByDates("17/08/2018", "19/08/2018");
    }

    @Test
    public void testMultipleYear() {
        assertCorrectResultByDates("18/08/2018", "17/08/2019");
        assertCorrectResultByDates("19/08/2018", "17/08/2020");
    }

    @Test
    public void testReversedDate() {
        assertCorrectResultByDates("18/08/2018", "17/08/2018");
        assertCorrectResultByDates("19/08/2018", "17/08/2018");
    }

    @Test
    public void testLeapYear() {
        assertCorrectResultByDates("18/08/2015", "17/08/2018");
        assertCorrectResultByDates("18/08/2099", "17/08/2100");
        assertCorrectResultByDates("18/08/2399", "17/08/2400");
    }

    private void assertCorrectResultByDates(String start, String end) {
        assertEquals(getDaysBetween(start, end), mSolution.getElapsedDays(start, end).get().intValue());
    }

    private int getDaysBetween(String dateStart, String dateStop) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(dateStart);
            d2 = format.parse(dateStop);
            DateTime dt1 = new DateTime(d1);
            DateTime dt2 = new DateTime(d2);
            int daysBetween = Math.abs(Days.daysBetween(dt1, dt2).getDays());
            return daysBetween > 1 ? daysBetween - 1 : 0;
        } catch (Exception e) {
            return -1;
        }
    }
}