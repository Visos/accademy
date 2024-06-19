package projectDate;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
//import java.sql.Date;

public class MainDate {
	public static void main (String args[]) {
		Date myDate = new Date();	//data di adesso
		
		System.out.println("myDate: "+myDate);
		
		//formato lcale italia
		Locale loc = new Locale("it");
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
		
		String date1 = df.format(new Date());
		
		System.out.println("format date: : "+date1);

		
		//formato che creo io
		String pattern = "MM/dd/yyyy";
		
		String pattern2 = "MMMM dd yyyy";
		
		String pattern3 = " EEEE dd MMMM yyyy";


		SimpleDateFormat sdf = new SimpleDateFormat(pattern3);
		
		String date2 = sdf.format(myDate);
		
		System.out.println("simple format date: : "+date2);
		
		//-----------------------------------------
		
		Client c = new Client("Gino", "Postino", 20, 04, 2001);
		
		System.out.println(c.toString());
		
		
		System.out.println("Nascita" + sdf.format(c.getDataNascita()));
		
		GregorianCalendar cal = new GregorianCalendar();
		
		cal.setTime(c.getDataNascita());
		
		System.out.println("giodno dell'anno: " + cal.get(Calendar.DAY_OF_YEAR));
		
		cal.set(Calendar.MONTH, 8);
		c.setDataNascita(cal.getTime());
		System.out.println("" + sdf.format(c.getDataNascita()));
		
		
		
		
		
		// DATA DA STRINGA A FORMATO DATA
		Date d = new Date();
		String dataString = "10/06/2024";
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			d = sdf.parse(dataString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat sdfOut = new SimpleDateFormat(pattern, loc);
		
		System.out.println("data: "+ sdf.format(sdfOut.format(d)));
		
		
		
		// da UTIL  a SQL
		java.util.Date utilDate =  new Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		// da GREGORIAN ad UTIL
		GregorianCalendar cal2 = new GregorianCalendar();
		utilDate = cal2.getTime();
		System.out.println("risltato gregorian: " + sdfOut.format(sqlDate));
		
		//
		GregorianCalendar cal3 = new GregorianCalendar();
		sqlDate = new java.sql.Date(cal3.getTime().getTime());
		System.out.println("risltato gregorian: " + sdfOut.format(sqlDate));
		
		// da SQL a UTIL
		sqlDate = new java.sql.Date(new Date().getTime());
		utilDate = new java.sql.Date(sqlDate.getTime());
		
		//da UTIL a GREGORIAN
		GregorianCalendar cal4 = new GregorianCalendar();
		cal4.setTime(utilDate);

		
		
	}
	



}
