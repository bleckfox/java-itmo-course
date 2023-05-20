package homeWorks.homeWork13;

public class PairContainer<K, V> {

    private K key;

    private V value;

    public PairContainer(K key, V value){
        setKey(key);
        setValue(value);
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
