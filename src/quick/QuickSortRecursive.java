/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package quick;

/**
 *
 * @author pelo
 */
public class QuickSortRecursive
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        int[] testArray = {7,1,5,2,9};

        
        System.out.println("BEFORE -----------------");
        for (int i : testArray)
        {
            System.out.print(" " + i);
        }
        
        testArray = QuickSorting.quickSort(testArray);
        
        System.out.println("AFTER  -----------------");
        for (int i : testArray)
        {
            System.out.print(" " + i);
        }
        
        
        
    }
}
