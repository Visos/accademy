package com.betacom.stream.object;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.betacom.stream.object.Persona;

public class MainStream {

	public static void main(String[] args) {
		
		// creazione Stream object
		Stream<Persona> sp = Stream.of(
				new Persona("Paolo", "Rossi", 10),
				new Persona("Pietro", "Verdi", 60),
				new Persona("Anna", "Giallo", 20),
				new Persona("Giuseppe", "Nero", 40),
				new Persona("Rosa", "Primo", 80),
				new Persona("Cinzia", "Secondo",30),
				new Persona("Aldo", "Terzo", 40)
				);

		// create con builder
		Stream<String> streamBuilder = Stream.<String>builder().add("Lunedi").add("Mertedi").add("Mercoledi").add("Giovedi").add("venerdi").add("Sabato").add("Domenica").build();

		// transform in list
		List<String> ls = streamBuilder.collect(Collectors.toList());
		System.out.println("ls size = " + ls.size());

		// creazione random
		Random ran = new Random();
		Stream<Integer> lg = Stream.generate(() -> ran.nextInt(100)).limit(10);
		lg.forEach(it -> System.out.println("Random:" + it));
		
		// creazione Iterate
		Stream<Integer> sI = Stream.iterate(4, n -> n*2).limit(10);
		sI.forEach(it -> System.out.println("Iterate :" + it));
		
		System.out.println("Dati primitivi ***");
		IntStream intStream = IntStream.range(10, 15);
		intStream.forEach(it -> System.out.println("iintStream:" + it));
		
		// convert to array di string		
		Stream<String> streamBuilder1 = Stream.<String>builder().add("Lnedi").add("Mertedi").add("Mercoledi").add("Giovedi").add("venerdi").add("Sabato").add("Domenica").build();
		String[] giorni = streamBuilder1.toArray(size -> new String[size]);
		System.out.println("Array length:" + giorni.length + " array[2]:" + giorni[2]);

		List<Persona> cp = Stream.of(
				new Persona("Paolo", "Rossi", 10),
				new Persona("Pietro", "Verdi", 60),
				new Persona("Anna", "Giallo", 20),
				new Persona("Giuseppe", "Nero", 40),
				new Persona("Rosa", "Primo", 80),
				new Persona("Cinzia", "Secondo",30),
				new Persona("Aldo", "Terzo", 40)
				).collect(Collectors.toList());
		
		cp.forEach(it -> System.out.println(it));
		
		System.out.println("Filter **");
		cp.stream().filter(s -> s.getEta() > 50).forEach(s -> System.out.println(s));

		System.out.println("Dopio Filter **");
		cp.stream().filter(s -> s.getEta() > 50).filter(s -> s.getCognome().startsWith("V"))
				.forEach(s -> System.out.println(s));

		System.out.println("Count **");
		long totalMatch = cp.stream().filter(s -> s.getEta() > 20).count();
		System.out.println("totalMatch:" + totalMatch);
		
		
		
		// map permette di mappare il contenuto
		
		System.out.println("*** MAP ***");
		
		List<String> listOfString = Arrays.asList("1", "2", "3", "4", "5");
		System.out.println("Numero elements listOfString" + listOfString.size());
		
		
		List<Integer> listOfIntegers = listOfString.stream()
//				.map(Integer :: valueOf)
				 .map(s -> Integer.valueOf(s))
				.collect(Collectors.toList());
		
		System.out.println("Map:" + listOfIntegers);
		
		// match
		
		List<Persona> lp = Stream.of(
				new Persona("Paolo", "Rossi", 10),
				new Persona("Pietro", "Verdi", 60),
				new Persona("Anna", "Giallo", 20),
				new Persona("Giuseppe", "Nero", 40),
				new Persona("Rosa", "Primo", 80),
				new Persona("Cinzia", "Secondo",30),
				new Persona("Aldo", "Terzo", 40)
				).collect(Collectors.toList());
		
		boolean matchResult = lp.stream().anyMatch(s -> s.getNome().startsWith("P"));
		System.out.println("Result match :" + matchResult);
		
		
		
	}

}
