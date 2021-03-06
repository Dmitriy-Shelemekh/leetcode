package two_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {
    private static final int REPEAT_TIMES = 20_000_000;

    private int[] ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private int target = 5;
    private Solution solution;
    private int[] expected = new int[]{0, 3};

    @Test
    public void solutionOneTest() {
        solution = new SolutionOne();

        int[] actual = runWithPerformanceMeter(solution);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void solutionTwoTest() {
        solution = new SolutionTwo();

        int[] actual = runWithPerformanceMeter(solution);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void solutionTreeTest() {
        solution = new SolutionTree();

        int[] actual = runWithPerformanceMeter(solution);

        Assertions.assertArrayEquals(expected, actual);
    }

    private int[] runWithPerformanceMeter(Solution solution) {
        int[] array = new int[]{};
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < REPEAT_TIMES; i++) {
            array = solution.twoSum(ints, target);
        }

        long endTime = System.currentTimeMillis();
        System.out.println((double) (endTime - startTime / REPEAT_TIMES));

        return array;
    }
}