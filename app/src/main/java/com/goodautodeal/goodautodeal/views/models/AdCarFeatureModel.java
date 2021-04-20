package com.goodautodeal.goodautodeal.views.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Bilal Zaman on 20/04/21.
 */
public class AdCarFeatureModel implements Serializable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("navigation")
    @Expose
    private Integer navigation;
    @SerializedName("zone_electronic_climate_control")
    @Expose
    private Integer zoneElectronicClimateControl;
    @SerializedName("smart_suspension")
    @Expose
    private Integer smartSuspension;
    @SerializedName("digital_cockpit")
    @Expose
    private Integer digitalCockpit;
    @SerializedName("bluetooth")
    @Expose
    private Integer bluetooth;
    @SerializedName("climate_control")
    @Expose
    private Integer climateControl;
    @SerializedName("auxiliary_point")
    @Expose
    private Integer auxiliaryPoint;
    @SerializedName("cruise_control")
    @Expose
    private Integer cruiseControl;
    @SerializedName("power_socket_centre_console")
    @Expose
    private Integer powerSocketCentreConsole;
    @SerializedName("adjustable_steering")
    @Expose
    private Integer adjustableSteering;
    @SerializedName("front_centre_armrest")
    @Expose
    private Integer frontCentreArmrest;
    @SerializedName("usb_connectivity")
    @Expose
    private Integer usbConnectivity;
    @SerializedName("rear_entertainment")
    @Expose
    private Integer rearEntertainment;
    @SerializedName("wifi_hotspot")
    @Expose
    private Integer wifiHotspot;
    @SerializedName("air_conditioning")
    @Expose
    private Integer airConditioning;
    @SerializedName("parking_sensor")
    @Expose
    private Integer parkingSensor;
    @SerializedName("anti_theft_alarm")
    @Expose
    private Integer antiTheftAlarm;
    @SerializedName("rain_sensor")
    @Expose
    private Integer rainSensor;
    @SerializedName("tool_kit")
    @Expose
    private Integer toolKit;
    @SerializedName("on_board_diagnostics")
    @Expose
    private Integer onBoardDiagnostics;
    @SerializedName("abs")
    @Expose
    private Integer abs;
    @SerializedName("front_passenger_airbags")
    @Expose
    private Integer frontPassengerAirbags;
    @SerializedName("passenger_airbags")
    @Expose
    private Integer passengerAirbags;
    @SerializedName("tyre_pressure_monitoring")
    @Expose
    private Integer tyrePressureMonitoring;
    @SerializedName("warning_triangle")
    @Expose
    private Integer warningTriangle;
    @SerializedName("locking_wheel_bolts")
    @Expose
    private Integer lockingWheelBolts;
    @SerializedName("remote_central_locking")
    @Expose
    private Integer remoteCentralLocking;
    @SerializedName("track_pack")
    @Expose
    private Integer trackPack;
    @SerializedName("back_Camera")
    @Expose
    private Integer backCamera;
    @SerializedName("isofix_mounts")
    @Expose
    private Integer isofixMounts;
    @SerializedName("blindspot_warning_alert")
    @Expose
    private Integer blindspotWarningAlert;
    @SerializedName("_360_degree_camera")
    @Expose
    private Integer _360DegreeCamera;
    @SerializedName("dimming_rear_mirror")
    @Expose
    private Integer dimmingRearMirror;
    @SerializedName("tyre_pressure_monitoring_display")
    @Expose
    private Integer tyrePressureMonitoringDisplay;
    @SerializedName("heated_seats")
    @Expose
    private Integer heatedSeats;
    @SerializedName("leather_seats")
    @Expose
    private Integer leatherSeats;
    @SerializedName("digital_radio")
    @Expose
    private Integer digitalRadio;
    @SerializedName("fulloption_steering_wheel")
    @Expose
    private Integer fulloptionSteeringWheel;
    @SerializedName("dvd_player")
    @Expose
    private Integer dvdPlayer;
    @SerializedName("car_mats")
    @Expose
    private Integer carMats;
    @SerializedName("sports_seats")
    @Expose
    private Integer sportsSeats;
    @SerializedName("mp3_player")
    @Expose
    private Integer mp3Player;
    @SerializedName("lome_link")
    @Expose
    private Integer lomeLink;
    @SerializedName("alloy_wheel")
    @Expose
    private Integer alloyWheel;
    @SerializedName("electric_heated_door_mirrors")
    @Expose
    private Integer electricHeatedDoorMirrors;
    @SerializedName("headlight_washer_jets")
    @Expose
    private Integer headlightWasherJets;
    @SerializedName("heated_windscreen_washer_jets")
    @Expose
    private Integer heatedWindscreenWasherJets;
    @SerializedName("led_lights")
    @Expose
    private Integer ledLights;
    @SerializedName("led_fog_lights")
    @Expose
    private Integer ledFogLights;
    @SerializedName("metallic_paint")
    @Expose
    private Integer metallicPaint;
    @SerializedName("winter_tyres")
    @Expose
    private Integer winterTyres;
    @SerializedName("panoramic_roof")
    @Expose
    private Integer panoramicRoof;
    @SerializedName("flat_tyres")
    @Expose
    private Integer flatTyres;
    @SerializedName("real_time_traffic_info")
    @Expose
    private Integer realTimeTrafficInfo;
    @SerializedName("button_start")
    @Expose
    private Integer buttonStart;
    @SerializedName("hill_start_assist")
    @Expose
    private Integer hillStartAssist;
    @SerializedName("engine_immobiliser")
    @Expose
    private Integer engineImmobiliser;
    @SerializedName("keyless_ignition")
    @Expose
    private Integer keylessIgnition;
    @SerializedName("electric_windows")
    @Expose
    private Integer electricWindows;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNavigation() {
        return navigation;
    }

    public void setNavigation(Integer navigation) {
        this.navigation = navigation;
    }

    public Integer getZoneElectronicClimateControl() {
        return zoneElectronicClimateControl;
    }

    public void setZoneElectronicClimateControl(Integer zoneElectronicClimateControl) {
        this.zoneElectronicClimateControl = zoneElectronicClimateControl;
    }

    public Integer getSmartSuspension() {
        return smartSuspension;
    }

    public void setSmartSuspension(Integer smartSuspension) {
        this.smartSuspension = smartSuspension;
    }

    public Integer getDigitalCockpit() {
        return digitalCockpit;
    }

    public void setDigitalCockpit(Integer digitalCockpit) {
        this.digitalCockpit = digitalCockpit;
    }

    public Integer getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(Integer bluetooth) {
        this.bluetooth = bluetooth;
    }

    public Integer getClimateControl() {
        return climateControl;
    }

    public void setClimateControl(Integer climateControl) {
        this.climateControl = climateControl;
    }

    public Integer getAuxiliaryPoint() {
        return auxiliaryPoint;
    }

    public void setAuxiliaryPoint(Integer auxiliaryPoint) {
        this.auxiliaryPoint = auxiliaryPoint;
    }

    public Integer getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(Integer cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public Integer getPowerSocketCentreConsole() {
        return powerSocketCentreConsole;
    }

    public void setPowerSocketCentreConsole(Integer powerSocketCentreConsole) {
        this.powerSocketCentreConsole = powerSocketCentreConsole;
    }

    public Integer getAdjustableSteering() {
        return adjustableSteering;
    }

    public void setAdjustableSteering(Integer adjustableSteering) {
        this.adjustableSteering = adjustableSteering;
    }

    public Integer getFrontCentreArmrest() {
        return frontCentreArmrest;
    }

    public void setFrontCentreArmrest(Integer frontCentreArmrest) {
        this.frontCentreArmrest = frontCentreArmrest;
    }

    public Integer getUsbConnectivity() {
        return usbConnectivity;
    }

    public void setUsbConnectivity(Integer usbConnectivity) {
        this.usbConnectivity = usbConnectivity;
    }

    public Integer getRearEntertainment() {
        return rearEntertainment;
    }

    public void setRearEntertainment(Integer rearEntertainment) {
        this.rearEntertainment = rearEntertainment;
    }

    public Integer getWifiHotspot() {
        return wifiHotspot;
    }

    public void setWifiHotspot(Integer wifiHotspot) {
        this.wifiHotspot = wifiHotspot;
    }

    public Integer getAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(Integer airConditioning) {
        this.airConditioning = airConditioning;
    }

    public Integer getParkingSensor() {
        return parkingSensor;
    }

    public void setParkingSensor(Integer parkingSensor) {
        this.parkingSensor = parkingSensor;
    }

    public Integer getAntiTheftAlarm() {
        return antiTheftAlarm;
    }

    public void setAntiTheftAlarm(Integer antiTheftAlarm) {
        this.antiTheftAlarm = antiTheftAlarm;
    }

    public Integer getRainSensor() {
        return rainSensor;
    }

    public void setRainSensor(Integer rainSensor) {
        this.rainSensor = rainSensor;
    }

    public Integer getToolKit() {
        return toolKit;
    }

    public void setToolKit(Integer toolKit) {
        this.toolKit = toolKit;
    }

    public Integer getOnBoardDiagnostics() {
        return onBoardDiagnostics;
    }

    public void setOnBoardDiagnostics(Integer onBoardDiagnostics) {
        this.onBoardDiagnostics = onBoardDiagnostics;
    }

    public Integer getAbs() {
        return abs;
    }

    public void setAbs(Integer abs) {
        this.abs = abs;
    }

    public Integer getFrontPassengerAirbags() {
        return frontPassengerAirbags;
    }

    public void setFrontPassengerAirbags(Integer frontPassengerAirbags) {
        this.frontPassengerAirbags = frontPassengerAirbags;
    }

    public Integer getPassengerAirbags() {
        return passengerAirbags;
    }

    public void setPassengerAirbags(Integer passengerAirbags) {
        this.passengerAirbags = passengerAirbags;
    }

    public Integer getTyrePressureMonitoring() {
        return tyrePressureMonitoring;
    }

    public void setTyrePressureMonitoring(Integer tyrePressureMonitoring) {
        this.tyrePressureMonitoring = tyrePressureMonitoring;
    }

    public Integer getWarningTriangle() {
        return warningTriangle;
    }

    public void setWarningTriangle(Integer warningTriangle) {
        this.warningTriangle = warningTriangle;
    }

    public Integer getLockingWheelBolts() {
        return lockingWheelBolts;
    }

    public void setLockingWheelBolts(Integer lockingWheelBolts) {
        this.lockingWheelBolts = lockingWheelBolts;
    }

    public Integer getRemoteCentralLocking() {
        return remoteCentralLocking;
    }

    public void setRemoteCentralLocking(Integer remoteCentralLocking) {
        this.remoteCentralLocking = remoteCentralLocking;
    }

    public Integer getTrackPack() {
        return trackPack;
    }

    public void setTrackPack(Integer trackPack) {
        this.trackPack = trackPack;
    }

    public Integer getBackCamera() {
        return backCamera;
    }

    public void setBackCamera(Integer backCamera) {
        this.backCamera = backCamera;
    }

    public Integer getIsofixMounts() {
        return isofixMounts;
    }

    public void setIsofixMounts(Integer isofixMounts) {
        this.isofixMounts = isofixMounts;
    }

    public Integer getBlindspotWarningAlert() {
        return blindspotWarningAlert;
    }

    public void setBlindspotWarningAlert(Integer blindspotWarningAlert) {
        this.blindspotWarningAlert = blindspotWarningAlert;
    }

    public Integer get360DegreeCamera() {
        return _360DegreeCamera;
    }

    public void set360DegreeCamera(Integer _360DegreeCamera) {
        this._360DegreeCamera = _360DegreeCamera;
    }

    public Integer getDimmingRearMirror() {
        return dimmingRearMirror;
    }

    public void setDimmingRearMirror(Integer dimmingRearMirror) {
        this.dimmingRearMirror = dimmingRearMirror;
    }

    public Integer getTyrePressureMonitoringDisplay() {
        return tyrePressureMonitoringDisplay;
    }

    public void setTyrePressureMonitoringDisplay(Integer tyrePressureMonitoringDisplay) {
        this.tyrePressureMonitoringDisplay = tyrePressureMonitoringDisplay;
    }

    public Integer getHeatedSeats() {
        return heatedSeats;
    }

    public void setHeatedSeats(Integer heatedSeats) {
        this.heatedSeats = heatedSeats;
    }

    public Integer getLeatherSeats() {
        return leatherSeats;
    }

    public void setLeatherSeats(Integer leatherSeats) {
        this.leatherSeats = leatherSeats;
    }

    public Integer getDigitalRadio() {
        return digitalRadio;
    }

    public void setDigitalRadio(Integer digitalRadio) {
        this.digitalRadio = digitalRadio;
    }

    public Integer getFulloptionSteeringWheel() {
        return fulloptionSteeringWheel;
    }

    public void setFulloptionSteeringWheel(Integer fulloptionSteeringWheel) {
        this.fulloptionSteeringWheel = fulloptionSteeringWheel;
    }

    public Integer getDvdPlayer() {
        return dvdPlayer;
    }

    public void setDvdPlayer(Integer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public Integer getCarMats() {
        return carMats;
    }

    public void setCarMats(Integer carMats) {
        this.carMats = carMats;
    }

    public Integer getSportsSeats() {
        return sportsSeats;
    }

    public void setSportsSeats(Integer sportsSeats) {
        this.sportsSeats = sportsSeats;
    }

    public Integer getMp3Player() {
        return mp3Player;
    }

    public void setMp3Player(Integer mp3Player) {
        this.mp3Player = mp3Player;
    }

    public Integer getLomeLink() {
        return lomeLink;
    }

    public void setLomeLink(Integer lomeLink) {
        this.lomeLink = lomeLink;
    }

    public Integer getAlloyWheel() {
        return alloyWheel;
    }

    public void setAlloyWheel(Integer alloyWheel) {
        this.alloyWheel = alloyWheel;
    }

    public Integer getElectricHeatedDoorMirrors() {
        return electricHeatedDoorMirrors;
    }

    public void setElectricHeatedDoorMirrors(Integer electricHeatedDoorMirrors) {
        this.electricHeatedDoorMirrors = electricHeatedDoorMirrors;
    }

    public Integer getHeadlightWasherJets() {
        return headlightWasherJets;
    }

    public void setHeadlightWasherJets(Integer headlightWasherJets) {
        this.headlightWasherJets = headlightWasherJets;
    }

    public Integer getHeatedWindscreenWasherJets() {
        return heatedWindscreenWasherJets;
    }

    public void setHeatedWindscreenWasherJets(Integer heatedWindscreenWasherJets) {
        this.heatedWindscreenWasherJets = heatedWindscreenWasherJets;
    }

    public Integer getLedLights() {
        return ledLights;
    }

    public void setLedLights(Integer ledLights) {
        this.ledLights = ledLights;
    }

    public Integer getLedFogLights() {
        return ledFogLights;
    }

    public void setLedFogLights(Integer ledFogLights) {
        this.ledFogLights = ledFogLights;
    }

    public Integer getMetallicPaint() {
        return metallicPaint;
    }

    public void setMetallicPaint(Integer metallicPaint) {
        this.metallicPaint = metallicPaint;
    }

    public Integer getWinterTyres() {
        return winterTyres;
    }

    public void setWinterTyres(Integer winterTyres) {
        this.winterTyres = winterTyres;
    }

    public Integer getPanoramicRoof() {
        return panoramicRoof;
    }

    public void setPanoramicRoof(Integer panoramicRoof) {
        this.panoramicRoof = panoramicRoof;
    }

    public Integer getFlatTyres() {
        return flatTyres;
    }

    public void setFlatTyres(Integer flatTyres) {
        this.flatTyres = flatTyres;
    }

    public Integer getRealTimeTrafficInfo() {
        return realTimeTrafficInfo;
    }

    public void setRealTimeTrafficInfo(Integer realTimeTrafficInfo) {
        this.realTimeTrafficInfo = realTimeTrafficInfo;
    }

    public Integer getButtonStart() {
        return buttonStart;
    }

    public void setButtonStart(Integer buttonStart) {
        this.buttonStart = buttonStart;
    }

    public Integer getHillStartAssist() {
        return hillStartAssist;
    }

    public void setHillStartAssist(Integer hillStartAssist) {
        this.hillStartAssist = hillStartAssist;
    }

    public Integer getEngineImmobiliser() {
        return engineImmobiliser;
    }

    public void setEngineImmobiliser(Integer engineImmobiliser) {
        this.engineImmobiliser = engineImmobiliser;
    }

    public Integer getKeylessIgnition() {
        return keylessIgnition;
    }

    public void setKeylessIgnition(Integer keylessIgnition) {
        this.keylessIgnition = keylessIgnition;
    }

    public Integer getElectricWindows() {
        return electricWindows;
    }

    public void setElectricWindows(Integer electricWindows) {
        this.electricWindows = electricWindows;
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
}
