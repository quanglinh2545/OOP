package binary;

import java.util.Arrays;

class BinarySearch { 
    int binarySearch(int arr[], int l, int r, int x) 
    { 
    	Arrays.sort(arr);
        if (r >= l) { 
            int mid = l + (r - l) / 2; 
            if (arr[mid] == x) 
                return mid; 
            if (arr[mid] > x) 
                return binarySearch(arr, l, mid - 1, x);  
            return binarySearch(arr, mid + 1, r, x); 
        } 
        return -1; 
    } 

} 