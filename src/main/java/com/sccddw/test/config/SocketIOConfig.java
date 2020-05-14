package com.sccddw.test.config;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * description
 *
 * @author dell
 * date 2020/5/14 15:33
 * @version 1.0
 **/
@org.springframework.context.annotation.Configuration
public class SocketIOConfig {
    @Value("${socketIo.host}")
    private String host;

    @Value("${socketIo.port}")
    private Integer port;

    @Value("${socketIo.context}")
    private String context;

    @Value("${socketIo.pingTimeout}")
    private int pingTimeout;

    @Bean
    public SocketIOServer socketIOServer() {
        Configuration configuration = new Configuration();
        configuration.setHostname(host);
        configuration.setPort(port);
        configuration.setContext(context);
        configuration.setPingTimeout(pingTimeout);

        return new SocketIOServer(configuration);
    }
}
