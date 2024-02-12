import 'dart:io';

void main(List<String> args) {
  String codigo = '';
  String cor = '';
  int contador = 0;

  print(
      'Digite as cores desejadas: • Preto • Marrom • Vermelho• Laranja • Amarelo • Verde • Azul • Violeta • Cinza • Branco (digite 0 para cancelar)');

  while (cor != '0') {
    cor = stdin.readLineSync()!;

    if (cor == '0') break;

    contador++;

    if (contador < 3) {
      switch (cor) {
        case 'Preto':
          codigo += '0';
          break;
        case 'Marrom':
          codigo += '1';
          break;
        case 'Vermelho':
          codigo += '2';
          break;
        case 'Laranja':
          codigo += '3';
          break;
        case 'Amarelo':
          codigo += '4';
          break;
        case 'Verde':
          codigo += '5';
          break;
        case 'Azul':
          codigo += '6';
          break;
        case 'Violeta':
          codigo += '7';
          break;
        case 'Cinza':
          codigo += '8';
          break;
        case 'Branco':
          codigo += '9';
          break;
        default:
          print('Cor não encontrada, digite novamente!');
      }
    }
  }

  print('O codigo é $codigo');
}
