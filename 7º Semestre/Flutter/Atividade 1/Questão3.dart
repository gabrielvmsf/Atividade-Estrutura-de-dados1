import 'dart:io';

void main(List<String> args) {
  bool entradaValida = false;
  String numero = '';

  print('Digite o número desejado:');

  while (entradaValida == false) {
    numero = stdin.readLineSync()!;

    //Aqui vamos utilizar uma expressão regular para substituir qualquer ocorrência de \s (espaço) por ''
    numero = numero.replaceAll(RegExp(r'\s+'), '');

    //Caso tenha algum conteúdo que não seja numeral, tryParse vai retornar null
    if (numero.length < 2 || int.tryParse(numero) == null) {
      print("Digite um número valido!");
      break;
    }

    entradaValida = true;
    //print("Número após pré-processamento: $numero");
  }

  List<int> lista = numero.split('').map(int.parse).toList();
  int pontuacao = 0;

  bool segundo = false;

  for (int i = lista.length - 1; i >= 0; i--) {
    if (segundo) {
      lista[i] *= 2;

      if (lista[i] > 9) {
        lista[i] = lista[i] - 9;
      }
      pontuacao += lista[i];
      segundo = false;
    } else {
      pontuacao += lista[i];
      segundo = true;
    }
  }

  print('pontuação: $pontuacao');
  print('Lista: $lista');

  if (pontuacao % 10 == 0) {
    print("Numero válido");
  } else {
    print("Numero Inválido");
    print("socorro");
  }
}
