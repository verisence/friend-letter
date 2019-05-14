import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) ->{
            Map<String,Object> model = new HashMap<String, Object>();

            model.put("template", "templates/hello.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, new VelocityTemplateEngine());

        get("/favorite_photos", (request,response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/favorite_photos.vtl");
            return new ModelAndView(model,"templates/layout.vtl");
        }, new VelocityTemplateEngine());
    }
}