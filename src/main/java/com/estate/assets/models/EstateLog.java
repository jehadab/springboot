package com.estate.assets.models;


import javax.persistence.*;
import java.util.Date;

/**
 * Created by Jehad on 12/13/2021.
 */
@Entity
@Table(name = "estate_log")
public class EstateLog {
    //    public Long getId() {
    //        return estateId;
    //    }
    //
    //    public void setId(Long id) {
    //        this.estateId = id;
    //    }

    public String getAdddedUser() {
        return adddedUser;
    }

    public void setAdddedUser(String adddedUser) {
        this.adddedUser = adddedUser;
    }

    public String getEditedUser() {
        return editedUser;
    }

    public void setEditedUser(String editedUser) {
        this.editedUser = editedUser;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Date getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(Date editedDate) {
        this.editedDate = editedDate;
    }

    public EstateModel getEsatete() {
        return estate;
    }

    public void setEsatete(EstateModel esatete) {
        this.estate = esatete;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public EstateLog(String id, String adddedUser , Date addedDate , EstateModel estate) {
        this.traceId = id ;
        this.estate = estate;
        this.adddedUser = adddedUser;
        this.addedDate = addedDate;
    }
    public void updateEstateLog(String id, String editedUser , Date editedDate , EstateModel estate){
        this.traceId = id ;
        this.editedUser = editedUser;
        this.editedDate = editedDate;
        this.estate = estate;
    }

    public EstateLog() {

    }

//    @Column(name = "estate_id")
//    Long estateId ;

    @Id
    @Column(name = "trace_id")
    private String traceId ;

    @ManyToOne
    @JoinColumn(name="id", nullable = false)
    private EstateModel estate ;

    @Column(name = "added_user")
    String adddedUser ;
    @Column(name = "edited_user")
    String editedUser ;

    @Column(name = "added_date")
    Date addedDate ;
    @Column(name = "edited_date")
    Date editedDate;
}
