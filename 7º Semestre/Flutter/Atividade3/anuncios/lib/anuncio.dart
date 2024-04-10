class Anuncio {
  static int _idCounter = 0;

  late int id;
  late String title;
  late String descricao;
  late double preco;

  Anuncio(this.title, this.descricao, this.preco) : id = _idCounter++;

  Anuncio.fromMap(Map<String, dynamic> map)
      : id = map['id'],
        title = map['title'],
        descricao = map['descricao'],
        preco = map['preco'];

  Map<String, dynamic> toMap() {
    return {
      'id': id,
      'title': title,
      'descricao': descricao,
      'preco': preco,
    };
  }

  static List<Anuncio> listaDeAnuncios = [];
}
