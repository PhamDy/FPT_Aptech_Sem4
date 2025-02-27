/*
import 'package:flutter/material.dart';
import 'models/Order.dart';
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'My Order',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<Order> orders = [];
  String searchKeyword = '';

  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  final TextEditingController _itemController = TextEditingController();
  final TextEditingController _itemNameController = TextEditingController();
  final TextEditingController _quantityController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();
  final TextEditingController _currencyController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('My Order'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              decoration: InputDecoration(
                labelText: 'Search',
                prefixIcon: Icon(Icons.search),
              ),
              onChanged: (value) {
                setState(() {
                  searchKeyword = value.toLowerCase();
                });
              },
            ),
            SizedBox(height: 20),
            Form(
              key: _formKey,
              child: Column(
                children: [
                  TextFormField(
                    controller: _itemController,
                    decoration: InputDecoration(labelText: 'Item'),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter an item';
                      }
                      return null;
                    },
                  ),
                  TextFormField(
                    controller: _itemNameController,
                    decoration: InputDecoration(labelText: 'Item Name'),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter an item name';
                      }
                      return null;
                    },
                  ),
                  TextFormField(
                    controller: _quantityController,
                    decoration: InputDecoration(labelText: 'Quantity'),
                    keyboardType: TextInputType.number,
                  ),
                  TextFormField(
                    controller: _priceController,
                    decoration: InputDecoration(labelText: 'Price'),
                    keyboardType: TextInputType.number,
                  ),
                  TextFormField(
                    controller: _currencyController,
                    decoration: InputDecoration(labelText: 'Currency'),
                  ),
                  SizedBox(height: 20),
                  ElevatedButton(
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        setState(() {
                          Order newOrder = Order(
                            item: _itemController.text,
                            itemName: _itemNameController.text,
                            price: double.parse(_priceController.text),
                            currency: _currencyController.text,
                            quantity: int.parse(_quantityController.text),
                          );
                          orders.add(newOrder);
                          _itemController.clear();
                          _itemNameController.clear();
                          _quantityController.clear();
                          _priceController.clear();
                          _currencyController.clear();
                        });
                      }
                    },
                    child: Text('Add Item'),
                  ),
                ],
              ),
            ),
            SizedBox(height: 20),
            Expanded(
              child: SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: DataTable(
                  columns: [
                    DataColumn(label: Text('ID')),
                    DataColumn(label: Text('Item')),
                    DataColumn(label: Text('Item Name')),
                    DataColumn(label: Text('Quantity')),
                    DataColumn(label: Text('Price')),
                    DataColumn(label: Text('Currency')),
                    DataColumn(label: Text('Action')),
                  ],
                  rows: orders.where((order) {
                    return order.item.toLowerCase().contains(searchKeyword) ||
                        order.itemName.toLowerCase().contains(searchKeyword) ||
                        order.quantity.toString().contains(searchKeyword) ||
                        order.price.toString().contains(searchKeyword) ||
                        order.currency.toLowerCase().contains(searchKeyword);
                  }).map((order) {
                    return DataRow(cells: [
                      DataCell(Text((orders.indexOf(order) + 1).toString())),
                      DataCell(Text(order.item)),
                      DataCell(Text(order.itemName)),
                      DataCell(Text(order.quantity.toString())),
                      DataCell(Text(order.price.toString())),
                      DataCell(Text(order.currency)),
                      DataCell(
                        Row(
                          children: [
                            IconButton(
                              icon: Icon(Icons.edit),
                              onPressed: () {
                                // Add edit functionality here
                              },
                            ),
                            IconButton(
                              icon: Icon(Icons.delete),
                              onPressed: () {
                                setState(() {
                                  orders.remove(order);
                                });
                              },
                            ),
                          ],
                        ),
                      ),
                    ]);
                  }).toList(),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
*/

