package cn.jdl.ecology;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr  = {1,2,3,6,5};
        int[] temp = new int[arr.length];

        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int left ,int right,int[] temp){
        if(left <right){
            int mid = (left + right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid +1,right,temp);

            //合并
            merge(arr,left,mid,right,temp);
        }
    }

    public static void merge(int[] arr,int left ,int mid,int right,int[] temp){
        int i = left;  //左边索引
        int j = mid +1 ; // 右边有序
        int t =0; // temp 临时索引

        while(i <=mid && j <= right ){
            System.out.println("i:" + i + "--- j:" +j + "arr:"+arr.length);
            if(arr[i] < arr[j]){
                temp[t] = arr[i];
                t+=1;
                i+=1;
            }else{
                temp[t] = arr[j];
                t+=1;
                j+=1;
            }
        }
        while(i <= mid ){
            temp[t] = arr[i];
            t+=1;
            i+=1;
        }

        while (j<=right){
            temp[t] =arr[j];
            t+=1;
            j+=1;
        }

        t =0 ;
        int tempLeft = left ;
        while (tempLeft <= right){
            arr[tempLeft]  =temp[t];
            t+=1;
            tempLeft +=1;
        }


    }

}