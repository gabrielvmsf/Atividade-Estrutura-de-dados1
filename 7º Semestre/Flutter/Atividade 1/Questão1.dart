import 'dart:io';

void main(List<String> args) {
  print('Digite o texto desejado:');

  String texto = stdin.readLineSync()!;
  List lista = texto.split('');
  int pontuacao = 0;

  lista.forEach((element) {
    switch (element) {
      case 'A' || 'E' || 'I' || 'O' || 'U' || 'L' || 'N' || 'R' || 'S' || 'T':
        pontuacao += 1;
        break;
      case 'D' || 'G':
        pontuacao += 2;
        break;
      case 'B' || 'C' || 'M' || 'P':
        pontuacao += 3;
        break;
      case 'F' || 'H' || 'V' || 'W' || 'Y':
        pontuacao += 4;
        break;
      case 'K':
        pontuacao += 5;
        break;
      case 'J' || 'X':
        pontuacao += 8;
        break;
      case 'Q' || 'Z':
        pontuacao += 10;
        break;
      default:
        break;
    }
  });
  print(pontuacao);
}
