import 'package:anuncios/add_anuncio.dart';
import 'package:anuncios/anuncio.dart';
import 'package:anuncios/edit_anuncio.dart';
import 'package:anuncios/noticiaHelper.dart';
import 'package:flutter/material.dart';
import 'package:url_launcher/url_launcher.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  AnunciosHelper _helper = AnunciosHelper();

  void launchWhatsappWithText(String message) async {
    final url = "whatsapp://send?text=$message";
    if (await canLaunchUrl(Uri.parse(Uri.encodeFull(url)))) {
      await launchUrl(Uri.parse(Uri.encodeFull(url)));
    } else {
      throw 'Could not launch $url';
    }
  }

  @override
  void initState() {
    super.initState();
  }

  @override
  void didChangeDependencies() {
    _helper.getAll().then((data) {
      if (data != null) {
        setState(() {
          Anuncio.listaDeAnuncios = data.toList();
        });
      }
    });
    super.didChangeDependencies();
  }

  void _addAnuncio() async {
    Navigator.push(
      context,
      MaterialPageRoute(builder: (context) => const AddAnuncio()),
    ).then((result) async {
      if (result != null && result is Anuncio) {
        setState(() {
          Anuncio.listaDeAnuncios.add(result);
        });
        await _helper.saveAnuncio(result);
      }
    });
  }

  void _editAnuncio(int index) async {
    final Anuncio anuncio = Anuncio.listaDeAnuncios[index];
    Navigator.push(
      context,
      MaterialPageRoute(
        builder: (context) => EditAnuncio(
          titulo: anuncio.title,
          descricao: anuncio.descricao,
          preco: anuncio.preco,
          imageUrl: anuncio.imageUrl,
          index: index,
        ),
      ),
    ).then((result) async {
      if (result != null && result is Anuncio) {
        setState(() {
          Anuncio.listaDeAnuncios[index] = result;
        });
        await _helper.editAnuncio(result);
      }
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: const Color(0xFF004D56),
        toolbarHeight: 80,
        title: Container(
          decoration: BoxDecoration(
            color: Colors.black,
            borderRadius: BorderRadius.circular(8.0),
          ),
          child: Row(
            children: [
              IconButton(
                onPressed: () {
                  showDialog(
                    context: context,
                    builder: (BuildContext context) {
                      return AlertDialog(
                        title: const Text('Pesquisa por texto'),
                        content: const Text(
                            'Este botão é só para representar o layout da amazon, não é funcional 😅'),
                        actions: [
                          TextButton(
                            onPressed: () {
                              Navigator.of(context).pop();
                            },
                            child: const Text('Fechar'),
                          ),
                        ],
                      );
                    },
                  );
                },
                icon: const Icon(Icons.search),
                color: Colors.white,
              ),
              const Expanded(
                child: TextField(
                  style: TextStyle(color: Colors.white),
                  decoration: InputDecoration(
                    border: InputBorder.none,
                    hintText: 'Pesquisar na Amazon.com.br',
                    hintStyle: TextStyle(color: Colors.white54),
                  ),
                ),
              ),
              IconButton(
                onPressed: () {
                  showDialog(
                    context: context,
                    builder: (BuildContext context) {
                      return AlertDialog(
                        title: const Text('Pesquisa por imagem'),
                        content: const Text(
                            'Este botão é só para representar o layout da amazon, não é funcional 😅'),
                        actions: [
                          TextButton(
                            onPressed: () {
                              Navigator.of(context).pop();
                            },
                            child: const Text('Fechar'),
                          ),
                        ],
                      );
                    },
                  );
                },
                icon: const Icon(Icons.photo),
                color: Colors.white,
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: const Color(0xFF004D56),
        onPressed: _addAnuncio,
        child: const Icon(
          Icons.add,
          color: Colors.white,
        ),
      ),
      body: Anuncio.listaDeAnuncios.isEmpty
          ? const Center(
              child: Text(
                'Não encontramos anuncios 😢',
                style: TextStyle(fontSize: 18),
              ),
            )
          : ListView.builder(
              itemCount: Anuncio.listaDeAnuncios.length,
              itemBuilder: (BuildContext context, int index) {
                final Anuncio anuncio = Anuncio.listaDeAnuncios[index];

                return Container(
                  margin: const EdgeInsets.all(8.0),
                  padding: const EdgeInsets.all(8.0),
                  decoration: BoxDecoration(
                    border: Border.all(color: Colors.grey),
                    borderRadius: BorderRadius.circular(8.0),
                  ),
                  child: ListTile(
                    leading: anuncio.imageUrl != null
                        ? Container(
                            width: 50,
                            height: 50,
                            decoration: BoxDecoration(
                              borderRadius: BorderRadius.circular(8.0),
                              image: DecorationImage(
                                image: NetworkImage(anuncio.imageUrl),
                                fit: BoxFit.cover,
                              ),
                            ),
                          )
                        : const Icon(
                            Icons.hide_image_outlined,
                            color: Colors.grey,
                            size: 50,
                          ),
                    title: Text(anuncio.title.length > 50
                        ? '${anuncio.title.substring(0, 50)}...'
                        : anuncio.title),
                    subtitle: Text(anuncio.descricao.length > 50
                        ? '${anuncio.descricao.substring(0, 50)}...'
                        : anuncio.descricao),
                    trailing: Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        Text(
                          'R\$${anuncio.preco.toStringAsFixed(2)}',
                          style: const TextStyle(fontSize: 18),
                        ),
                        PopupMenuButton<String>(
                          onSelected: (value) async {
                            if (value == 'editar') {
                              _editAnuncio(index);
                            } else if (value == 'deletar') {
                              setState(() {
                                Anuncio.listaDeAnuncios.removeAt(index);
                              });
                              await _helper.deleteAnuncio(anuncio);
                            } else if (value == 'compartilhar') {
                              final message =
                                  "Anúncio:\n\nTítulo: ${anuncio.title}\nDescrição: ${anuncio.descricao}\nPreço: R\$${anuncio.preco.toStringAsFixed(2)}";
                              launchWhatsappWithText(message);
                            }
                          },
                          itemBuilder: (BuildContext context) => [
                            const PopupMenuItem<String>(
                              value: 'editar',
                              child: Text('Editar'),
                            ),
                            const PopupMenuItem<String>(
                              value: 'deletar',
                              child: Text('Deletar'),
                            ),
                            const PopupMenuItem<String>(
                              value: 'compartilhar',
                              child: Text('Compartilhar'),
                            ),
                          ],
                        ),
                      ],
                    ),
                  ),
                );
              },
            ),
    );
  }
}
