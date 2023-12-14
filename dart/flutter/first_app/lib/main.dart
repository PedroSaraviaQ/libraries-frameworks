import 'package:flutter/material.dart';

void main() {
  //* "runApp" takes a widget and makes it the root of the widget tree
  runApp(
      //* "MaterialApp" is a widget that provides a number of basic widgets
      const MaterialApp(
    //* The "home" property is the widget that will be rendered when the app is started
    home:
        //* "Text" is a widget that displays a string
        Text('Hello World'),
    //* It's a good practice to put a comma after each property
  ));
}
