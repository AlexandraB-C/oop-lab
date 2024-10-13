import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonReader {
    public List<Individual> readJson(String filename) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
            Type individualListType = new TypeToken<List<Individual>>(){}.getType();
            return gson.fromJson(jsonObject.get("input"), individualListType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}