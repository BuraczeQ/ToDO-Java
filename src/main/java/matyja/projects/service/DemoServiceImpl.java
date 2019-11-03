package matyja.projects.service;

import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    Object object = new Object();
    @Override
    public String getHelloMessage(String user) {
        return "Hello message --> DemoServiceIMPL " + user;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome message --> DemoServiceIMPL";
    }
}
