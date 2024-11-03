package Java_Core.Annotations.AnnotationsTest;

import java.lang.reflect.Method;

public class AnnotationAnalizator {
    public void analize(Class<?> clazz) {
        Method[] methods = clazz.getMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent(XmlAttribute.class)) {
                XmlAttribute xmlAttribute = m.getAnnotation(XmlAttribute.class);
                System.out.println(xmlAttribute.name());

            }
            if(m.isAnnotationPresent(XmlElement.class)){
                XmlElement xmlElement = m.getAnnotation(XmlElement.class);
                System.out.println(xmlElement.name());

            }
        }
    }
}
