package art.school.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
public class Messages {

    @Autowired
    private MessageSource messageSource;

    private MessageSourceAccessor accessor;

    private Locale locale = LocaleContextHolder.getLocale();

    @PostConstruct
    private void init(){
        accessor = new MessageSourceAccessor(messageSource, locale);
        System.out.println(locale.toString());
    }

    public String get(String code){
        return accessor.getMessage(code);
    }

    public String get(String code, Object... args){
        return accessor.getMessage(code, args);
    }
}
