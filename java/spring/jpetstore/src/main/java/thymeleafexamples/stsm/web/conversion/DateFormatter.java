package thymeleafexamples.stsm.web.conversion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {
  
  @Autowired
  private MessageSource messageSource;

  public Date parse(final String text, final Locale locale) throws ParseException {
    SimpleDateFormat dateFormat = createDateFormat(locale);

    return dateFormat.parse(text);
  }

  public String print(final Date object, final Locale local) {
    final SimpleDateFormat dateFormat = createDateFormat(local);
    return dateFormat.format(object);
  }

  private SimpleDateFormat createDateFormat(final Locale locale) {
    final String format = this.messageSource.getMessage("date.format", null, locale);
    final SimpleDateFormat dateFormat =  new SimpleDateFormat(format);
    dateFormat.setLenient(false);

    return dateFormat;
  }


}
