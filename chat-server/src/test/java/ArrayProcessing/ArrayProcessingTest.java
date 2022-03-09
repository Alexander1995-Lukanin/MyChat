package ArrayProcessing;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



class ArrayProcessingTest {

    @Test
    void sliceArray1() {
        int [] a = new int[] {1, 3, 5, 3, 4, 4, 3, 4, 5, 2};
        int [] result = new int[] {5, 2};
        ArrayProcessing arrayProcessing=new ArrayProcessing();
        Assertions.assertArrayEquals(result,arrayProcessing.sliceArray(a));
    }
    @Test
    void sliceArray2() {
        int [] a = new int[] {1, 3, 5, 1, 1, 1, 1, 1, 5, 2};

        ArrayProcessing arrayProcessing=new ArrayProcessing();
        Assertions.assertThrows(RuntimeException.class, () -> {
            arrayProcessing.sliceArray(a);
        });
    }
    @Test
    void sliceArray3() {
        int [] a = new int[] {1, 3, 5, 3, 4, 4, 4, 3, 5, 2};
        int [] result = new int[] {3,5,2};
        ArrayProcessing arrayProcessing=new ArrayProcessing();
        Assertions.assertArrayEquals(result,arrayProcessing.sliceArray(a));
    }
    @Test
    void hasOneAndFour1() {
        ArrayProcessing arrayProcessing=new ArrayProcessing();
        int [] a = new int[] {4, 3, 1, 3, 2, 2, 2, 2, 5, 2};
        Assertions.assertTrue(arrayProcessing.hasOneAndFour(a));

    }
    @Test
    void hasOneAndFour2() {
        ArrayProcessing arrayProcessing=new ArrayProcessing();
        int [] a = new int[] {1, 1, 1, 1, 4, 4, 4, 3, 5, 2};
        Assertions.assertTrue(arrayProcessing.hasOneAndFour(a));

    }
    @Test
    void hasOneAndFour3() {
        ArrayProcessing arrayProcessing=new ArrayProcessing();
        int [] a = new int[] {2, 3, 5, 3, 2, 2, 2, 2,2 , 2};
        Assertions.assertFalse(arrayProcessing.hasOneAndFour(a));

    }


}