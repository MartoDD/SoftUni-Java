package softuni.exam.util;

import java.nio.file.Path;

public enum Paths {
    ;
    public final static Path PATH_OF_TOWN = Path.of("src/main/resources/files/json/towns.json");
    public final static Path PATH_OF_AGENT = Path.of("src/main/resources/files/json/agents.json");
    public final static Path PATH_OF_APARTMENT = Path.of("src/main/resources/files/xml/apartments.xml");
    public final static Path PATH_OF_OFFER = Path.of("src/main/resources/files/xml/offers.xml");
}
