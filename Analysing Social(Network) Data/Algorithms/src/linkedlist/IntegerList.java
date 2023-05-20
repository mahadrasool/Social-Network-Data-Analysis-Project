package linkedlist;

public class IntegerList implements LinkedListInterface<Integer> {

	private IntNode root;
	private IntNode last;
	
	public IntegerList() {
		this.root = null;
		last = null;
	}
	
	
	public IntNode getRoot() {
		return root;
	}
	
	@Override
	public void addValue(Integer val) {
		
		IntNode i = new IntNode();
		i.key = val;
		i.next = null;
		
		if (root == null) {
			root = i;
			last = root;
		}
		else {
			last.next = i;
			last = i;
		}
	}

	@Override
	public Integer deleteValue() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer searchValue(Integer key) {
		// TODO Auto-generated method stub
		return null;
	}
		

}
