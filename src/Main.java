 
public class Main {

	public static void main(String[] args) {
		DCL ll = new DCL(); 
		ll.addBegin(4);
		ll.addBegin(33);
		ll.addBegin(5);
		ll.addBegin(23);
		ll.addBegin(7);
		ll.addBegin(63);
//		ll.addAfter(1,5);
		ll.addAtEnd(7);
		ll.show();
//		System.out.println("Laenge der Liste : "+ll.getLenghList());
		System.out.println("2 und 4 tauschen ");
		ll.swap(2, 4);
		ll.show();
	}

}

/*
 * o	Erstes head und letztes Tail; ein Element hat Adresse vom nächsten und vom vorherigen a; jedes Element hat 2 Adressen also 2 pointer
o	Länge, Ausgabe mit Adressen, Eingabe also hinzufügen, DELETE, und dann noch SWAP dieses Mal
o	Delete und swap brauchen indes zum welchen die löschen oder welche sie tauschen wollen  
*/
 