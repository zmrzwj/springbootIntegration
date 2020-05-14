package com.sccddw.test.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * description 连接状态监听
 * Copyright (C), 2019 by 四川成电大为科技有限公司
 *
 * @author mingtao
 * @version 1.0
 * date：2019/7/1 16:33
 */
@Service("eventListenner")
@Slf4j
public class ConnectEventListenner {
    SocketIOServer socketIOServer;

    public void setServer(SocketIOServer server) {
        this.socketIOServer = server;
    }

    /** 连接时调用 */
    @OnConnect
    public void onConnect(SocketIOClient client) {
        log.info("连接成功了哟~");
        Map<String, List<String>> map = client.getHandshakeData().getUrlParams();
        if(map == null || map.get("token") == null){
            return;
        }
        List<String> list = map.get("token");
        if(list == null || list.size() <= 0){
            return;
        }
    }

    /** 连接关闭时调用 */
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        log.info("关闭啦~");
    }



}
