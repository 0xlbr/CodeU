public class Q2{
	
public class LinkedList<T>{
	Node<T> head;
}

public class Node<T>{
	T value;
	Node<T> next;
	Node(T val){
		this.value = val;
	}
}

public static <T> Node<T> nthToLast(int n, LinkedList<T> list){
	if(list.head==null || n<0) throw new IllegalArgumentException();
		
	Node<T> first = list.head;
	Node<T> second  = list.head;
	
	for (int i = 0; i < n; i++) {
		first = first.next;
		if (first == null) throw new IllegalArgumentException();
	}
	
	while (first.next!=null) {
	first = first.next;
	second = second.next;
	}
	
	return second;
}
}
