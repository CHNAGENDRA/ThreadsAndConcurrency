package forkjoinframework;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import static java.util.concurrent.ForkJoinTask.invokeAll;

public class MultiplesCalculator extends RecursiveTask<Integer> {

    private List<Integer> numbers;
    public static int threshold;
    public static int multipleOf;

    public MultiplesCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    /* Override the compute() method with the implementation for calculating multiples here
       i.e. divide and conquer mechanism based on the threshold value
     */
    @Override
    protected Integer compute() {
        if(numbers.size() <= threshold) {
            int count = computeDirectly();
            System.out.format("Number of multiples of %d in %s: %d\n", multipleOf, numbers.toString(), count);
            return count;
        } else {
            int mid = numbers.size() / 2;
            MultiplesCalculator subTask1 = new MultiplesCalculator(numbers.subList(0, mid));
            MultiplesCalculator subTask2 = new MultiplesCalculator(numbers.subList(mid, numbers.size()));

            invokeAll(subTask1, subTask2);

            return subTask1.join() + subTask2.join();
        }
    }


    protected int computeDirectly() {
        int count = 0;
        for (Integer n: numbers) {
            if (n % multipleOf == 0) {
                count +=1;
            }
        }
        return count;
    }
}
