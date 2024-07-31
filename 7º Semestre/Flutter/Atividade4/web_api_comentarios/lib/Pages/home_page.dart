import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:web_api_comentarios/Pages/post_page.dart';
import 'package:web_api_comentarios/user.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      title: 'Flutter Demo',
      home: HomePage(),
    );
  }
}

class HomePage extends StatefulWidget {
  const HomePage({super.key});

  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final TextEditingController _usernameController = TextEditingController();

  Future<void> _fetchUserData() async {
    final username = _usernameController.text;
    final url = 'https://jsonplaceholder.typicode.com/users?username=$username';

    final response = await http.get(Uri.parse(url));

    if (response.statusCode == 200) {
      final List<dynamic> data = json.decode(response.body);
      if (data.isNotEmpty) {
        final user = User.fromJson(data[0]);

        final prefs = await SharedPreferences.getInstance();
        prefs.setInt('id', user.id);
        prefs.setString('name', user.name);
        prefs.setString('username', user.username);
        prefs.setString('email', user.email);
        prefs.setString('street', user.address.street);
        prefs.setString('suite', user.address.suite);
        prefs.setString('city', user.address.city);
        prefs.setString('zipcode', user.address.zipcode);
        prefs.setString('lat', user.address.geo.lat);
        prefs.setString('lng', user.address.geo.lng);
        prefs.setString('phone', user.phone);
        prefs.setString('website', user.website);
        prefs.setString('companyName', user.company.name);
        prefs.setString('catchPhrase', user.company.catchPhrase);
        prefs.setString('bs', user.company.bs);

        Navigator.push(
          context,
          MaterialPageRoute(builder: (context) => const PostsPage()),
        );
      } else {
        ScaffoldMessenger.of(context).showSnackBar(
          const SnackBar(
            content: Text('Usuário não encontrado'),
          ),
        );
      }
    } else {
      throw Exception('Falha ao carregar dados');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Container(
        decoration: const BoxDecoration(
          gradient: LinearGradient(
            colors: [Colors.blueAccent, Colors.deepPurple],
            begin: Alignment.topLeft,
            end: Alignment.bottomRight,
          ),
        ),
        child: Center(
          child: Container(
            padding: const EdgeInsets.all(16.0),
            decoration: BoxDecoration(
              color: Colors.white,
              borderRadius: BorderRadius.circular(8.0),
              boxShadow: const [
                BoxShadow(
                  color: Colors.black12,
                  blurRadius: 10.0,
                  spreadRadius: 5.0,
                ),
              ],
            ),
            width: 300,
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                const Text(
                  'Login',
                  style: TextStyle(fontSize: 24.0, fontWeight: FontWeight.bold),
                ),
                const SizedBox(height: 16.0),
                TextField(
                  controller: _usernameController,
                  decoration: const InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Usuário',
                  ),
                ),
                const SizedBox(height: 16.0),
                const TextField(
                  decoration: InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Senha',
                  ),
                  obscureText: true,
                ),
                const SizedBox(height: 24.0),
                ElevatedButton(
                  onPressed: _fetchUserData,
                  child: const Text('Entrar'),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}
