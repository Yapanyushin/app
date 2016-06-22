package billbalancer.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import billbalancer.app.model.Bill;

public class BillFragment extends Fragment {
    private Bill mBill;
    private EditText mNameField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBill = new Bill();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_bill, container, false);
        setupListeners(v);
        fillInputs(v);
        return v;
    }

    private void setupListeners(View v){
        mNameField = (EditText)v.findViewById(R.id.bill_name);
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mBill.setName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void fillInputs(View v){
        Button dateButton = (Button)v.findViewById(R.id.bill_created_at);
        dateButton.setText(mBill.getCreatedAt().toString());
        dateButton.setEnabled(false);
    }
}
