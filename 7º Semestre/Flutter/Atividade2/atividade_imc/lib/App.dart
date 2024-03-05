import 'package:flutter/material.dart';

class App extends StatefulWidget {
  const App({Key? key});

  @override
  _AppState createState() => _AppState();
}

class _AppState extends State<App> {
  //Controllers para armazenar os valores digitados pelo usuário
  final alturaController = TextEditingController();
  final pesoController = TextEditingController();
  String resultado = '';

  //Posteriormente eu posso utilizar esse map para achar o diretorio pela palavra-chave
  final Map<String, String> imcImages = {
    'Abaixo do peso': 'assets/images/AbaixoDoPeso.png',
    'Peso ideal (parabéns)': 'assets/images/PesoIdeal.png',
    'Levemente acima do peso': 'assets/images/LevementeAcimaPeso.png',
    'Obesidade grau I': 'assets/images/ObesidadeGrauI.png',
    'Obesidade grau II (severa)': 'assets/images/ObesidadeGrauII.png',
    'Obesidade grau III (mórbida)': 'assets/images/ObesidadeGrauIII.png',
  };

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.blue,
          title: const Text('🧮 Calculadora IMC 🧮',
              textAlign: TextAlign.center,
              style: TextStyle(
                color: Colors.white,
                fontWeight: FontWeight.w100,
              )),
          centerTitle: true,
        ),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            //Coluna para colocar o formulario
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              children: [
                Image.asset('assets/images/doctor.png',
                    width: 180, height: 180, fit: BoxFit.cover),
                const SizedBox(height: 20),
                TextField(
                  controller: alturaController,
                  decoration: const InputDecoration(
                    labelText: 'Altura (m)',
                    labelStyle: TextStyle(
                      color: Colors.blue,
                    ),
                  ),
                ),
                TextField(
                  controller: pesoController,
                  decoration: const InputDecoration(
                    labelText: 'Peso (kg)',
                    labelStyle: TextStyle(
                      color: Colors.blue,
                    ),
                  ),
                ),
                const SizedBox(height: 20),
                ElevatedButton(
                  onPressed: () {
                    setState(() {
                      double altura =
                          double.tryParse(alturaController.text) ?? 0.0;
                      double peso = double.tryParse(pesoController.text) ?? 0.0;
                      resultado = calcularResultado(altura, peso);
                    });
                  },
                  child: const Text(
                    'Calcular',
                    style: TextStyle(
                      color: Colors.blue,
                    ),
                  ),
                ),
                const SizedBox(height: 20),
                const Text(
                  'Resultado:',
                  style: TextStyle(
                    color: Colors.blue,
                  ),
                ),
                //Texto dinamico para mostrar o resultado
                Text(
                  resultado,
                  textAlign: TextAlign.center,
                  style: const TextStyle(
                    color: Colors.blue,
                  ),
                ),
                const SizedBox(height: 40),
                //Procurar na lista de imagens a imagem correspondente ao resultado
                if (imcImages.containsKey(resultado))
                  Image.asset(imcImages[resultado]!),
              ],
            ),
          ),
        ),
      ),
    );
  }

  //Calculo do resultado do IMC, retornando Status em texto
  String calcularResultado(double altura, double peso) {
    double imc = peso / (altura * altura);
    if (imc < 18.5) {
      return 'Abaixo do peso';
    } else if (imc >= 18.5 && imc < 24.9) {
      return 'Peso ideal (parabéns)';
    } else if (imc >= 25 && imc < 29.9) {
      return 'Levemente acima do peso';
    } else if (imc >= 30 && imc < 34.9) {
      return 'Obesidade grau I';
    } else if (imc >= 35 && imc < 39.9) {
      return 'Obesidade grau II (severa)';
    } else if (imc >= 40) {
      return 'Obesidade grau III (mórbida)';
    } else {
      return 'Inválido';
    }
  }
}
