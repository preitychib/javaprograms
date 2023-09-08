//! 1095. Find in Mountain Array
//? Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
//? Input: array = [0,1,2,4,2,1], target = 3
//? Output: -1
//? Explanation: 3 does not exist in the array, so we return -1.

public class FindInMountain {
    int binary(int[] arr,int target,int s,int e,boolean condition){
        int m;
       
        if(condition){
            while(s<=e){ 
                 m=(e+s)/2;
                if(arr[m]>target) e=m-1;
                else if(arr[m]<target) s=m+1;
                else {
                    return m;
                }
            }
        }else{
            while(s<=e){
                 m=(e+s)/2;
                if(arr[m]>target) s=m+1;
                else if(arr[m]<target) e=m-1;
                else {
                    return m;
                }
            }
        }
        return -1;
    }
     int peakIndexInMountainArray(int[] arr) {
        int s=0,e,m;
        e=arr.length-1;
        while(s<e){
            m=(e+s)/2;
            if(arr[m]>arr[m+1]) e=m;
            else s=m+1;
        }
        return s;
    }

    public int findInMountainArray(int target, int[] mountainArr) {
        int peak=peakIndexInMountainArray(mountainArr); 
        int t= binary(mountainArr,target,0,peak,true);
        if(t==-1){
            t= binary(mountainArr,target,peak+1,mountainArr.length-1,false);
            
        }
        return t;
    }
}
