import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*** Question: Given a sorted array of elements, convert the list to a Binary Search Tree. 
**/
public class SortedArrayToBST {
    public static void main( String[] args ) {
        List<Integer> list = new ArrayList<Integer>( Arrays.asList( new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8 } ) );

        Node<Integer> root = toBST( list );
        root.print( );
    }

    public static <T>Node<T> toBST( List<T> list ) {
        return toBST( list, 0, list.size( ) - 1 );
    }

    private static <T>Node<T> toBST( List<T> list, int low, int high ) {
        if ( low > high ) {
            return null;
        }
        int median = low + (high - low) / 2;

        Node<T> root = new Node<T>( list.get( median ) );
        root.left = toBST( list, low, median - 1 );
        root.right = toBST( list, median + 1, high );
        return root;
    }

    private static class Node<T> {
        Node<T> left, right;
        T value;

        public Node( T value ) {
            this.value = value;
        }

        public void print( ) {
            if ( left != null ) {
                left.print( );
            }
            System.out.println( value );

            if ( right != null ) {
                right.print( );
            }

        }
    }
}
