package com.intipharga.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.intipharga.activity.MainActivity;
import com.intipharga.activity.R;

/**
 * Created by macair on 2/10/16.
 */
public class BugReportFragment extends Fragment {

    private AppCompatActivity activity;
    private EditText formEmail, formContent;
    private Button btnSend;
    private TextView txtInfo;

    public BugReportFragment(){}

    public static BugReportFragment newInstance(AppCompatActivity activity){
        BugReportFragment fragment = new BugReportFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_report_bug, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        formEmail = (EditText) v.findViewById(R.id.form_email);
        formContent = (EditText) v.findViewById(R.id.form_content);
        btnSend = (Button) v.findViewById(R.id.btn_send);
        txtInfo = (TextView) v.findViewById(R.id.txt_info);
    }

    public void setupViews(){
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Your report has been sent", Toast.LENGTH_SHORT).show();
                activity.startActivity(MainActivity.newIntent(activity, null, MainActivity.FRAGMENT_HOME));
                activity.finish();
            }
        });

        SpannableString ss = new SpannableString(txtInfo.getText().toString());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(activity, "Email link clicked", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(true);
            }
        };
        int idx = txtInfo.getText().toString().indexOf("security");
        System.out.println(txtInfo.getText().toString() + " " + idx);
        ss.setSpan(clickableSpan, idx, idx+23, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        txtInfo.setText(ss);
        txtInfo.setMovementMethod(LinkMovementMethod.getInstance());
        txtInfo.setHighlightColor(Color.TRANSPARENT);
    }
}
