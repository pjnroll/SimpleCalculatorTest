package org.farfallettalaviano.simplecalculator;

/**
 * Created by Stefano Farfalletta on 29/11/2017.
 */
import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class ProvaTestRule {
    @Test
    public void addition_test() {
        assertEquals(4, 2+2);
    }
}