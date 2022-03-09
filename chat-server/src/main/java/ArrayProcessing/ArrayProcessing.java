package ArrayProcessing;

import java.util.Arrays;
//HM-6
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
            boolean has = false;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1 || arr[i] == 4) {
                    has=true;
                    break;
                }
                else continue;
            }
             return has;
        }
}

