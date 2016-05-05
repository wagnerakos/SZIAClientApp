package bme.hu.sziaclientapp.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Ákos on 2016.05.05..
 */
public class Flight extends SugarRecord {
    String leavingFrom;
    String destination;
    Date departureTime;
    String checkInDeck;
    Integer delayInMinute;
    String comment;
}
