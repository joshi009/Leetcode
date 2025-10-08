import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++) {
            long minPotion = (success + spells[i] - 1) / spells[i]; // ceiling division

            // inline binary search
            int low = 0, high = potions.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (potions[mid] < minPotion)
                    low = mid + 1;
                else
                    high = mid - 1;
            }

            result[i] = potions.length - low; // count of successful pairs
        }

        return result;
    }
}