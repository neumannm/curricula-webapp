import de.th_koeln.iim.curricula.UserPasswordEncoderListener
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    localeResolver(SessionLocaleResolver) {
        defaultLocale= new java.util.Locale('de');
    }
}
