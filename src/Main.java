 
public class Main {

	public static void main(String[] args) {
		DCL ll = new DCL(10);
		ll.addElem(1);
		ll.addElem(2);
		ll.addElem(3);
		ll.addElem(11);
		ll.addElem(22);
		ll.addElem(33);
		System.out.println("Länge der Liste: " + ll.length());
		ll.printList();
		System.out.println("1 und 2 werden getauscht: ");
		ll.swap(1, 2);
		ll.printList();
		System.out.println("Das Element mit index 5 wir geschlöscht also 22");
		ll.deleteElem(5); 
		System.out.println("Jetzige Länge: " + ll.length());
		ll.printList();
	}

}

/*
 * o	Erstes head und letztes Tail; ein Element hat Adresse vom nächsten und vom vorherigen a; jedes Element hat 2 Adressen also 2 pointer
o	Länge, Ausgabe mit Adressen, Eingabe also hinzufügen, DELETE, und dann noch SWAP dieses Mal
o	Delete und swap brauchen indes zum welchen die löschen oder welche sie tauschen wollen  
*/
 