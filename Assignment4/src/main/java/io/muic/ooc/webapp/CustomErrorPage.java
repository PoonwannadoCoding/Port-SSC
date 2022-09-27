package io.muic.ooc.webapp;

import org.apache.tomcat.util.descriptor.web.ErrorPage;

public class CustomErrorPage extends ErrorPage {

    @Override
    public String getLocation() {
        System.out.println("xxx");
        return super.getLocation();
    }
}
