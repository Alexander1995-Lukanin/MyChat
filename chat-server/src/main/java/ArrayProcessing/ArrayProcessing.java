package ArrayProcessing;

import java.util.Arrays;

public class ArrayProcessing {

        public static int[] sliceArray(int[] arr) {
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] == 4) {
                    return Arrays.copyOfRange(arr, i + 1, arr.length);
                }
            }
            throw new RuntimeException("not found 4");
        }

        public static boolean hasOneAndFour(int[] arr) {
            boolean has1 = false;
            boolean has4 = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) {
                    has1 = true;
                }
                else if(arr[i] == 4) {
                    has4 = true;
                }
                else {
                    return false;
                }
            }
            return has1 && has4;
        }
}

