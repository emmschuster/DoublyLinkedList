public class LinkedListMeins {
	public Elem2 head;
	public LinkedListMeins(int i) {
		this.head = new Elem2(i);
	}
	public void printList() {
		Elem2 headJetzt = this.head;
		while (headJetzt != null) {
			//System.out.println(headJetzt.zahl+"	"+headJetzt.adress);
			headJetzt=headJetzt.adress;
		}
	}
	public void addElement(int e) {
		Elem2 newZahl=new Elem2(e);
		if (this.head == null) {
			this.head=newZahl;
			return;
		}
		Elem2 headJetzt=this.head;
		while (headJetzt.adress != null) {
			headJetzt=headJetzt.adress;
		}
		headJetzt.adress=new Elem2(e);
		//System.out.println("Ein Element mit dem Wert "+e+" wurde hinzugefügt");
	}

	public int getlenghtList () {
		int laenge = 0;
		Elem2 currentHead = this.head;
		while(currentHead.adress != null) {
			laenge+=1;
			currentHead = currentHead.adress;
		}
		return laenge;
	}
	
	public void deleteElement (int index) {	
		Elem2 dElem=head;
		Elem2 lastElem=null;
		if (index==0) {
			head=head.adress;
			return;
		}
		if (index<0) {
			System.out.println("negative indexes aren't allowed");
			return;
		}
		if (index>getlenghtList()) {
			System.out.println("number is bigger than the List is long");
			return;
		}
		//System.out.println("Das Element an der Stelle "+index+" wurde erfolgreich gelöscht");
		while(index>0) {
			lastElem=dElem;
			dElem=dElem.adress;
			index--;
		}
		lastElem.adress=dElem.adress;
	}
}
