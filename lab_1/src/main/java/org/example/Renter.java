package org.example;

import java.util.Objects;

/**
 * Клас, що представляє орендаря автомобіля.
 */
public class Renter {
    private String firstName;
    private String lastName;
    private String documentId;
    private String driverLicense;

    public Renter(String firstName, String lastName, String documentId, String driverLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentId = documentId;
        this.driverLicense = driverLicense;
    }

    @Override
    public String toString() {
        return "Renter{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", documentId='" + documentId + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Renter renter = (Renter) o;

        if (!documentId.equals(renter.documentId)) return false;
        return driverLicense.equals(renter.driverLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, documentId, driverLicense);
    }
}
