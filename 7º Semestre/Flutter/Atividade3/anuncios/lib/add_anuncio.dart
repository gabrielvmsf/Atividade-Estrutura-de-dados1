import 'dart:io';

import 'package:flutter/material.dart';
import 'package:anuncios/anuncio.dart';
import 'package:image_picker/image_picker.dart';

class AddAnuncio extends StatefulWidget {
  const AddAnuncio({Key? key}) : super(key: key);

  @override
  _AddAnuncioState createState() => _AddAnuncioState();
}

class _AddAnuncioState extends State<AddAnuncio> {
  final ImagePicker imagePicker = ImagePicker();
  File? imageFile;

  pick(ImageSource source) async {
    final pickedFile = await imagePicker.pickImage(source: source);
    if (pickedFile != null) {
      setState(() {
        imageFile = File(pickedFile.path);
      });
    }
  }

  final _formKey = GlobalKey<FormState>();
  late TextEditingController _tituloController;
  late TextEditingController _descricaoController;
  late TextEditingController _precoController;

  @override
  void initState() {
    super.initState();
    _tituloController = TextEditingController();
    _descricaoController = TextEditingController();
    _precoController = TextEditingController();
  }

  @override
  void dispose() {
    _tituloController.dispose();
    _descricaoController.dispose();
    _precoController.dispose();
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
        title: const Text('Adicionar Anúncio'),
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
                child: Container(
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
                      : IconButton(
                          onPressed: () {
                            pick(ImageSource.gallery);
                          },
                          icon: const Icon(Icons.add_a_photo),
                          color: Colors.white,
                        ),
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
                    'Adicionar Anúncio',
                    style: TextStyle(color: Colors.black),
                  ),
                ),
              ),
              const SizedBox(height: 16.0),
            ],
          ),
        ),
      ),
    );
  }
}
