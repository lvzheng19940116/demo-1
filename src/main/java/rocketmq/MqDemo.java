package rocketmq;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageConst;

/**
 * @author LvZheng
 * 创建时间：2021/3/11 下午5:33
 */
public class MqDemo {


    public void delayTopic() {
        Message msg = new Message();
        msg.setTopic("TopicA");
        msg.setTags("Tag");
        msg.setBody("this is a delay message".getBytes());
        //设置延迟level为5，对应延迟1分钟
        msg.setDelayTimeLevel(5);

        String propertyDelayTimeLevel = MessageConst.PROPERTY_DELAY_TIME_LEVEL;


    }
}
