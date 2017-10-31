package collections;

public class MyHashMap<K, V> {
    private int size = 0;
    private Node node;

    public class Node<K, V> {
        K key;
        V value;
        Node <K, V> prev;

        Node(K key , V value , Node <K, V> prev) {
            this.value = value;
            this.key = key;
            this.prev = prev;
        }
    }

    public void put(K key , V value) {
        if (node == null) {
            node = new Node<> ( key , value , null );
            size++;
        } else {
            Node<K, V> valueNode = node;
            boolean unique = true;
            do {
                if (valueNode.key.equals(key)) {
                    valueNode.value = value;
                    unique = false;
                }
                valueNode = valueNode.prev;
            } while (valueNode != null && unique);
            if (unique) {
                this.node = new Node<K, V> ( key , value , this.node );
                size++;
            }
        }
    }

    public void clear() {
        for (Node <K, V> n = node ; n != null ;) {
            Node <K, V> next = n.prev;
            n.key = null;
            n.value = null;
            n = next;
        }
        node = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get( K key ) {
        Node <K, V> valueNode = node;
        if ( valueNode == null ) return null;
        while ( ! valueNode.key.equals ( key ) ) {
            if ( valueNode.prev == null ) return null;
            valueNode = valueNode.prev;
        }
        return valueNode.value;
    }

    public void remove(K key) {
        int count = 0;
        Node<K, V> iterator = node;
        Node<K, V> Iterator1 = node;
        do {
            if (iterator.key.equals(key) && iterator.prev == null) {
                Iterator1.prev = null;
                size--;
                break;
            } else if (iterator.key.equals(key)) {
                iterator.key = iterator.prev.key;
                iterator.value = iterator.prev.value;
                iterator.prev = iterator.prev.prev;
                size--;
                break;
            }
            Iterator1 = iterator;
            iterator = iterator.prev;
            count++;

        } while (size != count);
    }
    public void show() {
        Node<K, V> valueNode = node;
        if (valueNode == null) {
            System.out.println("The hash map is empty");
            return;
        }
        do {
            System.out.println(valueNode.key + ":" + valueNode.value);
            valueNode = valueNode.prev;
        } while (valueNode != null);
    }

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put("1", "one");
        hashMap.put("2", "two");
        hashMap.put("10", "ten");
        hashMap.put("10", "tennn");
        hashMap.show();
    }
}
