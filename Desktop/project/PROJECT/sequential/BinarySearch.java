/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package br;
package sequential;
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
  
   /* public static void hi(String args[]) 
    { 
        BinarySearch ob = new BinarySearch(); 
        int arr[] = { 20, 3, 10, 100, 40}; 
        int n = arr.length; 
        int x = 10; 
        int result = ob.binarySearch(arr, 0, n - 1, x); 
        if (result == -1) 
            System.out.println("Element not present"); 
        else
            System.out.println("Element found at index " + result); 
    } */
} 