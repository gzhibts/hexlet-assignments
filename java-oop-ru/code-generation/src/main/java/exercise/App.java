package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


// BEGIN
public class App {

    @SneakyThrows
    public static void save(Path p, Car car) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(p.toFile(), car);
    }

    @SneakyThrows
    public static Car extract(Path p) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(p.toFile()));
            String line = reader.readLine();

            reader.close();

            return Car.deserialize(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
// END
