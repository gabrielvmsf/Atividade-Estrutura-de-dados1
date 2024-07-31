import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:web_api_comentarios/Pages/home_page.dart';

class Auth extends StatelessWidget {
  final Widget child;

  const Auth({required this.child, Key? key}) : super(key: key);

  Future<bool> _isLoggedIn() async {
    final prefs = await SharedPreferences.getInstance();
    final id = prefs.getInt('id');
    return id != null;
  }

  @override
  Widget build(BuildContext context) {
    return FutureBuilder(
      future: _isLoggedIn(),
      builder: (context, snapshot) {
        if (snapshot.connectionState == ConnectionState.waiting) {
          return const Center(child: CircularProgressIndicator());
        }

        if (snapshot.hasData && snapshot.data == true) {
          return child;
        } else {
          WidgetsBinding.instance?.addPostFrameCallback((_) {
            Navigator.of(context).pushReplacement(
              MaterialPageRoute(builder: (context) => const HomePage()),
            );
          });
          return Container();
        }
      },
    );
  }
}
