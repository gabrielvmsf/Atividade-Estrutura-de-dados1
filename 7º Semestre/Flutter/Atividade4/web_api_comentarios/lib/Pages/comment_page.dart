import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:web_api_comentarios/comment.dart';
import 'package:web_api_comentarios/auth.dart';

class CommentsPage extends StatefulWidget {
  final int postId;

  const CommentsPage({required this.postId, Key? key}) : super(key: key);

  @override
  _CommentsPageState createState() => _CommentsPageState();
}

class _CommentsPageState extends State<CommentsPage> {
  List<Comment> comments = [];
  bool isLoading = true;

  late int id;
  late String name;
  late String username;
  late String email;
  late String street;
  late String suite;
  late String city;
  late String zipcode;
  late String lat;
  late String lng;
  late String phone;
  late String website;
  late String companyName;
  late String catchPhrase;
  late String bs;

  @override
  void initState() {
    super.initState();
    _checkAuthAndLoadData();
  }

  Future<void> _checkAuthAndLoadData() async {
    final prefs = await SharedPreferences.getInstance();
    final isLoggedIn = prefs.getInt('id') != null;

    if (!isLoggedIn) {
      WidgetsBinding.instance?.addPostFrameCallback((_) {
        Navigator.of(context).pushReplacementNamed('/home');
      });
      return;
    }

    _loadUserData();
    _loadComments();
  }

  Future<void> _loadUserData() async {
    final prefs = await SharedPreferences.getInstance();

    setState(() {
      id = prefs.getInt('id') ?? 0;
      name = prefs.getString('name') ?? '';
      username = prefs.getString('username') ?? '';
      email = prefs.getString('email') ?? '';
      street = prefs.getString('street') ?? '';
      suite = prefs.getString('suite') ?? '';
      city = prefs.getString('city') ?? '';
      zipcode = prefs.getString('zipcode') ?? '';
      lat = prefs.getString('lat') ?? '';
      lng = prefs.getString('lng') ?? '';
      phone = prefs.getString('phone') ?? '';
      website = prefs.getString('website') ?? '';
      companyName = prefs.getString('companyName') ?? '';
      catchPhrase = prefs.getString('catchPhrase') ?? '';
      bs = prefs.getString('bs') ?? '';
    });
  }

  Future<void> _loadComments() async {
    final url =
        'https://jsonplaceholder.typicode.com/comments?postId=${widget.postId}';
    final response = await http.get(Uri.parse(url));

    if (response.statusCode == 200) {
      final List<dynamic> data = json.decode(response.body);

      setState(() {
        comments = data.map((json) => Comment.fromJson(json)).toList();
        isLoading = false;
      });
    } else {
      throw Exception('Falha para carregar comentários');
    }
  }

  Future<void> _showUserData() async {
    showDialog(
      context: context,
      builder: (BuildContext context) {
        return AlertDialog(
          title: const Text(
            'Dados de Usuário',
            style: TextStyle(fontWeight: FontWeight.bold),
          ),
          content: SingleChildScrollView(
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                _buildUserInfoRow(
                    Icons.account_balance_wallet_sharp, 'ID:', id.toString()),
                _buildUserInfoRow(Icons.person, 'Name:', name),
                _buildUserInfoRow(Icons.account_circle, 'Username:', username),
                _buildUserInfoRow(Icons.email, 'Email:', email),
                _buildUserInfoRow(Icons.location_on, 'Address:',
                    '$street, $suite, $city, $zipcode'),
                _buildUserInfoRow(Icons.map, 'Geo:', '$lat, $lng'),
                _buildUserInfoRow(Icons.phone, 'Phone:', phone),
                _buildUserInfoRow(Icons.web, 'Website:', website),
                _buildUserInfoRow(Icons.business, 'Company:', companyName),
                _buildUserInfoRow(Icons.star, 'CatchPhrase:', catchPhrase),
                _buildUserInfoRow(Icons.info, 'BS:', bs),
              ],
            ),
          ),
          actions: <Widget>[
            TextButton(
              child: const Text('OK'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            ),
          ],
        );
      },
    );
  }

  Widget _buildUserInfoRow(IconData icon, String label, String value) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 4.0),
      child: Row(
        children: [
          Icon(icon, size: 20.0, color: Colors.blueGrey),
          const SizedBox(width: 8.0),
          Expanded(
            child: Text(
              '$label $value',
              style: const TextStyle(fontSize: 16.0),
            ),
          ),
        ],
      ),
    );
  }

  Future<void> _logout() async {
    final prefs = await SharedPreferences.getInstance();
    await prefs.clear();

    Navigator.of(context).pushReplacementNamed('/home');
  }

  @override
  Widget build(BuildContext context) {
    return Auth(
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Comentários'),
          actions: [
            IconButton(
              icon: const Icon(Icons.info),
              onPressed: _showUserData,
            ),
            IconButton(
              icon: const Icon(Icons.logout),
              onPressed: _logout,
            ),
          ],
        ),
        body: Padding(
          padding: const EdgeInsets.all(16.0),
          child: isLoading
              ? const Center(child: CircularProgressIndicator())
              : ListView.builder(
                  itemCount: comments.length,
                  itemBuilder: (context, index) {
                    final comment = comments[index];
                    return Container(
                      margin: const EdgeInsets.symmetric(vertical: 8.0),
                      padding: const EdgeInsets.all(12.0),
                      decoration: BoxDecoration(
                        color: Colors.white,
                        borderRadius: BorderRadius.circular(8.0),
                        boxShadow: [
                          BoxShadow(
                            color: Colors.black.withOpacity(0.1),
                            blurRadius: 4.0,
                            offset: Offset(0, 2),
                          ),
                        ],
                      ),
                      child: Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            comment.name,
                            style: const TextStyle(
                              fontWeight: FontWeight.bold,
                              fontSize: 16.0,
                              color: Color.fromARGB(255, 102, 70, 158),
                            ),
                          ),
                          const SizedBox(height: 4.0),
                          Text(
                            comment.body,
                            style: const TextStyle(
                              fontSize: 14.0,
                              color: Colors.black87,
                            ),
                          ),
                        ],
                      ),
                    );
                  },
                ),
        ),
      ),
    );
  }
}
