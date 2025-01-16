// Honor Code: By doing this assignment and submitting, I pledge that this submission is solely my own work, and it is not a copy or partial copy from anywhere.

public class LargerThanN {
    public static void findLength(int[] array, int num) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > num) {
                System.out.println(array[i]);
            }
        }   
    }
    
    public static void main(String[] args) {
        int[] array1 = {1, 5, 10, 2, 4, -3, 6};
        int[] array2 = {10, 12, 15, 24};
        findLength(array1, 3);
        findLength(array2, 12);
    }
}
