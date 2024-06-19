package com.betacom.projectInner;

public class MainInner {
	public static void main(String args[]) {
		Inner inner = new Inner();
		inner.setFatherClass("load father");
		inner.setNumero(5);
		
		System.out.println("execute class: " + inner.getFatherClass() + "numero" + inner.getNumero());
		
		inner.f.setNumero2(30);
		
		inner.f.sowFiglio();
		
		System.out.println("inner class: " + inner.f.getNumero2());
		
		//-------------------------------------
// solo se il figlio non è final	
//		inner.setInstance();
//		inner.getF().setNumero2(0);
//		inner.getF().showFiglio();
		
		
		Inner.Figlio f = inner.new Figlio();
		Inner.Figlio.Nipote n = f.new Nipote();
		
		//nel main
		n.setNumero3(50);
		n.showNipote();
		// nella classe Figlio
		f.n.setNumero3(90);
		f.n.showNipote();

		
		

	}

}
