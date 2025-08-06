package com.custard.hotelmgmt.domain.enums;

public enum RoomType {
    SINGLE("Single Room", 1),
    DOUBLE("Double Room", 2),
    SUITE("Suite", 4),
    FAMILY("Family Room", 6),
    PENTHOUSE("Penthouse", 8),
    STUDIO("Studio Room", 2),
    DELUXE("Deluxe Room", 3),
    PRESIDENTIAL("Presidential Suite", 5);

    private final String description;
    private final int maxOccupancy;

    // Constructor for the enum values
    RoomType(String description, int maxOccupancy) {
        this.description = description;
        this.maxOccupancy = maxOccupancy;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    @Override
    public String toString() {
        return description + " (Max occupancy: " + maxOccupancy + ")";
    }

    // Example method to get a RoomType by its description
    public static RoomType fromDescription(String description) {
        for (RoomType roomType : RoomType.values()) {
            if (roomType.description.equalsIgnoreCase(description)) {
                return roomType;
            }
        }
        throw new IllegalArgumentException("No enum constant with description " + description);
    }
}
