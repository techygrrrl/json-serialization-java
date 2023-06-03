package stream.techygrrrl.jsonserialization;

import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import models.Dialogue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

@SpringBootApplication
public class JsonSerializationApplication {

    public static void main(String[] args) throws FileNotFoundException {
        JsonUtils jsonUtils = JsonUtils.getInstance();

        // Read JSON from resources
        String resourcesDirectory = FileUtils.getResourceDirectoryPath();
        // This is just reading raw JSON from file.
        FileReader fileReader = new FileReader(resourcesDirectory + "/static/data.json");
        JsonArray rawJson = jsonUtils.gson.fromJson(fileReader, JsonArray.class);
//        System.out.printf("Raw JSON: %s", rawJson);

        // Deserialize the JSON
        Type dialogueListType = new TypeToken<ArrayList<Dialogue>>() {}.getType();
        ArrayList<Dialogue> dialogueList = jsonUtils.gson.fromJson(rawJson, dialogueListType);

        System.out.println("\n🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣🟣\n");
        // Work with the dialogue more easily
        dialogueList.forEach(dialogue -> {
            System.out.printf("id: %s\n", dialogue.getId());
            System.out.printf("next: %s\n", dialogue.getNext());
            System.out.printf("text: %s\n", dialogue.getDialogueText());
            System.out.printf("The whole dialogue: %s\n", dialogue.toString());

            System.out.printf("Number of response items: %s\n", dialogue.getResponseOptions().size());

            System.out.println("-------------------------------------");
        });

        System.out.println("\n\n🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢🟢\n\n\n\n\n\n\n");

        SpringApplication.run(JsonSerializationApplication.class, args);
    }
}
