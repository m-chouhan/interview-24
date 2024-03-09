package problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://stackoverflow.com/questions/58173398/efficient-cab-scheduling
 * You want to schedule a certain number of trips with a collection of several cabs.
 * Given an integer n representing a desired number of trips, and an array cabTravelTime representing your cabs and how long it takes each cab (at that index of the array) to make a trip, return the minimum time required to make n trips.
 * Assume that cabs can run simultaneously and there is no waiting period between trips. There may be multiple cabs with the same time cost.*
 * Examples
 * If n=3 and cabTravelTime=[1,2], then the answer is 2. This is because the first cab (index 0, cost 1) can make 2 trips costing a total of 2 time units, and the second cab can make a single trip costing 2 at the same time.
 * n=10
 * cabTravelTime=[1,3,5,7,8]
 * * 7 trips with cab 0 (cost 1)
 * * 2 trips with cab 1 (cost 3)
 * * 1 trip with cab 2 (cost 5)
 * So, answer is 7 (there could be other combinations)
 * */
public class MinimumCabBookingTimeUber {
    class Cab implements Comparable<Cab> {
        int value;
        int time;
        Cab(int value) {
            this.value = value;
            this.time = 0;
        }

        public void updateTime() {
            this.time += value;
        }
        @Override
        public int compareTo(Cab cab) {
            return Integer.compare(time + value, cab.time + cab.value);
        }
    }

    int trips;
    int [] cabTimes;

    int findMinCabBookingTime(int trips, int[] cabTimes) {
        Arrays.sort(cabTimes);
        int low = 0, high = cabTimes[0] * trips;
        this.cabTimes = cabTimes;
        this.trips = trips;
        return binarySearch(low, high);
    }

    int binarySearch(int lowTime, int highTime) {
        if(lowTime == highTime) return lowTime;
        int midTime = (lowTime + highTime) / 2;
        int maxTrips = countMaxTrips(midTime, cabTimes);
        if(maxTrips < trips) return binarySearch(midTime + 1, highTime);
        else return binarySearch(lowTime, midTime);
    }

    int countMaxTrips(int time, int [] cabTimes) {
        int sum = 0;
        for(int cabTime : cabTimes)
            sum += time / cabTime;
        return sum;
    }

    int findMinCabBookingTimeV2(int trips, int[] cabTimes) {
        PriorityQueue<Cab> queue = new PriorityQueue<>();

        for(int cabTime : cabTimes) {
            queue.offer(new Cab(cabTime));
        }

        for(int i = 0; i < trips; ++i) {
            Cab cab = queue.remove();
            cab.updateTime();
            queue.offer(cab);
        }

        int maxTime = Integer.MIN_VALUE;
        for(Cab cab : queue) maxTime = Math.max(cab.time, maxTime);
        return maxTime;
    }
}
