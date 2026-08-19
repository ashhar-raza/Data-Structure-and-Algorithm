import java.util.*;

class Solution {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        
        for (int[] seat : reservedSeats) {
            reserved
                    .computeIfAbsent(seat[0], k -> new HashSet<>())
                    .add(seat[1]);
        }


        int count = (n - reserved.size()) * 2;

        for (Set<Integer> seats : reserved.values()) {

            boolean left = !(seats.contains(2)
                    || seats.contains(3)
                    || seats.contains(4)
                    || seats.contains(5)); 

            boolean middle = !(seats.contains(4)
                    || seats.contains(5)
                    || seats.contains(6)
                    || seats.contains(7));

            boolean right = !(seats.contains(6)
                    || seats.contains(7)
                    || seats.contains(8)
                    || seats.contains(9));

            if (left && right) {
                count += 2;
            } else if (left || middle || right) {
                count += 1;
            }
        }

        return count;
    }
}