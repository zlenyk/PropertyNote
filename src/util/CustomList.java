package util;



public class CustomList<T extends Listable>{
	
	/*private List<String> list;
	DatabaseManager dbManager;

	public CustomList(DatabaseManager db){
		dbManager = db;
		updateList();
	}
	
	private void updateList(){
		list = dbManager.getOwnerList();	
	}

	public void add(T l) throws ListableExistException{
		if(list.indexOf(l.getName()) != -1){
			throw new ListableExistException();
		}
		dbManager.add(l);
		updateList();
	}
	public void deleteOwner(String name) throws ListableExistException{
		if(list.indexOf(name) == -1){
			throw new ListableExistException();
		}
		dbManager.delete(name);
		updateList();
	}
	public List<String> getList(){
		return list;
	}
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	public class ListIterator implements Iterator<T> {
		private int index = 0;
	    public boolean hasNext() {
		    return index < list.size();
	    }
	    
		public T next() {
	        return (T) list.get(index++);
	    }

		@Override
		public void remove() {
		}
	}
	*/
}
