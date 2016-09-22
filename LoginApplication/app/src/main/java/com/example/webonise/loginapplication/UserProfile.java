package com.example.webonise.loginapplication;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by webonise on 19/9/16.
 */
public class UserProfile extends RealmObject implements Parcelable {

    public String fname, lname, password, confirmPassword, gender, address, securityQuestion, securityAnswer;
    int contact;

    @PrimaryKey
    private String email;

    public UserProfile() {
    }

    public UserProfile(String fname, String lname, int contact, String email, String password, String confirmPassword, String gender, String address, String securityQuestion, String securityAnswer) {
        this.fname = fname;
        this.lname = lname;
        this.contact = contact;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.gender = gender;
        this.address = address;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFname() {
        return fname;
    }

    public int getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public String getGender() {
        return gender;
    }

    public String getLname() {
        return lname;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public String getAddress() {
        return address;
    }

    protected UserProfile(Parcel in) {
        fname = in.readString();
        lname = in.readString();
        contact = in.readInt();
        email = in.readString();
        password = in.readString();
        confirmPassword = in.readString();
        gender = in.readString();
        address = in.readString();
        securityQuestion = in.readString();
        securityAnswer = in.readString();
    }

    public static final Creator<UserProfile> CREATOR = new Creator<UserProfile>() {
        @Override
        public UserProfile createFromParcel(Parcel in) {
            return new UserProfile(in);
        }

        @Override
        public UserProfile[] newArray(int size) {
            return new UserProfile[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fname);
        dest.writeString(lname);
        dest.writeInt(contact);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(confirmPassword);
        dest.writeString(gender);
        dest.writeString(address);
        dest.writeString(securityQuestion);
        dest.writeString(securityAnswer);
    }
}
