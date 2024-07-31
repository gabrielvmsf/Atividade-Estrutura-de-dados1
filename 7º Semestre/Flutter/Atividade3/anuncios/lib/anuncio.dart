import 'dart:io';

import 'package:path_provider/path_provider.dart';

class Anuncio {
  static int _idCounter = 0;

  late int id;
  late String title;
  late String descricao;
  late double preco;
  late String imageUrl;
  late File? imageFile;

  Anuncio(
    this.title,
    this.descricao,
    this.preco,
    this.imageFile,
  ) {
    imageUrl = imageFile!.path;
    id = _idCounter++;
  }

  Anuncio.fromMap(Map<String, dynamic> map)
      : id = map['id'],
        title = map['title'],
        descricao = map['descricao'],
        preco = map['preco'],
        imageUrl = map['image_url'];

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'title': title,
      'descricao': descricao,
      'preco': preco,
      'image_url': imageUrl,
    };
  }

  static List<Anuncio> listaDeAnuncios = [];
}
