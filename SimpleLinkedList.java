package DemoJavaListaEnlazadaSimple;

public class SimpleLinkedList<T> {
	private Node<T> first;

	public SimpleLinkedList() {
		this.first = null;
	}
	
	public boolean isEmpty() {
		return first == null;
	}

	public int lengthList() {
		Node<T> aux;
		int numElements = 0;
		aux = first;
		while(aux != null){
			numElements++;
			aux = aux.getNext();
		}
		return numElements;
	}

	public T getFirst() {
		T element = null;
		if (!this.isEmpty()) {
			element = this.first.getData();
		}
		return element;

	}

	public void addFirst(T data) {
		Node<T> newNode = new Node<>(data);
		newNode.setNext(this.first);
		this.first = newNode ;
	}

	public void addLast(T data) {
		if (this.isEmpty()) {
			this.addFirst(data);
		}else {
			Node<T> newNode = new Node<>(data);
			Node<T> aux = this.first;
			while (aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(newNode);
		}
	}

	public Node<T> delFirst(){
		Node<T> element = null;
		if (!this.isEmpty()) {
			element = this.first;
			first = first.getNext();
		}
		return element;
	}

	public Node<T> delLast(){
		Node<T> lastNode = null;
		Node<T> secondLastNode = null;
		if (!this.isEmpty()) {
			lastNode = this.first;
			while (lastNode.getNext()!=null){
				secondLastNode = lastNode;
				lastNode = lastNode.getNext();
			}
			secondLastNode.setNext(null);
		}
		return lastNode;
	}

	public Node<T> delNode(int pos) {
		Node<T> node = null;
		Node<T> beforeNode = null;
		if (!this.isEmpty()) {
			Node<T> aux = this.first;
			int count = 0;

			while(aux!=null && node==null) {
				if (count == pos) {
					node = aux;
				} else {
					beforeNode = aux;
					aux = aux.getNext();
					count++;
				}
			}
			beforeNode.setNext(node.getNext());
		}
		return node;
	}
	
	public T getData(int pos) {
		T element = null;
		Node<T> aux = this.first;
		int count = 0;

		if((pos >= 0) && pos <= this.lengthList()) {
			while (aux != null) {
				if(pos == count) {
					element=aux.getData();
				}
				count++;
				aux = aux.getNext();
			}
		}
		return element;
	}
	
	public Node<T> getNode(int pos) {
		Node<T> element = null;
		if (!this.isEmpty()) {
			Node<T> aux = this.first;
			int count = 0;

			while(aux != null && element == null) {
				if (count == pos) {
					element = aux;
				} else {
					aux = aux.getNext();
					count++;
				}
			}
		}
		return element;
	}

	public boolean setNode(int pos, T data) {
		boolean modifiedNode = false;
		this.getNode(pos).setData(data);
		return modifiedNode;
	}
}