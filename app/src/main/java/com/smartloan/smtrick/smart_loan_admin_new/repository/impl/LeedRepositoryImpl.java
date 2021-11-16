package com.smartloan.smtrick.smart_loan_admin_new.repository.impl;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.CheckList;
import com.smartloan.smtrick.smart_loan_admin_new.models.Commission;
import com.smartloan.smtrick.smart_loan_admin_new.models.FollowUp;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModelCo;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;
import com.smartloan.smtrick.smart_loan_admin_new.models.Target;
import com.smartloan.smtrick.smart_loan_admin_new.models.TodoList;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.repository.FirebaseTemplateRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;

import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_VERIFIED;

public class LeedRepositoryImpl extends FirebaseTemplateRepository implements LeedRepository {

    @Override
    public void readAllLeeds(final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF;
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void readAllInvoices(final CallBack callBack) {
        final Query query = Constant.INVOICE_TABLE_REF;
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void readAllInvoices1(final CallBack callBack) {
        final Query query = Constant.INVOICE_TABLE_REF;
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<Invoice> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            Invoice leedsModel = suggestionSnapshot.getValue(Invoice.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void readLeedsByUserId(String userId, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.orderByChild("agentId").equalTo(userId);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createLeed(LeedsModel leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedsModel.getLeedId());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void createInvoice(LeedsModel leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.INVOICE_TABLE_REF.child(leedsModel.getLeedId());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void deleteLeed(String leedId, CallBack callback) {
        DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedId);
        fireBaseDelete(databaseReference, callback);
    }

    @Override
    public void updateLeed(String leedId, Map leedMap, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedId);
        fireBaseUpdateChildren(databaseReference, leedMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void updateCoApplicantLeed(LeedsModelCo leedsModelCo, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.COAPPLICANT_LEEDS_TABLE_REF.child(leedsModelCo.getLeedId());
        fireBaseCreate(databaseReference, leedsModelCo, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void readLeedByLeedId(String leedId, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.child(leedId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot != null) {
                    if (dataSnapshot.getValue() != null) {
                        try {
                            if (dataSnapshot.hasChildren()) {
                                callBack.onSuccess(dataSnapshot.getValue(LeedsModel.class));
                            } else {
                                callBack.onError(null);
                            }
                        } catch (Exception e) {
                            ExceptionUtil.logException(e);
                        }
                    } else
                        callBack.onError(null);
                } else
                    callBack.onError(null);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                callBack.onError(databaseError);
            }
        });
    }
//    @Override
//    public void readLeedByLeedId(String leedId, final CallBack callBack) {
//        final Query query = Constant.LEEDS_TABLE_REF.child(leedId);
//        fireBaseReadData(query, new CallBack() {
//            @Override
//            public void onSuccess(Object object) {
//                if (object != null) {
//                    DataSnapshot dataSnapshot = (DataSnapshot) object;
//                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
//                        DataSnapshot child = dataSnapshot.getChildren().iterator().next();
//                        LeedsModel leedsModel = child.getValue(LeedsModel.class);
//                        callBack.onSuccess(leedsModel);
//                    } else
//                        callBack.onSuccess(null);
//                } else
//                    callBack.onSuccess(null);
//            }
//
//            @Override
//            public void onError(Object object) {
//                callBack.onError(object);
//            }
//        });
//    }

    @Override
    public void readLeedsByStatus(String status, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.orderByChild("status").equalTo(status);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readLeedsByID(String id, final CallBack callBack) {
        final Query query = Constant.COAPPLICANT_LEEDS_TABLE_REF.orderByChild("leedNumber").equalTo(id);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readLeedsByName(String name, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.orderByChild("salesPerson").equalTo(name);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);

                            if (leedsModel.getStatus().equalsIgnoreCase(STATUS_VERIFIED))
                                leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void updateLeedDocuments(String leedId, Map leedMap, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.LEEDS_TABLE_REF.child(leedId).child("documentImages");
        fireBaseUpdateChildren(databaseReference, leedMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createBank(Bank leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.BANK_TABLE_REF.child(leedsModel.getLeedid());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readAllBanks(final CallBack callBack) {
        final Query query = Constant.BANK_TABLE_REF;
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<Bank> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            Bank leedsModel = suggestionSnapshot.getValue(Bank.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readBankByName(final String bank, final CallBack callBack) {
        final Query query = Constant.BANK_TABLE_REF.orderByChild("bankname").equalTo(bank);
        fireBaseReadData(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        DataSnapshot firstChild = dataSnapshot.getChildren().iterator().next();
                        Bank bank1 = firstChild.getValue(Bank.class);
                        callBack.onSuccess(bank1);
                    } else {
                        callBack.onError(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }
//    @Override
//    public void readBankByName(String bank, final CallBack callBack) {
//        final Query query = Constant.BANK_TABLE_REF.orderByChild("bankname").equalTo(bank);
//        fireBaseNotifyChange(query, new CallBack() {
//            @Override
//            public void onSuccess(Object object) {
//                if (object != null) {
//                    DataSnapshot dataSnapshot = (DataSnapshot) object;
//                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
//                        ArrayList<Bank> leedsModelArrayList = new ArrayList<>();
//                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
//                            Bank leedsModel = suggestionSnapshot.getValue(Bank.class);
//                            leedsModelArrayList.add(leedsModel);
//                        }
//                        callBack.onSuccess(leedsModelArrayList);
//                    } else {
//                        callBack.onSuccess(null);
//                    }
//                }
//            }
//
//            @Override
//            public void onError(Object object) {
//                callBack.onError(object);
//            }
//        });
//    }

    @Override
    public void readUserByRole(String role, final CallBack callBack) {
        final Query query = Constant.USER_TABLE_REF.orderByChild("role").equalTo(role);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<User> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            User leedsModel = suggestionSnapshot.getValue(User.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readInvoicesByStatus(String status, final CallBack callBack) {
        final Query query = Constant.INVOICE_TABLE_REF.orderByChild("status").equalTo(status);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<Invoice> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            Invoice leedsModel = suggestionSnapshot.getValue(Invoice.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void updateInvoice(String leedId, Map leedMap, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.INVOICE_TABLE_REF.child(leedId);
        fireBaseUpdateChildren(databaseReference, leedMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createSalary(Expences salary, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.EXPENCE_TABLE_REF.child(salary.getGeneratedid());
        fireBaseCreate(databaseReference, salary, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createTravellingAllowance(Expences salary, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.EXPENCE_TABLE_REF.child(salary.getGeneratedid());
        fireBaseCreate(databaseReference, salary, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createRent(Expences salary, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.EXPENCE_TABLE_REF.child(salary.getGeneratedid());
        fireBaseCreate(databaseReference, salary, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createlightBill(Expences salary, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.EXPENCE_TABLE_REF.child(salary.getGeneratedid());
        fireBaseCreate(databaseReference, salary, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createOtherExpence(Expences salary, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.EXPENCE_TABLE_REF.child(salary.getGeneratedid());
        fireBaseCreate(databaseReference, salary, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readExpence(final CallBack callBack) {
        final Query query = Constant.EXPENCE_TABLE_REF;
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<Bank> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            Bank leedsModel = suggestionSnapshot.getValue(Bank.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void readExpenceByStatus(String status, final CallBack callBack) {
        final Query query = Constant.EXPENCE_TABLE_REF.orderByChild("status").equalTo(status);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<Expences> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            Expences leedsModel = suggestionSnapshot.getValue(Expences.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void updateExpence(String leedId, Map leedMap, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.EXPENCE_TABLE_REF.child(leedId);
        fireBaseUpdateChildren(databaseReference, leedMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void updateCommission(String leedId, Map leedMap, final CallBack callBack) {
        final DatabaseReference databaseReference = Constant.COMMISSION_TABLE_REF.child(leedId);
        fireBaseUpdateChildren(databaseReference, leedMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createCommission(Commission leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.COMMISSION_TABLE_REF.child(leedsModel.getGeneratedId());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readAllCommission(final CallBack callBack) {
        final Query query = Constant.COMMISSION_TABLE_REF;
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<Commission> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            Commission leedsModel = suggestionSnapshot.getValue(Commission.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createCheckList(CheckList leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.CHECKLIST_TABLE_REF.child(leedsModel.getGeneratedId());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readChecklistByRule(String rule, final CallBack callBack) {
        final Query query = Constant.CHECKLIST_TABLE_REF.orderByChild("ruleType").equalTo(rule);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<CheckList> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            CheckList leedsModel = suggestionSnapshot.getValue(CheckList.class);
                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createFollowUp(FollowUp followUp, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.FOLLOW_UP_TABLE_REF.child(followUp.getFollowupId());
        fireBaseCreate(databaseReference, followUp, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readFolloUpByLeedId(String id, final CallBack callBack) {
        final Query query = Constant.FOLLOW_UP_TABLE_REF.orderByChild("salesId").equalTo(id);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<FollowUp> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            FollowUp followUp = suggestionSnapshot.getValue(FollowUp.class);
                            leedsModelArrayList.add(followUp);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readLeedsByBankName(String name, final CallBack callBack) {
        final Query query = Constant.LEEDS_TABLE_REF.orderByChild("banknName").equalTo(name);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            LeedsModel leedsModel = suggestionSnapshot.getValue(LeedsModel.class);

                            leedsModelArrayList.add(leedsModel);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createInvoice1(Invoice leedsModel, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.INVOICE_TABLE_REF.child(leedsModel.getInvoiceId());
        fireBaseCreate(databaseReference, leedsModel, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }


    @Override
    public void createTarget(Target target, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.TARGET_TABLE_REF.child(target.getTargetId());
        fireBaseCreate(databaseReference, target, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void createTodolist(TodoList todoList, final CallBack callBack) {
        DatabaseReference databaseReference = Constant.TODOLIST_TABLE_REF.child(todoList.getTodolistId());
        fireBaseCreate(databaseReference, todoList, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                callBack.onSuccess(object);
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

    @Override
    public void readTodolistByLeedId(String id, final CallBack callBack) {
        final Query query = Constant.TODOLIST_TABLE_REF.orderByChild("adinId").equalTo(id);
        fireBaseNotifyChange(query, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    DataSnapshot dataSnapshot = (DataSnapshot) object;
                    if (dataSnapshot.getValue() != null & dataSnapshot.hasChildren()) {
                        ArrayList<TodoList> leedsModelArrayList = new ArrayList<>();
                        for (DataSnapshot suggestionSnapshot : dataSnapshot.getChildren()) {
                            TodoList followUp = suggestionSnapshot.getValue(TodoList.class);
                            leedsModelArrayList.add(followUp);
                        }
                        callBack.onSuccess(leedsModelArrayList);
                    } else {
                        callBack.onSuccess(null);
                    }
                }
            }

            @Override
            public void onError(Object object) {
                callBack.onError(object);
            }
        });
    }

}
