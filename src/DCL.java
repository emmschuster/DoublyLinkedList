
public class DCL {
	Elem head;
	public void addBegin(int i) {
		Elem newE = new Elem(i);
		newE.after =  head;
		newE.before = null;
		if (head != null) {
			head.before = newE;
		}
		head = newE;
	}
//	public void addAfter(int i, int j) {
//		Elem newE = new Elem(j);
//		
//	}
	public void addAtEnd(int i) {
		Elem newE = new Elem(i);
		Elem last = this.head;
		newE.after = null;
		if (head == null) {
			newE.before = null;
			head = newE;
			return;
		}
		while (last.after != null) {
			last = last.after;
		}
		last.after = newE;
		newE.before=last;
	}
    
	public void show() {
		System.out.println("List : ");
		while (head.after != null) {
			System.out.println(head.data+"	"+head.after);
			head=head.after;
		}
		
	}
	public int getLenghList() {
		int lenge = 0;
		Elem jetzt = this.head;
		while (jetzt.after != null) {
			lenge++;
			jetzt = jetzt.after;
		}
		return lenge;
	}
}
