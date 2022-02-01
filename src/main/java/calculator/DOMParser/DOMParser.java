package calculator.DOMParser;
import calculator.model.Distance;
import calculator.service.CityService;
import calculator.service.DistanceService;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import calculator.model.City;

import java.util.ArrayList;

public class DOMParser {
    private CityService cityService;
    private DistanceService distanceService;
    private static ArrayList<City> cities = new ArrayList<>();
    private static ArrayList<Distance> distances = new ArrayList<>();

    public void domParse(File file) throws ParserConfigurationException, SAXException, IOException{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        NodeList cityElements = document.getDocumentElement().getElementsByTagName("city");
        for (int i = 0; i < cityElements.getLength(); i++) {
                Node city = cityElements.item(i);
                NamedNodeMap attributes = city.getAttributes();
                cities.add(new City(attributes.getNamedItem("name").getNodeValue(),
                        Double.parseDouble(attributes.getNamedItem("latitude").getNodeValue()),
                        Double.parseDouble(attributes.getNamedItem("longitude").getNodeValue())));


                System.out.println(cities.get(i).toString());


        }

        NodeList distanceElements = document.getDocumentElement().getElementsByTagName("distance");
        for (int i = 0; i < distanceElements.getLength(); i++) {

            Node distance = distanceElements.item(i);
            NamedNodeMap attributes = distance.getAttributes();
            distances.add(new Distance(attributes.getNamedItem("fromCity").getNodeValue(),
                    attributes.getNamedItem("toCity").getNodeValue(),
                    Double.parseDouble(attributes.getNamedItem("distance").getNodeValue())));

        }
    }
        public static ArrayList<City> getCities() {
        return cities;
        }

        public static ArrayList<Distance> getDistances() {
        return distances;
        }
}
