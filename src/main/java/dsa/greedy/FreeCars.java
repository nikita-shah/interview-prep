package dsa.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.PriorityQueue;

public class FreeCars {
    int modVal = (int)1e9+7;
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        long profit = 0;
        int time =  0;
        ArrayList<CarBuyInfo>carChoices = new ArrayList<>();
        for(int i=0;i<A.size();i++)
        {
            CarBuyInfo car = new CarBuyInfo(A.get(i),B.get(i));
            carChoices.add(car);
        }

        carChoices.sort((car1, car2) -> car1.time - car2.time);

        PriorityQueue<CarBuyInfo>pq = new PriorityQueue<CarBuyInfo>((car1,car2)->car1.profit-car2.profit);

        for(int i=0;i<A.size();i++)
        {
            CarBuyInfo car = carChoices.get(i);
            if(time < car.time)
            {
                //take this and add it in the heap
                profit += car.profit;
                pq.add(car);
                time++;
            }
            else
            {
                //check if you have selected a lower profit
                //if so delete that and select this
                Optional<CarBuyInfo> selectedCar  = Optional.ofNullable(pq.peek());
                if(selectedCar.isPresent()) {
                    CarBuyInfo minProfitCar = pq.poll();
                    if (minProfitCar.profit < (car).profit) {
                        profit -= minProfitCar.profit;
                        pq.add(car);
                        profit+=car.profit;
                    }
                }
            }
        }

        return (int)profit%modVal;
    }

    public static void main(String args[])
    {
        FreeCars fc = new FreeCars();
        ArrayList<Integer> times = new ArrayList<>(Arrays.asList(1, 3, 2, 3, 3));
        ArrayList<Integer> profit = new ArrayList<>(Arrays.asList(5, 6, 1, 3, 9));
        System.out.println(fc.solve(times,profit));
    }


}
class CarBuyInfo
{
    int time;
    int profit;
    CarBuyInfo(int time, int profit)
    {
        this.time = time;
        this.profit = profit;
    }
    public String toString()
    {
        return "time:"+time+"profit:"+profit;
    }
}