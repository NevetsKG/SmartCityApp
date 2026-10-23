package com.smartcity.model;

import java.util.Comparator;

public class PlaceComparator implements Comparator<Place>{

    public enum sortList {NAME, CATEGORY, RATING}
    private sortList option;

    public PlaceComparator(sortList option){
        this.option = option;
    }

    int result;
    public int compare(Place a, Place b){
        switch(option){
            case NAME:
                result = a.getName().compareTo(b.getName());
                break;
            case CATEGORY:
                result = a.getCategory().compareTo(b.getCategory());
                if (result == 0) { 
                    result = a.getName().compareTo(b.getName()); 
                }
                break;
            default:
                System.out.println("❌ Invalid choice '" + option + "'. Please enter either the Name or Category.");
                break;
            }
        return result;
    }
}