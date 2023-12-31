// The additive persistence of an integer, n, is the number of times you have to replace n with the sum of its digits until n becomes a single digit integer.
// The multiplicative persistence of an integer, n, is the number of times you have to replace n with the product of its digits until n becomes a single digit integer.
// Create two functions that take an integer as an argument and:
// Return its additive persistence.
// Return its multiplicative persistence.

// Ex:
// additivePersistence(1679583) ➞ 3
// // 1 + 6 + 7 + 9 + 5 + 8 + 3 = 39
// // 3 + 9 = 12
// // 1 + 2 = 3
// // It takes 3 iterations to reach a single-digit number.
// additivePersistence(123456) ➞ 2
// // 1 + 2 + 3 + 4 + 5 + 6 = 21
// // 2 + 1 = 3
// additivePersistence(6) ➞ 0
// // Because 6 is already a single-digit integer.

// multiplicativePersistence(77) ➞ 4
// // 7 x 7 = 49
// // 4 x 9 = 36
// // 3 x 6 = 18
// // 1 x 8 = 8
// // It takes 4 iterations to reach a single-digit number.
// multiplicativePersistence(123456) ➞ 2
// // 1 x 2 x 3 x 4 x 5 x 6 = 720
// // 7 x 2 x 0 = 0
// multiplicativePersistence(4) ➞ 0
// // Because 4 is already a single-digit integer.
package VeryHardChallenges;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Persistence {
    
    public static void main(String[] args) {
        System.out.println(additivePersistence(1679583));
        System.out.println(multiplicativePersistence(123456));

    }

    public static int additivePersistence(int number){

       String n =  IntStream.of(number) 
            .mapToObj(Integer::toString) 
            .collect(Collectors.joining()); 

                        String a = number+"";
                        int count = 0;
                        while (a.length() > 1) {
                            final String originalA = a; 
                            int sum = IntStream.rangeClosed(0, a.length() - 1)
                                    .map(i -> (int) originalA.charAt(i) - '0')
                                    .reduce(0,(g,f)->g+f);
                            a = Integer.toString(sum);
                            count++;
                        
                                }
                                return count;
        
    }

    public static int multiplicativePersistence(int number){

        String a = Integer.toString(number);

        int count =0;
        while(a.length()>1){
            final String b = a;
            int  num = IntStream.rangeClosed(0,a.length()-1).map(i->b.charAt(i)-'0').reduce(1, (n1,n2)->n1*n2);
            a = Integer.toString(num);
            count++;
        }

        return count;

    }
}
