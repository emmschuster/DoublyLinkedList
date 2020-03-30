 
public class Main {

	public static void main(String[] args) {
		DCL ll = new DCL(); 
		ll.addBegin(4);
		ll.addBegin(33);
//		ll.addAfter(1,5);
		ll.addAtEnd(7);
		ll.show();
		System.out.println("Laenge der Liste : "+ll.getLenghList());
	}

}

/*
 * o	Erstes head und letztes Tail; ein Element hat Adresse vom nächsten und vom vorherigen a; jedes Element hat 2 Adressen also 2 pointer
o	Länge, Ausgabe mit Adressen, Eingabe also hinzufügen, DELETE, und dann noch SWAP dieses Mal
o	Delete und swap brauchen indes zum welchen die löschen oder welche sie tauschen wollen  
*/
 