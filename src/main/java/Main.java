import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static List<String> getPosts() {
	List<String> results = new ArrayList<String>();
		File[] files = new File("/home/vp/Desktop/blog/src/main/resources/spark/template/freemarker/posts").listFiles();
		for (File file : files) {
		    if (file.isFile() && file.getName().endsWith(".ftl")) {
			results.add(file.getName().replace(".ftl", ""));
		    }
		}
	return results;
    }

    public static void main(String[] args) {

        String port_value = System.getenv("PORT");
        if (port_value == null) {
            port_value = "3000";
        }
        port(Integer.valueOf(port_value));
        staticFileLocation("/public");

        get("/", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("message", "Hello World!");
                attributes.put("posts", Main.getPosts());
                return new ModelAndView(attributes, "index.ftl");
            }, new FreeMarkerEngine()
        );

        get("/posts/:name/", (request, response) -> {
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("posts", Main.getPosts());
                return new ModelAndView(attributes, "posts/" + request.params("name") + ".ftl");
            }, new FreeMarkerEngine()
        );
        
        
        
    }
}
