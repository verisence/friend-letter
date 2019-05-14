import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) ->{
            return new ModelAndView(new HashMap(), "templates/hello.vtl");
        }, new VelocityTemplateEngine());

        get("/favorite_photos", (request,response)->{
            return new ModelAndView(new HashMap(),"templates/favorite_photos.vtl");
        }, new VelocityTemplateEngine());
    }
}