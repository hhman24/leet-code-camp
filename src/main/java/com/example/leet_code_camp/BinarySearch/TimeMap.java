package com.example.leet_code_camp.BinarySearch;

import java.util.*;

public class TimeMap {
    private final Map<String, List<Pair>> map;

    static class Pair {
        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        this.map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        this.map.putIfAbsent(key, new ArrayList<>());
        this.map.get(key).add(new Pair(timestamp, value));

    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        // use binary search by timestamp
        int low = 0;
        int high = list.size() - 1;

        String result = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if (list.get(mid).timestamp == timestamp) return list.get(mid).value;
            if (list.get(mid).timestamp <= timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (high < 0) return "";
        if (low >= list.size()) return list.getLast().value;

        // since high < low and we need to return result with timestamp <= given timestamp
        return list.get(high).value;
    }
}
