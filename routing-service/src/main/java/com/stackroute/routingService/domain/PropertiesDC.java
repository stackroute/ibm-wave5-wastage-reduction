package com.stackroute.routingService.domain;

import org.neo4j.ogm.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RelationshipEntity(type = "LINKED_TO")
public class PropertiesDC {

    @Id @GeneratedValue private Long id;

    @StartNode
    private DeliveryBoy deliveryBoy;

    @EndNode
    private Charity charity;

    private String distance;

    public PropertiesDC() {
    }

    public PropertiesDC(Long id, Charity charity, String distance) {
        this.id = id;
        this.charity=charity;
        this.distance=distance;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public Charity getCharity() {
        return charity;
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
    }

}
