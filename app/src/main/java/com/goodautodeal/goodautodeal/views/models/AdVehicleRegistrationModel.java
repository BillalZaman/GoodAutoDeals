package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Bilal Zaman on 03/04/21.
 */
public class AdVehicleRegistrationModel {
    @SerializedName("DateOfLastUpdate")
    @Expose
    private String dateOfLastUpdate;
    @SerializedName("Colour")
    @Expose
    private String colour;
    @SerializedName("VehicleClass")
    @Expose
    private String vehicleClass;
    @SerializedName("CertificateOfDestructionIssued")
    @Expose
    private Boolean certificateOfDestructionIssued;
    @SerializedName("EngineNumber")
    @Expose
    private String engineNumber;
    @SerializedName("EngineCapacity")
    @Expose
    private String engineCapacity;
    @SerializedName("TransmissionCode")
    @Expose
    private Object transmissionCode;
    @SerializedName("Exported")
    @Expose
    private Boolean exported;
    @SerializedName("YearOfManufacture")
    @Expose
    private String yearOfManufacture;
    @SerializedName("WheelPlan")
    @Expose
    private String wheelPlan;
    @SerializedName("DateExported")
    @Expose
    private Object dateExported;
    @SerializedName("Scrapped")
    @Expose
    private Boolean scrapped;
    @SerializedName("Transmission")
    @Expose
    private Object transmission;
    @SerializedName("DateFirstRegisteredUk")
    @Expose
    private String dateFirstRegisteredUk;
    @SerializedName("Model")
    @Expose
    private String model;
    @SerializedName("GearCount")
    @Expose
    private Integer gearCount;
    @SerializedName("ImportNonEu")
    @Expose
    private Boolean importNonEu;
    @SerializedName("PreviousVrmGb")
    @Expose
    private Object previousVrmGb;
    @SerializedName("GrossWeight")
    @Expose
    private Integer grossWeight;
    @SerializedName("DoorPlanLiteral")
    @Expose
    private String doorPlanLiteral;
    @SerializedName("MvrisModelCode")
    @Expose
    private String mvrisModelCode;
    @SerializedName("Vin")
    @Expose
    private String vin;
    @SerializedName("Vrm")
    @Expose
    private String vrm;
    @SerializedName("DateFirstRegistered")
    @Expose
    private String dateFirstRegistered;
    @SerializedName("DateScrapped")
    @Expose
    private Object dateScrapped;
    @SerializedName("DoorPlan")
    @Expose
    private String doorPlan;
    @SerializedName("YearMonthFirstRegistered")
    @Expose
    private String yearMonthFirstRegistered;
    @SerializedName("VinLast5")
    @Expose
    private String vinLast5;
    @SerializedName("VehicleUsedBeforeFirstRegistration")
    @Expose
    private Boolean vehicleUsedBeforeFirstRegistration;
    @SerializedName("MaxPermissibleMass")
    @Expose
    private Integer maxPermissibleMass;
    @SerializedName("Make")
    @Expose
    private String make;
    @SerializedName("MakeModel")
    @Expose
    private String makeModel;
    @SerializedName("TransmissionType")
    @Expose
    private String transmissionType;
    @SerializedName("SeatingCapacity")
    @Expose
    private Integer seatingCapacity;
    @SerializedName("FuelType")
    @Expose
    private String fuelType;
    @SerializedName("Co2Emissions")
    @Expose
    private Integer co2Emissions;
    @SerializedName("Imported")
    @Expose
    private Boolean imported;
    @SerializedName("MvrisMakeCode")
    @Expose
    private String mvrisMakeCode;
    @SerializedName("PreviousVrmNi")
    @Expose
    private Object previousVrmNi;
    @SerializedName("VinConfirmationFlag")
    @Expose
    private Object vinConfirmationFlag;

