package application;

public class LinkList<T extends Comparable<T>> {
	
	private Node<T> head;
	
	
	
	public void insert(T data){
	  Node<T> newNode=new Node<>(data);
	  Node<T> prev=null, curr=head;
	  
		for(;curr!=null&&(curr.getData().compareTo(data)<0);prev=curr,curr=curr.getNext());
			if(head==null)
				head=newNode;
			
			else if(prev==null){
				newNode.setNext(head);
				head=newNode;
			}
			
			else if(curr==null){
				prev.setNext(newNode);
			}
			else{
				newNode.setNext(curr);
				prev.setNext(newNode);
			}
			
	}
	
	public void delet(T data){
		if(head==null){
			System.out.println("Empty");
			return;
		}
		
		Node<T> prev=null,curr=head;
		
		for(;curr!=null&&curr.getData().compareTo(data)<0;prev=curr,curr=curr.getNext());
		  if(curr==null){
			  System.out.println("not Found");
			  return;
		  }
		  if(curr.getData().equals(data)){
			  if(curr==head)
				  head=head.getNext();
			  else
				  prev.setNext(curr.getNext());
		  }
		  else
			  System.out.println("not Found");
	}
	
	
	public void traversList(){
		traversList(head);
	}
	
	private void traversList(Node<T> curr){
		if(curr==head)
			System.out.print("Head-->");
		if(curr==null)
			System.out.println("Null");
		else{
			System.out.print(curr.getData()+"-->");
			traversList(curr.getNext());
		}
	}
	
	
	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;
	}

	public LinkList<T> merge(LinkList<T> second){
		
		LinkList<T> result=new LinkList<>();
		Node<T> curr1=head,curr2=second.getHead();
		
		while((curr1!=null) && (curr2!=null)) {
			if(curr1.getData().compareTo(curr2.getData())<=0) {
				result.insert(curr1.getData());
				curr1=curr1.getNext();
			}
			else {
				result.insert(curr2.getData());
				curr2=curr2.getNext();
			}
		}
		while(curr1!=null) {
			result.insert(curr1.getData());
			curr1=curr1.getNext();
		}
		while(curr2!=null) {
			result.insert(curr2.getData());
			curr2=curr2.getNext();
		}
		
		return result;
	}
	
}
