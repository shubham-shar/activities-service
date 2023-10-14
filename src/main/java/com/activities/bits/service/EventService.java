package com.activities.bits.service;

import com.activities.bits.model.Event;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EventService {

    public List<Event> getEvents() {
        Event event1 = Event.builder()
                .id(1234L)
                .title("Event1")
                .build();
        Event event2 = Event.builder()
                .id(123456L)
                .title("Event2")
                .build();
        return Arrays.asList(event1, event2);
    }

    public Event getEvent(Long id) {
        return Event.builder()
                .id(id)
                .title("Event1")
                .description("DJ concert")
                .locationName("Bangalore")
                .build();
    }
}
