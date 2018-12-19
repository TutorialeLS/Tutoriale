//package pl.javastart;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration.Dynamic;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class AppInitializer implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {//metody ktore zostana wykonane po starcie servletu
//        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
//        ctx.setServletContext(servletContext);
//        DispatcherServlet dispatcher = new DispatcherServlet(ctx);//obiekt "kierujacy ruchem" w Spring        
//        Dynamic dispatcherConfig = servletContext.addServlet("dispatcher", dispatcher);
//        dispatcherConfig.addMapping("/");//przechwytuje wszystkie zadania z aplikacji
//        //gdyby bylo /app/ - Spirng przychwytywa³by tylko te ze wskazanego adresu
//    }
//}

//LUB prostsza wersja

package pl.javastart;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }
    @Override
    protected String[] getServletMappings() {//przechwytuje WSZYSTKIE zapytania do aplikacji,
    	//takze plik eclipse.png
        return new String[]{"/"};
    }
}

