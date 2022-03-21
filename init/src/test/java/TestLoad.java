import com.pscsoft.arcana.sdk.Category;
import com.pscsoft.arcana.sdk.FieldName;
import com.pscsoft.arcana.sdk.Processor;
import com.pscsoft.arcana.sdk.ProcessorName;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.ServiceLoader;

public class TestLoad {
    public static void main(String[] args) {
        ServiceLoader<Processor> loader = ServiceLoader.load(Processor.class);

        Iterator<Processor> iterator = loader.iterator();

        while (iterator.hasNext()) {
            try {
                Processor parse = iterator.next();
                if (parse == null) {
                    break;
                }
                System.out.println(parse);

                Category category = parse.getClass().getAnnotation(Category.class);
                if (category != null) {
                    System.out.println(category.value()[0]);
                }

                ProcessorName processorName = parse.getClass().getAnnotation(ProcessorName.class);
                if (processorName != null) {
                    System.out.println(processorName.value());
                }

                Field[] fields = parse.getClass().getDeclaredFields();
                if (fields != null && fields.length > 0) {
                    for (Field f : fields) {
                        FieldName fieldName = f.getAnnotation(FieldName.class);
                        if (fieldName != null) {
                            System.out.println(f.getName() + " " + f.getType().getName());
                        }
                    }
                    //System.out.println(fields);
                }
            }catch (Throwable ex){
                ex.printStackTrace();
            }
        }

        System.out.println("done");


    }
}
