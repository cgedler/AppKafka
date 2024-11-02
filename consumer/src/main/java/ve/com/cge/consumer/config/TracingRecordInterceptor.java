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

package ve.com.cge.consumer.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

/**
 * TracingRecordInterceptor
 * 
 * @author Christopher Gedler <cgedler@gmail.com>
 * @version 1.0
 * @since Nov 1, 2024
 */
public class TracingRecordInterceptor implements RecordInterceptor<String, String> {
    
    private static Logger logger = LoggerFactory.getLogger(TracingRecordInterceptor.class);

    @Override
    public ConsumerRecord<String, String> intercept(ConsumerRecord<String, String> record) {
        if(record.value().contains("Suscribe")){
            logger.info("Contains the word Subscribe");
            logger.info("Intercepted record: key = {}, value = {}", record.key(), record.value());
            return record;
        }
        return record;
    }
    
}
