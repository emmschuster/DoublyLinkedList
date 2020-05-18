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
				System.out.println("Es gibt kein Element mit dem Index: "+ index);
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
	public void addElem(int val) {		//wird einfach zum schluss rangehängt wenn man keine genaue stelle sagt
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
			System.out.println("Positive index (0 included) expected!");
			return;
		}
		if (index >= length()) {
			System.out.println("Index out of Bounds!");
			return;
		}
		//wenn head loeschen -> naechtes element wird head
		if (index == getIndexByElem(head)) { 
			head = head.next;
			return;
		}
		//wenn tail loeschen -> vorheriges element wird tail
		if (index == getIndexByElem(tail)) {
			tail = tail.last;
			return;
		}
		//sonnst muessen sich beider ändern
		Elem deleteElem = getElemByIndex(index);
		Elem lastElem = deleteElem.last;
		Elem nextElem = deleteElem.next;
		lastElem.next = nextElem;
		nextElem.last = lastElem;
	}
	public void deleteHead() {
		deleteElem(getIndexByElem(head));
	}
	public void deleteTail() {
		deleteElem(getIndexByElem(tail));
	}
	public void swap(int index1, int index2) {
		if (index1 == index2) {
			System.out.println("Nothing to swap here!");
			return;
		}
		if (index1 > index2) { //index1 must be < index2
			int temp = index1;
			index1 = index2;
			index2 = temp;
		}
		Elem e1 = getElemByIndex(index1);
		Elem e2 = getElemByIndex(index2);
		if (e1 == null || e2 == null) {
			System.out.println("Index out of Bounds!");
			return;
		}
		if (e1 == head) {
			head = e2;
		}
		if (e2 == tail) {
			tail = e1;
		}
		// wenn nebeneinnander
		if (e1.next == e2) { 
			e1.next = e2.next;
			e2.last = e1.last;
			
			if (e1.next != null) {
				e1.next.last = e1;
			}
			if (e2.last != null) {
				e2.last.next = e2;
			}
			
			e2.next = e1;
			e1.last = e2;
		} else {
			Elem l = e2.last;
			Elem n = e2.next;
			
			e2.last = e1.last;
			e2.next = e1.next;
			
			e1.last = l;
			e1.next = n;
			
			if (e2.next != null) {
				e2.next.last = e2;
			}
			if (e2.last != null) {
				e2.last.next = e2;
			}
			
			if (e1.next != null) {
				e1.next.last = e1;
			}
			if (e1.last != null) {
				e1.last.next = e1;
			}
		}
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
