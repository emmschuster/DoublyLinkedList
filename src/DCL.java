
public class DCL {
	Elem head;
	Elem tail;
	
	public void addBegin(int i) {
		Elem newE = new Elem(i);
		newE.after =  head;
		newE.before = null;
		if (head != null) {
			head.before = newE;
		}
		this.head = newE;
		this.tail=head;
	}

	public void addAtEnd(int val) {
		Elem nextElem = new Elem(val);
		tail.before = nextElem;
		nextElem.after = tail;
		tail = nextElem;
	}
	
//	public void addAtEnd(int i) {
//		Elem newE = new Elem(i);
//		Elem last = this.head;
//		newE.after = null;
//		if (head == null) {
//			newE.before = null;
//			head = newE;
//			return;
//		}
//		while (last.after != null) {
//			last = last.after;
//		}
//		last.after = newE;
//		newE.before=last;
//	}
    
	public void show() {
		System.out.println("List : ");
		Elem el = head;
		while (el != null) {
			System.out.println(el.data+"	");
			el=el.after;
		}
	}
	public int getLenghList() {
		int lenge = 1;
		Elem jetzt = this.head;
		while (jetzt != tail) {
			lenge++;
			jetzt = jetzt.after;
		}
		return lenge;
	}
	
	public void swap(int x, int y) 
    { 
        // Nothing to do if x and y are same 
        if (x == y) return; 
  
        // Search for x (keep track of prevX and CurrX) 
        Elem prevX = null, currX = head; 
        while (currX != null && currX.data != x) 
        { 
            prevX = currX; 
            currX = currX.after; 
        } 
  
        // Search for y (keep track of prevY and currY) 
        Elem prevY = null, currY = head; 
        while (currY != null && currY.data != y) 
        { 
            prevY = currY; 
            currY = currY.after; 
        } 
  
        // If either x or y is not present, nothing to do 
        if (currX == null || currY == null) 
            return; 
  
        // If x is not head of linked list 
        if (prevX != null) 
            prevX.after = currY; 
        else //make y the new head 
            head = currY; 
  
        // If y is not head of linked list 
        if (prevY != null) 
            prevY.after = currX; 
        else // make x the new head 
            head = currX; 
  
        // Swap next pointers 
        Elem temp = currX.after; 
        currX.after = currY.after; 
        currY.after = temp; 
    }
}
