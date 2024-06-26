package com.betacom.sql;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.sql.dao.Dipendenti;
import com.betacom.sql.utilities.DBUtilities;

public class ProcessUpdate extends DBUtilities  implements SQLProcess{
	private static SQLManager db = new SQLManager();
	
	@Override
	public void execute() {
		String dbURL = "jdbc:mysql://localhost:3306/dbprova";	
		Connection con = db.initSQL(dbURL, "root", "DataBase.345");
		System.out.println("after connection to db");;
		
		String sql = "insert into dipendenti (nome, cognome, data_assunzione, telefono, mansione, stipendio) values"
				+ "	(? , ? , ?, ? , ? , ?)";
		
		Map<Integer, Object> params = buildParameters(new Object[]{
				"Franco",
				"Insert",
				"2024-09-09",
				"636342252",
				"Impiegato",
				2600
			});
		
		int rc = db.insert(con, sql, params);
		System.out.println("After insert rc: " + rc);
		
		sql = "select * from dbprova.dipendenti";
		List<Dipendenti> lD = transformResultInDTO(db.list(con, sql, new HashMap<Integer, Object>()));		

		lD.forEach(d -> System.out.println(d));
		
		
		
		//-----------------------------UPDATE-------------------------
		
		sql = "update dipendenti set id_ufficio = ? where id_user = ?";
		
		params = buildParameters(new Object[]{
				2,
				5
			});
		
		rc = db.update(con, sql, params);
		System.out.println("*******************DOPO UPDATE*******************" + rc);
		
		sql = "select * from dipendenti";
		lD = transformResultInDTO(db.list(con, sql,  new HashMap<Integer, Object>()));
		lD.forEach(d -> System.out.println(d));

		
		//---------------------------DELETE--------------------------
		
		//query per selezionare in base al numero di telefono che user eliminare
		sql = "select * from dipendenti where telefono = ?";
		params = buildParameters(new Object[]{
				"636342252"
			});
		lD = transformResultInDTO(db.list(con, sql, params));

		sql = "delete from dipendenti where id_user = ?";
		System.out.println("STO CANCELLANDO:" +lD.get(0).getIdUser() );

		params = buildParameters(new Object[]{
				lD.get(0).getIdUser()
			});
		
		rc = db.update(con, sql, params);
		
		
		System.out.println("*******************DOPO delete*******************" + rc);
		
		sql = "select * from dipendenti";
		lD = transformResultInDTO(db.list(con, sql, new HashMap<Integer, Object>()));
		lD.forEach(d -> System.out.println(d));
	}
}
