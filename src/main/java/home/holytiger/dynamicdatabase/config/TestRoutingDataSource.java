package home.holytiger.dynamicdatabase.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Log4j2
public class TestRoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        log.info(request.getRequestURI());
        log.info(request.getRequestURI().endsWith("/master"));

        if(request.getRequestURI().endsWith("/master")){
            log.info("master");
            return "master";
        }else{
            log.info("slave");
            return "slave";
        }
    }
}
