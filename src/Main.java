import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static String stempel;
	static long t1,t2,t3,t4;
	static DCL ll = new DCL(10);
	static LinkedList<Integer>JavaListe2=new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		stempel = date.format(now);
		System.out.println("Willst du...");
		System.out.println("... das Programm mit der DVL Liste starten? Dann 1");
		System.out.println("... Das DVL Program mit der DVL von Java vergleichen (allgemein durchschnitt zeit) ? Dann 2");
		System.out.println("... wieder vergleichen, aber diesmal die einzelnen Vorgänge? Dann 3");

		int antwort = sc.nextInt();
		switch (antwort) {
		case 1:
			option1();
			break;
		case 2:
			option2();
			break;
		case 3:
			option3();
			break;
		}
		sc.close();
		
	}
	private static void option3() {
		ll.addElem(1);
		ll.addElem(2);
		ll.addElem(3);
		ll.addElem(11);
		ll.addElem(22);
		ll.addElem(33);
		JavaListe2.add(1);
		JavaListe2.add(2);
		JavaListe2.add(3);
		JavaListe2.add(11);
		JavaListe2.add(22);
		JavaListe2.add(33);
		laenge();
		addElementSchluss();
		addElementBestimmteStelle();
		deleteDenIndex();
		deleteFirst();
		deleteLast();
//		tauschen();
	}
	/*private static void tauschen() {
		t1=System.nanoTime();
		ll.swap(2, 4);
		t2=System.nanoTime();
		t3=System.nanoTime();
		JavaListe2.
		t4=System.nanoTime();
		System.out.println("Anzeigen der Liste (Dauer) : Meine DVL "+(t2-t1)+"s		Javas Linked List "+(t4-t3));
		
	}*/
	private static void deleteLast() {
		t1=System.nanoTime();
		ll.deleteTail();
		t2=System.nanoTime();
		t3=System.nanoTime();
		JavaListe2.removeLast();
		t4=System.nanoTime();
		System.out.println("Letztes Element loeschen (Dauer) : Meine DVL "+(t2-t1)+"s		Javas Linked List "+(t4-t3));
	}
	private static void deleteFirst() {
		t1=System.nanoTime();
		ll.deleteHead();
		t2=System.nanoTime();
		t3=System.nanoTime();
		JavaListe2.removeFirst();
		t4=System.nanoTime();
		System.out.println("Erstes Element loeschen (Dauer) : Meine DVL "+(t2-t1)+"s		Javas Linked List "+(t4-t3));
	}
	private static void deleteDenIndex() {		//deleteElem vs remove
		t1=System.nanoTime();
		ll.deleteElem(4);
		t2=System.nanoTime();
		t3=System.nanoTime();
		JavaListe2.remove(4);
		t4=System.nanoTime();
		System.out.println("Element beliebige Stelle loeschen (Dauer) : Meine DVL "+(t2-t1)+"s		Javas Linked List "+(t4-t3));
	}
	private static void addElementBestimmteStelle() {
		t1=System.nanoTime();
		ll.addElem(1001, 4);
		t2=System.nanoTime();
		t3=System.nanoTime();
		JavaListe2.add(4, 1001);
		t4=System.nanoTime();
		System.out.println("Element beliebige Stelle hinzufuegen (Dauer) : Meine DVL "+(t2-t1)+"s		Javas Linked List "+(t4-t3));
	}
	private static void addElementSchluss() {
		t1=System.nanoTime();
		ll.addElem(1000);
		t2=System.nanoTime();
		t3=System.nanoTime();
		JavaListe2.add(1000);
		t4=System.nanoTime();
		System.out.println("Element hinten hinzufuegen (Dauer) : Meine DVL "+(t2-t1)+"s		Javas Linked List "+(t4-t3));
	}
	private static void laenge() {		//length vs size
		t1=System.nanoTime();
		ll.length();
		t2=System.nanoTime();
		t3=System.nanoTime();
		JavaListe2.size();
		t4=System.nanoTime();
		System.out.println("Laenge herausfinden (Dauer) : Meine DVL "+(t2-t1)+"s 		 Javas Linked List "+(t4-t3));
	}
	public static void option2() {
		System.out.println("Zeitmessung Java DVK 1000 Durchgänge (erstellen, 4 hinzufügen, "
				+ "letztes loeschen, 2. Stelle loeschen)");
		t1=System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			LinkedList<Integer>JavaListe=new LinkedList<Integer>();
			JavaListe.add(2);
			JavaListe.add(4);
			JavaListe.add(6);
			JavaListe.add(2, 4);
			JavaListe.removeLast();
			JavaListe.remove(2);
		}
		t2=System.nanoTime();
		System.out.println(t2-t1+"ns hat es gedauert.");
		
		System.out.println("Zeitmessung Meine DVK, 1000 Durchgänge (erstellen, 4 hinzufügen, "
				+ "letztes loeschen, 2. Stelle loeschen)");
		t3=System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			DCL l = new DCL(10);
			l.addElem(2);
			l.addElem(4);
			l.addElem(6);
			l.addElem(2, 4);
			l.deleteTail();
			l.deleteElem(2);
		}
		t4=System.nanoTime();
		System.out.println(t4-t3+"ns hat es gedauert.");
		
		System.out.println("\nDie Java Implementierung ist um "+((t4-t3)-(t2-t1))+"ns schneller.");
		insFileSchreiben(); 
	}
	private static void insFileSchreiben() {
		FileWriter pWriter = null;
        try {
            pWriter = new FileWriter("Emma"+stempel+".txt");
            System.out.println("Die Java Implementierung ist um "+(((t4-t3)-(t2-t1))/1000)+"mikro s schneller.");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
		
	}
	public static void option1() {		//letztes element löscheln... da haggelts no
		ll.addElem(1);
		ll.addElem(2);
		ll.addElem(3);
		ll.addElem(11);
		ll.addElem(22);
		ll.addElem(33);
		ll.addElem(666, 3);
		System.out.println("Länge der Liste: " + ll.length());
		ll.printList();
		System.out.println("Stellen mit dem index 1 und 2 werden getauscht: ");
		ll.swap(1, 2);
		ll.printList();
		System.out.println("Das Element mit index 4 wird geloescht");
		ll.deleteElem(4); 
		System.out.println("Jetzige Länge: " + ll.length());
		ll.printList();
		System.out.println("Das erste Element wird geloescht");
		ll.deleteHead(); 
		System.out.println("Jetzige Länge: " + ll.length());
		ll.printList();
		System.out.println("Das letzte Element wird geschöscht");
		ll.deleteTail(); 
		System.out.println("Jetzige Länge: " + ll.length());
		ll.printList();
	}
}