    public String getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(String dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getVehicleClass() {
        return vehicleClass;
    }

    public void setVehicleClass(String vehicleClass) {
        this.vehicleClass = vehicleClass;
    }

    public Boolean getCertificateOfDestructionIssued() {
        return certificateOfDestructionIssued;
    }

    public void setCertificateOfDestructionIssued(Boolean certificateOfDestructionIssued) {
        this.certificateOfDestructionIssued = certificateOfDestructionIssued;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public Object getTransmissionCode() {
        return transmissionCode;
    }

    public void setTransmissionCode(Object transmissionCode) {
        this.transmissionCode = transmissionCode;
    }

    public Boolean getExported() {
        return exported;
    }

    public void setExported(Boolean exported) {
        this.exported = exported;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getWheelPlan() {
        return wheelPlan;
    }

    public void setWheelPlan(String wheelPlan) {
        this.wheelPlan = wheelPlan;
    }

    public Object getDateExported() {
        return dateExported;
    }

    public void setDateExported(Object dateExported) {
        this.dateExported = dateExported;
    }

    public Boolean getScrapped() {
        return scrapped;
    }

    public void setScrapped(Boolean scrapped) {
        this.scrapped = scrapped;
    }

    public Object getTransmission() {
        return transmission;
    }

    public void setTransmission(Object transmission) {
        this.transmission = transmission;
    }

    public String getDateFirstRegisteredUk() {
        return dateFirstRegisteredUk;
    }

    public void setDateFirstRegisteredUk(String dateFirstRegisteredUk) {
        this.dateFirstRegisteredUk = dateFirstRegisteredUk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getGearCount() {
        return gearCount;
    }

    public void setGearCount(Integer gearCount) {
        this.gearCount = gearCount;
    }

    public Boolean getImportNonEu() {
        return importNonEu;
    }

    public void setImportNonEu(Boolean importNonEu) {
        this.importNonEu = importNonEu;
    }

    public Object getPreviousVrmGb() {
        return previousVrmGb;
    }

    public void setPreviousVrmGb(Object previousVrmGb) {
        this.previousVrmGb = previousVrmGb;
    }

    public Integer getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(Integer grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getDoorPlanLiteral() {
        return doorPlanLiteral;
    }

    public void setDoorPlanLiteral(String doorPlanLiteral) {
        this.doorPlanLiteral = doorPlanLiteral;
    }

    public String getMvrisModelCode() {
        return mvrisModelCode;
    }

    public void setMvrisModelCode(String mvrisModelCode) {
        this.mvrisModelCode = mvrisModelCode;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getVrm() {
        return vrm;
    }

    public void setVrm(String vrm) {
        this.vrm = vrm;
    }

    public String getDateFirstRegistered() {
        return dateFirstRegistered;
    }

    public void setDateFirstRegistered(String dateFirstRegistered) {
        this.dateFirstRegistered = dateFirstRegistered;
    }

    public Object getDateScrapped() {
        return dateScrapped;
    }

    public void setDateScrapped(Object dateScrapped) {
        this.dateScrapped = dateScrapped;
    }

    public String getDoorPlan() {
        return doorPlan;
    }

    public void setDoorPlan(String doorPlan) {
        this.doorPlan = doorPlan;
    }

    public String getYearMonthFirstRegistered() {
        return yearMonthFirstRegistered;
    }

    public void setYearMonthFirstRegistered(String yearMonthFirstRegistered) {
        this.yearMonthFirstRegistered = yearMonthFirstRegistered;
    }

    public String getVinLast5() {
        return vinLast5;
    }

    public void setVinLast5(String vinLast5) {
        this.vinLast5 = vinLast5;
    }

    public Boolean getVehicleUsedBeforeFirstRegistration() {
        return vehicleUsedBeforeFirstRegistration;
    }

    public void setVehicleUsedBeforeFirstRegistration(Boolean vehicleUsedBeforeFirstRegistration) {
        this.vehicleUsedBeforeFirstRegistration = vehicleUsedBeforeFirstRegistration;
    }

    public Integer getMaxPermissibleMass() {
        return maxPermissibleMass;
    }

    public void setMaxPermissibleMass(Integer maxPermissibleMass) {
        this.maxPermissibleMass = maxPermissibleMass;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public Integer getCo2Emissions() {
        return co2Emissions;
    }

    public void setCo2Emissions(Integer co2Emissions) {
        this.co2Emissions = co2Emissions;
    }

    public Boolean getImported() {
        return imported;
    }

    public void setImported(Boolean imported) {
        this.imported = imported;
    }

    public String getMvrisMakeCode() {
        return mvrisMakeCode;
    }

    public void setMvrisMakeCode(String mvrisMakeCode) {
        this.mvrisMakeCode = mvrisMakeCode;
    }

    public Object getPreviousVrmNi() {
        return previousVrmNi;
    }

    public void setPreviousVrmNi(Object previousVrmNi) {
        this.previousVrmNi = previousVrmNi;
    }

    public Object getVinConfirmationFlag() {
        return vinConfirmationFlag;
    }

    public void setVinConfirmationFlag(Object vinConfirmationFlag) {
        this.vinConfirmationFlag = vinConfirmationFlag;
    }

}
