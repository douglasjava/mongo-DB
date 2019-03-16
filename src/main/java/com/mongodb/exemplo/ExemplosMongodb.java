package com.mongodb.exemplo;

import java.net.UnknownHostException;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class ExemplosMongodb {

	public static void main(String[] args) throws UnknownHostException {

		int i = 1;

		Mongo mongo = new Mongo("10.2.10.5", 27017);
		DB db = mongo.getDB("testemongodb");

		BasicDBObject doc = new BasicDBObject("username", "douglasDias").append("nome", "Douglas Dias").append("cidade", "Contagem");
		DBCollection collec = db.getCollection("dados");
		collec.insert(doc);

		// Lista as coleções.
		DBCursor cursor = collec.find();

		while (cursor.hasNext()) {
			System.out.println("Documento Inserido: " + i);
			System.out.println(cursor.next());
			i++;
		}

		System.out.println("Banco de dados armazanados: ");
		List<String> dbs = mongo.getDatabaseNames();
		for (String dbStr : dbs) {
			System.out.println(dbStr);
		}

		System.out.println("Fim execução");

	}

}
