import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // lower half: maz heap
        PriorityQueue<Integer> lower = new PriorityQueue<>(Collections.reverseOrder());

        // upper half: min heap
        PriorityQueue<Integer> upper = new PriorityQueue<>();

        for(int i = 0; i < n; i++)
        {
            int x = sc.nextInt();

            //Step 1: insert into correct heap
            if(lower.isEmpty() || x <= lower.peek())
            {
                lower.add(x);
            }else{
                upper.add(x);
            }

            //Step 2: rebalance so sizes differ by at most 1
            if(lower.size() > upper.size()+1)
            {
                upper.add(lower.poll());
            }else if (upper.size() > lower.size() +1) {
                lower.add(upper.poll());
            }

            //Step 3: compute median
            double median;
            if(lower.size() == upper.size())
            {
                median = (lower.peek() + upper.peek()) / 2.0;
            }else if (lower.size() > upper.size()) {
                median = lower.peek();
            }else{
                median = upper.peek();
            }

            System.out.println(median);
        }

        sc.close();
    }
}
