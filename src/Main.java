public class Main {

	public static void main(String[] args) {
		DCL ll = new DCL(10);
		ll.addElem(1);
		ll.addElem(2);
		ll.addElem(3);
		ll.addElem(11);
		ll.addElem(22);
		ll.addElem(33);
		ll.addElem(666, 3);
		System.out.println("L�nge der Liste: " + ll.length());
		ll.printList();
		System.out.println("Stellen mit dem index 1 und 2 werden getauscht: ");
		ll.swap(4, 5);
		ll.printList();
		System.out.println("Das Element mit index 5 wird geschl�scht also 22");
		ll.deleteElem(5); 
		System.out.println("Jetzige L�nge: " + ll.length());
		ll.printList();
		System.out.println("Das Element mit index 0 wird geschl�scht (also es erste)");
		ll.deleteElem(0); 
		System.out.println("Jetzige L�nge: " + ll.length());
		ll.printList();
		System.out.println("Das letzte Element wird gesch�scht also mit dem Index "+ll.length());
		ll.deleteElem(ll.length()-1); 
		System.out.println("Jetzige L�nge: " + ll.length());
		ll.printList();
	}

}
/*
 * o	Erstes head und letztes Tail; ein Element hat Adresse vom n�chsten und vom vorherigen a; jedes Element hat 2 Adressen also 2 pointer
o	L�nge, Ausgabe mit Adressen, Eingabe also hinzuf�gen, DELETE, und dann noch SWAP dieses Mal
o	Delete und swap brauchen indes zum welchen die l�schen oder welche sie tauschen wollen  
*/