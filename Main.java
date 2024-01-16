package DemoJavaListaEnlazadaSimple;

public class Main {

	public static void main(String[] args) {
		ListaEnlazadaSimple lista = new ListaEnlazadaSimple();
		lista.addFirst("Hola");
		lista.addLast("Adios");
		lista.addLast("Buenas noches");
		lista.addLast("Buenos días");
		
		for(int i=0;i<lista.lengthList();i++) {
			System.out.println(lista.getDato(i));
		}

		System.out.println("... Muestra posición 1");
		System.out.println(lista.getNodo(1).getDato());

		System.out.println("... Elimina posición 2");
		lista.delNode(2);
		for(int i=0;i<lista.lengthList();i++) {
			System.out.println(lista.getDato(i));
		}

		System.out.println("... Elimina primero");
		lista.delFirst();
		for(int i=0;i<lista.lengthList();i++) {
			System.out.println(lista.getDato(i));
		}

		System.out.println("... Elimina último");
		lista.delLast();
		for(int i=0;i<lista.lengthList();i++) {
			System.out.println(lista.getDato(i));
		}

		System.out.println("... Modifica el 0");
		lista.setNode(0, "modificado");
		for(int i=0;i<lista.lengthList();i++) {
			System.out.println(lista.getDato(i));
		}
	}
}