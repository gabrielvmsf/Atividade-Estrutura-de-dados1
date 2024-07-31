import 'dart:io';

import 'package:flutter/material.dart';
import 'package:anuncios/anuncio.dart';
import 'package:image_picker/image_picker.dart';
import 'package:path_provider/path_provider.dart';

class EditAnuncio extends StatefulWidget {
  final String titulo;
  final String descricao;
  final double preco;
  final int index;
  final String imageUrl;

  const EditAnuncio(
      {Key? key,
      required this.titulo,
      required this.descricao,
      required this.preco,
      required this.index,
      required this.imageUrl})
      : super(key: key);

  @override
  _EditAnuncioState createState() => _EditAnuncioState();
}

class _EditAnuncioState extends State<EditAnuncio> {
  final ImagePicker imagePicker = ImagePicker();
  File? imageFile;
  late String imageFileName;

  pick(ImageSource source) async {
    final pickedFile = await imagePicker.pickImage(source: source);
    if (pickedFile != null) {
      setState(() {
        imageFile = File(pickedFile.path);
      });

      Directory directory = await getApplicationDocumentsDirectory();
      String _localPath = directory.path;
      String uniqueID = UniqueKey().toString();
      final File savedImage =
          await imageFile!.copy('$_localPath/image_$uniqueID.png');
      imageFileName = ('$_localPath/image_$uniqueID.png');
      setState(() {
        imageFile = savedImage;
      });
    }
  }

  final _formKey = GlobalKey<FormState>();
  late TextEditingController _tituloController;
  late TextEditingController _descricaoController;
  late TextEditingController _precoController;
  late TextEditingController _urlController;

  @override
  void initState() {
    super.initState();
    _tituloController = TextEditingController(text: widget.titulo);
    _descricaoController = TextEditingController(text: widget.descricao);
    _precoController = TextEditingController(text: widget.preco.toString());
    _urlController = TextEditingController(text: widget.imageUrl);
  }

  @override
  void dispose() {
    _tituloController.dispose();
    _descricaoController.dispose();
    _precoController.dispose();
    _urlController.dispose();
    super.dispose();
  }

  void _enviarFormulario() {
    if (_formKey.currentState!.validate()) {
      Anuncio novoAnuncio = Anuncio(
          _tituloController.text,
          _descricaoController.text,
          double.parse(_precoController.text),
          imageFile!);

      Navigator.pop(context, novoAnuncio);
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Editar Anúncio'),
        leading: IconButton(
          icon: const Icon(Icons.arrow_back),
          onPressed: () {
            Navigator.of(context).pop();
          },
        ),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Form(
          key: _formKey,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Center(
                child: Stack(
                  children: [
                    Container(
                      width: 100,
                      height: 100,
                      decoration: const BoxDecoration(
                        shape: BoxShape.circle,
                        color: Colors.grey,
                      ),
                      child: imageFile != null
                          ? ClipOval(
                              child: Image.network(
                                imageFile!.path,
                                fit: BoxFit.cover,
                                width: double.infinity,
                                height: double.infinity,
                              ),
                            )
                          : _urlController.text.isNotEmpty
                              ? ClipOval(
                                  child: Image.network(
                                    _urlController.text,
                                    fit: BoxFit.cover,
                                    width: double.infinity,
                                    height: double.infinity,
                                  ),
                                )
                              : Container(
                                  decoration: const BoxDecoration(
                                    shape: BoxShape.circle,
                                    color: Colors.black,
                                  ),
                                  child: IconButton(
                                    onPressed: () {
                                      pick(ImageSource.gallery);
                                    },
                                    icon: const Icon(Icons.add_a_photo,
                                        color: Colors.white),
                                  ),
                                ),
                    ),
                    Positioned(
                      right: 0,
                      bottom: 0,
                      child: Container(
                        width: 30,
                        height: 30,
                        decoration: BoxDecoration(
                          shape: BoxShape.rectangle,
                          borderRadius: BorderRadius.circular(15),
                          color: Colors.black.withOpacity(0.8),
                        ),
                        alignment: Alignment.center,
                        child: Opacity(
                          opacity: 0.8,
                          child: IconButton(
                            onPressed: () {
                              pick(ImageSource.gallery);
                            },
                            icon: const Icon(Icons.edit, color: Colors.white),
                          ),
                        ),
                      ),
                    )
                  ],
                ),
              ),
              TextFormField(
                controller: _tituloController,
                decoration: const InputDecoration(labelText: 'Título'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor, insira um título';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _descricaoController,
                decoration: const InputDecoration(labelText: 'Descrição'),
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor, insira uma descrição';
                  }
                  return null;
                },
              ),
              TextFormField(
                controller: _precoController,
                decoration: const InputDecoration(labelText: 'Preço'),
                keyboardType: TextInputType.number,
                validator: (value) {
                  if (value == null || value.isEmpty) {
                    return 'Por favor, insira um preço';
                  }
                  if (double.tryParse(value) == null) {
                    return 'Por favor, insira um valor numérico';
                  }
                  return null;
                },
              ),
              const SizedBox(height: 16.0),
              Center(
                child: ElevatedButton(
                  onPressed: _enviarFormulario,
                  child: const Text(
                    'Editar Anúncio',
                    style: TextStyle(color: Colors.black),
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }
}
