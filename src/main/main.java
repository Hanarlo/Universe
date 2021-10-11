package main;

import entities.Planet;
import entities.Satellite;
import entities.Star;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {
    static File file;
    static DocumentBuilderFactory factory;
    static DocumentBuilder builder;
    static Document document;
    static File resultFile;
    static Document resultDocument;
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Initialize();

        List<Star> StarList = GetStarFromXml();
        long StarWeight = 0;
        for (int i = 0; i < StarList.size(); i++) {
            Star star = StarList.get(i);
            StarWeight += star.getWeight();
        }

        System.out.println("Количество всех звезд в системе:" + StarList.size());
        System.out.println("Масса всех звезд в системе: " + StarWeight + "\n");


        List<Planet> PlanetArrayList = GetPlanetFromXml();
        long PlanetWeight = 0;
        for (int i = 0; i < PlanetArrayList.size(); i++) {
            Planet planet = PlanetArrayList.get(i);
            PlanetWeight += planet.getWeight();
        }
        System.out.println("Количество всех планет в системе:" + PlanetArrayList.size());
        System.out.println("Масса всех планет в системе: " + PlanetWeight + "\n");


        List<Satellite> SatelliteArrayList = GetSatelliteFromXml();
        long SatelliteWeight = 0;
        for (int i = 0; i < SatelliteArrayList.size(); i++) {
            Satellite satellite = SatelliteArrayList.get(i);
            SatelliteWeight += satellite.getWeight();
        }
        System.out.println("Количество всех cпутников в системе:" + StarList.size());
        System.out.println("Масса всех спутников в системе: " + SatelliteWeight + "\n");




    }
    private static void  Initialize() throws ParserConfigurationException, IOException, SAXException {
        file = new File("src/xml/universe.xml");
        resultFile = new File("src/xml/result.xml");
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
        document = builder.parse(file);
        resultDocument = builder.parse(resultFile);

    }




    static private List<Star> GetStarFromXml(){
        NodeList starsList = document.getElementsByTagName("star");
        List<Star> StarArrayList = new ArrayList<>();
        for (int i = 0; i < starsList.getLength(); i++) {
            if (starsList.item(i).getNodeType() == Node.ELEMENT_NODE){
                Element starElement = (Element) starsList.item(i);
                NodeList childNodes = starElement.getChildNodes();
                Star star = new Star();
                for (int j = 0;j < childNodes.getLength(); j++){
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE){
                        Element ChildNodeElement = (Element) childNodes.item(j);
                        switch (ChildNodeElement.getNodeName()){
                            case "name" : star.setName(ChildNodeElement.getTextContent()); break;
                            case "weight" : star.setWeight(Long.valueOf(ChildNodeElement.getTextContent())); break;
                        }
                    }
                }
                StarArrayList.add(star);
            }
        }
        return StarArrayList;
    }

    static private List<Planet> GetPlanetFromXml(){
        NodeList PlanetList = document.getElementsByTagName("planet");
        List<Planet> PlanetArrayList = new ArrayList<>();
        for (int i = 0; i < PlanetList.getLength(); i++) {
            if (PlanetList.item(i).getNodeType() == Node.ELEMENT_NODE){
                Element PlanetElement = (Element) PlanetList.item(i);
                NodeList childNodes = PlanetElement.getChildNodes();
                Planet planet = new Planet();
                for (int j = 0;j < childNodes.getLength(); j++){
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE){
                        Element ChildNodeElement = (Element) childNodes.item(j);
                        switch (ChildNodeElement.getNodeName()){
                            case "name" : planet.setName(ChildNodeElement.getTextContent()); break;
                            case "weight" : planet.setWeight(Long.valueOf(ChildNodeElement.getTextContent())); break;
                        }
                    }
                }
                PlanetArrayList.add(planet);
            }
        }
        return PlanetArrayList;
    }

    static private List<Satellite> GetSatelliteFromXml(){
        NodeList SatelliteList = document.getElementsByTagName("satellite");
        List<Satellite> SatelliteArrayList = new ArrayList<>();
        for (int i = 0; i < SatelliteList.getLength(); i++) {
            if (SatelliteList.item(i).getNodeType() == Node.ELEMENT_NODE){
                Element SatelliteElement = (Element) SatelliteList.item(i);
                NodeList childNodes = SatelliteElement.getChildNodes();
                Satellite satellite = new Satellite();
                for (int j = 0;j < childNodes.getLength(); j++){
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE){
                        Element ChildNodeElement = (Element) childNodes.item(j);
                        switch (ChildNodeElement.getNodeName()){
                            case "name" : satellite.setName(ChildNodeElement.getTextContent()); break;
                            case "weight" : satellite.setWeight(Long.valueOf(ChildNodeElement.getTextContent())); break;
                        }
                    }
                }
                SatelliteArrayList.add(satellite);
            }
        }
        return SatelliteArrayList;
    }
}


