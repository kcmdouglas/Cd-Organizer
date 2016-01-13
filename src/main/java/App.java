import java.util.HashMap;
import java.util.ArrayList;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/albums", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("albumsArray", Organizer.all());
      model.put("template", "templates/albums.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("albums/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/albums-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/albums", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      String artist = request.queryParams("artist");
      String album = request.queryParams("album");
      Organizer organizer = new Organizer(artist, album);
      model.put("organizer", organizer);
      model.put("template", "templates/confirmation.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/albums/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Organizer organizer = Organizer.find(Integer.parseInt(request.params(":id")));
      model.put("organizer", organizer);
      model.put("template", "templates/album.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }


}
