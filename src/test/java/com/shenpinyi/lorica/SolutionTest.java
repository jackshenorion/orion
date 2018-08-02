package com.shenpinyi.lorica;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testInputs() {
        Solution.main(new String[] {"diff", "17/08/2017", "17/09/2018"});
        Solution.main(new String[] {"diff", "17/08/2018", "17/09/2017"});
        Solution.main(new String[] {"diff", "17/08/2017", "17/08/2017"});
        Solution.main(new String[] {"diff", "17/08/2017", "18/08/2017"});
        Solution.main(new String[] {"diff", "17/08/2017", "19/08/2017"});
        Solution.main(new String[] {"diff", "02/06/1983", "22/06/1983"});
        Solution.main(new String[] {"diff", "04/07/1984", "25/12/1984"});
        Solution.main(new String[] {"diff", "03/01/1989", "03/08/1983"});
    }
}