package com.sleep.tugasakhir.model;

public class Data {
    private String id, name, harga, jenis;

    public Data(){

    }

    public Data(String id, String name, String harga, String jenis){
        this.id = id;
        this.name = name;
        this.harga = harga;
        this.jenis = jenis;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
}
