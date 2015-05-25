package pt.iscte.tsi.mediamood.database.entity;

import org.mongodb.morphia.annotations.Embedded;

/**
 * Created by Chen on 21-05-2015.
 */
@Embedded("clusters")
public class Clusters {

    private String Blood;
    private String Discrimination;
    private String Drink;
    private String Drugs;
    private String Gambling;
    private String Nudity;
    private String Profanity;
    private String Sex;
    private String Tobaco;
    private String Violence;

    public Clusters(){

    }

    public Clusters(String blood,
                    String discrimination,
                    String drink,
                    String drugs,
                    String gambling,
                    String nudity,
                    String profanity,
                    String sex,
                    String tobaco,
                    String violence){
        this.Blood = blood;
        this.Discrimination = discrimination;
        this.Drink = drink;
        this.Drugs = drugs;
        this.Gambling = gambling;
        this.Nudity = nudity;
        this.Profanity = profanity;
        this.Sex = sex;
        this.Tobaco = tobaco;
        this.Violence = violence;
    }

    public String getBlood() {
        return Blood;
    }

    public void setBlood(String blood) {
        Blood = blood;
    }

    public String getDiscrimination() {
        return Discrimination;
    }

    public void setDiscrimination(String discrimination) {
        Discrimination = discrimination;
    }

    public String getDrink() {
        return Drink;
    }

    public void setDrink(String drink) {
        Drink = drink;
    }

    public String getDrugs() {
        return Drugs;
    }

    public void setDrugs(String drugs) {
        Drugs = drugs;
    }

    public String getGambling() {
        return Gambling;
    }

    public void setGambling(String gambling) {
        Gambling = gambling;
    }

    public String getNudity() {
        return Nudity;
    }

    public void setNudity(String nudity) {
        Nudity = nudity;
    }

    public String getProfanity() {
        return Profanity;
    }

    public void setProfanity(String profanity) {
        Profanity = profanity;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getTobaco() {
        return Tobaco;
    }

    public void setTobaco(String tobaco) {
        Tobaco = tobaco;
    }

    public String getViolence() {
        return Violence;
    }

    public void setViolence(String violence) {
        Violence = violence;
    }

    @Override
    public String toString() {
        //return "Clusters{" +
        //        "Blood='" + Blood + '\'' +
        //        ", Discrimination='" + Discrimination + '\'' +
        //        ", Drink='" + Drink + '\'' +
        //        ", Gambling='" + Gambling + '\'' +
        //        ", Nudity='" + Nudity + '\'' +
        //        ", Profanity='" + Profanity + '\'' +
        //        ", Sex='" + Sex + '\'' +
        //        ", Tobaco='" + Tobaco + '\'' +
        //        ", Violence='" + Violence + '\'' +
        //        '}';
        return "{" + Blood + "," + Discrimination + "," + Drink + "," + Drugs + "," + Gambling
                + "," + Nudity + "," + Profanity + "," + Sex + "," + Tobaco + "," + Violence + "}";
    }
}
