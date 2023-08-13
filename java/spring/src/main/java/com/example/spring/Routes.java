package com.example.spring;

import org.springframework.web.bind.annotation.*;

//* When initializing a Spring project, you should add the following dependencies:
//* spring-boot-starter-web, spring-boot-devtools.

//* The @RestController annotation helps to create a REST-ful controller in a class.
@RestController
public class Routes {

    //* The @RequestMapping annotation routes the HTTP requests to the handler methods.
    //* The default HTTP method is GET, but you can specify it.
    //* @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @RequestMapping("/menu")
    public String menu() {
        return "Hello menu!";
    }

    //* Or you can use the @GetMapping annotation to use the GET method instead.
    @GetMapping("/costumers")
    public String users() {
        return "Hello costumers!";
    }

    //* As well as the others: @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping
}

//* If you want to group the routes, you can use the @RequestMapping annotation in the class.
@RestController
//* Sometimes you can omit the "/" in the routes, but it's better to use it.
// @RequestMapping("api")
@RequestMapping("/api")
class ApiRoutes {

    //* So this route would be "/api/users"
    @GetMapping("/users")
    public String menu() {
        return "Hello users!";
    }

    //* You can also use variables in the routes.
    //! Spring handles the data type conversion automatically, unlike Express.js.
    //* If the path variable matches the method parameter, you can omit the argument name.
    @GetMapping("/item/{id}")
    public String item(@PathVariable int id) {
        return "Item " + id;
    }

    //* You can also omit them for multiple path variables.
    @GetMapping("/item/{category}/{id}")
    public String items(@PathVariable String category, @PathVariable int id) {
        return category + " item " + id;
    }

    //! However, you can't omit the annotation argument if it doesn't match the method parameter.
    @GetMapping("/item/new/{productId}")
    public String newItem(@PathVariable("productId") int id) {
        return "New item " + id;
    }

    //* You can also use query parameters.
    //* You can omit the annotation argument even if there are multiple parameters too.
    @GetMapping("/login")
    public String login(@RequestParam String name, @RequestParam String password) {
        return "Hello " + name + ", your password is " + password;
    }

    //* When you want the parameter to be optional, you can use the required argument.
    @GetMapping("/user")
    public String user(@RequestParam(required = false) String name) {
        if (name == null) {
            return "Hello user!";
        }
        return "Hello " + name;
    }

    //* But when those values are optional, you should use wrappers instead of primitives
    //* to take into account the "null" cases.
    @GetMapping("/product")
    public String product(@RequestParam(required = false) Integer id) {
        if (id == null) {
            return "Hello product!";
        }
        return "Hello product " + id + "!";
    }

    //! So this would throw an error because primitives can't be null.
    // @GetMapping("/products")
    // public String products(@RequestParam(required = false) int id) {
    //     if (id == null) {
    //         return "Hello product!";
    //     }
    //     return "Hello product " + id + "!";
    // }

    //! Be careful when using "" and "/" in the routes, because they are different in some cases.
    @GetMapping("")
    public String noSlash() {
        return "Without slash!";
    }

    @GetMapping("/")
    public String slash() {
        return "With slash. See the difference?";
    }
}