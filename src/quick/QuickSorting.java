/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quick;

import java.util.Arrays;

/**
 *
 * @author pelo
 */
public class QuickSorting
{
    public static final boolean DEBUG_ON = false;
    
    public static int[] quickSort(int[] messy)
    {
        int[] result = messy;
        int[] right = new int[0];
        int[] left = new int[0];
        int pivotIndex = 0;
        int pivotValue = 0;
        int[] pivotArray = new int[1];
        //2) Sort all the other numbers accordin to the pivot
        //2.1) Smaller than to the left
        //2.2) Greateer than to the right

        //If you only have one element, then ....just return that.
        if (messy.length <= 1)
        {
            result = messy;
        } else
        {
            pivotIndex = messy.length / 2;
            if(DEBUG_ON) { System.out.println("Messy: " + Arrays.toString(messy) + ". PivotIndex: " + pivotIndex); }
            pivotValue = messy[ pivotIndex]; //1) pick a pivot element
            pivotArray[0] = pivotValue;

            for (int i = 0; i < messy.length; i++)
            {
                if (i == pivotIndex) //We hit the pivot index. This value should not be sorted anywere 
                {
                } else if (messy[i] > pivotValue) //Greater than the pivot and we sort right
                {
                    right = Arrays.copyOf(right, right.length+1);  //Increasing the array by 1
                    right[ right.length - 1] = messy[i]; //Inserting the current value in the last position in the left array                                       
                } else if (messy[i] < pivotValue) //It is less than the pivot, so sort left
                {
                    left = Arrays.copyOf(left, left.length+1);  //Increasing the array by 1
                    left[ left.length - 1] = messy[i]; //Inserting the current value in the last position in the left array                    
                }

            }
            //Sort the left and right array:
            left = quickSort(left);
            right = quickSort(right);
            
            //Sticking the array together: First the left and pivot array, then with the right arrray
            int[] temp_LeftAndPivot = concatInt(left,pivotArray) ;
            result = concatInt(temp_LeftAndPivot, right);  //Ready to be returned.
        }
        return result;    
    }

    /**
     *  Method simply merges 2 arrays.
     * Method found 13.12.2013 here:
     * http://stackoverflow.com/questions/80476/how-to-concatenate-two-arrays-in-java
     * @param <T>
     * @param first
     * @param second
     * @return
     */
    public static <T> T[] concat(T[] first, T[] second)
    {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
    
    /**
     * Method simply merges 2 arrays.
     * Method found 13.12.2013 here:
     * http://stackoverflow.com/questions/80476/how-to-concatenate-two-arrays-in-java
     * @param first
     * @param second
     * @return
     */
    public static int[] concatInt(int[] first, int[] second)
    {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
