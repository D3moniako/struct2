// package com.example.service;
// import org.apache.kafka.clients.producer.KafkaProducer;
// import org.apache.kafka.clients.producer.ProducerConfig;
// import org.apache.kafka.clients.producer.ProducerRecord;
// import org.apache.kafka.common.serialization.StringSerializer;

// import java.util.Properties;

// public class KafkaProducerService {
//     private final KafkaProducer<String, String> producer;
//     private final String topic;

//     public KafkaProducerService(String topic) {
//         Properties props = new Properties();
//         props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
//         props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//         props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
//         producer = new KafkaProducer<>(props);
//         this.topic = topic;
//     }

//     public void sendMessage(String key, String value) {
//         producer.send(new ProducerRecord<>(topic, key, value));
//     }

//     public void close() {
//         producer.close();
//     }
// }
package com.example.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducerService {
    private final KafkaProducer<String, String> producer;
    private final String topic;

    public KafkaProducerService(String topic) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        producer = new KafkaProducer<>(props);
        this.topic = topic;
    }

    public void sendMessage(String key, String value) {
        producer.send(new ProducerRecord<>(topic, key, value));
    }

    public void close() {
        producer.close();
    }
}
