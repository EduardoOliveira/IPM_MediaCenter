package pt.iscte.ipm.mediacenter.core.utils;

import java.util.*;

public class MultiKeyMap<K1 extends UUID, K2, V> {

    private Map<K1, V> map1;
    private Map<K2, V> map2;

    public MultiKeyMap() {
        this.map1 = new HashMap<>();
        this.map2 = new HashMap<>();
    }

    public synchronized void put(K1 key1, K2 key2, V value) {
        this.map1.put(key1, value);
        this.map2.put(key2, value);
    }

    public synchronized V remove(K1 key) {
        V res = this.map1.remove(key);
        this.map2.values().remove(res);
        return res;
    }

    public synchronized V remove(K2 key) {
        V res = this.map2.remove(key);
        this.map1.values().remove(res);
        return res;
    }

    public synchronized V get(K1 key) {
        return map1.get(key);
    }

    public synchronized V get(K2 key) {
        return map2.get(key);
    }

    public synchronized int size() {
        try {
            if (map1.values().size() != map2.values().size()) {
                throw new Exception("Incoherent Maps!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map2.size();
    }

    public synchronized Collection<V> values() {
        try {
            if (map1.values().size() != map2.values().size()) {
                throw new Exception("Incoherent Maps!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map2.values();
    }
}
