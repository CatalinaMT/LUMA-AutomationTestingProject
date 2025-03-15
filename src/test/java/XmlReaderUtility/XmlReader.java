package XmlReaderUtility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class XmlReader
{
    //clasa utilitara pentru citirea seturilor de date din xml-ul CreateAnAccountObjectData si atribuirea lor unor clase
    //clasa mapeaza datele in obiecte
    //metoda generica <T>

    public static <T> Map<String, T> loadData(String filePath, Class<T> clazz)
    {
        Map<String, T> dataMap = new HashMap<>();
        try {
            File file = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("dataSets").item(0).getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++)
            {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element element = (Element) node;
                    String key = element.getNodeName();

                    T obj = clazz.getDeclaredConstructor().newInstance();

                    for (Field field: clazz.getDeclaredFields())
                    {
                        field.setAccessible(true);
                        String fieldName = field.getName();

                        if (element.getElementsByTagName(fieldName).getLength()>0)
                        {
                            String value = element.getElementsByTagName(fieldName).item(0).getTextContent();

                            if (field.getType().equals(int.class))
                            {
                                field.set(obj, Integer.parseInt(value));
                            }
                            else field.set(obj,value);
                        }
                    }
                    dataMap.put(key,obj);
                }
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return dataMap;
    }

}
