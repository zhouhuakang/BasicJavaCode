package hank.testbasic.generic;

import java.util.Collection;
import java.util.Iterator;

public class Collections {
	public static <A extends Comparable<A>> A max(Collection<A> xs){
		Iterator<A> xi = xs.iterator();
		A w = xi.next();
		while(xi.hasNext()){
			A x = xi.next();
			if (w.compareTo(x) < 0) {
				w = x;
			}
		}
		return w;
	}
}
