import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) ->{
            Map<String,Object> model = new HashMap<String, Object>();

            model.put("template", "templates/hello.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/favorite_photos", (request,response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/favorite_photos.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/form",(request,response)->{
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/greeting_card", (request, response) -> {
            System.out.println(request.queryParams("recipient"));
            Map<String, Object> model = new HashMap<String, Object>();

            String recipient = request.queryParams("recipient");
            String sender = request.queryParams("sender");
            model.put("recipient", recipient);
            model.put("sender", sender);
            model.put("template", "templates/greeting_card.vtl");
            return new ModelAndView(model, layout);

        }, new VelocityTemplateEngine());
    }
}