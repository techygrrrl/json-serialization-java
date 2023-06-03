package stream.techygrrrl.jsonserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtils {
    public final Gson gson;

    private static JsonUtils instance = null;

    private JsonUtils() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        // If you need custom serializers, you'd add them here.
        // You don't need them for your current data structure.

        this.gson = gsonBuilder.create();
    }

    public static JsonUtils getInstance() {
        if (instance == null) {
            instance = new JsonUtils();
        }

        return instance;
    }
}
