public class LRUCacheDriver {

    public static void main(String[] args)
    {
        LRUCache cache = new LRUCache(2); // capacity of 2
        cache.put(1,2);
        cache.put(3,4);

        System.out.println(cache.get(1)); // returns 2

        cache.put(7,8);
        cache.put(5,6);
    }

}
