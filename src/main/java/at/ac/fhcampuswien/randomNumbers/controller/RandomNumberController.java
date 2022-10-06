package at.ac.fhcampuswien.randomNumbers.controller;

public class RandomNumberController {

    private final int COUNT_OF_NUMBERS_IN_RETURN_ARRAY = 10;
    private final int FACTOR = 1103515245;
    private final int INCREMENT = 12345;
    private final long MODUL = (long) Math.pow(2, 31);

    public long[] getRandomNumbers(long seed) {
        long[] result = new long[COUNT_OF_NUMBERS_IN_RETURN_ARRAY];
        long computedSeed = seed;
        for (int count = 0; count < COUNT_OF_NUMBERS_IN_RETURN_ARRAY; count++) {
            computedSeed = calculateNumber(computedSeed);
            result[count] = computedSeed;
        }
        return result;
    }

    private long calculateNumber(long seed) {
        long result = (FACTOR * seed + INCREMENT) % MODUL;
        return result;
    }
}
