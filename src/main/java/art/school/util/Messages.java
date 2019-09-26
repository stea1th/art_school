package art.school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    public String get(String code){
        accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
        return accessor.getMessage(code);
    }

    public String get(String code, Object... args){
        accessor = new MessageSourceAccessor(messageSource, LocaleContextHolder.getLocale());
        return accessor.getMessage(code, args);
    }
}
