//import java.util.ArrayList;
//import java.util.HashMap;
//
//class TimeMap {
//    Map<String, List<Pair<Integer, String>>> map;
//
//    public TimeMap() {
//        map = new HashMap<>();
//    }
//
//    public void set(String key, String value, int timestamp) {
//        if (map.containsKey(key)) {
//            List<Pair<Integer, String>> list = map.get(key);
//            list.add(new Pair(timestamp, value));
//        } else {
//            List<Pair<Integer, String>> list = new ArrayList<>();
//            list.add(new Pair(timestamp, value));
//            map.put(key, list);
//        }
//    }
//
//    public String get(String key, int timestamp) {
//        List<Pair<Integer, String>> list = map.get(key);
//        if (list == null) {
//            return "";
//        }
//        return binarySearch(list, timestamp);
//    }
//
//    public String binarySearch(List<Pair<Integer, String>> list, int timestamp) {
//        int st = 0;
//        int end = list.size() - 1;
//
//        while (st < end) {
//            int mid = st + (end - st + 1) / 2;
//            if (list.get(mid).getKey() > timestamp) {
//                end = mid - 1;
//            } else {
//                st = mid;
//            }
//        }
//        if (list.get(st).getKey() <= timestamp) {
//            return list.get(st).getValue();
//        }
//        return "";
//    }
//}
//
///**
// * Your TimeMap object will be instantiated and called as such:
// * TimeMap obj = new TimeMap();
// * obj.set(key,value,timestamp);
// * String param_2 = obj.get(key,timestamp);
// */