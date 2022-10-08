package at.ac.fhcampuswien.arraySwapper.controller;

public class SwapController {

    public boolean haveSameLength(int[] arrayOne, int[] arrayTwo) {
        return arrayOne.length == arrayTwo.length;
    }

    public void swapArrays(int[] arrayOne, int[] arrayTwo) {
        for (int index = 0; index < arrayOne.length; index++) {
            int integerA = arrayOne[index];
            int integerB = arrayTwo[index];
            arrayOne[index] = integerB;
            arrayTwo[index] = integerA;
        }
    }
}
