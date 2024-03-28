//package com.sourav;
//
//public class RecoSystem {
////    map of userID to A Queue
////    map of string to a queue
////    key is the userID
////    value is Queue
//
////    {userID, productId}
//
////    lookup in the map
////    find the queue , append the productId to the front of the queue
////    if the length is greater than x (50) remove from the tail of the queue
//
//
////  if not in map , initalise new queue and add it in the map
//
////    How to avoid duplicate elements in the queue (LinkedList Implementation)
////    map of user to a map of (product, Node previous to productId)
//
//
//    p13 ->p1 -> p2-> ,......->
////    map (product,
//
////    p1-> p2-> p3_.....p12->p13->p14......p49
////    p13->p1->......p12->p14....p49
////    head = p1
////    mapIndex = p12
//    temp = head;
//    head = mapIndex.next;
//    head.next = temp;
//    mapIndex.next = mapIndex.next.next;
//
////    map userId to {linkedList, index}
////   map user ->  mp[p13- p12]
//
//// 3 3 4 5 7 9 12
////    3 7 9 12 4 3 5 -> (1,6)
////    first index from left for which we have seen a smaller element in the right of that index
////    first index from right for which we have seen a greater element in the left of that index
//
////    max = 3 (index zero )
////    start from index 1
////    curr = 7, max = 7, if(max>curr) {startIndex = i-1}
////    curr = 9, max = 9
////    12
////    curr = 4, max = 12 (3,
//}
