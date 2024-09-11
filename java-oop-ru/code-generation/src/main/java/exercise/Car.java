package exercise;

import lombok.SneakyThrows;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringReader;
import java.io.StringWriter;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    @SneakyThrows
    public String serialize() {

        var mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, this);
        String result = writer.toString();
        return result;
    }

    @SneakyThrows
    public static Car deserialize(String json) {

        StringReader reader = new StringReader(json);

        ObjectMapper mapper = new ObjectMapper();

        Car car = mapper.readValue(reader, Car.class);

        return car;

    }

    // END
}
