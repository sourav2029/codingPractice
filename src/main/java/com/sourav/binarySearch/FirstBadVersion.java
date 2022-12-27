package com.sourav.binarySearch;

public class FirstBadVersion {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            int start = 1;
            int end = n;
            int res = -1;
            while(start<=end){
                int mid = start+(end-start)/2;
//              Please note (start+end)/2 will overflow int if end is big enough
                if(isBadVersion(mid)){
                    res = mid;
                    end = mid-1;
                } else {
                    start = mid+1;
                }
            }
            return res;
        }
    }
}
