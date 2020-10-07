package edu.northeastern.ashish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

//        int[] arr = {4,1,4,4,3,3,4,4,3,2,4,2};
//        System.out.println(majorityElement(arr));
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

//        int[] arr = {2, 4, 3, 1, 11, 15};
//        sortArrayWaveFormLinear(arr);
//        printArray(arr);
       // System.out.println(sumOfTwoValuesEqualToRest(arr));

//        ArrayList<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(1,4));
//        intervals.add(new Interval(3,8));
//        intervals.add(new Interval(4,6));
//        intervals.add(new Interval(10,12));
//        intervals.add(new Interval(7,9));
//
//        ArrayList<Interval> merged =  mergeIntervals(intervals);
//        System.out.println("");

//        int[] arr1 = {1,6,11,16,17};
//        int[] arr2 = {2,7,12,18};
//        int[] arr3 = {3,8,13};
//        int[] arr4 = {4,9,14};
//        int[] arr5 = {5,10,15};
//        ArrayList<int[]> list = new ArrayList<>();
//        list.add(arr1);
//        list.add(arr2);
//        list.add(arr3);
//        list.add(arr4);
//        list.add(arr5);
//
//
//        int[] merged = mergedKSortedArrays(list );
//        printArray(merged);

        int[] arr = {1,2,3,4,5,6,7,8,9};
        rotate(arr, 3);
        printArray(arr);

    }

    //region Class 1
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

    //endregion



    // region Class 2

    static void reverse(int[] arr, int start, int end){
        if(arr == null || arr.length <= 1 || start >= end ){
            return;
        }
        while(start < end){
            swap(arr, start,end);
            start ++;
            end--;
        }


    }

    static boolean binSearch(int[] arr, int x){
        if(arr == null || arr.length == 0){
            return false;
        }
        int low = 0;
        int high = arr.length -1;
        while (low <= high){
            int mid = (low + high)/2;

            if(arr[mid] == x){
                return true;
            }
            else if(arr[mid] < x){
                low = mid +1;
            }
            else{
                high = mid -1;
            }
        }
        return  false;
    }

    static boolean binSearchRecursive(int[] arr, int x){
        return binSearchRecursive(arr, x, 0, arr.length -1);
    }

    static boolean binSearchRecursive(int[] arr, int x, int low, int high){
        if(low > high){
            return  false;
        }

        int mid = (low + high)/2;

        if(arr[mid] == x){
            return  true;
        }else if(arr[mid] < x){
            return binSearchRecursive(arr, x, mid +1, high);
        }else{
            return binSearchRecursive(arr, x, low, mid - 1);
        }
    }


    static int getNumberOfOccurances(int[] arr, int x){
        return  getNumberOfOccurances(arr, x, 0, arr.length -1);
    }

    static int getNumberOfOccurances(int[] arr, int x, int start, int end){
       // we did not find the value
        if( end < start){
            return 0;
        }

        // smallest value is bigger than the value we are searching for
        if( arr[start] > x){
            return  0;
        }
        // largest value is smaller than the value we are searching for
        if(arr[end] < x){
            return 0;
        }

        // if all the elements are equal to value we are searching for
        if(arr[start] == x && arr[end] == x){
            return  end - start +1;
        }

        int mid = (start + end)/2;

        // if we find X we will return 1 + elements on left as well as right
        if( arr[mid] == x){
            return  1 + getNumberOfOccurances(arr, x, start, mid -1)
                    + getNumberOfOccurances(arr, x, mid + 1, end);
        }
        else if ( arr[mid] < x){
            return getNumberOfOccurances(arr, x, mid + 1 , end);
        }
        else {
            return getNumberOfOccurances(arr, x, start , mid -1);
        }

    }

    static int getIndexOfFirst(int[] arr, int x){
        return  getIndexOfFirst(arr, x, 0, arr.length -1);
    }

    static int getIndexOfFirst(int[] arr, int x, int start, int end){
        if(start > end){
            return -1;
        }
        // smallest value is bigger than the value we are searching for
        if( arr[start] > x){
            return  -1;
        }
        // largest value is smaller than the value we are searching for
        if(arr[end] < x){
            return -1;
        }

        // if all the elements are equal to value we are searching for
        if(arr[start] == x){
            return start;
        }

        int mid = (start + end)/2;


        if(arr[mid] == x){
            return getIndexOfFirst(arr, x, start, mid);
        }else if(arr[mid] < x){
            return getIndexOfFirst(arr, x, mid + 1, end);

        }else {
            return getIndexOfFirst(arr, x, start, mid -1);
        }

    }

    static int findCeiling(int[] arr, int x){
        return  findCeiling(arr, x, 0, arr.length -1);
    }

    static int findCeiling(int[] arr, int x, int start, int end){

        if(arr[start] > x){
            return  arr[start];
        }
        if(arr[end] < x){
            return Integer.MAX_VALUE;
        }

        int mid = (start + end)/2;

        if(arr[mid] == x){
            return x;

        }else if (arr[mid] < x){
            return findCeiling(arr, x, mid +1, end);
        } else {
            return findCeiling(arr, x, start, mid);
        }

    }

    static int findFloor(int[] arr, int x){
        return  findFloor(arr, x, 0, arr.length -1);
    }

    static int findFloor(int[] arr, int x, int start, int end){

        if(arr[start] > x){
            return  Integer.MIN_VALUE;
        }
        if(arr[end] < x){
            return arr[end];
        }

        int mid = (start + end)/2;

        if(arr[mid] == x){
            return x;
        }else if (arr[mid] < x){
            return findFloor(arr, x, mid, end);
        } else {
            return findFloor(arr, x, start, mid-1);
        }

    }

    static boolean checkIfTwoValuesSumEqualX(int[] arr, int x){
        if(arr == null || arr.length <= 1){
            return false;
        }

        Arrays.sort(arr);

        int start = 0 ;
        int end = arr.length -1;

        while(start < end){
            int sum = arr[start] + arr[end];
            if( sum == x){
                return  true;
            }else if ( sum < x){
                start ++;
            }else{
                end --;
            }
        }

        return  false;


    }

    static  boolean sumOfTwoValuesEqualToRest(int[] arr){
        int sum = 0 ;

        for(int i = 0 ; i < arr.length; i ++){
            sum += arr[i];
        }

        Arrays.sort(arr);

        int start = 0 ;
        int end = arr.length -1;

        while(start < end){
            int currSum = arr[start] + arr[end];
            if( currSum * 2 == sum ){
                System.out.println("Found elements Start = " + arr[start] + " end = " + arr[end]);
                return true;
            }else if (currSum * 2 < sum){
                start++;
            }else {
                end --;
            }

        }
        return  false;
    }

    static  void sortArrayWaveForm(int[] arr){
        if(arr == null || arr.length <= 1 ){
            return;
        }
        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length -1 ; i +=2){
            swap(arr, i, i +1);
        }
    }

    static  void sortArrayWaveFormLinear(int[] arr){
        if(arr == null || arr.length <= 1 ){
            return;
        }

        for(int i = 0 ; i < arr.length ; i +=2){
            if( i > 0 && arr[i-1] > arr[i]){
                swap(arr, i-1, i);
            }

            if(i < arr.length -1 && arr[i] < arr[ i +1]){
                swap(arr, i, i +1);
            }
        }
    }

    static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervals){

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval x, Interval y) {
                if(x.start > y.start ){
                    return  1;
                }else if (x.start < y.start){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        Stack<Interval> stack  = new Stack<>();
        stack.push(intervals.get(0));

        for(int i = 1; i < intervals.size(); i ++){
            Interval top = stack.peek();
            Interval current = intervals.get(i);
            if(top.end < current.start){
                stack.push(current);
            }
            else if(top.end < current.end ){
                top.end  = current.end;
                stack.pop();
                stack.push(top);
            }
        }

        Stack<Interval> reverse = new Stack<>();

        while(! stack.isEmpty() ){
            reverse.push(stack.pop());
        }

        ArrayList<Interval> merged = new ArrayList<>();
        while(!reverse.isEmpty()){
            merged.add(reverse.pop());
        }
        return merged;
    }

    static  int[] mergeSortedArrays(int[] arr1, int[] arr2){

        int[] merged = new int[arr1.length + arr2.length];
        int ptr1 = 0;
        int ptr2 = 0;
        int ptr = 0 ;
        while(ptr1 < arr1.length && ptr2 < arr2.length){
            if(arr1[ptr1] < arr2[ptr2]){
                merged[ptr++] = arr1[ptr1++];
            }else {
                merged[ptr++] = arr2[ptr2++];
            }
        }

        while(ptr1 < arr1.length){
            merged[ptr++] = arr1[ptr1++];
        }
        while(ptr2 < arr2.length){
            merged[ptr++] = arr2[ptr2++];
        }
        return  merged;
    }

    static int[] mergedKSortedArrays(ArrayList<int[]> listSortedArrays){
        int[] merged = {};
        for(int i = 1; i < listSortedArrays.size(); i ++){
            if(i == 1 ){
                merged = mergeSortedArrays(listSortedArrays.get(0), listSortedArrays.get(i));
            }else {
                merged = mergeSortedArrays(merged, listSortedArrays.get(i));
            }
        }

        return merged;
    }


    static void rotate(int[] arr, int n){
        n = n % arr.length;

        reverse(arr, 0, arr.length -1);
        reverse(arr, 0, n-1);
        reverse(arr, n, arr.length -1);

    }












        // endregion












}
