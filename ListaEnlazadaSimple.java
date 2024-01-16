package DemoJavaListaEnlazadaSimple;

public class ListaEnlazadaSimple<T> {
	private Nodo<T> primero;

	public ListaEnlazadaSimple() {
		this.primero=null;
	}
	
	public boolean isEmpty() {
		return primero==null;
	}

	public int lengthList() {
		Nodo <T> aux;
		int numElementos=0;
		aux=primero;
		while(aux != null){
			numElementos++;
			aux = aux.getSiguiente();
		}
		return numElementos;
	}

	public T getFirst() {
		T elemento = null;
		if (!this.isEmpty()) {
			elemento=this.primero.getDato();
		}
		return elemento;

	}

	public void addFirst(T dato) {
		Nodo<T> nuevo= new Nodo<>(dato);
		nuevo.setSiguiente(this.primero);
		this.primero=nuevo;
	}

	public void addLast(T dato) {
		if (this.isEmpty()) {
			this.addFirst(dato);
		}else {
			Nodo<T> nuevo= new Nodo<>(dato);
			Nodo<T> aux = this.primero;
			while (aux.getSiguiente()!=null) {
				aux=aux.getSiguiente();
			}
			aux.setSiguiente(nuevo);
		}
	}

	public Nodo<T> delFirst(){
		Nodo<T> elemento = null;
		if (!this.isEmpty()) {
			elemento = this.primero;
			primero = primero.getSiguiente();
		}
		return elemento;
	}

	public Nodo<T> delLast(){
		Nodo<T> ultimo = null;
		Nodo<T> penultimo = null;
		if (!this.isEmpty()) {
			ultimo = this.primero;
			while (ultimo.getSiguiente()!=null){
				penultimo = ultimo;
				ultimo = ultimo.getSiguiente();
			}
			penultimo.setSiguiente(null);
		}
		return ultimo;
	}

	public Nodo<T> delNode(int pos) {
		Nodo<T> elemento = null;
		Nodo<T> anterior = null;
		if (!this.isEmpty()) {
			Nodo<T> aux = this.primero;
			int cont = 0;

			while(aux!=null && elemento==null) {
				if (cont == pos) {
					elemento = aux;
				} else {
					anterior = aux;
					aux = aux.getSiguiente();
					cont++;
				}
			}
			anterior.setSiguiente(elemento.getSiguiente());
		}
		return elemento;
	}
	
	public T getDato(int pos) {
		T elemento = null;
		Nodo <T> aux = this.primero;
		int cont=0;

		if((pos>=0) && pos<=this.lengthList()) {
			while (aux!=null) {
				if(pos == cont) {
					elemento=aux.getDato();
				}
				cont++;
				aux=aux.getSiguiente();
			}
		}
		return elemento;
	}
	
	public Nodo<T> getNodo(int pos) {
		Nodo<T> elemento = null;
		if (!this.isEmpty()) {
			Nodo<T> aux = this.primero;
			int cont = 0;

			while(aux!=null && elemento==null) {
				if (cont == pos) {
					elemento = aux;
				} else {
					aux = aux.getSiguiente();
					cont++;
				}
			}
		}
		return elemento;
	}

	public boolean setNode(int pos, T dato) {
		boolean modificado = false;
		this.getNodo(pos).setDato(dato);
		return modificado;
	}
}