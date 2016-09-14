package billbalancer.app;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import billbalancer.app.model.Bill;
import billbalancer.app.model.repository.BillRepository;
import billbalancer.app.model.repository.Repository;

public class BillFragment extends ListItemFragment {

    private Bill mBillFormData;
    private EditText mNameField;
    private EditText mTotalField;
    private EditText mCreateDateField;
    private Calendar myCalendar = Calendar.getInstance();


    private final String DEFAULT_DATE_FORMAT = "dd.MM.yy HH:mm";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        mModel = (Bill) arguments.getSerializable(ListItemActivity.ITEM_OBJECT);
        View v = inflater.inflate(R.layout.fragment_bill, container, false);
        setupListeners(v);
        return v;
    }

    private DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }

    };

    private TimePickerDialog.OnTimeSetListener time = new TimePickerDialog.OnTimeSetListener() {

        @Override
        public void onTimeSet(TimePicker view, int hour, int minute) {
            myCalendar.set(Calendar.HOUR_OF_DAY, hour);
            myCalendar.set(Calendar.MONTH, minute);
            updateLabel();
        }

    };

    private void updateLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT, Locale.US);
        mCreateDateField.setText(dateFormat.format(myCalendar.getTime()));
    }

    @Override
    Repository getRepository() {
        return  BillRepository.getInstance(getContext());
    }

    protected void setupListeners(View v) {
        super.setupListeners(v);
        setupNameFieldListener(v);
        setupDateFieldListener(v);
        setupTotalFieldListener(v);
    }

    private void setupTotalFieldListener(View v) {
        mTotalField = (EditText) v.findViewById(R.id.bill_total);
        if (mModel.isValid()) {
            mTotalField.setText(String.valueOf(((Bill)mModel).getTotal()));
        }
        mTotalField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((Bill)mModel).setTotal(null);
                if (s.toString().length() > 0) {
                    ((Bill)mModel).setTotal(Double.parseDouble(s.toString()));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });
    }

    private void setupDateFieldListener(View v) {
        mCreateDateField = (EditText) v.findViewById(R.id.bill_create_date);
        myCalendar.setTime(((Bill)mModel).getCreateDate());
        updateLabel();
        mCreateDateField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new DatePickerDialog(v.getContext(), date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

                    new TimePickerDialog(v.getContext(), time, myCalendar.get(Calendar.HOUR_OF_DAY), myCalendar.get(Calendar.MINUTE), true).show();
                }
            }
        });
    }

    private void setupNameFieldListener(View v) {
        mNameField = (EditText) v.findViewById(R.id.bill_name);
        if (mModel.isValid()) {
            mNameField.setText(((Bill)mModel).getTitle());
        }
        mNameField.setHint(((Bill)mModel).getTitle());
        mNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ((Bill)mModel).setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
