package dev.srg.application;

import dev.srg.domain.model.Itineraries;
import dev.srg.domain.model.Itinerary;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
final class CreateItineraryService implements CreateItineraryUseCase{

    private final Itineraries itineraries;

    @Override
    public void create(Itinerary itinerary) {
        log.debug("Save itinerary {}", itinerary);
        itineraries.save(itinerary);
    }
}
