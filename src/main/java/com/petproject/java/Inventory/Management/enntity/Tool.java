package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="tool")
public class Tool {
    @Column(name="id")
    private int id;
    @Column(name="part_number")
    private String partNumber;
    @Column(name="serial_number")
    private String serialNumber;
    @Column(name="description")
    private String description;

    public Tool() {
    }

    public Tool(String partNumber, String serialNumber, String description) {
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.description = description;
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


