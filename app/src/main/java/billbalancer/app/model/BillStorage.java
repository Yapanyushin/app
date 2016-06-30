package billbalancer.app.model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BillStorage {
    private static BillStorage instance;
    private List<Bill> mBills;

    private BillStorage(Context context){
        mBills = new ArrayList<>();

    }

    public static BillStorage getInstance(Context context){
        if (instance == null) {

            instance = new BillStorage(context);
        }
        return instance;
    }

    public List<Bill> getBills(){
        return mBills;
    }

    public void addBill(Bill bill) {
        mBills.add(bill);
    }

    public void removeBill(Bill bill) {
        Log.d(BillStorage.class.getSimpleName(), String.valueOf(mBills.size()));
        mBills.remove(bill);
        Log.d(BillStorage.class.getSimpleName(), String.valueOf(mBills.size()));
    }

    public Bill getBill(UUID id){
        for (Bill bill : mBills){
            if (bill.getId().equals(id)){
                return bill;
            }
        }
        return null;
    }
}
