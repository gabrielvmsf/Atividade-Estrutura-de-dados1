import 'package:anuncios/noticiaHelper.dart';
import 'package:sqflite/sqflite.dart';
import 'package:path/path.dart';
import 'package:path_provider/path_provider.dart';

class DatabaseHelper {
  Database? _db;

  static final DatabaseHelper _instance = DatabaseHelper._internal();

  factory DatabaseHelper() => _instance;

  DatabaseHelper._internal();

  Future<Database?> get db async {
    if (_db != null) {
      return _db;
    } else {
      _db = await initDb();
      return _db;
    }
  }

  Future<Database?> initDb() async {
    final directory = await getApplicationDocumentsDirectory();
    final path = join(directory.path, 'noticiaBD.db');

    try {
      return _db = await openDatabase(path,
          version: 4, onCreate: _onCreateDB, onUpgrade: onUpgradeDB);
    } catch (e) {
      print(e);
    }
  }

  Future<void> _onCreateDB(Database db, int newVersion) async {
    await db.execute(AnunciosHelper.createScript());
  }

  Future<void> onUpgradeDB(Database db, int oldVersion, int newVersion) async {
    if (oldVersion < newVersion) {
      await db.execute("DROP TABLE ${AnunciosHelper.tableName};");
      await _onCreateDB(db, newVersion);
    }
  }
}
