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

public class Queens {

    private int n;
    private Consumer<int[]> solution;

    public static void solve(int n, Consumer<int[]> solution) {
        new Queens(n, solution).solve();
    }

    private Queens(int n, Consumer<int[]> solution) {
        if (n <= 0) {
            throw new IllegalStateException("Positive N expected");
        }
        this.n = n;
        this.solution = solution;
    }

    private void solve() {
        solve(new int[n], 0);
    }

    private void solve(int[] q, int k) {
        if (k == n) {
            //solution found.
            solution.accept(q);
            return;
        }
        for (int i = 0; i < n; i++) {
            q[k] = i;
            if (valid(q, k)) {
                solve(q, k + 1);
            }
        }
    }

    private boolean valid(int[] q, int k) {
        for (int i = 0; i < k; i++) {
            if (q[i] == q[k]) {
                //same column
                return false;
            }
            if (Math.abs(q[k] - q[i]) == (k - i)) {
                //diagonal
                return false;
            }
            for (int j = i + 1; j < k; j++) {
                if (((q[j] - q[i]) * (k - i)) == (q[k] - q[i]) * (j - i)) {
                    //i, j, k on same line
                    return false;
                }
            }
        }
        return true;
    }

}
