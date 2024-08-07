package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN

class App {

    public static List<String> buildApartmentsList(List<Home> homeList, int n) {
        List<Home> sorted = homeList.stream()
                .sorted(Home::compareTo)
                .toList();

        int i = 0;
        List<String> result = new ArrayList<>();
        for (Home element : sorted) {
            if (i < n) {
                result.add(element.toString());
            }
            i++;
        }

        return result;
    }
}

// END
