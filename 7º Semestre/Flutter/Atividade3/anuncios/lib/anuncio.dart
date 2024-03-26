class Anuncio {
  late String title;
  late String descricao;
  late double preco;

  Anuncio(this.title, this.descricao, this.preco);

  static final List<Anuncio> listaDeAnuncios = [];
}
