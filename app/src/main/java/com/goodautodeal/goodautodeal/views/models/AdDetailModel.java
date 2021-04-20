package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bilal Zaman on 20/04/21.
 */
public class AdDetailModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ad_uuid")
    @Expose
    private String adUuid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("vrm")
    @Expose
    private String vrm;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;
    @SerializedName("finance_type")
    @Expose
    private String financeType;
    @SerializedName("make")
    @Expose
    private String make;
    @SerializedName("model")
    @Expose
    private String model;
    @SerializedName("variant")
    @Expose
    private String variant;
    @SerializedName("engine")
    @Expose
    private String engine;
    @SerializedName("colour")
    @Expose
    private String colour;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("mileage")
    @Expose
    private Integer mileage;
    @SerializedName("series")
    @Expose
    private Object series;
    @SerializedName("numberofdoors")
    @Expose
    private String numberofdoors;
    @SerializedName("numberofseats")
    @Expose
    private String numberofseats;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("transmission")
    @Expose
    private String transmission;
    @SerializedName("fueltype")
    @Expose
    private String fueltype;
    @SerializedName("co2emission")
    @Expose
    private String co2emission;
    @SerializedName("geartype")
    @Expose
    private String geartype;
    @SerializedName("seating")
    @Expose
    private String seating;
    @SerializedName("kerb")
    @Expose
    private String kerb;
    @SerializedName("axles")
    @Expose
    private String axles;
    @SerializedName("gear")
    @Expose
    private String gear;
    @SerializedName("keeper")
    @Expose
    private String keeper;
    @SerializedName("lenght")
    @Expose
    private String lenght;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("bhp")
    @Expose
    private String bhp;
    @SerializedName("max_speed")
    @Expose
    private String maxSpeed;
    @SerializedName("cylinder")
    @Expose
    private String cylinder;
    @SerializedName("euro_status")
    @Expose
    private String euroStatus;
    @SerializedName("GrossWeight")
    @Expose
    private String grossWeight;
    @SerializedName("ExtraUrban")
    @Expose
    private String extraUrban;
    @SerializedName("CertificateOfDestructionIssued")
    @Expose
    private String certificateOfDestructionIssued;
    @SerializedName("Scrapped")
    @Expose
    private String scrapped;
    @SerializedName("WheelPlan")
    @Expose
    private String wheelPlan;
    @SerializedName("WheelBase")
    @Expose
    private String wheelBase;
    @SerializedName("UrbanCold")
    @Expose
    private String urbanCold;
    @SerializedName("DrivingAxle")
    @Expose
    private String drivingAxle;
    @SerializedName("Exported")
    @Expose
    private String exported;
    @SerializedName("PlateChangeCount")
    @Expose
    private String plateChangeCount;
    @SerializedName("Range")
    @Expose
    private String range;
    @SerializedName("BodyStyle")
    @Expose
    private String bodyStyle;
    @SerializedName("CarLength")
    @Expose
    private String carLength;
    @SerializedName("Combined")
    @Expose
    private String combined;
    @SerializedName("NumberOfPreviousKeepers")
    @Expose
    private String numberOfPreviousKeepers;
    @SerializedName("NominalEngineCapacity")
    @Expose
    private String nominalEngineCapacity;
    @SerializedName("FuelTankCapacity")
    @Expose
    private String fuelTankCapacity;
    @SerializedName("FtLb")
    @Expose
    private String ftLb;
    @SerializedName("Acceleration")
    @Expose
    private String acceleration;
    @SerializedName("ImportNonEu")
    @Expose
    private String importNonEu;
    @SerializedName("V5CCertificateCount")
    @Expose
    private String v5CCertificateCount;
    @SerializedName("NumberOfGears")
    @Expose
    private String numberOfGears;
    @SerializedName("YearOfManufacture")
    @Expose
    private Object yearOfManufacture;
    @SerializedName("DateFirstRegisteredUk")
    @Expose
    private Object dateFirstRegisteredUk;
    @SerializedName("MotExpires")
    @Expose
    private Object motExpires;
    @SerializedName("RoadTax")
    @Expose
    private Object roadTax;
    @SerializedName("RoadTaxExpires")
    @Expose
    private Object roadTaxExpires;
    @SerializedName("BootCaicity")
    @Expose
    private Object bootCaicity;
    @SerializedName("zipcode")
    @Expose
    private String zipcode;
    @SerializedName("value_price")
    @Expose
    private Integer valuePrice;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("previous_price")
    @Expose
    private Object previousPrice;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("reject_reason")
    @Expose
    private Object rejectReason;
    @SerializedName("premium")
    @Expose
    private Integer premium;
    @SerializedName("featured")
    @Expose
    private Integer featured;
    @SerializedName("ad_no")
    @Expose
    private Integer adNo;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("adType")
    @Expose
    private Integer adType;
    @SerializedName("expiry")
    @Expose
    private Object expiry;
    @SerializedName("adApproved_by")
    @Expose
    private Object adApprovedBy;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("vfeature_id")
    @Expose
    private Integer vfeatureId;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("features")
    @Expose
    private List<AdCarFeatureModel> adCarFeatureModels = null;
    @SerializedName("adimage")
    @Expose
    private List<AdImagesModel> adimage = null;
    @SerializedName("advideo")
    @Expose
    private Object advideo;
    @SerializedName("users")
    @Expose
    private AdUsersModel adUsersModels;
    @SerializedName("dealers")
    @Expose
    private AdDealerModel adDealerModels;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdUuid() {
        return adUuid;
    }

    public void setAdUuid(String adUuid) {
        this.adUuid = adUuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVrm() {
        return vrm;
    }

    public void setVrm(String vrm) {
        this.vrm = vrm;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getFinanceType() {
        return financeType;
    }

    public void setFinanceType(String financeType) {
        this.financeType = financeType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Object getSeries() {
        return series;
    }

    public void setSeries(Object series) {
        this.series = series;
    }

    public String getNumberofdoors() {
        return numberofdoors;
    }

    public void setNumberofdoors(String numberofdoors) {
        this.numberofdoors = numberofdoors;
    }

    public String getNumberofseats() {
        return numberofseats;
    }

    public void setNumberofseats(String numberofseats) {
        this.numberofseats = numberofseats;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public String getCo2emission() {
        return co2emission;
    }

    public void setCo2emission(String co2emission) {
        this.co2emission = co2emission;
    }

    public String getGeartype() {
        return geartype;
    }

    public void setGeartype(String geartype) {
        this.geartype = geartype;
    }

    public String getSeating() {
        return seating;
    }

    public void setSeating(String seating) {
        this.seating = seating;
    }

    public String getKerb() {
        return kerb;
    }

    public void setKerb(String kerb) {
        this.kerb = kerb;
    }

    public String getAxles() {
        return axles;
    }

    public void setAxles(String axles) {
        this.axles = axles;
    }

    public String getGear() {
        return gear;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(String keeper) {
        this.keeper = keeper;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getBhp() {
        return bhp;
    }

    public void setBhp(String bhp) {
        this.bhp = bhp;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public String getEuroStatus() {
        return euroStatus;
    }

    public void setEuroStatus(String euroStatus) {
        this.euroStatus = euroStatus;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getExtraUrban() {
        return extraUrban;
    }

    public void setExtraUrban(String extraUrban) {
        this.extraUrban = extraUrban;
    }

    public String getCertificateOfDestructionIssued() {
        return certificateOfDestructionIssued;
    }

    public void setCertificateOfDestructionIssued(String certificateOfDestructionIssued) {
        this.certificateOfDestructionIssued = certificateOfDestructionIssued;
    }

    public String getScrapped() {
        return scrapped;
    }

    public void setScrapped(String scrapped) {
        this.scrapped = scrapped;
    }

    public String getWheelPlan() {
        return wheelPlan;
    }

    public void setWheelPlan(String wheelPlan) {
        this.wheelPlan = wheelPlan;
    }

    public String getWheelBase() {
        return wheelBase;
    }

    public void setWheelBase(String wheelBase) {
        this.wheelBase = wheelBase;
    }

    public String getUrbanCold() {
        return urbanCold;
    }

    public void setUrbanCold(String urbanCold) {
        this.urbanCold = urbanCold;
    }

    public String getDrivingAxle() {
        return drivingAxle;
    }

    public void setDrivingAxle(String drivingAxle) {
        this.drivingAxle = drivingAxle;
    }

    public String getExported() {
        return exported;
    }

    public void setExported(String exported) {
        this.exported = exported;
    }

    public String getPlateChangeCount() {
        return plateChangeCount;
    }

    public void setPlateChangeCount(String plateChangeCount) {
        this.plateChangeCount = plateChangeCount;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getCarLength() {
        return carLength;
    }

    public void setCarLength(String carLength) {
        this.carLength = carLength;
    }

    public String getCombined() {
        return combined;
    }

    public void setCombined(String combined) {
        this.combined = combined;
    }

    public String getNumberOfPreviousKeepers() {
        return numberOfPreviousKeepers;
    }

    public void setNumberOfPreviousKeepers(String numberOfPreviousKeepers) {
        this.numberOfPreviousKeepers = numberOfPreviousKeepers;
    }

    public String getNominalEngineCapacity() {
        return nominalEngineCapacity;
    }

    public void setNominalEngineCapacity(String nominalEngineCapacity) {
        this.nominalEngineCapacity = nominalEngineCapacity;
    }

    public String getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public void setFuelTankCapacity(String fuelTankCapacity) {
        this.fuelTankCapacity = fuelTankCapacity;
    }

    public String getFtLb() {
        return ftLb;
    }

    public void setFtLb(String ftLb) {
        this.ftLb = ftLb;
    }

    public String getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(String acceleration) {
        this.acceleration = acceleration;
    }

    public String getImportNonEu() {
        return importNonEu;
    }

    public void setImportNonEu(String importNonEu) {
        this.importNonEu = importNonEu;
    }

    public String getV5CCertificateCount() {
        return v5CCertificateCount;
    }

    public void setV5CCertificateCount(String v5CCertificateCount) {
        this.v5CCertificateCount = v5CCertificateCount;
    }

    public String getNumberOfGears() {
        return numberOfGears;
    }

    public void setNumberOfGears(String numberOfGears) {
        this.numberOfGears = numberOfGears;
    }

    public Object getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(Object yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Object getDateFirstRegisteredUk() {
        return dateFirstRegisteredUk;
    }

    public void setDateFirstRegisteredUk(Object dateFirstRegisteredUk) {
        this.dateFirstRegisteredUk = dateFirstRegisteredUk;
    }

    public Object getMotExpires() {
        return motExpires;
    }

    public void setMotExpires(Object motExpires) {
        this.motExpires = motExpires;
    }

    public Object getRoadTax() {
        return roadTax;
    }

    public void setRoadTax(Object roadTax) {
        this.roadTax = roadTax;
    }

    public Object getRoadTaxExpires() {
        return roadTaxExpires;
    }

    public void setRoadTaxExpires(Object roadTaxExpires) {
        this.roadTaxExpires = roadTaxExpires;
    }

    public Object getBootCaicity() {
        return bootCaicity;
    }

    public void setBootCaicity(Object bootCaicity) {
        this.bootCaicity = bootCaicity;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Integer getValuePrice() {
        return valuePrice;
    }

    public void setValuePrice(Integer valuePrice) {
        this.valuePrice = valuePrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Object getPreviousPrice() {
        return previousPrice;
    }

    public void setPreviousPrice(Object previousPrice) {
        this.previousPrice = previousPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(Object rejectReason) {
        this.rejectReason = rejectReason;
    }

    public Integer getPremium() {
        return premium;
    }

    public void setPremium(Integer premium) {
        this.premium = premium;
    }

    public Integer getFeatured() {
        return featured;
    }

    public void setFeatured(Integer featured) {
        this.featured = featured;
    }

    public Integer getAdNo() {
        return adNo;
    }

    public void setAdNo(Integer adNo) {
        this.adNo = adNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAdType() {
        return adType;
    }

    public void setAdType(Integer adType) {
        this.adType = adType;
    }

    public Object getExpiry() {
        return expiry;
    }

    public void setExpiry(Object expiry) {
        this.expiry = expiry;
    }

    public Object getAdApprovedBy() {
        return adApprovedBy;
    }

    public void setAdApprovedBy(Object adApprovedBy) {
        this.adApprovedBy = adApprovedBy;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVfeatureId() {
        return vfeatureId;
    }

    public void setVfeatureId(Integer vfeatureId) {
        this.vfeatureId = vfeatureId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<AdCarFeatureModel> getAdCarFeatureModels() {
        return adCarFeatureModels;
    }

    public void setAdCarFeatureModels(List<AdCarFeatureModel> adCarFeatureModels) {
        this.adCarFeatureModels = adCarFeatureModels;
    }

    public List<AdImagesModel> getAdimage() {
        return adimage;
    }

    public void setAdimage(List<AdImagesModel> adimage) {
        this.adimage = adimage;
    }

    public Object getAdvideo() {
        return advideo;
    }

    public void setAdvideo(Object advideo) {
        this.advideo = advideo;
    }

    public AdUsersModel getAdUsersModels() {
        return adUsersModels;
    }

    public void setAdUsersModels(AdUsersModel adUsersModels) {
        this.adUsersModels = adUsersModels;
    }

    public AdDealerModel getAdDealerModels() {
        return adDealerModels;
    }

    public void setAdDealerModels(AdDealerModel adDealerModels) {
        this.adDealerModels = adDealerModels;
    }
}
