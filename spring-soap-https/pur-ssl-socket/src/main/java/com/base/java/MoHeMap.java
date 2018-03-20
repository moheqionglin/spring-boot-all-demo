package com.base.java;

/**
 * @author wanli zhou
 * @created 2018-03-06 8:46 PM.
 */
public class MoHeMap<K, V> {

    private final int defaultLength = 16;

    private final float loadFactor = 0.75F;
    private MoHeEntry<K, V> table[] = null;
    private int size = 0;

    public V put(K key, V value){
        int index = hashIndex(key);
        MoHeEntry<K, V> entry = table[index];

        if(entry == null){
            table[index] = new MoHeEntry<>(key, value, null);
        }else{
            table[index] = new MoHeEntry<>(key, value, entry);
        }

        size ++ ;
        return table[index].getValue();
    }

    private void reHash(){

    }
    private int hashIndex(K key) {
        //可能是负数
        int keyHashCode = key.hashCode();
        int index = keyHashCode % defaultLength;
        return index >= 0 ? index : 0 ;
    }

    public V get(K key){
        return null;
    }

    public int size(){
        return size;
    }



    class MoHeEntry<K, V> {
        public MoHeEntry(K key, V value, MoHeEntry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        K key;
        V value;
        MoHeEntry next;

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

        public MoHeEntry getNext() {
            return next;
        }

        public void setNext(MoHeEntry next) {
            this.next = next;
        }
    }
}
