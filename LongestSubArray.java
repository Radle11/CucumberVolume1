package jPractice;

import java.util.*;
import java.util.stream.IntStream;

public class LongestSubArray {

    /*
    Write a code to find the longest subarray that starts and ends on the same digit e.g,
        Example:
        Input: [1, 2, 3, 7, 6, 1, 9, 8, 6]
        Output: [1, 2, 3, 7, 6, 1]
     */
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 7, 6, 1, 9, 8, 6};
      System.out.println(Arrays.toString(compareSub(arr)));


    }

    public static int[] compareSub(int arr[]){
        int size=0;
        List<int[]> lists=new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    int[] ints = Arrays.copyOfRange(arr, i, j + 1);
                    if (ints.length>size){
                        size=ints.length;
                        lists = new ArrayList<>(Collections.singletonList(ints));
                    }
                }
            }
        }


 //       System.out.println(lists.size());
//        for(int i=0;i<lists.size();i++){
//            for(int j=i++;j<lists.size();j++) {
//                if (lists.get(i).length< lists.get(j).length) {
//                    lists.remove(i);
//                }
//            }
//        }
        return lists.get(0);
    }
//    public static int sumOfSub(int arr[],int start,int end){
//        int sum=0;
//        for(int i=start;i<end;i++)
//            sum+=arr[i];
//        return sum;
//    }
//    public static void arrays1(int[] arr){
//        List<List<Integer>> list2 = new ArrayList<>();
//        for(int i=0;i<arr.length;i++){
//            int x = arr[i];
//            int count =2;
//            for(int k=i+1;k<arr.length;k++){
//                if(x==arr[k]){
//                    List<Integer> list = new ArrayList<>();
//                    for(int l=i;l<k+1;l++){
//                        list.add(arr[l]);
//                    }
//                    list2.add(list);
//                    //      System.out.println(list);
//                }
//                count++;
//            }
//        }
//        System.out.println(list2);
//        //     System.out.println(list2);
//        int temp = list2.get(0).size();
//        List<Integer> list3 = new ArrayList<>();
//        list3.addAll(list2.get(0));
//        System.out.println(list3);
//        for(int i=1;i<list2.size();i++){
//            if(temp<list2.get(i).size()){
//                list3.remove(list3.get(0));
//                list3.addAll(list2.get(i));
//            }
//        }
//        System.out.println(list3);
//    }

}
