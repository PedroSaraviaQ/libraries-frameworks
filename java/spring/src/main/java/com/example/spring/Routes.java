package com.example.spring;

import org.springframework.web.bind.annotation.*;

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
    public String Item(@PathVariable int id) {
        return "Item " + id;
    }

    //* You can also omit them for multiple path variables.
    @GetMapping("/item/{category}/{id}")
    public String Items(@PathVariable String category, @PathVariable int id) {
        return category + " item " + id;
    }

    //! However, you can't omit the annotation argument if it doesn't match the method parameter.
    @GetMapping("/item/new/{productId}")
    public String NewItem(@PathVariable("productId") int id) {
        return "New item " + id;
    }

    //* You can also use query parameters.
    //* You can omit the annotation argument even if there are multiple parameters too.
    @GetMapping("/login")
    public String Login(@RequestParam String name, @RequestParam String password) {
        return "Hello " + name + ", your password is " + password;
    }

    //* When you want the parameter to be optional, you can use the required argument.
    @GetMapping("/user")
    public String User(@RequestParam(required = false) String name) {
        if (name == null) {
            return "Hello user!";
        }
        return "Hello " + name;
    }

    //! Be careful when using "" and "/" in the routes, because they are different in some cases.
    @GetMapping("")
    public String NoSlash() {
        return "Without slash!";
    }

    @GetMapping("/")
    public String Slash() {
        return "With slash. See the difference?";
    }
}