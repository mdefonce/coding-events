package org.launchcode.codingevents.models;

import javax.validation.constraints.*;
import java.util.Objects;

public class Event {

    private int id;
    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 20, message = "Name must bee between 3 and 50 characters long.")
    private String name;

    @NotBlank(message = "Description is required.")
    @Size(max = 500, message = "Description must no more than 500 characters.")
    private String description;

    @NotBlank(message = "Location cannot be empty.")
    @NotNull
    private String location;

    @AssertTrue
    private boolean registrationRequired;

//    @Min(1)
    @Positive(message="Number of attendees must be one or more.")
    private int numberOfAttendees;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

    public Event(String name, String description, String location, boolean registrationRequired, int numberOfAttendees, String contactEmail) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.registrationRequired = registrationRequired;
        this.numberOfAttendees = numberOfAttendees;
        this.contactEmail = contactEmail;
        this.id = nextId;
        nextId++;
    }

    public Event() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
