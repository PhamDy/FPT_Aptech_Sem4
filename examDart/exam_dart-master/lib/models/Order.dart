class Order {
  final String item;
  final String itemName;
  final int quantity;
  final double price;
  final String currency;

  Order({
    required this.item,
    required this.itemName,
    required this.quantity,
    required this.price,
    required this.currency,
  });

  factory Order.fromJson(Map<String, dynamic> json) {
    return Order(
      item: json['Item'],
      itemName: json['ItemName'],
      price: json['Price'].toDouble(),
      currency: json['Currency'],
      quantity: json['Quantity'],
    );
  }
}