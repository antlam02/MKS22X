public class FrontierQueue implements Frontier{
    private LinkedList<Location> data = new LinkedList<>();
    public void add(Location next){
	data.addLast(next);
    }
    public Location remove(){
	return data.removeFirst();
    }
    public boolean hasNext(){
	return data.size()>0;
    }
}
