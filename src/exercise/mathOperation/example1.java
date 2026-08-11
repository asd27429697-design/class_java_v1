package exercise.mathOperation;

@FunctionalInterface
interface mathOperation {
    int num(int x, int y);
}


public class example1 {
    public static void main(String[] args) {

       mathOperation num1 = (x, y) -> {
           if (x > y) {
               return x;
           } else {
               return y;
           }
       };

        System.out.println(num1.num(20,10));
    }
}


