public class DCL {
	Elem head;
	Elem tail;
	
	public DCL (int value) {
		this.head=new Elem (value);
		this.tail=head;
	}

	public int length() {
		int length = 1;
		Elem currentElem = head;
		while (currentElem != tail) {
			length++;
			currentElem = currentElem.next;
		}
		return length;
	}
	private Elem getElemByIndex(int index) {
		Elem currentElem = head;
		int counter = 0;
		while (index != counter) {
			currentElem = currentElem.next;
			counter++;
			if (currentElem == null) {
				System.out.println("No Element with Index: " + index + " exists!");
				return null;
			}
		}
		return currentElem;
	}
	private int getIndexByElem(Elem e) {
		int index = 0;
		Elem currentElem = head;
		while (currentElem != e) {
			index++;
			currentElem = currentElem.next;
		}
		return index;
	}
	public void addElem(int val) {		//wird einfach zum schluss rangeh‰ngt wenn man keine genaue stelle sagt
		Elem nextElem = new Elem(val);
		tail.next = nextElem;
		nextElem.last = tail;
		tail = nextElem;
	}
	
	public void addElem(int val, int index) {		//Element mit bestimmten wert kommt an bestimmte stelle (index wird angegeben)
		Elem newElem = new Elem(val);
		if (index == length()) { 	//schaun ob index die erste stelle is, dann head machen
			tail.next = newElem;
			newElem.last = tail;
			tail = newElem;
			return;
		}
		Elem nextElem = getElemByIndex(index);	//nein also beliebige stelle
		Elem lastElem = getElemByIndex(index - 1);
		newElem.last = lastElem;
		newElem.next = nextElem;
		nextElem.last = newElem;
		lastElem.next = newElem;
	}
	
	public void deleteElem(int index) {
		if (index < 0) {
			System.out.println("positiver Wert muss eingegeben werden!!!");
			return;
		}
		if (index >= length()) {
			System.out.println("der index ist zu groﬂ; liste is zu klein/kurz");
			return;
		}
		if (index == getIndexByElem(head)) { 
			head = head.next;
			return;
		}
		if (index == getIndexByElem(tail)) {
			tail = tail.last;
			return;
		}
		Elem deleteElem = getElemByIndex(index);
		Elem lastElem = deleteElem.last;
		Elem nextElem = deleteElem.next;
		lastElem.next = nextElem;
		nextElem.last = lastElem;
	}
	
	public void swap(int index1, int index2) {
		if (index1 == index2) {
			System.out.println("Nothing to swap here!");
			return;
		}
		Elem e1 = getElemByIndex(index1);
		Elem e2 = getElemByIndex(index2);
		Elem temp = e1.next;
		e1.next = e2.next;
		e2.next = temp;
		temp = e1.last;
		e1.last = e2.last;
		e2.last = temp;
		e1.last.last = e2;
		e2.next.next = e1;
		e2.last.next = e2;
		e1.next.last = e1;
	}
	public void printList() {
		Elem currentElem = head;
		while (currentElem != null) {
			System.out.print("Element "+currentElem);
			System.out.print("	mit dem Wert "+currentElem.data+"\n");
			currentElem = currentElem.next;
		}
		System.out.println();
	}
}
