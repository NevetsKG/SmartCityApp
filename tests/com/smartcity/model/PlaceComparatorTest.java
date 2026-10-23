package com.smartcity.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PlaceComparatorTest {
    private Place place1, place2, place3, place4;
    private ArrayList<Place> places;

    @BeforeEach 
    void setUp(){
        place4 = new Place(1, "Washington Square Park", "Park", "Lower Manhattan", "City park with iconic arch");
        place1 = new Place(2, "Central Park", "Park", "Downtown", "A beautiful green space");
        place2 = new Place(3, "Public Library", "Library", "Manhattan", "A stunning literary hub");
        place3 = new Place(4, "Hudson Theatre", "Theatre", "Manhattan", "Historic Broadway venue");
        place4 = new Place(5, "Flatiron Building", "Landmark", "Manhattan", "Iconic wedge shaped landmark");
    
        places = new ArrayList<>();
        places.add(place1); places.add(place2); places.add(place3); places.add(place4);
    }

    private List<String> nameList(){
        return places.stream().map(Place::getName).toList();
    }

    @DisplayName("Place Comparators")
        @Test
        void NameComparator_ShouldAlphabetize(){
            Collections.sort(places, new PlaceComparator(PlaceComparator.sortList.NAME));
            assertEquals(List.of("Central Park", "Flatiron Building", "Hudson Theatre", "Public Library", "Washington Square Park"), nameList());
        }
        
        @Test 
        void CategoryComparator_ShouldSortByCategoryThenAlphabetize(){
            Collections.sort(places, new PlaceComparator(PlaceComparator.sortList.CATEGORY));
            assertEquals(List.of("Flatiron Building", "Public Library", "Central Park", "Washing Square Park", "Hudson Theatre"), nameList());
        }

        @Test 
        void PlaceComparator_ShouldHandleSingleOrEmptyListByName(){
            ArrayList<Place> testList = new ArrayList<>();
            Collections.sort(testList, new PlaceComparator(PlaceComparator.sortList.NAME));
            assertTrue(testList.isEmpty());

            testList.add(places.get(0));
            Collections.sort(testList, new PlaceComparator(PlaceComparator.sortList.NAME));
            assertEquals(1, testList.size());
        }
        
        @Test 
        void PlaceComparator_ShouldHandleSingleOrEmptyListByCategory(){
            ArrayList<Place> testList = new ArrayList<>();
            Collections.sort(testList, new PlaceComparator(PlaceComparator.sortList.CATEGORY));
            assertTrue(testList.isEmpty());

            testList.add(places.get(0));
            Collections.sort(testList, new PlaceComparator(PlaceComparator.sortList.CATEGORY));
            assertEquals(1, testList.size());
        }
}

