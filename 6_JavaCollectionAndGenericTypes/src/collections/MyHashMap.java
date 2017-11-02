package collections;

public class MyHashMap<Key, Value> {
    private int size = 0;
    private int M = 16;
    private Key[] keys;
    private Value[] values;

    public MyHashMap() {
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    public MyHashMap(int capacity) {
        M = capacity;
        size = 0;
        keys = (Key[]) new Object[M];
        values = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int capacity) {
        MyHashMap<Key, Value> temp = new MyHashMap<Key, Value>(capacity);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        M = temp.M;
    }

    public void put(Key key, Value value) {
        if (size >= M/2) { resize(2 * M); }
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public void delete(Key key) {
        if (get(key) == null) { return; }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            size--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % M;
        }
        size--;
        if (size > 0 && size == M/8) {
            resize(M/2);
        }
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("1", "one");
        hashMap.put("2", "two");
        hashMap.put("10", "ten");
        hashMap.put("10", "tennn");
        System.out.println(hashMap.get("10"));
    }
}
