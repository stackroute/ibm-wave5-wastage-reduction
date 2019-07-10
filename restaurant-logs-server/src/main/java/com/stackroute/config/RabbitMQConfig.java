package com.stackroute.config;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${restaurantLogs.rabbitmq.queue}")
    String restaurantQueue;

    @Value("${restaurant.rabbitmq.exchange}")
    String restaurantExchange;

    @Value("${restaurantLogs.rabbitmq.routingkey}")
    private String restaurantRoutingkey;

    @Bean
    Queue resQueue() {
        System.out.println("inside restaurant queue");
        return new Queue(restaurantQueue, true);
    }

    @Bean
    DirectExchange resExchange() {
        System.out.println("inside restaurant exchange");
        return new DirectExchange(restaurantExchange);
    }

    @Bean
    Binding resBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(resQueue()).to(resExchange()).with(restaurantRoutingkey);
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        System.out.println("inside rabbittemplate");
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}