import 'package:flutter/material.dart';
import 'models/Order.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Order Management',
      theme: ThemeData(
        primarySwatch: Colors.blue,
        fontFamily: 'Roboto',
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  List<Order> orders = [];
  String searchKeyword = '';

  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  final TextEditingController _itemController = TextEditingController();
  final TextEditingController _itemNameController = TextEditingController();
  final TextEditingController _quantityController = TextEditingController();
  final TextEditingController _priceController = TextEditingController();
  final TextEditingController _currencyController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(
          'My Order',
          style: TextStyle(color: Colors.white),
        ),
        centerTitle: true,
        backgroundColor: Colors.deepPurple,
      ),

      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            TextField(
              decoration: InputDecoration(
                labelText: 'Search',
                prefixIcon: Icon(Icons.search),
              ),
              onChanged: (value) {
                setState(() {
                  searchKeyword = value.toLowerCase();
                });
              },
            ),
            SizedBox(height: 20),
            Form(
              key: _formKey,
              child: Column(
                children: [
                  TextFormField(
                    controller: _itemController,
                    decoration: InputDecoration(
                      labelText: 'Item',
                      border: OutlineInputBorder(),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter an item';
                      }
                      return null;
                    },
                  ),
                  SizedBox(height: 10),
                  TextFormField(
                    controller: _itemNameController,
                    decoration: InputDecoration(
                      labelText: 'Item Name',
                      border: OutlineInputBorder(),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter an item name';
                      }
                      return null;
                    },
                  ),
                  SizedBox(height: 10),
                  Row(
                    children: [
                      Expanded(
                        child: TextFormField(
                          controller: _quantityController,
                          decoration: InputDecoration(
                            labelText: 'Quantity',
                            border: OutlineInputBorder(),
                          ),
                          keyboardType: TextInputType.number,
                        ),
                      ),
                      SizedBox(width: 10),
                      Expanded(
                        child: TextFormField(
                          controller: _priceController,
                          decoration: InputDecoration(
                            labelText: 'Price',
                            border: OutlineInputBorder(),
                          ),
                          keyboardType: TextInputType.number,
                        ),
                      ),
                    ],
                  ),
                  SizedBox(height: 10),
                  TextFormField(
                    controller: _currencyController,
                    decoration: InputDecoration(
                      labelText: 'Currency',
                      border: OutlineInputBorder(),
                    ),
                  ),
                  SizedBox(height: 20),
                  ElevatedButton(
                    onPressed: () {
                      if (_formKey.currentState!.validate()) {
                        setState(() {
                          Order newOrder = Order(
                            item: _itemController.text,
                            itemName: _itemNameController.text,
                            price: double.parse(_priceController.text),
                            currency: _currencyController.text,
                            quantity: int.parse(_quantityController.text),
                          );
                          orders.add(newOrder);
                          _itemController.clear();
                          _itemNameController.clear();
                          _quantityController.clear();
                          _priceController.clear();
                          _currencyController.clear();
                        });
                      }
                    },
                    child: Text('Add Item'),
                  ),
                ],
              ),
            ),
            SizedBox(height: 20),
            Expanded(
              child: SingleChildScrollView(
                scrollDirection: Axis.horizontal,
                child: DataTable(
                  columns: [
                    DataColumn(label: Text('ID')),
                    DataColumn(label: Text('Item')),
                    DataColumn(label: Text('Item Name')),
                    DataColumn(label: Text('Quantity')),
                    DataColumn(label: Text('Price')),
                    DataColumn(label: Text('Currency')),
                    DataColumn(label: Text('Action')),
                  ],
                  rows: orders.where((order) {
                    return order.item.toLowerCase().contains(searchKeyword) ||
                        order.itemName.toLowerCase().contains(searchKeyword) ||
                        order.quantity.toString().contains(searchKeyword) ||
                        order.price.toString().contains(searchKeyword) ||
                        order.currency.toLowerCase().contains(searchKeyword);
                  }).map((order) {
                    return DataRow(cells: [
                      DataCell(Text((orders.indexOf(order) + 1).toString())),
                      DataCell(Text(order.item)),
                      DataCell(Text(order.itemName)),
                      DataCell(Text(order.quantity.toString())),
                      DataCell(Text(order.price.toString())),
                      DataCell(Text(order.currency)),
                      DataCell(
                        Row(
                          children: [
                            IconButton(
                              icon: Icon(Icons.edit),
                              onPressed: () {
                                // Add edit functionality here
                              },
                            ),
                            IconButton(
                              icon: Icon(Icons.delete),
                              onPressed: () {
                                setState(() {
                                  orders.remove(order);
                                });
                              },
                            ),
                          ],
                        ),
                      ),
                    ]);
                  }).toList(),
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}

