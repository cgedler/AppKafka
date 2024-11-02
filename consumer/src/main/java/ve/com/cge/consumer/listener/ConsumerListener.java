/* 
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ve.com.cge.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * ConsumerListener
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 1, 2024
 */
@Component
public class ConsumerListener {
    
    private static Logger logger = LoggerFactory.getLogger(ConsumerListener.class);
     
    @KafkaListener(groupId = "group-1",
            topicPartitions = @TopicPartition(topic = "producer-topic", partitions = {"0"})
            ,containerFactory = "containerFactory")
    public void listener1(String message){
        logger.info("LISTENER1 ::: Receiving a message {}", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = @TopicPartition(topic = "producer-topic", partitions = {"1"})
            ,containerFactory = "containerFactory")
    public void listener2(String message){
        logger.info("LISTENER2 ::: Receiving a message {}",message);
    }

    @KafkaListener(groupId = "group-2",topics = "producer-topic", containerFactory = "containerFactory")
    public void listener3(String message){
        logger.info("LISTENER3 ::: Receiving a message {}", message);
    }
    
}
