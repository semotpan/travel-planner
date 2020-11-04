package dev.srg.application;

import dev.srg.domain.model.Itineraries;
import dev.srg.domain.model.Itinerary;

public interface CreateItineraryUseCase {

    void create(Itinerary itinerary);

    static CreateItineraryUseCase createItineraryUseCase(Itineraries itineraries) {
        return new CreateItineraryService(itineraries);
    }

}
