/**
 * EmitLogTopic.java
 *
 * Copyright 2016 the original author or authors.
 *
 * We licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.apache.niolex.rabbit.log;

import org.apache.niolex.commons.concurrent.ThreadUtil;
import org.apache.niolex.commons.test.MockUtil;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author <a href="mailto:xiejiyun@foxmail.com">Xie, Jiyun</a>
 * @version 2.1.2
 * @since Jul 19, 2016
 */
public class EmitLogTopic {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv)
                  throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        for (int i = 0; i < 100; ++i) {
            String message = String.format("%02d %s", i, MockUtil.randString(5));
            ThreadUtil.sleepAtLeast(1000);
            
            String routingKey = getSeverity() + "." + getFacility();
    
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes());
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");
        }
        
        channel.close();
        connection.close();
    }
    
    public static String getSeverity() {
        switch (MockUtil.randInt(8)) {
            case 0:
                return "error";
            case 1:
            case 2:
                return "warn";
            default:
                return "info";
        }
    }
    
    public static String getFacility() {
        switch (MockUtil.randInt(4)) {
            case 0:
                return "cron";
            case 1:
                return "kern";
            case 2:
                return "disk";
            default:
                return "sw";
        }
    }
    
}
