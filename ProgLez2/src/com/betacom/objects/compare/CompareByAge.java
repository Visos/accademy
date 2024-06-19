package com.betacom.objects.compare;
import com.betacom.objects.*;
public class CompareByAge implements java.util.Comparator<Cliente>{

	@Override
	public int compare(Cliente a, Cliente b) {
		return a.getEtà()-b.getEtà();
	}

}
