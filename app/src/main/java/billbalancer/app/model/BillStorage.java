package billbalancer.app.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BillStorage {
    private static BillStorage instance;
    private List<Bill> mBills;

    private BillStorage(Context context){
        mBills = new ArrayList<>();
        generateBills();
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

    public Bill getBill(UUID id){
        for (Bill bill : mBills){
            if (bill.getId().equals(id)){
                return bill;
            }
        }
        return null;
    }

    private void generateBills(){
        for (int i = 0; i < 100; i++) {
            Bill bill = new Bill();
            bill.setName("Bill #" + i);
            bill.setTotal(100.0);
            mBills.add(bill);
        }
    }
}
