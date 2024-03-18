package problems;

/*
Parking in Uber inspection centers: Uber has vehicle inspection centers to inspect the quality of all new vehicles
signing up to join the platform. As an Inspector in one of these Inspection centers you’re now charged to manage
the vehicles coming in and leaving the inspection center.
Being a smart engineer you are, you’ve figured that you prefer to keep as much distance as possible
between two vehicles to ease the inspection and avoid nuisance.

You can assume that the parking lot is a straight line of individual parking spaces each numbered from 1 to N.
As each vehicle comes in you want to assign it a parking spot. (For e.g. -  you assigned parking space 1 to
the very first car now to maximize the distance you’d assign the next car to space N.)
The next car now could be in the space N/2. (Whenever there are two positions each maximizing the distance
we will prefer the one with a smaller index.).Your problem now is to figure out the position at which the next
incoming car should park. You can assume that the parking lot was empty when you started.
Extended requirement - You realize that your algorithm is not complete as some of the vehicles have now
started to leave the parking lot once their inspection is complete.
How would you modify your algorithm to take this into account?

*/

import java.util.PriorityQueue;

public class MaxDistanceForBookingCab {

    class Segment implements Comparable<Segment> {
        int startIndex, length;
        Segment(int startIndex, int length) {
            this.startIndex = startIndex;
            this.length = length;
        }

        public int lastIndex() {
            // 0 indexed
            return startIndex + length - 1;
        }

        Segment[] split() {
            int midPoint = startIndex + length / 2;
            Segment s1 = new Segment(startIndex, length / 2);
            Segment s2 = new Segment(midPoint, length - length / 2);
            return new Segment[]{s1, s2};
        }

        @Override
        public int compareTo(Segment o) {
            if(length == o.length) return Integer.compare(startIndex, o.startIndex);
            return Integer.compare(o.length, length);
        }
    }

    Segment[] parkings;
    PriorityQueue<Segment> queue = new PriorityQueue<>();

    MaxDistanceForBookingCab(final int N) {
        parkings = new Segment[N];
        queue.offer(new Segment(0, N));
    }

    public int next() {
        Segment segment = queue.peek();
        if(parkings[segment.startIndex] == null) {
            parkings[segment.startIndex] = segment;
            return segment.startIndex;
        }
        else if(parkings[segment.lastIndex()] == null) {
            parkings[segment.lastIndex()] = segment;
            return segment.lastIndex();
        }

        queue.remove();
        Segment[] segments = segment.split();
        insertSegment(segments[0]);
        insertSegment(segments[1]);
        return segments[1].startIndex;
    }

    void insertSegment(Segment segment) {
        parkings[segment.startIndex] = segment;
        parkings[segment.lastIndex()] = segment;
        queue.offer(segment);
    }

    public void remove(int index){
        if(parkings[index] == null) return;
        Segment segment = parkings[index];
        if(segment.startIndex == index) {
            Segment previousSegment = findPreviousSegment(index);
            queue.remove(segment);
            queue.remove(previousSegment);
            int startIndex = previousSegment == null ? 0 : previousSegment.startIndex;
            int length = segment.lastIndex() - startIndex + 1;
            Segment newSegment = new Segment(startIndex, length);
            insertSegment(newSegment);
        }
        else if(segment.lastIndex() == index) {
            Segment nextSegment = findNextSegment(index);
            queue.remove(segment);
            queue.remove(nextSegment);
            int endIndex = nextSegment == null ? parkings.length - 1 : nextSegment.lastIndex();
            Segment newSegment = new Segment(segment.startIndex, endIndex - segment.startIndex + 1);
            insertSegment(newSegment);
        }

        parkings[index] = null;
    }

    Segment findPreviousSegment(int starIndex) {
        for(int i = starIndex - 1; i >= 0; --i) {
            if(parkings[i] != null) return parkings[i];
        }
        return null;
    }
    Segment findNextSegment(int starIndex) {
        for(int i = starIndex + 1; i < parkings.length; ++i) {
            if(parkings[i] != null) return parkings[i];
        }
        return null;
    }

}
