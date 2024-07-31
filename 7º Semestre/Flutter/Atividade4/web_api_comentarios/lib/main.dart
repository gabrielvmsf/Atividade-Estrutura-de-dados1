import 'package:flutter/material.dart';
import 'package:web_api_comentarios/Pages/home_page.dart';
import 'package:web_api_comentarios/Pages/post_page.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Web API Comentários',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const HomePage(),
      routes: {
        '/home': (context) => const HomePage(),
        '/posts': (context) => const PostsPage(),
      },
      debugShowCheckedModeBanner: false,
    );
  }
}
