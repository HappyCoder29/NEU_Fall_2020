package edu.northeastern.ashish;

public class Main {

    public static void main(String[] args) {

        int[] arr = {1,3,2,3,4,3,1,4,3,2,3,1};
        System.out.println(majorityElement(arr));
//        int[] arr = {-1,-3,5,2,0,-6,3,0,-2,3};
//        dutchFlag(arr, 0);
//        printArray(arr);
//        int[] arr = {0,5,3,3,2,5,6,6,6,7,2,9,1,2};
//        countSort(arr, 10);
//        printArray(arr);
        //int[] arr = {6,5,3,1,8,7,2,4};
       // findNthLargest(arr, 3);
        //quickSort(arr);
        //printArray(arr);
    }

    private static void printArray(int[] arr){
        for (int i : arr) {
            System.out.printf(i + " ");
        }
        System.out.println("");
    }

    private static void swap(int[] arr, int i , int j){
        if(arr == null || arr.length == 0 || i < 0 || j < 0 || i >= arr.length || j >= arr.length ){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bubbleSort(int[] arr){
        for(int i = 0 ; i < arr.length; i ++){
            for(int j = 0; j < arr.length - i -1;  j ++){
                if (arr[j] > arr[j +1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    private static void selectionSort(int[] arr){
        for(int i = 0 ; i < arr.length; i ++){
            int minIndex = i;
            for(int j = i +1 ; j < arr.length ; j ++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if(minIndex != i ){
                swap(arr, i, minIndex );
            }
        }
    }

    private static void mergeSort(int[] arr){
        mergeSort(arr, 0, arr.length-1);
    }

    private static void mergeSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }

        int mid = (low + high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high);
    }

    private static void merge(int[] arr, int low, int high){
        int mid = (low + high)/2;
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int index = 0 ;

        // While i or j is in bounds compare and add values inside the temp array
        while( i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[index] = arr[i];
                i ++;
            }else{
                temp[index] = arr[j];
                j ++;
            }
            index++;
        }

        // copy over remaining
        while(i <= mid){
            temp[index++] = arr[i++];
        }
        while( j <= high){
            temp[index++] = arr[j++];
        }

        i = low;

        // Copy the temp values in original array
        for(int k = 0 ; k < temp.length; k ++){
            arr[i] = temp[k];
            i ++;
        }
    }

    private static void quickSort(int[] arr){
       quickSort(arr, 0, arr.length -1);
    }

    private static void quickSort(int[] arr, int low, int high){

        if(low < high){
            int pos = partition(arr, low, high);
            quickSort(arr, low, pos-1);
            quickSort(arr, pos +1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int wall = low -1;

        for(int i = low; i < high; i ++){
            if(arr[i] < pivot){
                wall++;
                swap(arr, i, wall);
            }
        }
        wall ++;
        swap(arr, high, wall);
        return  wall;
    }

    private static void findNthLargest(int[] arr, int n){
        if( arr== null || arr.length == 0 || n < 0 || n > arr.length){
            return ;
        }
        findNthLargest(arr, 0, arr.length -1, n);
    }
    private static void findNthLargest(int[] arr, int low, int high, int n){
        if(low < high){
            int pos = partition(arr, low, high);
            // if the position returned is the value we are looking for
            //return the value
            if( pos == arr.length - n){
                System.out.println(arr[pos]);
            }
            findNthLargest(arr, low, pos-1, n);
            findNthLargest(arr, pos +1, high, n);
        }
    }

    private static void countSort(int[] arr, int RANGE){
        int[] countArr = new int[RANGE];
        for(int i = 0 ; i < arr.length; i ++){
            countArr[arr[i]] ++;
        }

        int index = 0 ;

        for(int i = 0 ; i < RANGE; i ++){

            while(countArr[i] > 0){
                arr[index] = i;
                index++;
                countArr[i] --;
            }
        }
    }

    private static void dutchFlag(int[] arr, int pivot){
        int low = 0 ;
        int mid = 0;
        int high = arr.length -1;

        while (mid <= high){
            if(arr[mid] < pivot){
                swap(arr, low++, mid++);
            }
            else if (arr[mid] == pivot){
                mid++;
            }else{
                swap(arr, mid, high--);
            }
        }
    }

    private static int majorityElement(int[] arr){
        int candidate = findCandidate(arr);
        int count = 0;
        for(int i = 0 ; i < arr.length; i ++){
            if(arr[i] == candidate){
                count++;
            }
        }

        if(count > arr.length/2){
            return candidate;
        }
        return Integer.MIN_VALUE;
    }

    private static int findCandidate(int[] arr){
        int majorityElement = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i ++){
            if(arr[i] == majorityElement){
                count++;
            }else{
                count--;
                if( count == 0 ){
                    majorityElement = arr[i];
                    count = 1;
                }
            }
        }

        return majorityElement;

    }













}
