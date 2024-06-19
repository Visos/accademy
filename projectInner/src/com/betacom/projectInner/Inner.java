package com.betacom.projectInner;

public class Inner {
	
	private String fatherClass;
	private int numero;
	
	final Figlio f = new Figlio();
	
	
	
	
	
	
	// Figlio f1 = new Figlio();
	//da usare solo se il figlio non è fianle
//	public Figlio getF() {
//		return f;
//	}
//	
//	public void setF(Figlio f) {
//		this.f=f;
//	}

	public class Figlio{
		private int numero2;
		
		final Nipote n = new Nipote();
		
		
		//siccome non ho messo publi allora è una local class
		class Nipote{
			private int numero3;

			public int getNumero3() {
				return numero3;
			}

			public void setNumero3(int numero3) {
				this.numero3 = numero3;
			}
			
			
			public void showNipote() {
				System.out.println("nipote: "+ numero3);
			}
			
		}

		public int getNumero2() {
			return numero2;
		}

		public void setNumero2(int numero2) {
			this.numero2 = numero2;
		}
		
		public void sowFiglio() {
			System.out.println("figlio numero2:" + numero2 + " padre numero: "+ numero);
		}
		
	}
	
	public Figlio setInstance() {
		Figlio f = new Figlio();
			return f;
	}
	
	

	public String getFatherClass() {
		return fatherClass;
	}

	public int getNumero() {
		return numero;
	}

	public void setFatherClass(String fatherClass) {
		this.fatherClass = fatherClass;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}



}
