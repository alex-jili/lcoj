/**
   Write a program that outputs the string representation of numbers from 1 to n.
   But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
   For numbers which are multiples of both three and five output “FizzBuzz”.
 */

import java.util.*;


public class fizzBuzz {
    public static void main(String args[]) {

        fizzBuzz a = new fizzBuzz();
        a.testFizzBuzz();
    }

    public List<String> FizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        assert n > 0 : "Input is not valid";
        for(int i = 1; i <= n; i++) {
            if(i % 15 == 0) {
                ret.add("FizzBuzz");
            } else if (i % 3 == 0) {
                ret.add("Fizz");
            } else if(i % 5 == 0) {
                ret.add("Buzz");
            } else {
                ret.add(String.valueOf(i));
            }
        }
        return ret;
    }

    public void testFizzBuzz() {
        for(int testCase = 1; testCase < 101; testCase++) {
            List<String> testResult = FizzBuzz(testCase);
            //System.out.println(testResult.size());

            assert testResult != null;
            assert testResult.size() > 0 : "Return size is zero.";
            for(int item = 0; item < testResult.size(); item++) {
                int idx = item + 1;
                if(idx % 15 == 0) {
                    assert testResult.get(item).equals("FizzBuzz");
                } else if(idx % 3 == 0) {
                    assert testResult.get(item).equals("Fizz");
                } else if(idx % 5 == 0) {
                    assert testResult.get(item).equals("Buzz");
                } else {
                    assert testResult.get(item).equals(String.valueOf(idx));
                }
            }
        }

        System.out.println("test pass");
    }
}
