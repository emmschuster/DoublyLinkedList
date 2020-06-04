import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	static String stempel;
	public static void main(String[] args) {
		Scanner sc= new Scanner (System.in);
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		LocalDateTime now = LocalDateTime.now();
		stempel = date.format(now);
		System.out.println("Willst du...");
		System.out.println("... das Programm mit der DVL Liste starten? Dann 1");
		System.out.println("... Das DVL Program mit der DVL von Java vergleichen? Dann 2");
		int antwort = sc.nextInt();
		switch (antwort) {
		case 1:
			option1();
			break;
		case 2:
			option2();
			break;
		}
		sc.close();
	}
	public static void option2() {
		System.out.println("Zeitmessung Java DVK 1000 Durchg�nge (erstellen, 4 hinzuf�gen, "
				+ "letztes loeschen, 2. Stelle loeschen)");
		long t1=System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			LinkedList<Integer>JavaListe=new LinkedList<Integer>();
			JavaListe.add(2);
			JavaListe.add(4);
			JavaListe.add(6);
			JavaListe.add(2, 4);
			JavaListe.removeLast();
			JavaListe.remove(2);
		}
		long t2=System.nanoTime();
		System.out.println(t2-t1+"ns hat es gedauert.");
		
		System.out.println("Zeitmessung Meine DVK, 1000 Durchg�nge (erstellen, 4 hinzuf�gen, "
				+ "letztes loeschen, 2. Stelle loeschen)");
		long t3=System.nanoTime();
		for (int i = 0; i < 1000; i++) {
			DCL l = new DCL(10);
			l.addElem(2);
			l.addElem(4);
			l.addElem(6);
			l.addElem(2, 4);
			l.deleteTail();
			l.deleteElem(2);
		}
		long t4=System.nanoTime();
		System.out.println(t4-t3+"ns hat es gedauert.");
		
		System.out.println("\nDie Java Implementierung ist um "+((t4-t3)-(t2-t1))+"ns schneller.");
		
		 FileWriter pWriter = null;
	        try {
//	        	Calendar cal = Calendar.getInstance ();
//	        	String uhrzeit= cal.get( Calendar.HOUR_OF_DAY ) + ":" +
//	                      cal.get( Calendar.MINUTE ) + ":" +
//	                      cal.get( Calendar.SECOND ) + ":" +
//	                      cal.get( Calendar.MILLISECOND ) ;
//	        	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//	        	timestamp=timestamp;
	            pWriter = new FileWriter("Emma"+stempel+".txt");
	            System.out.println("Die Java Implementierung ist um "+((t4-t3)-(t2-t1))+"ns schneller.");
	        } catch (IOException ioe) {
	            ioe.printStackTrace();
	        } 
	}
	public static void option1() {	//letztes element l�scheln... da haggelts no
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
		ll.swap(1, 2);
		ll.printList();
		System.out.println("Das Element mit index 4 wird geloescht");
		ll.deleteElem(4); 
		System.out.println("Jetzige L�nge: " + ll.length());
		ll.printList();
		System.out.println("Das erste Element wird geloescht");
		ll.deleteHead(); 
		System.out.println("Jetzige L�nge: " + ll.length());
		ll.printList();
		System.out.println("Das letzte Element wird gesch�scht");
		ll.deleteTail(); 
		System.out.println("Jetzige L�nge: " + ll.length());
		ll.printList();
	}
}
