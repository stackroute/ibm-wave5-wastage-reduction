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

    @Value("${charityLogs.rabbitmq.queue}")
    String charityQueue;

    @Value("${charity.rabbitmq.exchange}")
    String charityExchange;

    @Value("${charityLogs.rabbitmq.routingkey}")
    private String charityRoutingkey;

    @Value("${deliveryBoyLogs.rabbitmq.queue}")
    String deliveryBoyQueue;

    @Value("${deliveryBoy.rabbitmq.exchange}")
    String deliveryBoyExchange;

    @Value("${deliveryBoyLogs.rabbitmq.routingkey}")
    private String deliveryBoyRoutingkey;


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
    Queue chrQueue() {
        System.out.println("inside charity queue");
        return new Queue(charityQueue, true);
    }

    @Bean
    DirectExchange chrExchange() {
        System.out.println("inside charity exchange");
        return new DirectExchange(charityExchange);
    }

    @Bean
    Binding chrBinding() {
        System.out.println("inside charity binding");
        return BindingBuilder.bind(chrQueue()).to(chrExchange()).with(charityRoutingkey);
    }

    @Bean
    Queue dbQueue() {
        System.out.println("inside delivery boy queue");
        return new Queue(deliveryBoyQueue, true);
    }

    @Bean
    DirectExchange dbExchange() {
        System.out.println("inside delivery boy exchange");
        return new DirectExchange(deliveryBoyExchange);
    }

    @Bean
    Binding dbBinding() {
        System.out.println("inside delivery boy binding");
        return BindingBuilder.bind(dbQueue()).to(dbExchange()).with(deliveryBoyRoutingkey);
    }

    @Value("${saveRestaurant.rabbitmq.queue}")
    String restaurantSaveQueueName;

    @Value("${saveRestaurant.rabbitmq.exchange}")
    String restaurantSaveExchange;

    @Value("${saveRestaurant.rabbitmq.routingkey}")
    private String restaurantSaveRoutingkey;

    @Bean
    Queue restaurantQueue() {
        System.out.println("inside queue");
        return new Queue(restaurantSaveQueueName, true);
    }

    @Bean
    DirectExchange restaurantExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(restaurantSaveExchange);
    }

    @Bean
    Binding binding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(restaurantQueue()).to(restaurantExchange()).with(restaurantSaveRoutingkey);
    }



    @Value("${saveCharity.rabbitmq.queue}")
    String charitySaveQueueName;

    @Value("${saveCharity.rabbitmq.exchange}")
    String charitySaveExchange;

    @Value("${saveCharity.rabbitmq.routingkey}")
    private String charitySaveRoutingkey;

    @Bean
    Queue charityQueue() {
        System.out.println("inside queue");
        return new Queue(charitySaveQueueName, true);
    }

    @Bean
    DirectExchange charityExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(charitySaveExchange);
    }

    @Bean
    Binding charityBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(charityQueue()).to(charityExchange()).with(charitySaveRoutingkey);
    }

    @Value("${saveDeliveryBoy.rabbitmq.queue}")
    String deliveryBoySaveQueueName;

    @Value("${saveDeliveryBoy.rabbitmq.exchange}")
    String deliveryBoySaveExchange;

    @Value("${saveDeliveryBoy.rabbitmq.routingkey}")
    private String deliveryBoySaveRoutingkey;

    @Bean
    Queue deliveryBoyQueue() {
        System.out.println("inside queue");
        return new Queue(deliveryBoySaveQueueName, true);
    }

    @Bean
    DirectExchange deliveryBoyExchange() {
        System.out.println("inside exchange");
        return new DirectExchange(deliveryBoySaveExchange);
    }

    @Bean
    Binding deliveryBoyBinding() {
        System.out.println("inside binding");
        return BindingBuilder.bind(deliveryBoyQueue()).to(deliveryBoyExchange()).with(deliveryBoySaveRoutingkey);
    }




    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
