public class thirdChallenge {
    public static int sumOfNums(int num, int sum){
        if (num == 0) {
            return sum;
        }
        return sumOfNums(num - 1, sum + num);
    };
    
    public static void main(String[] args) {
        System.out.println(sumOfNums(4, 0));
    }
}
