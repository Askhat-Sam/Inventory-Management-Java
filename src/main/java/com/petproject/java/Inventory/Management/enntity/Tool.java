package com.petproject.java.Inventory.Management.enntity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name="tool")
public class Tool implements Comparable<Tool>{
    @Id
    @Column(name = "barcode_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int barcodeId;

    @Size(min=1, message = "field is required")
    @Column(name="parent_barcode_id")
    private String parentBarcodeId;

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
    @Size(min=1, message = "field is required")
    @Column(name="shelf")
    private String shelf;
    @Size(min=1, message = "field is required")
    @Column(name="verification_type")
    private String verificationType;
    @Size(min=1, message = "field is required")
    @Column(name="next_due_date")
    private String nextDueDate;

    public Tool(String parentBarcodeId, String partNumber, String serialNumber, String description, String location, String shelf, String verificationType, String nextDueDate) {
        this.parentBarcodeId = parentBarcodeId;
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.description = description;
        this.location = location;
        this.shelf = shelf;
        this.verificationType = verificationType;
        this.nextDueDate = nextDueDate;
    }
    public Tool(int barcodeId, String parentBarcodeId, String partNumber, String serialNumber, String description, String location, String shelf, String verificationType, String nextDueDate) {
        this.barcodeId = barcodeId;
        this.parentBarcodeId = parentBarcodeId;
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.description = description;
        this.location = location;
        this.shelf = shelf;
        this.verificationType = verificationType;
        this.nextDueDate = nextDueDate;
    }
    public Tool(String partNumber, String serialNumber, String description, String location) {
        this.partNumber = partNumber;
        this.serialNumber = serialNumber;
        this.description = description;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "barcodeId=" + barcodeId +
                ", parentBarcodeId='" + parentBarcodeId + '\'' +
                ", partNumber='" + partNumber + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", shelf='" + shelf + '\'' +
                ", verificationType='" + verificationType + '\'' +
                ", nextDueDate='" + nextDueDate + '\'' +
                '}';
    }

    @Override
    public int compareTo(Tool o) {
        return Comparator.comparing(Tool::getPartNumber)
                .thenComparing(Tool::getSerialNumber)
                .thenComparing(Tool::getDescription)
                .thenComparing(Tool::getLocation)
                .thenComparing(Tool::getShelf)
                .thenComparing(Tool::getNextDueDate)
                .thenComparing(Tool::getVerificationType)
                .compare(this, o);
    }
}


