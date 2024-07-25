// package com.example.service;

// import org.apache.kafka.clients.consumer.ConsumerConfig;
// import org.apache.kafka.clients.consumer.ConsumerRecord;
// import org.apache.kafka.clients.consumer.KafkaConsumer;
// import org.apache.kafka.common.serialization.StringDeserializer;

// import java.util.Collections;
// import java.util.Properties;

// public class KafkaConsumerService {
//     private final KafkaConsumer<String, String> consumer;

//     public KafkaConsumerService(String topic) {
//         Properties props = new Properties();
//         props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
//         props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group");
//         props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//         props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
//         consumer = new KafkaConsumer<>(props);
//         consumer.subscribe(Collections.singletonList(topic));
//     }

//     public void consumeMessages() {
//         while (true) {
//             for (ConsumerRecord<String, String> record : consumer.poll(100).records("health_reports")) {
//                 System.out.printf("Consumed record with key %s and value %s%n", record.key(), record.value());
//             }
//         }
//     }
// }
package com.example.service;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaConsumerService {
    private final KafkaConsumer<String, String> consumer;

    public KafkaConsumerService(String topic) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList(topic));
    }

    public void consumeMessages() {
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            records.forEach(record -> 
                System.out.printf("Consumed record with key %s and value %s%n", record.key(), record.value())
            );
        }
    }
}
