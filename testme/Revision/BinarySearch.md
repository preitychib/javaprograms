# 🗂️ Binary Search Pattern Bank
 

```java
int binarySearch(int[] arr, int target) {
  int low=0, high=arr.length-1;
  while(low<=high) {
    int mid=low+(high-low)/2;
    if(arr[mid]==target) return mid;
    else if(arr[mid]<target) low=mid+1;
    else high=mid-1;
  }
  return -1;
}


int lowerBound(int[] arr, int target) {
  int low=0, high=arr.length;
  while(low<high) {
    int mid=low+(high-low)/2;
    if(arr[mid]<target) low=mid+1;
    else high=mid;
  }
  return low;
}

int upperBound(int[] arr, int target) {
  int low=0, high=arr.length;
  while(low<high) {
    int mid=low+(high-low)/2;
    if(arr[mid]<=target) low=mid+1;
    else high=mid;
  }
  return low-1;
}

int searchRotated(int[] arr, int target) {
  int low=0, high=arr.length-1;
  while(low<=high) {
    int mid=low+(high-low)/2;
    if(arr[mid]==target) return mid;
    if(arr[low]<=arr[mid]) {
      if(arr[low]<=target && target<arr[mid]) high=mid-1;
      else low=mid+1;
    } else {
      if(arr[mid]<target && target<=arr[high]) low=mid+1;
      else high=mid-1;
    }
  }
  return -1;
}

int minEatingSpeed(int[] piles, int h) {
  int low=1, high=1_000_000_000;
  while(low<high) {
    int mid=low+(high-low)/2;
    int time=0;
    for(int p : piles) time += (p+mid-1)/mid;
    if(time>h) low=mid+1;
    else high=mid;
  }
  return low;
}

int findPeak(int[] arr) {
  int low=0, high=arr.length-1;
  while(low<high) {
    int mid=low+(high-low)/2;
    if(arr[mid]>arr[mid+1]) high=mid;
    else low=mid+1;
  }
  return low;
}

int findMin(int[] arr) {
  int low=0, high=arr.length-1;
  while(low<high) {
    int mid=low+(high-low)/2;
    if(arr[mid]>arr[high]) low=mid+1;
    else if(arr[mid]<arr[high]) high=mid;
    else high--;
  }
  return arr[low];
}

```