package com.sccddw.test.service.impl;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.sccddw.test.service.ConnectEventListenner;
import com.sccddw.test.service.SocketIOService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description
 *
 * @author dell
 * date 2020/5/14 16:20
 * @version 1.0
 **/
@Slf4j
@Service(value = "SocketIOService")
public class SocketIOServiceImpl implements SocketIOService {
    /**
     * 存放已连接的客户端
     */
    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    /**
     * 自定义事件`push_data_event`,用于服务端与客户端通信
     */
    private static final String PUSH_DATA_EVENT = "push_data_event";
    // client.sendEvent(PUSH_DATA_EVENT, msgContent); (发送事件)

    @Autowired
    private SocketIOServer socketIOServer;

    @Resource
    private ConnectEventListenner connectEventListenner;

    @Override
    public void start() {

        // 监听客户端连接
        socketIOServer.addConnectListener(client -> {
            log.info("************ 客户端： " + getIpByClient(client) + " 已连接 ************");
            // 自定义事件`connected` -> 与客户端通信  （也可以使用内置事件，如：Socket.EVENT_CONNECT）
            client.sendEvent("connected", "你成功连接上了哦...");
            Map params = getParamsByClient(client);
            log.info(params.toString());
        });

        // 监听客户端断开连接
        socketIOServer.addDisconnectListener(client -> {
            String clientIp = getIpByClient(client);
            log.info(clientIp + " *********************** " + "客户端已断开连接");
            Map params = getParamsByClient(client);
            log.info(params.toString());
        });

        // 自定义事件`client_info_event` -> 监听客户端消息
        socketIOServer.addEventListener(PUSH_DATA_EVENT, String.class, (client, data, ackSender) -> {
            // 客户端推送`client_info_event`事件时，onData接受数据，这里是string类型的json数据，还可以为Byte[],object其他类型
            log.info(PUSH_DATA_EVENT + " *********************** " + "事件触发");
            log.info(data);
            String clientIp = getIpByClient(client);
            log.debug(clientIp + " ************ 客户端：" + data);
        });

        // 启动服务
        socketIOServer.start();
    }

    @Override
    public void stop() {
        if (socketIOServer != null) {
            socketIOServer.stop();
            socketIOServer = null;
        }
    }

    /**
     * 获取客户端url中的userId参数（这里根据个人需求和客户端对应修改即可）
     *
     * @param client: 客户端
     * @return: java.lang.String
     */
    private Map getParamsByClient(SocketIOClient client) {
        // 获取客户端url参数（这里的userId是唯一标识）
        Map<String, List<String>> params = client.getHandshakeData().getUrlParams();
        if (!CollectionUtils.isEmpty(params)) {
            return params;
        }
        return null;
    }

    /**
     * 获取连接的客户端ip地址
     *
     * @param client: 客户端
     * @return: java.lang.String
     */
    private String getIpByClient(SocketIOClient client) {
        String sa = client.getRemoteAddress().toString();
        String clientIp = sa.substring(1, sa.indexOf(":"));
        return clientIp;
    }
}
