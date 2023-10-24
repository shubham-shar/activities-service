package com.activities.bits.service;

import com.activities.bits.config.EventConfig;
import com.activities.bits.model.Event;
import com.activities.bits.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EventService {

    @Autowired
    EventConfig eventConfig;

    @Autowired
    RestTemplate restTemplate;

    public List<Event> getEvents() throws URISyntaxException {
        String getEventsUrl = eventConfig.getUrl().concat(eventConfig.getEventsPath());
        URI uri = new URI(getEventsUrl);
        ResponseEntity<Event[]> events = restTemplate.getForEntity(uri, Event[].class);
        return Arrays.asList(events.getBody());
    }

    public Event getEvent(Long id) throws URISyntaxException {
        String getEventByIdUrl = eventConfig.getUrl().concat(eventConfig.getEventByIdPath())
                .concat("/").concat(id.toString());
        URI uri = new URI(getEventByIdUrl);
        ResponseEntity<Event> event = restTemplate.getForEntity(uri, Event.class);
        return event.getBody();
    }
}
