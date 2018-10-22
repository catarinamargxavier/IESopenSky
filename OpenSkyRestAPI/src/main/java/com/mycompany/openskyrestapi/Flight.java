package com.mycompany.openskyrestapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@JsonIgnoreProperties(ignoreUnknown = true)
@Embeddable
public class Flight implements Serializable {
    
    @Column (name="ICAO")
    private String icao24;
    
    @Column (name="FIRST_SEEN")
    private int firstSeen;
    
    @Column (name="DEPARTURE_AIRPORT")
    private String estDepartureAirport;
    
    @Column (name="LAST_SEEN")
    private int lastSeen;
    
    @Column (name="ARRIVAL_AIRPORT")
    private String estArrivalAirport;
    
    @Column (name="CALL_SIGN")
    private String callSign;
    
    @Column (name="DEPARTURE_HORIZONTAL")
    private int estDepartureAirportHorizDistance;
    
    @Column (name="DEPARTURE_VERTICAL")
    private int estDepartureAirportVertDistance;
    
    @Column (name="ARRIVAL_HORIZONTAL")
    private int estArrivalAirportHorizDistance;
    
    @Column (name="ARRIVAL_VERTICAL")
    private int estArrivalAirportVertDistance;
    
    @Transient
    private int departureAirportCandidatesCount;
    
    @Transient
    private int arrivalAirportCandidatesCount;
    
    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public int getFirstSeen() {
        return firstSeen;
    }

    public void setFirstSeen(int firstSeen) {
        this.firstSeen = firstSeen;
    }

    public String getEstDepartureAirport() {
        return estDepartureAirport;
    }

    public void setEstDepartureAirport(String estDepartureAirport) {
        this.estDepartureAirport = estDepartureAirport;
    }

    public int getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(int lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getEstArrivalAirport() {
        return estArrivalAirport;
    }

    public void setEstArrivalAirport(String estArrivalAirport) {
        this.estArrivalAirport = estArrivalAirport;
    }

    public String getCallSign() {
        return callSign;
    }

    public void setCallSign(String callSign) {
        this.callSign = callSign;
    }

    public int getEstDepartureAirportHorizDistance() {
        return estDepartureAirportHorizDistance;
    }

    public void setEstDepartureAirportHorizDistance(int estDepartureAirportHorizDistance) {
        this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
    }

    public int getEstDepartureAirportVertDistance() {
        return estDepartureAirportVertDistance;
    }

    public void setEstDepartureAirportVertDistance(int estDepartureAirportVertDistance) {
        this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
    }

    public int getEstArrivalAirportHorizDistance() {
        return estArrivalAirportHorizDistance;
    }

    public void setEstArrivalAirportHorizDistance(int estArrivalAirportHorizDistance) {
        this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
    }

    public int getEstArrivalAirportVertDistance() {
        return estArrivalAirportVertDistance;
    }

    public void setEstArrivalAirportVertDistance(int estArrivalAirportVertDistance) {
        this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
    }

    public int getDepartureAirportCandidatesCount() {
        return departureAirportCandidatesCount;
    }

    public void setDepartureAirportCandidatesCount(int departureAirportCandidatesCount) {
        this.departureAirportCandidatesCount = departureAirportCandidatesCount;
    }

    public int getArrivalAirportCandidatesCount() {
        return arrivalAirportCandidatesCount;
    }

    public void setArrivalAirportCandidatesCount(int arrivalAirportCandidatesCount) {
        this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
    }

    @Override
    public String toString() {
        return "Flight{" + "icao24=" + icao24 + ", firstSeen=" + firstSeen + ", estDepartureAirport=" + estDepartureAirport + ", lastSeen=" + lastSeen + ", estArrivalAirport=" + estArrivalAirport + ", callSign=" + callSign + ", estDepartureAirportHorizDistance=" + estDepartureAirportHorizDistance + ", estDepartureAirportVertDistance=" + estDepartureAirportVertDistance + ", estArrivalAirportHorizDistance=" + estArrivalAirportHorizDistance + ", estArrivalAirportVertDistance=" + estArrivalAirportVertDistance + ", departureAirportCandidatesCount=" + departureAirportCandidatesCount + ", arrivalAirportCandidatesCount=" + arrivalAirportCandidatesCount + '}';
    }
    
    public Flight () {
    }

}
