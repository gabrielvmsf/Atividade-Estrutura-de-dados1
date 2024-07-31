import 'package:anuncios/anuncio.dart';
import 'package:anuncios/databaseHelper.dart';
import 'package:sqflite/sqflite.dart';

class AnunciosHelper {
  static final String tableName = "anuncios";
  static final String idColumn = "id";
  static final String titleColumn = "titulo";
  static final String descriptionColumn = "descricao";
  static final String priceColumn = "preco";

  static String createScript() {
    return "CREATE TABLE $tableName ($idColumn INTEGER PRIMARY KEY AUTOINCREMENT, $titleColumn TEXT NOT NULL, $descriptionColumn TEXT NOT NULL, $priceColumn REAL);";
  }

  Future<Anuncio?> saveAnuncio(Anuncio anuncio) async {
    Database? db = await DatabaseHelper().db;

    if (db != null) {
      anuncio.id = await db.insert(tableName, anuncio.toMap());
      return anuncio;
    }

    return null;
  }

  Future<List<Anuncio>?> getAll() async {
    Database? db = await DatabaseHelper().db;
    if (db == null) return null;

    List<Map<String, dynamic>> returnedAnuncios = await db.query(tableName,
        columns: [idColumn, titleColumn, descriptionColumn, priceColumn]);

    List<Anuncio> anuncios = List.empty(growable: true);

    for (Map<String, dynamic> anuncio in returnedAnuncios) {
      anuncios.add(Anuncio.fromMap(anuncio));
    }
    return anuncios;
  }

  Future<Anuncio?> getById(int id) async {
    Database? db = await DatabaseHelper().db;
    if (db == null) return null;

    List<Map<String, dynamic>> returnedAnuncio = await db.query(tableName,
        columns: [idColumn, titleColumn, descriptionColumn, priceColumn],
        where: "$idColumn = ?",
        whereArgs: [id]);

    if (returnedAnuncio.isEmpty) return null;

    return Anuncio.fromMap(returnedAnuncio.first);
  }

  Future<int?> editAnuncio(Anuncio anuncio) async {
    Database? db = await DatabaseHelper().db;

    if (db == null) return null;

    return await db.update(tableName, anuncio.toMap(),
        where: "$idColumn = ?", whereArgs: [anuncio.id]);
  }

  Future<int?> deleteAnuncio(Anuncio anuncio) async {
    Database? db = await DatabaseHelper().db;

    if (db == null) return null;

    return await db
        .delete(tableName, where: "$idColumn = ?", whereArgs: [anuncio.id]);
  }
}
