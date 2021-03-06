package com.estate.assets.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Jehad on 12/1/2021.
 */
@Entity
@Table(name = "estate")
public class EstateModel {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getStocksNumber() {
        return stocksNumber;
    }

    public void setStocksNumber(int stocksNumber) {
        this.stocksNumber = stocksNumber;
    }

    public Date getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(Date sellingDate) {
        this.sellingDate = sellingDate;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private long price;
    @Column(name = "stocks_number")
    private int stocksNumber;
    @Column(name = "selling_date")
    private Date sellingDate;
    @Column(name = "sold_price")
    private double soldPrice;
    @Column(name = "buyer_name")
    private String buyerName;

    @Version
    private Long version;

    @OneToMany(mappedBy = "estate")
    private List<EstateLog> estateLogs = new ArrayList<EstateLog>();

    public List<EstateLog> getEstateLogs() {
        return estateLogs;
    }

    public void addLog(EstateLog log){
        estateLogs.add(log);
        log.setEsatete(this);

    }
    public void setEstateLogs(List<EstateLog> estateLogs) {
        this.estateLogs = estateLogs;
    }

    public EstateModel(String name, long price, int stocksNumber , Date sellingDate, long soldPrice, String buyerName ){
        super();
        this.name = name;
        this.price = price;
        this.stocksNumber = stocksNumber;
        this.sellingDate = sellingDate;
        this.soldPrice = soldPrice;
        this.buyerName = buyerName;

    }
    public EstateModel (String name , long price ){
        this.name = name;
        this.price = price;
    }
    public EstateModel (String name , long price , int stocksNumber){
        this.name = name;
        this.price = price;
        this.stocksNumber = stocksNumber;
    }
    public  EstateModel (){

    }
}
