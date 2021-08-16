package scout; 

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Scout {

    private static Scout instance;
    private ArrayList<Equipier> equipiers;

    private Scout() {
        equipiers = new ArrayList<>();
    }
    
    public static Scout getInstance(){
        if(instance == null){
            return  instance = new Scout();
        }
        return instance;
    }

    public void loadData() throws ParserConfigurationException, SAXException, IOException {
        ArrayList<Equipier> equipiers = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        File fp = new File("data.xml");
        if (fp.length() > 60) {
            Document doc = (Document) builder.parse(fp);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("equipier");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) node;
                    Equipier equipier = new Equipier();
                    equipier.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    equipier.setEquipe(eElement.getElementsByTagName("equipe").item(0).getTextContent());
                    equipier.setDateOfBirth(eElement.getElementsByTagName("date_of_birth").item(0).getTextContent());
                    equipier.setMobile(eElement.getElementsByTagName("mobile").item(0).getTextContent());
                    equipier.setNationalId(eElement.getElementsByTagName("national_id").item(0).getTextContent());
                    equipier.setBonus(Integer.parseInt(eElement.getElementsByTagName("bonus").item(0).getTextContent()));
                    equipier.setTotal(Integer.parseInt(eElement.getElementsByTagName("total").item(0).getTextContent()));
                    
                    ArrayList<Activity> activities = new ArrayList<>();
                    NodeList nodeList1 = eElement.getElementsByTagName("activity");
                    for (int j = 0; j < nodeList1.getLength(); j++) {
                        Node node1 = nodeList1.item(j);
                        if (node1.getNodeType() == Node.ELEMENT_NODE) {
                            Element eElement1 = (Element) node1;

                            Activity activity = new Activity();
                            activity.setActivityName(eElement1.getElementsByTagName("activity_name").item(0).getTextContent());
                            activity.setPoints(Integer.parseInt(eElement1.getElementsByTagName("points").item(0).getTextContent()));

                            activities.add(activity);
                        }
                    }
                    equipier.setActivities(activities);
                    equipiers.add(equipier);
                }
            }
            this.equipiers = equipiers;
        }
    }

    public void saveData() throws ParserConfigurationException, TransformerConfigurationException, TransformerException {

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbf.newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("scout");

        Element equipiers = doc.createElement("equipiers");

        for (int i = 0; i < this.equipiers.size(); i++) {

            Element equipier = doc.createElement("equipier");

            Element name = doc.createElement("name");
            Text nName = doc.createTextNode(this.equipiers.get(i).getName());
            name.appendChild(nName);

            Element equipe = doc.createElement("equipe");
            Text nEquipe = doc.createTextNode(this.equipiers.get(i).getEquipe());
            equipe.appendChild(nEquipe);

            Element dateOfBirth = doc.createElement("date_of_birth");
            Text nDateOfBirth = doc.createTextNode(this.equipiers.get(i).getDateOfBirth());
            dateOfBirth.appendChild(nDateOfBirth);

            Element mobile = doc.createElement("mobile");
            Text nMobile = doc.createTextNode(this.equipiers.get(i).getMobile());
            mobile.appendChild(nMobile);

            Element nationalId = doc.createElement("national_id");
            Text nNationalId = doc.createTextNode(this.equipiers.get(i).getNationalId());
            nationalId.appendChild(nNationalId);

            Element activities = doc.createElement("activities");

            for (int j = 0; j < this.equipiers.get(i).getActivities().size(); j++) {
                Element activity = doc.createElement("activity");

                Element activityName = doc.createElement("activity_name");
                Text nActivityName = doc.createTextNode(this.equipiers.get(i).getActivities().get(j).getActivityName());
                activityName.appendChild(nActivityName);

                Element points = doc.createElement("points");
                Text nPoints = doc.createTextNode(String.valueOf(this.equipiers.get(i).getActivities().get(j).getPoints()));
                points.appendChild(nPoints);

                activity.appendChild(activityName);
                activity.appendChild(points);

                activities.appendChild(activity);
            }

            Element bonus = doc.createElement("bonus");
            Text nBonus = doc.createTextNode(String.valueOf(this.equipiers.get(i).getBonus()));
            bonus.appendChild(nBonus);

            Element total = doc.createElement("total");
            Text nTotal = doc.createTextNode(String.valueOf(this.equipiers.get(i).getTotal()));
            total.appendChild(nTotal);

            equipier.appendChild(name);
            equipier.appendChild(equipe);
            equipier.appendChild(dateOfBirth);
            equipier.appendChild(mobile);
            equipier.appendChild(nationalId);
            equipier.appendChild(activities);
            equipier.appendChild(bonus);
            equipier.appendChild(total);
            equipier.appendChild(activities);
            equipiers.appendChild(equipier);
        }
        root.appendChild(equipiers);
        doc.appendChild(root);

        File fp = new File("data.xml");
        if (!fp.exists()) {
            JOptionPane.showMessageDialog(null, "File doesn't exist !");
            System.exit(-1);
        }

        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
        StreamResult result = new StreamResult(fp);
        transformer.transform(source, result);

    }

    public ArrayList<Equipier> getEquipiers() {
        return equipiers;
    }

    public void setEquipiers(ArrayList<Equipier> equipiers) {
        this.equipiers = equipiers;
    }

}
