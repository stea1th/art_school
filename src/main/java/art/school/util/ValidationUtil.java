package art.school.util;

import art.school.entity.AbstractBaseEntity;
import art.school.util.exception.IllegalRequestDataException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ValidationUtil {

    public static void assureIdConsistent(AbstractBaseEntity bean, int id) {
        if(bean.isNew()){
            bean.setId(id);
        } else if(bean.getId() != id){
            throw new IllegalRequestDataException(bean + " must be with id=" + id);
        }

    }

    public static void checkNew(AbstractBaseEntity bean){
        if(!bean.isNew()){
            throw new IllegalRequestDataException(bean + " must be new (id=null");
        }
    }
}
