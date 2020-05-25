public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		_146LRUCache cache = new _146LRUCache(10);
		
		cache.put(10, 13);
		cache.put(3, 17);
		cache.put(6, 11);
		cache.put(10, 5);
		cache.put(9, 10);
		System.out.println(cache.get(13));
		cache.put(2, 19);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.put(5, 25);
		System.out.println(cache.get(8));
		cache.put(9, 22);
		cache.put(5, 5);
		cache.put(1, 30);
		System.out.println(cache.get(11));
		cache.put(9, 12);
		System.out.println(cache.get(7));
		System.out.println(cache.get(5));
		System.out.println(cache.get(8));
		System.out.println(cache.get(9));
		cache.put(4, 30);
		cache.put(9, 3);
		System.out.println(cache.get(9));
		System.out.println(cache.get(10));
		System.out.println(cache.get(10));
		cache.put(6, 14);
		return;
		
		//["LRUCache","put","put","put","put","put","get","put","get","get","put","get","put","put","put","get","put","get","get","get","get","put","put","get","get","get","put","put","get","put","get","put","get","get","get","put","put","put","get","put","get","get","put","put","get","put","put","put","put","get","put","put","get","put","put","get","put","put","put","put","put","get","put","put","get","put","get","get","get","put","get","get","put","put","put","put","get","put","put","put","put","get","get","get","put","put","put","get","put","put","put","get","put","put","put","get","get","get","put","put","put","put","get","put","put","put","put","put","put","put"]
		//[3,1],[3],[10,11],[8],[2,14],[1],[5],[4],[11,4],[12,24],[5,18],[13],[7,23],[8],[12],[3,27],[2,12],[5],[2,9],[13,4],[8,18],[1,7],[6],[9,29],[8,21],[5],[6,30],[1,12],[10],[4,15],[7,22],[11,26],[8,17],[9,29],[5],[3,4],[11,30],[12],[4,29],[3],[9],[6],[3,4],[1],[10],[3,29],[10,28],[1,20],[11,13],[3],[3,12],[3,8],[10,9],[3,26],[8],[7],[5],[13,17],[2,27],[11,15],[12],[9,19],[2,15],[3,16],[1],[12,17],[9,1],[6,19],[4],[5],[5],[8,1],[11,7],[5,2],[9,28],[1],[2,2],[7,4],[4,22],[7,24],[9,26],[13,28],[11,26]]
	}

}
