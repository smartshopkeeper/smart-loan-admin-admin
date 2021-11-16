package com.smartloan.smtrick.smart_loan_admin_new.models;


import android.view.View.OnClickListener;


import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LeedsModel implements Serializable {
    private String address;
    private String addressYesNo;
    private String adharNo;
    private String agentId;
    private String agentName;
    private String aggrecultureIncome;
    private String alternetMobileNumber;
    private String annualincome;
    private String apdrivinglicence;
    private String appassport;
    private String appointmentltr;
    private String approvedLoan;
    private String apvoterid;
    private String area;
    private String bankName;
    private String bankstmt;
    private String bonus;
    private String businessagmt;
    private String carLoanAmount;
    private String channelPartner;
    private String checkpanCardNumber;
    private String coApplicantYN;
    private String coapplicantotherrelation;
    private String companytype;
    private String conformationltr;
    private String contractltr;
    private String createdBy;
    private Long createdDateTime;
    private String currentarea;
    private String currentbankstmt;
    private String currentlandmark;
    private String currentpin;
    private String currentstreet;
    private String customerImageSmall;
    private String customerImagelarg;
    private String customerName;
    private String dateOfBirth;
    private String department;
    private String description;
    private String designation;
    private String dissbussloan;
    private Map<String, ImagesModel> documentImages;
    private String downpayment;
    private String education;
    private String email;
    private String emi;
    private String emiOtherDetails;
    private String emicar;
    private String emihome;
    private String emiother;
    private String emipersonal;
    private String emisociety;
    private String emploerltr;
    private String employed;
    private String expectedLoanAmount;
    private String disbusedLoanAmount;
    private String pendingLoanAmount;
    private String experience;
    private String experiencemonths;
    private String experinceltr;
    private String flatno;
    private String form;
    private String gender;
    private String grosssalary;
    private String gst;
    private String homeLoanAmount;
    private String incentive;
    private String income;
    private String itr;
    private String landmark;
    private String leedId;
    private String leedNumber;
    private String loanType;
    private String loanrequirement;
    private String mincome;
    private String mobileNumber;
    private String netsalary;
    private String nrebankstmt;
    private String occupation;
    private String officeAdderess;
    private String otherEducation;
    private String otherIncome;
    private String othercompany;
    private String overseasbankdetail;
    private String overtime;
    private String panCardNumber;
    private String partnersheepdeed;
    private String passport;
    private String payout;
    private String pcity;
    private String peraddress;
    private String personalLoanAmount;
    private String pincode;
    private String poa;
    private String prAPadhar;
    private String prAapan;
    private String prAapdl;
    private String prAappassport;
    private String prAapvoterid;
    private String pradadhar;
    private String pradcurrentacctstmt;
    private String praddl;
    private String pradelectricity;
    private String pradgovtid;
    private String pradgumasta;
    private String pradpassport;
    private String pradrentagmt;
    private String pradvoterid;
    private String praplicantoffceaddress;
    private String prapplicantaltcontactno;
    private String prapplicantcontactno;
    private String prapplicantcurrentaddress;
    private String prapplicantdob;
    private String prapplicantemail;
    private String prapplicantfullname;
    private String prapplicantperaddress;
    private String prapplicantrelation;
    private String prdescripiton;
    private String predu;
    private String prgender;
    private String projectname;
    private String proofadhar;
    private String proofcurrentacctstmt;
    private String proofdl;
    private String proofelectricitybill;
    private String proofgevtid;
    private String proofgumasta;
    private String proofpassport;
    private String proofrentagmt;
    private String proofvoterid;
    private String propaddress;
    private String propage;
    private String proparea;
    private String propertyAddress;
    private String propety;
    private String propetyYN;
    private String prprojectname;
    private String prpropertyaddress;
    private String prpropertyarea;
    private String prpropertylandmark;
    private String prpropertypin;
    private String prpropertytype;
    private String prrecidenttype;
    private String prreference1address;
    private String prreference1name;
    private String prreference2address;
    private String prreference2contactno;
    private String prreference2name;
    private String prreference2relationship;
    private String prreferencecontactno;
    private String prreferencerelationship;
    private String pstate;
    private String qualification;
    private String recidential;
    private String rental;
    private String rentalincome;
    private OnClickListener requestBtnClickListener;
    private String salarysleep;
    private String salaytype;
    private String savingacctstmt;
    private String societyLoanAmount;
    private String status;
    private String street;
    private String tenure;
    private String tenuremonth;
    private Long updatedDateTime;
    private Long disbussmentDateTime;
    private String visa;
    private String yincome;

    private String banknName;
    private String branchName;
    private String ifscCode;
    private String appointment;
    private String rescheduledappointment;
    private String appointreschedualreason;
    private String loginid;
    private String salesPerson;
    private String rejectionReason;
    private String comissionamount;
    private String disbussmentDate;

    private String homeLoanType;
    private String balanceTransferLoanType;

    private String callingStatus;
    private String callingStatusReason;

    private ArrayList<String> checklist;
    private ArrayList<String> checklistCollected;
    private ArrayList<String> checklistCollectedimages;

    public LeedsModel(int id) {

        this.bankName = "bank";
        this.branchName = "branch";
        this.ifscCode = "ifsc";
        this.appointment = "appointment";
        this.rescheduledappointment = "rescheduledappointment";
        this.appointreschedualreason = "appointreschedualreason";
        this.loginid = "loginid";
        this.salesPerson = "sales";

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
        this.recidential = "84121211";
        this.peraddress = "Pune";
        this.customerName = "Prateek Patel";
        this.mobileNumber = "84121211";
        this.address = "Pune";
        this.gender = Constant.MALE;
        this.agentId = "Ag-56465";
        this.loanType = "Home Loan";
        this.panCardNumber = "jds45";
        this.checkpanCardNumber = "31564";
        this.email = "kjsdj@jhjdf.sdf";
        this.expectedLoanAmount = "2565656";
        this.disbusedLoanAmount = "1234567";
        this.pendingLoanAmount = "1234567";
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
        this.alternetMobileNumber = "na";
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
        this.employed = "na";
        this.companytype = "na";
        this.othercompany = "na";
        this.salaytype = "na";
        this.emi = "na";
        this.emicar = "na";
        this.emihome = "na";
        this.emisociety = "na";
        this.emipersonal = "na";
        this.emiother = "na";
        this.emiOtherDetails = "na";
        this.tenure = "na";
        this.tenuremonth = "na";
        this.experience = "na";
        this.experiencemonths = "na";
        this.department = "na";
        this.designation = "na";
        this.grosssalary = "na";
        this.netsalary = "na";
        this.overtime = "na";
        this.incentive = "na";
        this.bonus = "na";
        this.rentalincome = "na";
        this.annualincome = "na";
        this.rental = "na";
        this.salarysleep = "na";
        this.bankstmt = "na";
        this.form = "na";
        this.appointmentltr = "na";
        this.conformationltr = "na";
        this.experinceltr = "na";
        this.visa = "na";
        this.passport = "na";
        this.emploerltr = "na";
        this.contractltr = "na";
        this.poa = "na";
        this.nrebankstmt = "na";
        this.overseasbankdetail = "na";
        this.itr = "na";
        this.currentbankstmt = "na";
        this.savingacctstmt = "na";
        this.partnersheepdeed = "na";
        this.businessagmt = "na";
        this.qualification = "na";
        this.aggrecultureIncome = "na";
        this.otherIncome = "na";
        this.carLoanAmount = "na";
        this.homeLoanAmount = "na";
        this.societyLoanAmount = "na";
        this.personalLoanAmount = "na";
        this.prgender = "na";
        this.predu = "na";
        this.prpropertyaddress = "na";
        this.prpropertypin = "na";
        this.prpropertylandmark = "na";
        this.prpropertyarea = "na";
        this.prprojectname = "na";
        this.prapplicantfullname = "na";
        this.prapplicantdob = "na";
        this.prapplicantcontactno = "na";
        this.prapplicantaltcontactno = "na";
        this.prapplicantemail = "na";
        this.prapplicantcurrentaddress = "na";
        this.prapplicantperaddress = "na";
        this.praplicantoffceaddress = "na";
        this.prAPadhar = "na";
        this.prAapan = "na";
        this.prAapvoterid = "na";
        this.prAapdl = "na";
        this.prAappassport = "na";
        this.pradadhar = "na";
        this.pradvoterid = "na";
        this.praddl = "na";
        this.pradelectricity = "na";
        this.pradpassport = "na";
        this.pradrentagmt = "na";
        this.pradgovtid = "na";
        this.pradgumasta = "na";
        this.pradcurrentacctstmt = "na";
        this.prpropertytype = "na";
        this.prrecidenttype = "na";
        this.prdescripiton = "na";
        this.rejectionReason = "na";
        this.comissionamount = "na";
        this.disbussmentDate = "na";

        this.homeLoanType = "na";
        this.balanceTransferLoanType = "na";

        this.callingStatus = "callingStatus";
        this.callingStatusReason = "callingStatusReason";

        this.checklist = new ArrayList<String>();
        this.checklistCollected = new ArrayList<String>();
        this.checklistCollectedimages = new ArrayList<String>();
    }

    public LeedsModel() {

    }

    @Exclude
    public Long getCreatedDateTimeLong() {
        return this.createdDateTime;
    }

    public Map<String, String> getCreatedDateTime() {
        return ServerValue.TIMESTAMP;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getBanknName() {
        return banknName;
    }

    public void setBanknName(String banknName) {
        this.banknName = banknName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getRescheduledappointment() {
        return rescheduledappointment;
    }

    public void setRescheduledappointment(String rescheduledappointment) {
        this.rescheduledappointment = rescheduledappointment;
    }

    public String getAppointreschedualreason() {
        return appointreschedualreason;
    }

    public void setAppointreschedualreason(String appointreschedualreason) {
        this.appointreschedualreason = appointreschedualreason;
    }

    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public String getSalesPerson() {
        return salesPerson;
    }

    public void setSalesPerson(String salesPerson) {
        this.salesPerson = salesPerson;
    }

    public String getProofadhar() {
        return this.proofadhar;
    }

    public void setProofadhar(String proofadhar) {
        this.proofadhar = proofadhar;
    }

    public String getProofvoterid() {
        return this.proofvoterid;
    }

    public void setProofvoterid(String proofvoterid) {
        this.proofvoterid = proofvoterid;
    }

    public String getProofdl() {
        return this.proofdl;
    }

    public void setProofdl(String proofdl) {
        this.proofdl = proofdl;
    }

    public String getProofelectricitybill() {
        return this.proofelectricitybill;
    }

    public void setProofelectricitybill(String proofelectricitybill) {
        this.proofelectricitybill = proofelectricitybill;
    }

    public String getProofrentagmt() {
        return this.proofrentagmt;
    }

    public void setProofrentagmt(String proofrentagmt) {
        this.proofrentagmt = proofrentagmt;
    }

    public String getProofpassport() {
        return this.proofpassport;
    }

    public void setProofpassport(String proofpassport) {
        this.proofpassport = proofpassport;
    }

    public String getProofgevtid() {
        return this.proofgevtid;
    }

    public void setProofgevtid(String proofgevtid) {
        this.proofgevtid = proofgevtid;
    }

    public String getProofgumasta() {
        return this.proofgumasta;
    }

    public void setProofgumasta(String proofgumasta) {
        this.proofgumasta = proofgumasta;
    }

    public String getProofcurrentacctstmt() {
        return this.proofcurrentacctstmt;
    }

    public void setProofcurrentacctstmt(String proofcurrentacctstmt) {
        this.proofcurrentacctstmt = proofcurrentacctstmt;
    }

    public String getApvoterid() {
        return this.apvoterid;
    }

    public void setApvoterid(String apvoterid) {
        this.apvoterid = apvoterid;
    }

    public String getApdrivinglicence() {
        return this.apdrivinglicence;
    }

    public void setApdrivinglicence(String apdrivinglicence) {
        this.apdrivinglicence = apdrivinglicence;
    }

    public String getAppassport() {
        return this.appassport;
    }

    public void setAppassport(String appassport) {
        this.appassport = appassport;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getOtherEducation() {
        return this.otherEducation;
    }

    public void setOtherEducation(String otherEducation) {
        this.otherEducation = otherEducation;
    }

    @Exclude
    public Long getUpdatedDateTimeLong() {
        return this.updatedDateTime;
    }

    public void setUpdatedDateTime(Long updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Map<String, String> getUpdatedDateTime() {
        return ServerValue.TIMESTAMP;
    }

    public String getofficeAdderess() {
        return this.officeAdderess;
    }

    public void setOfficeAdderess(String officeAdderess) {
        this.officeAdderess = officeAdderess;
    }

    public String getpropertyAddress() {
        return this.propertyAddress;
    }

    public String getdescription() {
        return this.description;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public String getAlternetMobileNumber() {
        return this.alternetMobileNumber;
    }

    public void setAlternetMobileNumber(String alternetMobileNumber) {
        this.alternetMobileNumber = alternetMobileNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAgentId() {
        return this.agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getadharNo() {
        return this.adharNo;
    }

    public void setAdharNo(String adharNo) {
        this.adharNo = adharNo;
    }

    public String getLandmark() {
        return this.landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getincome() {
        return this.income;
    }

    public String getLoanType() {
        return this.loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setgst(String gst) {
        this.gst = gst;
    }

    public String getPanCardNumber() {
        return this.panCardNumber;
    }

    public void setPanCardNumber(String panCardNumber) {
        this.panCardNumber = panCardNumber;
    }

    public String getCheckpanCardNumber() {
        return this.checkpanCardNumber;
    }

    public void setCheckpanCardNumber(String checkpanCardNumber) {
        this.checkpanCardNumber = checkpanCardNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddressYesNo() {
        return this.addressYesNo;
    }

    public void setAddressYesNo(String addressYesNo) {
        this.addressYesNo = addressYesNo;
    }

    public String getFlatno() {
        return this.flatno;
    }

    public void setFlatno(String flatno) {
        this.flatno = flatno;
    }

    public String getProjectname() {
        return this.projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getPropaddress() {
        return this.propaddress;
    }

    public void setPropaddress(String propaddress) {
        this.propaddress = propaddress;
    }

    public String getPropage() {
        return this.propage;
    }

    public void setPropage(String propage) {
        this.propage = propage;
    }

    public String getProparea() {
        return this.proparea;
    }

    public void setProparea(String proparea) {
        this.proparea = proparea;
    }

    public String getCurrentpin() {
        return this.currentpin;
    }

    public void setCurrentpin(String currentpin) {
        this.currentpin = currentpin;
    }

    public String getCurrentlandmark() {
        return this.currentlandmark;
    }

    public void setCurrentlandmark(String currentlandmark) {
        this.currentlandmark = currentlandmark;
    }

    public String getCurrentarea() {
        return this.currentarea;
    }

    public void setCurrentarea(String currentarea) {
        this.currentarea = currentarea;
    }

    public String getCurrentstreet() {
        return this.currentstreet;
    }

    public void setCurrentstreet(String currentstreet) {
        this.currentstreet = currentstreet;
    }

    public String getPincode() {
        return this.pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getPcity() {
        return this.pcity;
    }

    public void setPcity(String pcity) {
        this.pcity = pcity;
    }

    public String getPstate() {
        return this.pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getMincome() {
        return this.mincome;
    }

    public void setMincome(String mincome) {
        this.mincome = mincome;
    }

    public String getYincome() {
        return this.yincome;
    }

    public void setYincome(String yincome) {
        this.yincome = yincome;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setdissbussloan(String dissbussloan) {
        this.dissbussloan = dissbussloan;
    }

    public String getOccupation() {
        return this.occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAgentName() {
        return this.agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomerImageSmall() {
        return this.customerImageSmall;
    }

    public void setCustomerImageSmall(String customerImageSmall) {
        this.customerImageSmall = customerImageSmall;
    }

    public String getCustomerImagelarg() {
        return this.customerImagelarg;
    }

    public void setCustomerImagelarg(String customerImagelarg) {
        this.customerImagelarg = customerImagelarg;
    }

    public String getLeedId() {
        return this.leedId;
    }

    public void setLeedId(String leedId) {
        this.leedId = leedId;
    }

    public String getLeedNumber() {
        return this.leedNumber;
    }

    public void setLeedNumber(String leedNumber) {
        this.leedNumber = leedNumber;
    }

    public String getPeraddress() {
        return this.peraddress;
    }

    public void setPeraddress(String peraddress) {
        this.peraddress = peraddress;
    }

    public String getRecidential() {
        return this.recidential;
    }

    public void setRecidential(String recidential) {
        this.recidential = recidential;
    }

    public String getExpectedLoanAmount() {
        return this.expectedLoanAmount;
    }

    public void setExpectedLoanAmount(String expectedLoanAmount) {
        this.expectedLoanAmount = expectedLoanAmount;
    }

    public String getDisbusedLoanAmount() {
        return disbusedLoanAmount;
    }

    public void setDisbusedLoanAmount(String disbusedLoanAmount) {
        this.disbusedLoanAmount = disbusedLoanAmount;
    }

    public String getPendingLoanAmount() {
        return pendingLoanAmount;
    }

    public void setPendingLoanAmount(String pendingLoanAmount) {
        this.pendingLoanAmount = pendingLoanAmount;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getPayout() {
        return this.payout;
    }

    public void setPayout(String payout) {
        this.payout = payout;
    }

    public Map<String, ImagesModel> getDocumentImages() {
        return this.documentImages;
    }

    public void setDocumentImages(Map<String, ImagesModel> documentImages) {
        this.documentImages = documentImages;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getApprovedLoan() {
        return this.approvedLoan;
    }

    public void setApprovedLoan(String approvedLoan) {
        this.approvedLoan = approvedLoan;
    }

    public String getEmployed() {
        return this.employed;
    }

    public void setEmployed(String employed) {
        this.employed = employed;
    }

    public String getCompanytype() {
        return this.companytype;
    }

    public void setCompanytype(String companytype) {
        this.companytype = companytype;
    }

    public String getOthercompany() {
        return this.othercompany;
    }

    public void setOthercompany(String othercompany) {
        this.othercompany = othercompany;
    }

    public String getSalaytype() {
        return this.salaytype;
    }

    public void setSalaytype(String salaytype) {
        this.salaytype = salaytype;
    }

    public String getEmi() {
        return this.emi;
    }

    public void setEmi(String emi) {
        this.emi = emi;
    }

    public String getEmicar() {
        return this.emicar;
    }

    public void setEmicar(String emicar) {
        this.emicar = emicar;
    }

    public String getEmihome() {
        return this.emihome;
    }

    public void setEmihome(String emihome) {
        this.emihome = emihome;
    }

    public String getEmisociety() {
        return this.emisociety;
    }

    public void setEmisociety(String emisociety) {
        this.emisociety = emisociety;
    }

    public String getEmipersonal() {
        return this.emipersonal;
    }

    public void setEmipersonal(String emipersonal) {
        this.emipersonal = emipersonal;
    }

    public String getEmiother() {
        return this.emiother;
    }

    public void setEmiother(String emiother) {
        this.emiother = emiother;
    }

    public String getEmiOtherDetails() {
        return this.emiOtherDetails;
    }

    public void setEmiOtherDetails(String emiOtherDetails) {
        this.emiOtherDetails = emiOtherDetails;
    }

    public String getTenure() {
        return this.tenure;
    }

    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getTenuremonth() {
        return tenuremonth;
    }

    public void setTenuremonth(String tenuremonth) {
        this.tenuremonth = tenuremonth;
    }

    public String getExperience() {
        return this.experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExperiencemonths() {
        return experiencemonths;
    }

    public void setExperiencemonths(String experiencemonths) {
        this.experiencemonths = experiencemonths;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return this.designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getGrosssalary() {
        return this.grosssalary;
    }

    public void setGrosssalary(String grosssalary) {
        this.grosssalary = grosssalary;
    }

    public String getNetsalary() {
        return this.netsalary;
    }

    public void setNetsalary(String netsalary) {
        this.netsalary = netsalary;
    }

    public String getOvertime() {
        return this.overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getIncentive() {
        return this.incentive;
    }

    public void setIncentive(String incentive) {
        this.incentive = incentive;
    }

    public String getBonus() {
        return this.bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getRentalincome() {
        return this.rentalincome;
    }

    public void setRentalincome(String rentalincome) {
        this.rentalincome = rentalincome;
    }

    public String getAnnualincome() {
        return this.annualincome;
    }

    public void setAnnualincome(String annualincome) {
        this.annualincome = annualincome;
    }

    public String getRental() {
        return this.rental;
    }

    public void setRental(String rental) {
        this.rental = rental;
    }

    public String getAggrecultureIncome() {
        return this.aggrecultureIncome;
    }

    public void setAggrecultureIncome(String aggrecultureIncome) {
        this.aggrecultureIncome = aggrecultureIncome;
    }

    public String getOtherIncome() {
        return this.otherIncome;
    }

    public void setOtherIncome(String otherIncome) {
        this.otherIncome = otherIncome;
    }

    public String getSalarysleep() {
        return this.salarysleep;
    }

    public void setSalarysleep(String salarysleep) {
        this.salarysleep = salarysleep;
    }

    public String getBankstmt() {
        return this.bankstmt;
    }

    public void setBankstmt(String bankstmt) {
        this.bankstmt = bankstmt;
    }

    public String getForm() {
        return this.form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getAppointmentltr() {
        return this.appointmentltr;
    }

    public void setAppointmentltr(String appointmentltr) {
        this.appointmentltr = appointmentltr;
    }

    public String getConformationltr() {
        return this.conformationltr;
    }

    public void setConformationltr(String conformationltr) {
        this.conformationltr = conformationltr;
    }

    public String getExperinceltr() {
        return this.experinceltr;
    }

    public void setExperinceltr(String experinceltr) {
        this.experinceltr = experinceltr;
    }

    public String getVisa() {
        return this.visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }

    public String getPassport() {
        return this.passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmploerltr() {
        return this.emploerltr;
    }

    public void setEmploerltr(String emploerltr) {
        this.emploerltr = emploerltr;
    }

    public String getContractltr() {
        return this.contractltr;
    }

    public void setContractltr(String contractltr) {
        this.contractltr = contractltr;
    }

    public String getPoa() {
        return this.poa;
    }

    public void setPoa(String poa) {
        this.poa = poa;
    }

    public String getNrebankstmt() {
        return this.nrebankstmt;
    }

    public void setNrebankstmt(String nrebankstmt) {
        this.nrebankstmt = nrebankstmt;
    }

    public String getOverseasbankdetail() {
        return this.overseasbankdetail;
    }

    public void setOverseasbankdetail(String overseasbankdetail) {
        this.overseasbankdetail = overseasbankdetail;
    }

    public String getItr() {
        return this.itr;
    }

    public void setItr(String itr) {
        this.itr = itr;
    }

    public String getCurrentbankstmt() {
        return this.currentbankstmt;
    }

    public void setCurrentbankstmt(String currentbankstmt) {
        this.currentbankstmt = currentbankstmt;
    }

    public String getSavingacctstmt() {
        return this.savingacctstmt;
    }

    public void setSavingacctstmt(String savingacctstmt) {
        this.savingacctstmt = savingacctstmt;
    }

    public String getPartnersheepdeed() {
        return this.partnersheepdeed;
    }

    public void setPartnersheepdeed(String partnersheepdeed) {
        this.partnersheepdeed = partnersheepdeed;
    }

    public String getPrgender() {
        return this.prgender;
    }

    public void setPrgender(String prgender) {
        this.prgender = prgender;
    }

    public String getPredu() {
        return this.predu;
    }

    public void setPredu(String predu) {
        this.predu = predu;
    }

    public String getPrpropertyaddress() {
        return this.prpropertyaddress;
    }

    public void setPrpropertyaddress(String prpropertyaddress) {
        this.prpropertyaddress = prpropertyaddress;
    }

    public String getPropety() {
        return this.propety;
    }

    public void setPropety(String propety) {
        this.propety = propety;
    }

    public String getPropetyYN() {
        return this.propetyYN;
    }

    public void setPropetyYN(String propetyYN) {
        this.propetyYN = propetyYN;
    }

    public String getLoanrequirement() {
        return this.loanrequirement;
    }

    public void setLoanrequirement(String loanrequirement) {
        this.loanrequirement = loanrequirement;
    }

    public String getDownpayment() {
        return this.downpayment;
    }

    public void setDownpayment(String downpayment) {
        this.downpayment = downpayment;
    }

    public String getPrpropertypin() {
        return this.prpropertypin;
    }

    public void setPrpropertypin(String prpropertypin) {
        this.prpropertypin = prpropertypin;
    }

    public String getPrpropertylandmark() {
        return this.prpropertylandmark;
    }

    public void setPrpropertylandmark(String prpropertylandmark) {
        this.prpropertylandmark = prpropertylandmark;
    }

    public String getPrpropertyarea() {
        return this.prpropertyarea;
    }

    public void setPrpropertyarea(String prpropertyarea) {
        this.prpropertyarea = prpropertyarea;
    }

    public String getPrprojectname() {
        return this.prprojectname;
    }

    public void setPrprojectname(String prprojectname) {
        this.prprojectname = prprojectname;
    }

    public String getPrapplicantfullname() {
        return this.prapplicantfullname;
    }

    public void setPrapplicantfullname(String prapplicantfullname) {
        this.prapplicantfullname = prapplicantfullname;
    }

    public String getPrapplicantdob() {
        return this.prapplicantdob;
    }

    public void setPrapplicantdob(String prapplicantdob) {
        this.prapplicantdob = prapplicantdob;
    }

    public String getPrapplicantcontactno() {
        return this.prapplicantcontactno;
    }

    public void setPrapplicantcontactno(String prapplicantcontactno) {
        this.prapplicantcontactno = prapplicantcontactno;
    }

    public String getPrapplicantaltcontactno() {
        return this.prapplicantaltcontactno;
    }

    public void setPrapplicantaltcontactno(String prapplicantaltcontactno) {
        this.prapplicantaltcontactno = prapplicantaltcontactno;
    }

    public String getPrapplicantemail() {
        return this.prapplicantemail;
    }

    public void setPrapplicantemail(String prapplicantemail) {
        this.prapplicantemail = prapplicantemail;
    }

    public String getPrapplicantcurrentaddress() {
        return this.prapplicantcurrentaddress;
    }

    public void setPrapplicantcurrentaddress(String prapplicantcurrentaddress) {
        this.prapplicantcurrentaddress = prapplicantcurrentaddress;
    }

    public String getPrapplicantperaddress() {
        return this.prapplicantperaddress;
    }

    public void setPrapplicantperaddress(String prapplicantperaddress) {
        this.prapplicantperaddress = prapplicantperaddress;
    }

    public String getPraplicantoffceaddress() {
        return this.praplicantoffceaddress;
    }

    public void setPraplicantoffceaddress(String praplicantoffceaddress) {
        this.praplicantoffceaddress = praplicantoffceaddress;
    }

    public String getPrreference1name() {
        return this.prreference1name;
    }

    public void setPrreference1name(String prreference1name) {
        this.prreference1name = prreference1name;
    }

    public String getPrreference1address() {
        return this.prreference1address;
    }

    public void setPrreference1address(String prreference1address) {
        this.prreference1address = prreference1address;
    }

    public String getPrreferencecontactno() {
        return this.prreferencecontactno;
    }

    public void setPrreferencecontactno(String prreferencecontactno) {
        this.prreferencecontactno = prreferencecontactno;
    }

    public String getPrreferencerelationship() {
        return this.prreferencerelationship;
    }

    public void setPrreferencerelationship(String prreferencerelationship) {
        this.prreferencerelationship = prreferencerelationship;
    }

    public String getPrreference2name() {
        return this.prreference2name;
    }

    public void setPrreference2name(String prreference2name) {
        this.prreference2name = prreference2name;
    }

    public String getPrreference2address() {
        return this.prreference2address;
    }

    public void setPrreference2address(String prreference2address) {
        this.prreference2address = prreference2address;
    }

    public String getPrreference2contactno() {
        return this.prreference2contactno;
    }

    public void setPrreference2contactno(String prreference2contactno) {
        this.prreference2contactno = prreference2contactno;
    }

    public String getPrreference2relationship() {
        return this.prreference2relationship;
    }

    public void setPrreference2relationship(String prreference2relationship) {
        this.prreference2relationship = prreference2relationship;
    }

    public String getPrAPadhar() {
        return this.prAPadhar;
    }

    public void setPrAPadhar(String prAPadhar) {
        this.prAPadhar = prAPadhar;
    }

    public String getPrAapan() {
        return this.prAapan;
    }

    public void setPrAapan(String prAapan) {
        this.prAapan = prAapan;
    }

    public String getPrAapvoterid() {
        return this.prAapvoterid;
    }

    public void setPrAapvoterid(String prAapvoterid) {
        this.prAapvoterid = prAapvoterid;
    }

    public String getPrAapdl() {
        return this.prAapdl;
    }

    public void setPrAapdl(String prAapdl) {
        this.prAapdl = prAapdl;
    }

    public String getPrAappassport() {
        return this.prAappassport;
    }

    public void setPrAappassport(String prAappassport) {
        this.prAappassport = prAappassport;
    }

    public String getPradadhar() {
        return this.pradadhar;
    }

    public void setPradadhar(String pradadhar) {
        this.pradadhar = pradadhar;
    }

    public String getPradvoterid() {
        return this.pradvoterid;
    }

    public void setPradvoterid(String pradvoterid) {
        this.pradvoterid = pradvoterid;
    }

    public String getPraddl() {
        return this.praddl;
    }

    public void setPraddl(String praddl) {
        this.praddl = praddl;
    }

    public String getPradelectricity() {
        return this.pradelectricity;
    }

    public void setPradelectricity(String pradelectricity) {
        this.pradelectricity = pradelectricity;
    }

    public String getPradpassport() {
        return this.pradpassport;
    }

    public void setPradpassport(String pradpassport) {
        this.pradpassport = pradpassport;
    }

    public String getPradrentagmt() {
        return this.pradrentagmt;
    }

    public void setPradrentagmt(String pradrentagmt) {
        this.pradrentagmt = pradrentagmt;
    }

    public String getPradgovtid() {
        return this.pradgovtid;
    }

    public void setPradgovtid(String pradgovtid) {
        this.pradgovtid = pradgovtid;
    }

    public String getPradgumasta() {
        return this.pradgumasta;
    }

    public void setPradgumasta(String pradgumasta) {
        this.pradgumasta = pradgumasta;
    }

    public String getPradcurrentacctstmt() {
        return this.pradcurrentacctstmt;
    }

    public void setPradcurrentacctstmt(String pradcurrentacctstmt) {
        this.pradcurrentacctstmt = pradcurrentacctstmt;
    }

    public String getPrpropertytype() {
        return this.prpropertytype;
    }

    public void setPrpropertytype(String prpropertytype) {
        this.prpropertytype = prpropertytype;
    }

    public String getPrrecidenttype() {
        return this.prrecidenttype;
    }

    public void setPrrecidenttype(String prrecidenttype) {
        this.prrecidenttype = prrecidenttype;
    }

    public String getPrdescripiton() {
        return this.prdescripiton;
    }

    public void setPrdescripiton(String prdescripiton) {
        this.prdescripiton = prdescripiton;
    }

    public String getCoApplicantYN() {
        return this.coApplicantYN;
    }

    public void setCoApplicantYN(String coApplicantYN) {
        this.coApplicantYN = coApplicantYN;
    }

    public String getPrapplicantrelation() {
        return this.prapplicantrelation;
    }

    public void setPrapplicantrelation(String prapplicantrelation) {
        this.prapplicantrelation = prapplicantrelation;
    }

    public String getCoapplicantotherrelation() {
        return this.coapplicantotherrelation;
    }

    public void setCoapplicantotherrelation(String coapplicantotherrelation) {
        this.coapplicantotherrelation = coapplicantotherrelation;
    }

    public String getBusinessagmt() {
        return this.businessagmt;
    }

    public void setBusinessagmt(String businessagmt) {
        this.businessagmt = businessagmt;
    }

    public String getQualification() {
        return this.qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public OnClickListener getRequestBtnClickListener() {
        return this.requestBtnClickListener;
    }

    public void setRequestBtnClickListener(OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    public String getCarLoanAmount() {
        return this.carLoanAmount;
    }

    public void setCarLoanAmount(String carLoanAmount) {
        this.carLoanAmount = carLoanAmount;
    }

    public String getHomeLoanAmount() {
        return this.homeLoanAmount;
    }

    public void setHomeLoanAmount(String homeLoanAmount) {
        this.homeLoanAmount = homeLoanAmount;
    }

    public String getSocietyLoanAmount() {
        return this.societyLoanAmount;
    }

    public void setSocietyLoanAmount(String societyLoanAmount) {
        this.societyLoanAmount = societyLoanAmount;
    }

    public String getPersonalLoanAmount() {
        return this.personalLoanAmount;
    }

    public void setPersonalLoanAmount(String personalLoanAmount) {
        this.personalLoanAmount = personalLoanAmount;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getComissionamount() {
        return comissionamount;
    }

    public void setComissionamount(String comissionamount) {
        this.comissionamount = comissionamount;
    }

    public ArrayList<String> getChecklist() {
        return checklist;
    }

    public void setChecklist(ArrayList<String> checklist) {
        this.checklist = checklist;
    }

    public ArrayList<String> getChecklistCollected() {
        return checklistCollected;
    }

    public void setChecklistCollected(ArrayList<String> checklistCollected) {
        this.checklistCollected = checklistCollected;
    }

    public ArrayList<String> getChecklistCollectedimages() {
        return checklistCollectedimages;
    }

    public void setChecklistCollectedimages(ArrayList<String> checklistCollectedimages) {
        this.checklistCollectedimages = checklistCollectedimages;
    }

    public String getDisbussmentDate() {
        return disbussmentDate;
    }

    public void setDisbussmentDate(String disbussmentDate) {
        this.disbussmentDate = disbussmentDate;
    }

    public static ArrayList<LeedsModel> getLeeds() {
        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            leedsModelArrayList.add(new LeedsModel(i));
        }
        return leedsModelArrayList;
    }

    public String getChannelPartner() {
        return this.channelPartner;
    }

    public void setChannelPartner(String channelPartner) {
        this.channelPartner = channelPartner;
    }

    public String getHomeLoanType() {
        return homeLoanType;
    }

    public void setHomeLoanType(String homeLoanType) {
        this.homeLoanType = homeLoanType;
    }

    public String getBalanceTransferLoanType() {
        return balanceTransferLoanType;
    }

    public void setBalanceTransferLoanType(String balanceTransferLoanType) {
        this.balanceTransferLoanType = balanceTransferLoanType;
    }

    public String getCallingStatus() {
        return callingStatus;
    }

    public void setCallingStatus(String callingStatus) {
        this.callingStatus = callingStatus;
    }

    public String getCallingStatusReason() {
        return callingStatusReason;
    }

    public void setCallingStatusReason(String callingStatusReason) {
        this.callingStatusReason = callingStatusReason;
    }

    @Exclude
    public Map getLeedStatusMap() {
        Map<String, Object> leedMap = new HashMap();

        leedMap.put("updatedDateTime", getUpdatedDateTime());
        leedMap.put("customerName", getCustomerName());
        leedMap.put("address", getAddress());
        leedMap.put("agentId", getAgentId());
        leedMap.put("loanType", getLoanType());
        leedMap.put("mobileNumber", getMobileNumber());
        leedMap.put("panCardNumber", getPanCardNumber());
        leedMap.put("checkpanCardNumber", getCheckpanCardNumber());
        leedMap.put("bankName", getBankName());
        leedMap.put("officeAdderess", getofficeAdderess());
        leedMap.put("propertyAddress", getpropertyAddress());
        leedMap.put("description", getdescription());
        leedMap.put("alternetMobileNumber", getAlternetMobileNumber());
        leedMap.put("adharNo", getadharNo());
        leedMap.put("expectedLoanAmount", getExpectedLoanAmount());
        leedMap.put("recidential", getRecidential());
        leedMap.put("peraddress", getPeraddress());
        leedMap.put("mincome", getMincome());
        leedMap.put("yincome", getYincome());
        leedMap.put("flatno", getFlatno());
        leedMap.put("projectname", getProjectname());
        leedMap.put("propage", getPropage());
        leedMap.put("proparea", getProparea());
        leedMap.put("currentpin", getCurrentpin());
        leedMap.put("currentlandmark", getCurrentlandmark());
        leedMap.put("currentarea", getCurrentarea());
        leedMap.put("currentstreet", getCurrentstreet());
        leedMap.put("pincode", getPincode());
        leedMap.put("pcity", getPcity());
        leedMap.put("pstate", getPstate());
        leedMap.put("propaddress", getPropaddress());
        leedMap.put("channelPartner", getChannelPartner());
        leedMap.put("education", getEducation());
        leedMap.put("landmark", getLandmark());
        leedMap.put("area", getArea());
        leedMap.put("street", getStreet());
        leedMap.put("addressYesNo", getAddressYesNo());
        leedMap.put("email", getEmail());
        leedMap.put("gender", getGender());
        leedMap.put("dateOfBirth", getDateOfBirth());
        leedMap.put("otherEducation", getOtherEducation());
        leedMap.put("coApplicantYN", getCoApplicantYN());
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
        leedMap.put("leedNumber", getLeedNumber());
        leedMap.put("employed", getEmployed());
        leedMap.put("occupation", getOccupation());
        leedMap.put("companytype", getCompanytype());
        leedMap.put("othercompany", getOthercompany());
        leedMap.put("salaytype", getSalaytype());
        leedMap.put("emi", getEmi());
        leedMap.put("emicar", getEmicar());
        leedMap.put("emihome", getEmihome());
        leedMap.put("emisociety", getEmisociety());
        leedMap.put("emipersonal", getEmipersonal());
        leedMap.put("emiother", getEmiother());
        leedMap.put("emiOtherDetails", getEmiOtherDetails());
        leedMap.put("carLoanAmount", getCarLoanAmount());
        leedMap.put("homeLoanAmount", getHomeLoanAmount());
        leedMap.put("societyLoanAmount", getSocietyLoanAmount());
        leedMap.put("personalLoanAmount", getPersonalLoanAmount());
        leedMap.put("tenure", getTenure());
        leedMap.put("tenuremonth", getTenuremonth());
        leedMap.put("experience", getExperience());
        leedMap.put("experiencemonths", getExperiencemonths());
        leedMap.put("department", getDepartment());
        leedMap.put("designation", getDesignation());
        leedMap.put("grosssalary", getGrosssalary());
        leedMap.put("netsalary", getNetsalary());
        leedMap.put("overtime", getOvertime());
        leedMap.put("incentive", getIncentive());
        leedMap.put("bonus", getBonus());
        leedMap.put("rentalincome", getRentalincome());
        leedMap.put("annualincome", getAnnualincome());
        leedMap.put("rental", getRental());
        leedMap.put("salarysleep", getSalarysleep());
        leedMap.put("bankstmt", getBankstmt());
        leedMap.put("form", getForm());
        leedMap.put("appointmentltr", getAppointmentltr());
        leedMap.put("conformationltr", getConformationltr());
        leedMap.put("experinceltr", getExperinceltr());
        leedMap.put("visa", getVisa());
        leedMap.put("passport", getPassport());
        leedMap.put("emploerltr", getEmploerltr());
        leedMap.put("contractltr", getContractltr());
        leedMap.put("poa", getPoa());
        leedMap.put("nrebankstmt", getNrebankstmt());
        leedMap.put("overseasbankdetail", getOverseasbankdetail());
        leedMap.put("itr", getItr());
        leedMap.put("currentbankstmt", getCurrentbankstmt());
        leedMap.put("savingacctstmt", getSavingacctstmt());
        leedMap.put("partnersheepdeed", getPartnersheepdeed());
        leedMap.put("businessagmt", getBusinessagmt());
        leedMap.put("qualification", getQualification());
        leedMap.put("aggrecultureIncome", getAggrecultureIncome());
        leedMap.put("otherIncome", getOtherIncome());
        leedMap.put("prgender", getPrgender());
        leedMap.put("predu", getPredu());
        leedMap.put("prpropertyaddress", getPrpropertyaddress());
        leedMap.put("prpropertypin", getPrpropertypin());
        leedMap.put("prpropertylandmark", getPrpropertylandmark());
        leedMap.put("prpropertyarea", getPrpropertyarea());
        leedMap.put("prprojectname", getPrprojectname());
        leedMap.put("prapplicantfullname", getPrapplicantfullname());
        leedMap.put("prapplicantdob", getPrapplicantdob());
        leedMap.put("prapplicantcontactno", getPrapplicantcontactno());
        leedMap.put("prapplicantaltcontactno", getPrapplicantaltcontactno());
        leedMap.put("prapplicantemail", getPrapplicantemail());
        leedMap.put("prapplicantcurrentaddress", getPrapplicantcurrentaddress());
        leedMap.put("prapplicantperaddress", getPrapplicantperaddress());
        leedMap.put("praplicantoffceaddress", getPraplicantoffceaddress());
        leedMap.put("prAPadhar", getPrAPadhar());
        leedMap.put("prAapan", getPrAapan());
        leedMap.put("prAapvoterid", getPrAapvoterid());
        leedMap.put("prAapdl", getPrAapdl());
        leedMap.put("prAappassport", getPrAappassport());
        leedMap.put("pradadhar", getPradadhar());
        leedMap.put("pradvoterid", getPradvoterid());
        leedMap.put("praddl", getPraddl());
        leedMap.put("pradelectricity", getPradelectricity());
        leedMap.put("pradpassport", getPradpassport());
        leedMap.put("pradrentagmt", getPradrentagmt());
        leedMap.put("pradgovtid", getPradgovtid());
        leedMap.put("pradgumasta", getPradgumasta());
        leedMap.put("pradcurrentacctstmt", getPradcurrentacctstmt());
        leedMap.put("prpropertytype", getPrpropertytype());
        leedMap.put("prrecidenttype", getPrrecidenttype());
        leedMap.put("prdescripiton", getPrdescripiton());
        leedMap.put("propety", getPropety());
        leedMap.put("propetyYN", getPropetyYN());
        leedMap.put("loanrequirement", getLoanrequirement());
        leedMap.put("approvedLoan", getApprovedLoan());
        leedMap.put("disbusedLoanAmount", getDisbusedLoanAmount());
        leedMap.put("pendingLoanAmount", getPendingLoanAmount());

        leedMap.put("downpayment", getDownpayment());
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
        leedMap.put("banknName", getBanknName());
        leedMap.put("branchName", getBranchName());
        leedMap.put("ifscCode", getIfscCode());
        leedMap.put("appointment", getAppointment());
        leedMap.put("rescheduledappointment", getRescheduledappointment());
        leedMap.put("appointreschedualreason", getAppointreschedualreason());

        leedMap.put("loginid", getLoginid());
        leedMap.put("salesPerson", getSalesPerson());

        leedMap.put("checklist", getChecklist());
        leedMap.put("checklistCollected", getChecklistCollected());
        leedMap.put("checklistCollectedimages", getChecklistCollectedimages());
        leedMap.put("rejectionReason", getRejectionReason());
        leedMap.put("comissionamount", getComissionamount());
        leedMap.put("status", getStatus());
        leedMap.put("disbussmentDate", getDisbussmentDate());

        leedMap.put("homeLoanType", getHomeLoanType());
        leedMap.put("balanceTransferLoanType", getBalanceTransferLoanType());

        leedMap.put("callingStatusReason", getCallingStatus());
        leedMap.put("callingStatusReason", getCallingStatusReason());

        return leedMap;
    }

    @Exclude
    public Map getLeedStatusMap1() {
        Map<String, Object> leedMap = new HashMap();
        leedMap.put(NotificationCompat.CATEGORY_STATUS, getStatus());
        leedMap.put("updatedDateTime", getUpdatedDateTime());
        return leedMap;
    }
}
