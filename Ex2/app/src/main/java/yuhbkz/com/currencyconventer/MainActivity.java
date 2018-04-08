package yuhbkz.com.currencyconventer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private TextView tvResult;
    private Spinner spInput;
    private Spinner spResult;
    private String currencyArr[];
    private Double valueArr[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // init
        init();

        // adapter
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,currencyArr);
        spInput.setAdapter(adapter);
        spResult.setAdapter(adapter);

        // listen currency's item selected
        spInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        spResult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                convert();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        txtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                convert();
            }
        });
    }
    /*
    INIT
     */
    private void init(){
        txtInput = (EditText) findViewById(R.id.txtInput);
        tvResult = (TextView) findViewById(R.id.tvResult);
        spInput = (Spinner) findViewById(R.id.spInput);
        spResult = (Spinner) findViewById(R.id.spResult);
        currencyArr = new String[]{"USD","VND","EUR","JPY","CNY","HKD","CAD","AUD","RUB"};
        valueArr = new Double[]{1.0,22802.5,0.8131,106.93,6.2958,7.8494,1.2801,1.3019,58.1549};
    }
    /*
    Converting when changing input number or currency's item
     */
    private void convert(){
        if (txtInput.getText().toString().isEmpty()) {
            tvResult.setText("");
        }
        else{
            DecimalFormat formatter = new DecimalFormat("#,###,###");
            Double input = Double.parseDouble(txtInput.getText().toString());
            Double output = input / valueArr[spInput.getSelectedItemPosition()] * valueArr[spResult.getSelectedItemPosition()];
            tvResult.setText(formatter.format(output));
        }


    }


}
