package com.example.submission;
import com.example.basicapp.BasicAppApplication;

public class SubmissionForm {
    public String Name;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String Id;
    public String VendorName;
    public int rate;
    public String leadName;
    public String Technology;

    public void setName(String name) {
        this.Name=name;
    }

    public void setVendorName(String vndr) {
        this.VendorName=vndr;
    }

    public void setRate(int i) {
        this.rate=i;
    }

    public String getName() {
        return Name;
    }

    public String getVendorName() {
        return VendorName;
    }

    public int getRate() {
        return rate;
    }
}

