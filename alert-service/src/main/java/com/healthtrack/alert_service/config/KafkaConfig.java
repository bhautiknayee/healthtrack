package com.healthtrack.alert_service.config;

import com.healthtrack.alert_service.entity.Vital;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    @Bean
    public ConsumerFactory<String, Vital> vitalConsumerFactory() {
        JsonDeserializer<Vital> deserializer = new JsonDeserializer<>(Vital.class);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("com.healthtrack.alert_service.entity");
        deserializer.setUseTypeMapperForKey(true); // Optional: depends on use-case

        Map<String, Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG, "alert-group");
        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Vital> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Vital> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(vitalConsumerFactory());
        return factory;
    }
}
