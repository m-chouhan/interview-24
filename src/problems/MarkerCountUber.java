package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * There is a long road with markers on it after each unit of distance. There are some ubers standing on the road.
 * You are given the starting and ending coordinate of each uber (both inclusive).
 * Note: At any given marker there may be multiple ubers or there may be none at all.
 * Your task is to find the number of markers on which at least one uber is present. An uber with coordinates (l, r) is considered to be present on a marker m if and only if l ≤ m ≤ r.
 * Example :
 * For coordinates=[[4, 7], [-1, 5], [3, 6]], the output should be easyCountUber(coordinates) = 9.
 * */
public class MarkerCountUber {

    int countMarkers(int [][] coordinates) {
        return countMarkers2(coordinates);
    }

    private int countMarkers1(int [][] coordinates) {
        HashSet<Integer> markers = new HashSet<>();
        for(int[] coordinate : coordinates) {
            for(int i = coordinate[0]; i <= coordinate[1]; ++i)
                markers.add(i);
        }
        return markers.size();
    }

    class Point implements Comparable<Point>{
        int start, end;
        Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(start, o.start);
        }
    }
    private int countMarkers2(int [][] coordinates) {
        ArrayList<Point> points = new ArrayList<>();
        for(int [] coordinate : coordinates)
            points.add(new Point(coordinate[0], coordinate[1]));
        Collections.sort(points);

        int markerCount = 0;
        Point lastPoint = null;
        for(Point currentPoint : points) {
            markerCount += currentPoint.end - currentPoint.start + 1;
            if (lastPoint != null && lastPoint.end >= currentPoint.start) {
                int overlappingPoints = Math.min(lastPoint.end, currentPoint.end) - currentPoint.start + 1;
                markerCount -= overlappingPoints;
            }
            lastPoint = currentPoint;
        }
        return markerCount;
    }
}
