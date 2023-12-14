import 'package:flutter/material.dart';

void main1() {
  //* "runApp" takes a widget and makes it the root of the widget tree
  runApp(
      //* "MaterialApp" is a widget that provides a number of basic widgets
      const MaterialApp(
    //* The "home" property is the widget that will be rendered when the app is started
    home:
        //* "Text" is used whenever you want to display a string
        Text("Hello World"),
    //* It's a good practice to put a comma after each property
  ));
}

void main() {
  runApp(MaterialApp(
    //* "Scaffold" is a widget that provides a basic layout structure for the app
    home: Scaffold(
      //* "appBar" is a property that takes an "AppBar" widget which displays a toolbar
      appBar: AppBar(
        //* "title" lets you display a string in the toolbar
        title: const Text("My First App"),
        //* "centerTitle" centers it
        centerTitle: true,
      ),
      //* "body" will be the main content of the app
      //* "Center" can be used to wrap any widget and center it
      body: const Center(
        //* It takes a "child" property which will be centered
        child: Text("Hello Pedro"),
      ),
      //* "floatingActionButton" takes a widget (same name) that is displayed at the bottom right
      floatingActionButton: const FloatingActionButton(
        //! "onPressed" is required, but we'll leave it as null for now
        onPressed: null,
        //* "child" is the widget that will be displayed inside the button
        child: Text("Click"),
      ),
    ),
  ));
}
