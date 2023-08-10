package ajiet.ise.dept.horizonbank;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Users {
    private String email,firstname,lastname, parentname, dob,gender,nationality,maritial_status,phno,permanentaddress, residentialaddress,incometype,income,education_qualification,occupationtype,occupation, religion,catogory;

    static long acid,aid;


        public  Users()
        {

        }
    public Users(long id,String email, String firstname, String lastname, String parentname, String dob, String gender, String nationality, String maritial_status, String phno, String permanentaddress, String residentialaddress, String incometype, String income, String education_qualification, String occupationtype, String occupation, String religion, String catogory) {

        DatabaseReference usersRef = FirebaseDatabase.getInstance().getReference("Users");
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists())
                {
                    aid=(snapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        id=aid;


        this.acid=id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.parentname = parentname;
        this.dob = dob;
        this.gender = gender;
        this.nationality = nationality;
        this.maritial_status = maritial_status;
        this.phno = phno;
        this.permanentaddress = permanentaddress;
        this.residentialaddress = residentialaddress;
        this.incometype = incometype;
        this.income = income;
        this.education_qualification = education_qualification;
        this.occupationtype = occupationtype;
        this.occupation = occupation;
        this.religion = religion;
        this.catogory = catogory;

    }


    public long getAcid() {
        return acid;
    }

    public void setAcid(long acid) {
        this.acid =acid;


    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parent) {
        this.parentname = parent;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMaritial_status() {
        return maritial_status;
    }

    public void setMaritial_status(String maritial) {
        this.maritial_status = maritial;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getPermanentaddress() {
        return permanentaddress;
    }

    public void setPermanentaddress(String permanentaddress) {
        this.permanentaddress = permanentaddress;
    }

    public String getResidentialaddress() {
        return residentialaddress;
    }

    public void setResidentialaddress(String residentialaddress) {
        this.residentialaddress = residentialaddress;
    }

    public String getIncometype() {
        return incometype;
    }

    public void setIncometype(String intype) {
        this.incometype = intype;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String in) {
        this.income = in;
    }

    public String getEducation_qualification() {
        return education_qualification;
    }

    public void setEducation_qualification(String edu) {
        this.education_qualification = edu;
    }

    public String getOccupationtype() {
        return occupationtype;
    }

    public void setOccupationtype(String ocptype) {
        this.occupationtype = ocptype;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String rel) {
        this.religion = rel;
    }

    public String getCatogory() {
        return catogory;
    }

    public void setCatogory(String cat) {
        this.catogory = cat;
    }
}
