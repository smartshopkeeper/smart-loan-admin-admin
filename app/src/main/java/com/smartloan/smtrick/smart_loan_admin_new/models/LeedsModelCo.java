package com.smartloan.smtrick.smart_loan_admin_new.models;

import android.view.View;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeedsModelCo implements Serializable {

    //Applicant
    private String customerName;
    private String mobileNumber;
    private String address;
    private String gender;
    private String agentId;
    private Long createdDateTime, updatedDateTime;
    private String loanType;
    private String panCardNumber;
    private String email;
    private String dateOfBirth;
    private String expectedLoanAmount;
    private String occupation;
    private String agentName;
    private String leedId;
    private String status;
    private String customerImageSmall;
    private String customerImagelarg;
    private String leedNumber;
    private String bankName;
    private String payout;
    private String createdBy;
    private Map<String, ImagesModel> documentImages;
    private String approvedLoan;
    private String gst;
    private String officeAdderess;
    private String propertyAddress;
    private String description;
    private String dissbussloan;
    private String adharNo;
    private String altmobile;
    private String income;
    private String parents;
    private String recidential;
    private String peraddress;
    private String mincome;
    private String yincome;
    private String flatno;
    private String projectname;
    private String propaddress;
    private String propage;
    private String proparea;

    private String currentpin;
    private String currentlandmark;
    private String currentarea;
    private String currentstreet;

    private String pincode;
    private String landmark;
    private String area;
    private String street;
    private String pcity;
    private String pstate;
    private String education;
    private String channelPartner;
    private String addressYesNo;
    private String otherEducation;
    private String apvoterid;
    private String apdrivinglicence;
    private String appassport;
    private String proofadhar;
    private String proofvoterid;
    private String proofdl;
    private String proofelectricitybill;
    private String proofrentagmt;
    private String proofpassport;
    private String proofgevtid;
    private String proofgumasta;
    private String proofcurrentacctstmt;

    private String coApplicantYN;
    private String prapplicantrelation;
    private String coapplicantotherrelation;
    private String prreference1name;
    private String prreference1address;
    private String prreferencecontactno;
    private String prreferencerelationship;
    private String prreference2name;
    private String prreference2address;
    private String prreference2contactno;
    private String prreference2relationship;


//Income
//    private String employed;
//    private String companytype;
//    private String othercompany;
//    private String salaytype;
//    private String emi;
//    private String tenure;
//    private String experience;
//    private String department;
//    private String designation;
//    private String grosssalary;
//    private String netsalary;
//    private String overtime;
//    private String incentive;
//    private String bonus;
//    private String rentalincome;
//    private String annualincome;
//    private String rental;
//    private String salarysleep;
//    private String bankstmt;
//    private String form;
//    private String appointmentltr;
//    private String conformationltr;
//    private String experinceltr;
//    private String visa;
//    private String passport;
//    private String emploerltr;
//    private String contractltr;
//    private String poa;
//    private String nrebankstmt;
//    private String overseasbankdetail;
//    private String itr;
//    private String currentbankstmt;
//    private String savingacctstmt;
//    private String partnersheepdeed;
//    private String businessagmt;
//    private String qualification;
//    private String aggrecultureIncome;
//    private String otherIncome;
//    private String emicar;
//    private String emihome;
//    private String emisociety;
//    private String emipersonal;
//    private String emiother;
//    private String emiOtherDetails;
//
////Propety Details
//    private String propety;
//    private String propetyYN;
//    private String loanrequirement;
//    private String downpayment;
//
//
//    private String prgender;
//    private String predu;
//    private String prpropertyaddress;
//    private String prpropertypin;
//    private String prpropertylandmark;
//    private String prpropertyarea;
//    private String prprojectname;
//    private String prapplicantfullname;
//    private String prapplicantdob;
//    private String prapplicantcontactno;
//    private String prapplicantaltcontactno;
//    private String prapplicantemail;
//    private String prapplicantcurrentaddress;
//    private String prapplicantperaddress;
//    private String praplicantoffceaddress;
//    private String prAPadhar;
//    private String prAapan;
//    private String prAapvoterid;
//    private String prAapdl;
//    private String prAappassport;
//    private String pradadhar;
//    private String pradvoterid;
//    private String praddl;
//    private String pradelectricity;
//    private String pradpassport;
//    private String pradrentagmt;
//    private String pradgovtid;
//    private String pradgumasta;
//    private String pradcurrentacctstmt;
//    private String prpropertytype;
//    private String prrecidenttype;



    private View.OnClickListener requestBtnClickListener;

    public LeedsModelCo() {
    }

    public LeedsModelCo(int id) {

        this.addressYesNo = "address";
        this.otherEducation = "other";
        this.apvoterid = "voterid";
        this.apdrivinglicence = "licence";
        this.appassport = "passport";
        this.proofadhar = "adhar";
        this.proofvoterid = "adhar";
        this.proofdl = "adhar";
        this.proofelectricitybill = "adhar";
        this.proofrentagmt = "adhar";
        this.proofpassport = "adhar";
        this.proofgevtid = "adhar";
        this.proofgumasta = "adhar";
        this.proofcurrentacctstmt = "adhar";

        this.channelPartner = "ChannelPartner";
        this.education = "mca";
        this.flatno = "Prateek Patel";
        this.projectname = "84121211";
        this.propaddress = "Prateek Patel";
        this.propage = "84121211";
        this.proparea = "Pune";

        this.currentpin = "pin";
        this.currentlandmark = "pin";
        this.currentarea = "pin";
        this.currentstreet = "pin";

        this.pincode = "Prateek Patel";
        this.landmark = "akurdi";
        this.area = "dyp";
        this.street = "fcroad";
        this.pcity = "84121211";
        this.pstate = "Pune";
        this.mincome = "Prateek Patel";
        this.yincome = "84121211";
        this.parents = "Prateek Patel";
        this.recidential = "84121211";
        this.peraddress = "Pune";
        this.customerName = "Prateek Patel";
        this.mobileNumber = "84121211";
        this.address = "Pune";
        this.gender = "Male";
        this.agentId = "Ag-56465";
        this.loanType = "Home Loan";
        this.panCardNumber = "jds45";
        this.email = "kjsdj@jhjdf.sdf";
        this.expectedLoanAmount = "2565656";
        this.occupation = "vdvf";
        this.agentName = "Aikk";
        this.leedId = "dfgdfg";
        this.status = "Generated";
        this.leedNumber = "LD_56654";
        this.bankName = "SBI";
        this.payout = "325454";
        this.approvedLoan = "3564545";
        this.dissbussloan = "3564545";
        this.gst = "2%";
        this.officeAdderess = "na";
        this.propertyAddress = "na";
        this.description = "na";
        this.altmobile = "na";
        this.adharNo = "na";
        this.income = "na";

        this.coApplicantYN = "YN";
        this.prapplicantrelation = "na";
        this.coapplicantotherrelation = "na";
        this.prreference1name = "na";
        this.prreference1address = "na";
        this.prreferencecontactno = "na";
        this.prreferencerelationship = "na";
        this.prreference2name = "na";
        this.prreference2address = "na";
        this.prreference2contactno = "na";
        this.prreference2relationship = "na";

        //Income
//        this.employed = "na";
//        this.companytype = "na";
//        this.othercompany = "na";
//        this.salaytype = "na";
//        this.emi = "na";
//        this.emicar = "na";
//        this.emihome = "na";
//        this.emisociety = "na";
//        this.emipersonal = "na";
//        this.emiother = "na";
//        this.emiOtherDetails = "na";
//        this.tenure = "na";
//        this.experience = "na";
//        this.department = "na";
//        this.designation = "na";
//        this.grosssalary = "na";
//        this.netsalary = "na";
//        this.overtime = "na";
//        this.incentive = "na";
//        this.bonus = "na";
//        this.rentalincome = "na";
//        this.annualincome = "na";
//        this.rental = "na";
//        this.salarysleep = "na";
//        this.bankstmt = "na";
//        this.form = "na";
//        this.appointmentltr = "na";
//        this.conformationltr = "na";
//        this.experinceltr = "na";
//        this.visa = "na";
//        this.passport = "na";
//        this.emploerltr = "na";
//        this.contractltr = "na";
//        this.poa = "na";
//        this.nrebankstmt = "na";
//        this.overseasbankdetail = "na";
//        this.itr = "na";
//        this.currentbankstmt = "na";
//        this.savingacctstmt = "na";
//        this.partnersheepdeed = "na";
//        this.businessagmt = "na";
//        this.qualification = "na";
//        this.aggrecultureIncome = "na";
//        this.otherIncome = "na";
//
//        //Property
//        this.prgender = "na";
//        this.predu = "na";
//        this.prpropertyaddress = "na";
//        this.prpropertypin = "na";
//        this.prpropertylandmark = "na";
//        this.prpropertyarea = "na";
//        this.prprojectname = "na";
//        this.prapplicantfullname = "na";
//        this.prapplicantdob = "na";
//        this.prapplicantcontactno = "na";
//        this.prapplicantaltcontactno = "na";
//        this.prapplicantemail = "na";
//        this.prapplicantcurrentaddress = "na";
//        this.prapplicantperaddress = "na";
//        this.praplicantoffceaddress = "na";
//        this.prAPadhar = "na";
//        this.prAapan = "na";
//        this.prAapvoterid = "na";
//        this.prAapdl = "na";
//        this.prAappassport = "na";
//        this.pradadhar = "na";
//        this.pradvoterid = "na";
//        this.praddl = "na";
//        this.pradelectricity = "na";
//        this.pradpassport = "na";
//        this.pradrentagmt = "na";
//        this.pradgovtid = "na";
//        this.pradgumasta = "na";
//        this.pradcurrentacctstmt = "na";
//        this.prpropertytype = "na";
//        this.prrecidenttype = "na";


    }

    @Exclude
    public Long getCreatedDateTimeLong() {
        return createdDateTime;
    }

    public Map<String, String> getCreatedDateTime() {
        return ServerValue.TIMESTAMP;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = (Long) createdDateTime;
    }


    public String getProofadhar() {
        return proofadhar;
    }

    public void setProofadhar(String proofadhar) {
        this.proofadhar = proofadhar;
    }

    public String getProofvoterid() {
        return proofvoterid;
    }

    public void setProofvoterid(String proofvoterid) {
        this.proofvoterid = proofvoterid;
    }

    public String getProofdl() {
        return proofdl;
    }

    public void setProofdl(String proofdl) {
        this.proofdl = proofdl;
    }

    public String getProofelectricitybill() {
        return proofelectricitybill;
    }

    public void setProofelectricitybill(String proofelectricitybill) {
        this.proofelectricitybill = proofelectricitybill;
    }

    public String getProofrentagmt() {
        return proofrentagmt;
    }

    public void setProofrentagmt(String proofrentagmt) {
        this.proofrentagmt = proofrentagmt;
    }

    public String getProofpassport() {
        return proofpassport;
    }

    public void setProofpassport(String proofpassport) {
        this.proofpassport = proofpassport;
    }

    public String getProofgevtid() {
        return proofgevtid;
    }

    public void setProofgevtid(String proofgevtid) {
        this.proofgevtid = proofgevtid;
    }

    public String getProofgumasta() {
        return proofgumasta;
    }

    public void setProofgumasta(String proofgumasta) {
        this.proofgumasta = proofgumasta;
    }

    public String getProofcurrentacctstmt() {
        return proofcurrentacctstmt;
    }

    public void setProofcurrentacctstmt(String proofcurrentacctstmt) {
        this.proofcurrentacctstmt = proofcurrentacctstmt;
    }

    public String getApvoterid() {
        return apvoterid;
    }

    public void setApvoterid(String apvoterid) {
        this.apvoterid = apvoterid;
    }

    public String getApdrivinglicence() {
        return apdrivinglicence;
    }

    public void setApdrivinglicence(String apdrivinglicence) {
        this.apdrivinglicence = apdrivinglicence;
    }

    public String getAppassport() {
        return appassport;
    }

    public void setAppassport(String appassport) {
        this.appassport = appassport;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOtherEducation() {
        return otherEducation;
    }

    public void setOtherEducation(String otherEducation) {
        this.otherEducation = otherEducation;
    }

    @Exclude
    public Long getUpdatedDateTimeLong() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Long updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Map<String, String> getUpdatedDateTime() {
        return ServerValue.TIMESTAMP;
    }

    public String getofficeAdderess() {
        return officeAdderess;
    }

    public void setOfficeAdderess(String officeAdderess) {
        this.officeAdderess = officeAdderess;
    }

    public String getpropertyAddress() {
        return propertyAddress;
    }

    public String getdescription() {
        return description;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setAltmobile(String altmobile) {
        this.altmobile = altmobile;
    }

    public String getaltmobile() {
        return altmobile;
    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getadharNo() {
        return adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getincome() {
        return income;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setgst(String gst) {
        this.gst = gst;
    }

    public String getPanCardNumber() {
        return panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressYesNo() {
        return addressYesNo;
    }

    public void setAddressYesNo(String addressYesNo) {
        this.addressYesNo = addressYesNo;
    }

    public String getFlatno() {
        return flatno;
    }

    public void setFlatno(String flatno) {
        this.flatno = flatno;
    }


    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }


    public String getPropaddress() {
        return propaddress;
    }

    public void setPropaddress(String propaddress) {
        this.propaddress = propaddress;
    }


    public String getPropage() {
        return propage;
    }

    public void setPropage(String propage) {
        this.propage = propage;
    }

    public String getProparea() {
        return proparea;
    }

    public void setProparea(String proparea) {
        this.proparea = proparea;
    }

    public String getCurrentpin() {
        return currentpin;
    }

    public void setCurrentpin(String currentpin) {
        this.currentpin = currentpin;
    }

    public String getCurrentlandmark() {
        return currentlandmark;
    }

    public void setCurrentlandmark(String currentlandmark) {
        this.currentlandmark = currentlandmark;
    }

    public String getCurrentarea() {
        return currentarea;
    }

    public void setCurrentarea(String currentarea) {
        this.currentarea = currentarea;
    }

    public String getCurrentstreet() {
        return currentstreet;
    }

    public void setCurrentstreet(String currentstreet) {
        this.currentstreet = currentstreet;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }


    public String getPcity() {
        return pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }


    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }


    public String getMincome() {
        return mincome;
    }

    public void setMincome(String mincome) {
        this.mincome = mincome;
    }

    public String getYincome() {
        return yincome;
    }

    public void setYincome(String yincome) {
        this.yincome = yincome;
    }


    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExpectedLoanAmount() {
        return expectedLoanAmount;
    }

    public void setdissbussloan(String dissbussloan) {
        this.dissbussloan = dissbussloan;
    }

    public void setExpectedLoanAmount(String expectedLoanAmount) {
        this.expectedLoanAmount = expectedLoanAmount;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerImageSmall() {
        return customerImageSmall;
    }


    public void setCustomerImageSmall(String customerImageSmall) {
        this.customerImageSmall = customerImageSmall;
    }

    public String getCustomerImagelarg() {
        return customerImagelarg;
    }

    public void setCustomerImagelarg(String customerImagelarg) {
        this.customerImagelarg = customerImagelarg;
    }

    public String getLeedId() {
        return leedId;
    }

    public void setLeedId(String leedId) {
        this.leedId = leedId;
    }


    public String getLeedNumber() {
        return leedNumber;
    }

    public void setLeedNumber(String leedNumber) {
        this.leedNumber = leedNumber;
    }


    public String getPeraddress() {
        return peraddress;
    }

    public void setPeraddress(String peraddress) {
        this.peraddress = peraddress;
    }


    public String getRecidential() {
        return recidential;
    }

    public void setRecidential(String recidential) {
        this.recidential = recidential;
    }


    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }


    public String getPayout() {
        return payout;
    }

    public void setPayout(String payout) {
        this.payout = payout;
    }

    public Map<String, ImagesModel> getDocumentImages() {
        return documentImages;
    }

    public void setDocumentImages(Map<String, ImagesModel> documentImages) {
        this.documentImages = documentImages;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getApprovedLoan() {
        return approvedLoan;
    }

    public void setApprovedLoan(String approvedLoan) {
        this.approvedLoan = approvedLoan;
    }


//    public String getEmployed() {
//        return employed;
//    }
//
//    public void setEmployed(String employed) {
//        this.employed = employed;
//    }
//
//    public String getCompanytype() {
//        return companytype;
//    }
//
//    public void setCompanytype(String companytype) {
//        this.companytype = companytype;
//    }
//
//    public String getOthercompany() {
//        return othercompany;
//    }
//
//    public void setOthercompany(String othercompany) {
//        this.othercompany = othercompany;
//    }
//
//    public String getSalaytype() {
//        return salaytype;
//    }
//
//    public void setSalaytype(String salaytype) {
//        this.salaytype = salaytype;
//    }
//
//    public String getEmi() {
//        return emi;
//    }
//
//    public void setEmi(String emi) {
//        this.emi = emi;
//    }
//
//    public String getEmicar() {
//        return emicar;
//    }
//
//    public void setEmicar(String emicar) {
//        this.emicar = emicar;
//    }
//
//    public String getEmihome() {
//        return emihome;
//    }
//
//    public void setEmihome(String emihome) {
//        this.emihome = emihome;
//    }
//
//    public String getEmisociety() {
//        return emisociety;
//    }
//
//    public void setEmisociety(String emisociety) {
//        this.emisociety = emisociety;
//    }
//
//    public String getEmipersonal() {
//        return emipersonal;
//    }
//
//    public void setEmipersonal(String emipersonal) {
//        this.emipersonal = emipersonal;
//    }
//
//    public String getEmiother() {
//        return emiother;
//    }
//
//    public void setEmiother(String emiother) {
//        this.emiother = emiother;
//    }
//
//    public String getEmiOtherDetails() {
//        return emiOtherDetails;
//    }
//
//    public void setEmiOtherDetails(String emiOtherDetails) {
//        this.emiOtherDetails = emiOtherDetails;
//    }
//
//    public String getTenure() {
//        return tenure;
//    }
//
//    public void setTenure(String tenure) {
//        this.tenure = tenure;
//    }
//
//    public String getExperience() {
//        return experience;
//    }
//
//    public void setExperience(String experience) {
//        this.experience = experience;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getDesignation() {
//        return designation;
//    }
//
//    public void setDesignation(String designation) {
//        this.designation = designation;
//    }
//
//    public String getGrosssalary() {
//        return grosssalary;
//    }
//
//    public void setGrosssalary(String grosssalary) {
//        this.grosssalary = grosssalary;
//    }
//
//    public String getNetsalary() {
//        return netsalary;
//    }
//
//    public void setNetsalary(String netsalary) {
//        this.netsalary = netsalary;
//    }
//
//    public String getOvertime() {
//        return overtime;
//    }
//
//    public void setOvertime(String overtime) {
//        this.overtime = overtime;
//    }
//
//    public String getIncentive() {
//        return incentive;
//    }
//
//    public void setIncentive(String incentive) {
//        this.incentive = incentive;
//    }
//
//    public String getBonus() {
//        return bonus;
//    }
//
//    public void setBonus(String bonus) {
//        this.bonus = bonus;
//    }
//
//    public String getRentalincome() {
//        return rentalincome;
//    }
//
//    public void setRentalincome(String rentalincome) {
//        this.rentalincome = rentalincome;
//    }
//
//    public String getAnnualincome() {
//        return annualincome;
//    }
//
//    public void setAnnualincome(String annualincome) {
//        this.annualincome = annualincome;
//    }
//
//    public String getRental() {
//        return rental;
//    }
//
//    public void setRental(String rental) {
//        this.rental = rental;
//    }
//
//    public String getAggrecultureIncome() {
//        return aggrecultureIncome;
//    }
//
//    public void setAggrecultureIncome(String aggrecultureIncome) {
//        this.aggrecultureIncome = aggrecultureIncome;
//    }
//
//    public String getOtherIncome() {
//        return otherIncome;
//    }
//
//    public void setOtherIncome(String otherIncome) {
//        this.otherIncome = otherIncome;
//    }
//
//    public String getSalarysleep() {
//        return salarysleep;
//    }
//
//    public void setSalarysleep(String salarysleep) {
//        this.salarysleep = salarysleep;
//    }
//
//    public String getBankstmt() {
//        return bankstmt;
//    }
//
//    public void setBankstmt(String bankstmt) {
//        this.bankstmt = bankstmt;
//    }
//
//    public String getForm() {
//        return form;
//    }
//
//    public void setForm(String form) {
//        this.form = form;
//    }
//
//    public String getAppointmentltr() {
//        return appointmentltr;
//    }
//
//    public void setAppointmentltr(String appointmentltr) {
//        this.appointmentltr = appointmentltr;
//    }
//
//    public String getConformationltr() {
//        return conformationltr;
//    }
//
//    public void setConformationltr(String conformationltr) {
//        this.conformationltr = conformationltr;
//    }
//
//    public String getExperinceltr() {
//        return experinceltr;
//    }
//
//    public void setExperinceltr(String experinceltr) {
//        this.experinceltr = experinceltr;
//    }
//
//    public String getVisa() {
//        return visa;
//    }
//
//    public void setVisa(String visa) {
//        this.visa = visa;
//    }
//
//    public String getPassport() {
//        return passport;
//    }
//
//    public void setPassport(String passport) {
//        this.passport = passport;
//    }
//
//    public String getEmploerltr() {
//        return emploerltr;
//    }
//
//    public void setEmploerltr(String emploerltr) {
//        this.emploerltr = emploerltr;
//    }
//
//    public String getContractltr() {
//        return contractltr;
//    }
//
//    public void setContractltr(String contractltr) {
//        this.contractltr = contractltr;
//    }
//
//    public String getPoa() {
//        return poa;
//    }
//
//    public void setPoa(String poa) {
//        this.poa = poa;
//    }
//
//    public String getNrebankstmt() {
//        return nrebankstmt;
//    }
//
//    public void setNrebankstmt(String nrebankstmt) {
//        this.nrebankstmt = nrebankstmt;
//    }
//
//    public String getOverseasbankdetail() {
//        return overseasbankdetail;
//    }
//
//    public void setOverseasbankdetail(String overseasbankdetail) {
//        this.overseasbankdetail = overseasbankdetail;
//    }
//
//    public String getItr() {
//        return itr;
//    }
//
//    public void setItr(String itr) {
//        this.itr = itr;
//    }
//
//    public String getCurrentbankstmt() {
//        return currentbankstmt;
//    }
//
//    public void setCurrentbankstmt(String currentbankstmt) {
//        this.currentbankstmt = currentbankstmt;
//    }
//
//    public String getSavingacctstmt() {
//        return savingacctstmt;
//    }
//
//    public void setSavingacctstmt(String savingacctstmt) {
//        this.savingacctstmt = savingacctstmt;
//    }
//
//    public String getPartnersheepdeed() {
//        return partnersheepdeed;
//    }
//
//    public void setPartnersheepdeed(String partnersheepdeed) {
//        this.partnersheepdeed = partnersheepdeed;
//    }
//
//    public String getPrgender() {
//        return prgender;
//    }
//
//    public void setPrgender(String prgender) {
//        this.prgender = prgender;
//    }
//
//    public String getPredu() {
//        return predu;
//    }
//
//    public void setPredu(String predu) {
//        this.predu = predu;
//    }
//
//    public String getPrpropertyaddress() {
//        return prpropertyaddress;
//    }
//
//    public void setPrpropertyaddress(String prpropertyaddress) {
//        this.prpropertyaddress = prpropertyaddress;
//    }
//
//    public String getPropety() {
//        return propety;
//    }
//
//    public void setPropety(String propety) {
//        this.propety = propety;
//    }
//
//    public String getPropetyYN() {
//        return propetyYN;
//    }
//
//    public void setPropetyYN(String propetyYN) {
//        this.propetyYN = propetyYN;
//    }
//
//    public String getLoanrequirement() {
//        return loanrequirement;
//    }
//
//    public void setLoanrequirement(String loanrequirement) {
//        this.loanrequirement = loanrequirement;
//    }
//
//    public String getDownpayment() {
//        return downpayment;
//    }
//
//    public void setDownpayment(String downpayment) {
//        this.downpayment = downpayment;
//    }
//
//    public String getPrpropertypin() {
//        return prpropertypin;
//    }
//
//    public void setPrpropertypin(String prpropertypin) {
//        this.prpropertypin = prpropertypin;
//    }
//
//    public String getPrpropertylandmark() {
//        return prpropertylandmark;
//    }
//
//    public void setPrpropertylandmark(String prpropertylandmark) {
//        this.prpropertylandmark = prpropertylandmark;
//    }
//
//    public String getPrpropertyarea() {
//        return prpropertyarea;
//    }
//
//    public void setPrpropertyarea(String prpropertyarea) {
//        this.prpropertyarea = prpropertyarea;
//    }
//
//    public String getPrprojectname() {
//        return prprojectname;
//    }
//
//    public void setPrprojectname(String prprojectname) {
//        this.prprojectname = prprojectname;
//    }
//
//    public String getPrapplicantfullname() {
//        return prapplicantfullname;
//    }
//
//    public void setPrapplicantfullname(String prapplicantfullname) {
//        this.prapplicantfullname = prapplicantfullname;
//    }
//
//    public String getPrapplicantdob() {
//        return prapplicantdob;
//    }
//
//    public void setPrapplicantdob(String prapplicantdob) {
//        this.prapplicantdob = prapplicantdob;
//    }
//
//    public String getPrapplicantcontactno() {
//        return prapplicantcontactno;
//    }
//
//    public void setPrapplicantcontactno(String prapplicantcontactno) {
//        this.prapplicantcontactno = prapplicantcontactno;
//    }
//
//    public String getPrapplicantaltcontactno() {
//        return prapplicantaltcontactno;
//    }
//
//    public void setPrapplicantaltcontactno(String prapplicantaltcontactno) {
//        this.prapplicantaltcontactno = prapplicantaltcontactno;
//    }
//
//    public String getPrapplicantemail() {
//        return prapplicantemail;
//    }
//
//    public void setPrapplicantemail(String prapplicantemail) {
//        this.prapplicantemail = prapplicantemail;
//    }
//
//    public String getPrapplicantcurrentaddress() {
//        return prapplicantcurrentaddress;
//    }
//
//    public void setPrapplicantcurrentaddress(String prapplicantcurrentaddress) {
//        this.prapplicantcurrentaddress = prapplicantcurrentaddress;
//    }
//
//    public String getPrapplicantperaddress() {
//        return prapplicantperaddress;
//    }
//
//    public void setPrapplicantperaddress(String prapplicantperaddress) {
//        this.prapplicantperaddress = prapplicantperaddress;
//    }
//
//    public String getPraplicantoffceaddress() {
//        return praplicantoffceaddress;
//    }
//
//    public void setPraplicantoffceaddress(String praplicantoffceaddress) {
//        this.praplicantoffceaddress = praplicantoffceaddress;
//    }

    public String getPrreference1name() {
        return prreference1name;
    }

    public void setPrreference1name(String prreference1name) {
        this.prreference1name = prreference1name;
    }

    public String getPrreference1address() {
        return prreference1address;
    }

    public void setPrreference1address(String prreference1address) {
        this.prreference1address = prreference1address;
    }

    public String getPrreferencecontactno() {
        return prreferencecontactno;
    }

    public void setPrreferencecontactno(String prreferencecontactno) {
        this.prreferencecontactno = prreferencecontactno;
    }

    public String getPrreferencerelationship() {
        return prreferencerelationship;
    }

    public void setPrreferencerelationship(String prreferencerelationship) {
        this.prreferencerelationship = prreferencerelationship;
    }

    public String getPrreference2name() {
        return prreference2name;
    }

    public void setPrreference2name(String prreference2name) {
        this.prreference2name = prreference2name;
    }

    public String getPrreference2address() {
        return prreference2address;
    }

    public void setPrreference2address(String prreference2address) {
        this.prreference2address = prreference2address;
    }

    public String getPrreference2contactno() {
        return prreference2contactno;
    }

    public void setPrreference2contactno(String prreference2contactno) {
        this.prreference2contactno = prreference2contactno;
    }

    public String getPrreference2relationship() {
        return prreference2relationship;
    }

    public void setPrreference2relationship(String prreference2relationship) {
        this.prreference2relationship = prreference2relationship;
    }

//    public String getPrAPadhar() {
//        return prAPadhar;
//    }
//
//    public void setPrAPadhar(String prAPadhar) {
//        this.prAPadhar = prAPadhar;
//    }
//
//    public String getPrAapan() {
//        return prAapan;
//    }
//
//    public void setPrAapan(String prAapan) {
//        this.prAapan = prAapan;
//    }
//
//    public String getPrAapvoterid() {
//        return prAapvoterid;
//    }
//
//    public void setPrAapvoterid(String prAapvoterid) {
//        this.prAapvoterid = prAapvoterid;
//    }
//
//    public String getPrAapdl() {
//        return prAapdl;
//    }
//
//    public void setPrAapdl(String prAapdl) {
//        this.prAapdl = prAapdl;
//    }
//
//    public String getPrAappassport() {
//        return prAappassport;
//    }
//
//    public void setPrAappassport(String prAappassport) {
//        this.prAappassport = prAappassport;
//    }
//
//    public String getPradadhar() {
//        return pradadhar;
//    }
//
//    public void setPradadhar(String pradadhar) {
//        this.pradadhar = pradadhar;
//    }
//
//    public String getPradvoterid() {
//        return pradvoterid;
//    }
//
//    public void setPradvoterid(String pradvoterid) {
//        this.pradvoterid = pradvoterid;
//    }
//
//    public String getPraddl() {
//        return praddl;
//    }
//
//    public void setPraddl(String praddl) {
//        this.praddl = praddl;
//    }
//
//    public String getPradelectricity() {
//        return pradelectricity;
//    }
//
//    public void setPradelectricity(String pradelectricity) {
//        this.pradelectricity = pradelectricity;
//    }
//
//    public String getPradpassport() {
//        return pradpassport;
//    }
//
//    public void setPradpassport(String pradpassport) {
//        this.pradpassport = pradpassport;
//    }
//
//    public String getPradrentagmt() {
//        return pradrentagmt;
//    }
//
//    public void setPradrentagmt(String pradrentagmt) {
//        this.pradrentagmt = pradrentagmt;
//    }
//
//    public String getPradgovtid() {
//        return pradgovtid;
//    }
//
//    public void setPradgovtid(String pradgovtid) {
//        this.pradgovtid = pradgovtid;
//    }
//
//    public String getPradgumasta() {
//        return pradgumasta;
//    }
//
//    public void setPradgumasta(String pradgumasta) {
//        this.pradgumasta = pradgumasta;
//    }
//
//    public String getPradcurrentacctstmt() {
//        return pradcurrentacctstmt;
//    }
//
//    public void setPradcurrentacctstmt(String pradcurrentacctstmt) {
//        this.pradcurrentacctstmt = pradcurrentacctstmt;
//    }
//
//    public String getPrpropertytype() {
//        return prpropertytype;
//    }
//
//    public void setPrpropertytype(String prpropertytype) {
//        this.prpropertytype = prpropertytype;
//    }
//
//    public String getPrrecidenttype() {
//        return prrecidenttype;
//    }
//
//    public void setPrrecidenttype(String prrecidenttype) {
//        this.prrecidenttype = prrecidenttype;
//    }

    public String getCoApplicantYN() {
        return coApplicantYN;
    }

    public void setCoApplicantYN(String coApplicantYN) {
        this.coApplicantYN = coApplicantYN;
    }

    public String getPrapplicantrelation() {
        return prapplicantrelation;
    }

    public void setPrapplicantrelation(String prapplicantrelation) {
        this.prapplicantrelation = prapplicantrelation;
    }

    public String getCoapplicantotherrelation() {
        return coapplicantotherrelation;
    }

    public void setCoapplicantotherrelation(String coapplicantotherrelation) {
        this.coapplicantotherrelation = coapplicantotherrelation;
    }

//    public String getBusinessagmt() {
//        return businessagmt;
//    }
//
//    public void setBusinessagmt(String businessagmt) {
//        this.businessagmt = businessagmt;
//    }
//
//    public String getQualification() {
//        return qualification;
//    }
//
//    public void setQualification(String qualification) {
//        this.qualification = qualification;
//    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    public static ArrayList<LeedsModelCo> getLeeds() {
        ArrayList<LeedsModelCo> leedsModelArrayList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            LeedsModelCo leedsModel = new LeedsModelCo(i);
            leedsModelArrayList.add(leedsModel);
        }
        return leedsModelArrayList;
    }

    public String getChannelPartner() {
        return channelPartner;
    }

    public void setChannelPartner(String channelPartner) {
        this.channelPartner = channelPartner;
    }

    @Exclude
    public Map getLeedStatusMap() {
        Map<String, Object> leedMap = new HashMap<>();
        //leedMap.put("status", getStatus());
        leedMap.put("updatedDateTime", getUpdatedDateTime());
        leedMap.put("customerName", getCustomerName());
        leedMap.put("address", getAddress());
        leedMap.put("agentId", getAgentId());
        leedMap.put("loanType", getLoanType());
        leedMap.put("mobileNumber", getMobileNumber());
        leedMap.put("panCardNumber", getPanCardNumber());
        leedMap.put("bankName", getBankName());
        leedMap.put("officeAdderess", getofficeAdderess());
        leedMap.put("propertyAddress", getpropertyAddress());
        leedMap.put("description", getdescription());
        leedMap.put("altmobile", getaltmobile());
        leedMap.put("adharNo", getadharNo());
        leedMap.put("ExpectedLoanAmount", getExpectedLoanAmount());
        leedMap.put("parents", getParents());
        leedMap.put("recidential", getRecidential());
        leedMap.put("peraddress", getPeraddress());
        leedMap.put("mincome", getMincome());
        leedMap.put("yincome", getYincome());
        leedMap.put("flatno", getFlatno());
        leedMap.put("projectname", getProjectname());
        leedMap.put("propage", getPropage());
        leedMap.put("proparea", getProparea());
        leedMap.put("pincode", getPincode());
        leedMap.put("pcity", getPcity());
        leedMap.put("pstate", getPstate());
        leedMap.put("propaddress", getPropaddress());
        leedMap.put("channelPartner", getChannelPartner());
        leedMap.put("education", getEducation());
        leedMap.put("landmark", getLandmark());
        leedMap.put("area", getArea());
        leedMap.put("street", getStreet());
        leedMap.put("addressYesNo",getAddressYesNo());
        leedMap.put("email", getEmail());
        leedMap.put("gender", getGender());
        leedMap.put("dateOfBirth", getDateOfBirth());
        leedMap.put("otherEducation", getOtherEducation());

        leedMap.put("currentpin", getCurrentpin());
        leedMap.put("currentlandmark", getCurrentlandmark());
        leedMap.put("currentarea", getCurrentarea());
        leedMap.put("currentstreet", getCurrentstreet());

        leedMap.put("coApplicantYN",getCoApplicantYN());
        leedMap.put("prapplicantrelation", getPrapplicantrelation());
        leedMap.put("coapplicantotherrelation", getCoapplicantotherrelation());
        leedMap.put("prreference1name", getPrreference1name());
        leedMap.put("prreference1address", getPrreference1address());
        leedMap.put("prreferencecontactno", getPrreferencecontactno());
        leedMap.put("prreferencerelationship", getPrreferencerelationship());
        leedMap.put("prreference2name", getPrreference2name());
        leedMap.put("prreference2address", getPrreference2address());
        leedMap.put("prreference2contactno", getPrreference2contactno());
        leedMap.put("prreference2relationship", getPrreference2relationship());
        leedMap.put("leedNumber",getLeedNumber());

//        leedMap.put("employed", getEmployed());
//        leedMap.put("companytype", getCompanytype());
//        leedMap.put("othercompany", getOthercompany());
//        leedMap.put("salaytype", getSalaytype());
//        leedMap.put("emi", getEmi());
//        leedMap.put("emicar", getEmicar());
//        leedMap.put("emihome", getEmihome());
//        leedMap.put("emisociety", getEmisociety());
//        leedMap.put("emipersonal", getEmipersonal());
//        leedMap.put("emiother", getEmiother());
//        leedMap.put("emiOtherDetails", getEmiOtherDetails());
//
//        leedMap.put("tenure", getTenure());
//        leedMap.put("experience", getExperience());
//        leedMap.put("department", getDepartment());
//        leedMap.put("designation", getDesignation());
//        leedMap.put("grosssalary", getGrosssalary());
//        leedMap.put("netsalary", getNetsalary());
//        leedMap.put("overtime", getOvertime());
//        leedMap.put("incentive", getIncentive());
//        leedMap.put("bonus", getBonus());
//        leedMap.put("rentalincome", getRentalincome());
//        leedMap.put("annualincome", getAnnualincome());
//        leedMap.put("rental", getRental());
//        leedMap.put("salarysleep", getSalarysleep());
//        leedMap.put("bankstmt", getBankstmt());
//        leedMap.put("form", getForm());
//        leedMap.put("appointmentltr", getAppointmentltr());
//        leedMap.put("conformationltr", getConformationltr());
//        leedMap.put("experinceltr", getExperinceltr());
//        leedMap.put("visa", getVisa());
//        leedMap.put("passport", getPassport());
//        leedMap.put("emploerltr", getEmploerltr());
//        leedMap.put("contractltr", getContractltr());
//        leedMap.put("poa", getPoa());
//        leedMap.put("nrebankstmt", getNrebankstmt());
//        leedMap.put("overseasbankdetail", getOverseasbankdetail());
//        leedMap.put("itr", getItr());
//        leedMap.put("currentbankstmt", getCurrentbankstmt());
//        leedMap.put("savingacctstmt", getSavingacctstmt());
//        leedMap.put("partnersheepdeed", getPartnersheepdeed());
//        leedMap.put("businessagmt", getBusinessagmt());
//        leedMap.put("qualification", getQualification());
//        leedMap.put("aggrecultureIncome", getAggrecultureIncome());
//        leedMap.put("otherIncome", getOtherIncome());
//
//        leedMap.put("prgender", getPrgender());
//        leedMap.put("predu", getPredu());
//        leedMap.put("prpropertyaddress", getPrpropertyaddress());
//        leedMap.put("prpropertypin", getPrpropertypin());
//        leedMap.put("prpropertylandmark", getPrpropertylandmark());
//        leedMap.put("prpropertyarea", getPrpropertyarea());
//        leedMap.put("prprojectname", getPrprojectname());
//        leedMap.put("prapplicantfullname", getPrapplicantfullname());
//        leedMap.put("prapplicantdob", getPrapplicantdob());
//        leedMap.put("prapplicantcontactno", getPrapplicantcontactno());
//        leedMap.put("prapplicantaltcontactno", getPrapplicantaltcontactno());
//        leedMap.put("prapplicantemail", getPrapplicantemail());
//        leedMap.put("prapplicantcurrentaddress", getPrapplicantcurrentaddress());
//        leedMap.put("prapplicantperaddress", getPrapplicantperaddress());
//        leedMap.put("praplicantoffceaddress", getPraplicantoffceaddress());
//
//        leedMap.put("prAPadhar", getPrAPadhar());
//        leedMap.put("prAapan", getPrAapan());
//        leedMap.put("prAapvoterid", getPrAapvoterid());
//        leedMap.put("prAapdl", getPrAapdl());
//        leedMap.put("prAappassport", getPrAappassport());
//        leedMap.put("pradadhar", getPradadhar());
//        leedMap.put("pradvoterid", getPradvoterid());
//        leedMap.put("praddl", getPraddl());
//        leedMap.put("pradelectricity", getPradelectricity());
//        leedMap.put("pradpassport", getPradpassport());
//        leedMap.put("pradrentagmt", getPradrentagmt());
//        leedMap.put("pradgovtid", getPradgovtid());
//        leedMap.put("pradgumasta", getPradgumasta());
//        leedMap.put("pradcurrentacctstmt", getPradcurrentacctstmt());
//        leedMap.put("prpropertytype", getPrpropertytype());
//        leedMap.put("prrecidenttype", getPrrecidenttype());
//
//
//        leedMap.put("propety",getPropety());
//        leedMap.put("propetyYN",getPropetyYN());
//        leedMap.put("loanrequirement",getLoanrequirement());
//        leedMap.put("downpayment",getDownpayment());

        leedMap.put("apvoterid", getApvoterid());
        leedMap.put("apdrivinglicence", getApdrivinglicence());
        leedMap.put("appassport", getAppassport());

        leedMap.put("proofadhar", getProofadhar());
        leedMap.put("proofvoterid", getProofvoterid());
        leedMap.put("proofdl", getProofdl());
        leedMap.put("proofelectricitybill", getProofelectricitybill());
        leedMap.put("proofrentagmt", getProofrentagmt());
        leedMap.put("proofpassport", getProofpassport());
        leedMap.put("proofgevtid", getProofgevtid());
        leedMap.put("proofgumasta", getProofgumasta());
        leedMap.put("proofcurrentacctstmt", getProofcurrentacctstmt());

        return leedMap;
    }

    @Exclude
    public Map getLeedStatusMap1() {
        Map<String, Object> leedMap = new HashMap<>();
        leedMap.put("status", getStatus());
        leedMap.put("updatedDateTime", getUpdatedDateTime());

        return leedMap;
    }
}
