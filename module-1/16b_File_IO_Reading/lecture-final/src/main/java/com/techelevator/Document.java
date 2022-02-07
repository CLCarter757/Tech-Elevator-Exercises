package com.techelevator;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Document {
    private LocalDateTime dateCreated;
    private LocalDateTime dateLastUpdated;
    private Person createdBy;
    private Person lastUpdatedBy;
    private Person signedBy;

    public abstract List<String> getQuestions();

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateLastUpdated() {
        return dateLastUpdated;
    }

    public void setDateLastUpdated(LocalDateTime dateLastUpdated) {
        this.dateLastUpdated = dateLastUpdated;
    }

    public Person getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Person createdBy) {
        this.createdBy = createdBy;
    }

    public Person getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Person lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Person getSignedBy() {
        return signedBy;
    }

    public void setSignedBy(Person signedBy) {
        this.signedBy = signedBy;
    }
}
