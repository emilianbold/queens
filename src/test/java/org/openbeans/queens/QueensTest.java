/**
 * Copyright (c) 2020 Emilian Marius Bold
 *
 * Permission to use, copy, modify, and distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 *
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */
package org.openbeans.queens;

import java.util.function.Consumer;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class QueensTest {
    
    @Test(expected = IllegalStateException.class)
    public void negativeTest() {
        Queens.solve(0, (x) -> {});
    }
    
    @Test
    public void solveTest() {
        assertEquals(1, countSolutions(1));
        assertEquals(0, countSolutions(5));
    }

    private int countSolutions(int n) {
        int[] total = new int[1];
        Consumer<int[]> counter = (t) -> {
            total[0]++;
        };
        Queens.solve(n, counter);
        
        return total[0];
    }
    
}
