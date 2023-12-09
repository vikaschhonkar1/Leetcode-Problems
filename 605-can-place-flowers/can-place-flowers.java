class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int size = flowerbed.length;

        if(size == 1) {
            if (n >= 2) return false;
            if (n == 1 && flowerbed[0] == 0) return true;
            if (n == 0) return true;
            return false;
        } else if(size == 2) {
            if (n >= 2) return false;
            if (n == 1 && flowerbed[0] == 0 && flowerbed[1] == 0) return true;
            if (n == 0) return true;
            return false;
        }

        int canPlant = 0;

        int tempArray1[] = flowerbed;

        if(tempArray1[0] == 0 && tempArray1[1] == 0) {
            tempArray1[0] = 1;
            canPlant++;
        }
        for(int i = 1; i < size - 1; i++) {
            if(tempArray1[i] == 0 && tempArray1[i - 1] == 0 && tempArray1[i + 1] == 0) {
                tempArray1[i] = 1;
                canPlant++;
            } 
        }
        if(tempArray1[size - 1] == 0 && tempArray1[size - 2] == 0) {
            tempArray1[size - 1] = 1;
            canPlant++;
        }

        if(canPlant >= n) return true;
        return false;
    }
}