import org.junit.Test;
import static org.junit.Assert.*;


public class mini_HeapTest {
    @org.junit.Test
    public void main() throws Exception {
        mini_Heap tester = new mini_Heap();
        Integer[] testListing = new Integer[8];
        testListing[0] = -600;
        testListing[1] = 60;
        testListing[2] = 6;
        testListing[3] = -50;
        testListing[4] = 280;
        testListing[5] = 1;
        testListing[6] = 0;
        testListing[7] = 5;
        assertArrayEquals("User expects 280, 60, 6, 5, 1, 0, -50, -600","280, 60, 6, 5, 1, 0, -50, -600", tester.main(testListing.heapSort()));
    }

}