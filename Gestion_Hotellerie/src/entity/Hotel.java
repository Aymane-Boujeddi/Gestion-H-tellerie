package entity;

import java.util.UUID;


public class Hotel {
    private String id;
    private String name; // Unique
    private String adresse;
    private Integer chambre;
    private Double note;

    public Hotel (String name,String adresse,Double note,Integer chambre){
        this.name = name;
        this.adresse = adresse;
        this.note = note ;
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", adresse='" + adresse + '\'' +
                ", chambre=" + chambre +
                ", note=" + note +
                '}';
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getChambre() {
        return chambre;
    }

    public void setChambre(Integer chambre) {
        this.chambre = chambre;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
    }
}
