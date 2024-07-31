import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:web_api_comentarios/Pages/comment_page.dart';
import 'package:web_api_comentarios/posts.dart';
import 'package:web_api_comentarios/auth.dart';

class PostsPage extends StatefulWidget {
  const PostsPage({super.key});

  @override
  _PostsPageState createState() => _PostsPageState();
}

class _PostsPageState extends State<PostsPage> {
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

  List<Posts> posts = [];
  bool isLoading = false;
  bool dataLoaded = false;

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

    _loadPosts();
  }

  Future<void> _loadPosts() async {
    if (dataLoaded) return;

    setState(() {
      isLoading = true;
    });

    final url = 'https://jsonplaceholder.typicode.com/posts?userId=$id';
    final response = await http.get(Uri.parse(url));

    if (response.statusCode == 200) {
      final List<dynamic> data = json.decode(response.body);

      setState(() {
        posts = data.map((json) => Posts.fromJson(json)).toList();
        isLoading = false;
        dataLoaded = true;
      });
    } else {
      throw Exception('Falha para carregar posts');
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

  Future<bool> _onWillPop() async {
    await _logout();
    return false;
  }

  @override
  Widget build(BuildContext context) {
    return Auth(
      child: WillPopScope(
        onWillPop: _onWillPop,
        child: Scaffold(
          appBar: AppBar(
            title: const Text('Posts'),
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
            child: Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                if (isLoading) const Center(child: CircularProgressIndicator()),
                if (posts.isNotEmpty) ...[
                  Expanded(
                    child: ListView.builder(
                      itemCount: posts.length,
                      itemBuilder: (context, index) {
                        final post = posts[index];
                        return GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(
                                builder: (context) =>
                                    CommentsPage(postId: post.id),
                              ),
                            );
                          },
                          child: Card(
                            margin: const EdgeInsets.symmetric(vertical: 8.0),
                            elevation: 8.0,
                            shape: RoundedRectangleBorder(
                              borderRadius: BorderRadius.circular(12.0),
                            ),
                            child: Column(
                              crossAxisAlignment: CrossAxisAlignment.start,
                              children: [
                                Container(
                                  width: double.infinity,
                                  padding: const EdgeInsets.all(16.0),
                                  decoration: const BoxDecoration(
                                    borderRadius: BorderRadius.vertical(
                                        top: Radius.circular(12.0)),
                                    color: Colors.blue,
                                  ),
                                  child: Text(
                                    post.title,
                                    style: const TextStyle(
                                      fontWeight: FontWeight.bold,
                                      fontSize: 18.0,
                                      color: Colors.white,
                                    ),
                                  ),
                                ),
                                Padding(
                                  padding: const EdgeInsets.all(16.0),
                                  child: Text(
                                    post.body,
                                    style: const TextStyle(
                                      fontSize: 16.0,
                                      color: Colors.black87,
                                    ),
                                  ),
                                ),
                              ],
                            ),
                          ),
                        );
                      },
                    ),
                  ),
                ] else if (!isLoading) ...[
                  const SizedBox(height: 16.0),
                  const Center(child: Text('Sem posts disponíveis.')),
                ],
              ],
            ),
          ),
        ),
      ),
    );
  }
}
