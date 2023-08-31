package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="tool")
public class Tool {
    @Id
    @Column(name="id")
    private int id;

    @Size(min=1, message = "field is required")
    @Column(name="part_number")
    private String partNumber;

    @Size(min=1, message = "field is required")
    @Column(name="serial_number")
    private String serialNumber;

    @Size(min=1, message = "field is required")
    @Column(name="description")
    private String description;
    @Size(min=1, message = "field is required")
    @Column(name="location")
    private String location;
    public Tool() {
    }

    public Tool(String partNumber, String serialNumber, String description, String location) {
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.description = description;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "id=" + id +
                ", partNumber='" + partNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


