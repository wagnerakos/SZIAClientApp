package bme.hu.sziaclientapp.model;

import java.util.Objects;
import java.util.Date;

import com.google.gson.annotations.SerializedName;


public class Flight {

  public Flight(Long id, String leavingFrom, String destination) {
    this.id = id;
    this.leavingFrom = leavingFrom;
    this.destination = destination;
  }

  @SerializedName("id")
  private Long id = null;
  
  @SerializedName("leavingFrom")
  private String leavingFrom = null;
  
  @SerializedName("destination")
  private String destination = null;
  
  @SerializedName("departureTime")
  private Date departureTime = null;
  
  @SerializedName("checkInDeck")
  private String checkInDeck = null;
  
  @SerializedName("delayInMinute")
  private Integer delayInMinute = null;
  
  @SerializedName("comment")
  private String comment = null;
  

  
  /**
   **/
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  
  /**
   * City (with name of airport) where the flight starts.
   **/
  public String getLeavingFrom() {
    return leavingFrom;
  }
  public void setLeavingFrom(String leavingFrom) {
    this.leavingFrom = leavingFrom;
  }

  
  /**
   * Destination city (with name of airport).
   **/
  public String getDestination() {
    return destination;
  }
  public void setDestination(String destination) {
    this.destination = destination;
  }

  
  /**
   * Date and time when the flight takes off.
   **/
  public Date getDepartureTime() {
    return departureTime;
  }
  public void setDepartureTime(Date departureTime) {
    this.departureTime = departureTime;
  }

  
  /**
   * The code of the deck where passengers can check in to the flight.
   **/
  public String getCheckInDeck() {
    return checkInDeck;
  }
  public void setCheckInDeck(String checkInDeck) {
    this.checkInDeck = checkInDeck;
  }

  
  /**
   * The delay of the flight, in minutes.
   **/
  public Integer getDelayInMinute() {
    return delayInMinute;
  }
  public void setDelayInMinute(Integer delayInMinute) {
    this.delayInMinute = delayInMinute;
  }

  
  /**
   * Comment about the flight by the staff.
   **/
  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }
}
