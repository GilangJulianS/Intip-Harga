package com.intipharga.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.intipharga.activity.R;

/**
 * Created by macair on 2/10/16.
 */
public class TermConditionFragment extends Fragment {

    private AppCompatActivity activity;
    private TextView txtContent;

    public TermConditionFragment(){}

    public static TermConditionFragment newInstance(AppCompatActivity activity){
        TermConditionFragment fragment = new TermConditionFragment();
        fragment.activity = activity;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_terms_conditions, parent, false);

        bindViews(v);
        setupViews();

        return v;
    }

    public void bindViews(View v){
        txtContent = (TextView) v.findViewById(R.id.txt_content);
    }

    public void setupViews(){
        txtContent.setText(Html.fromHtml("<b>Lorem ipsum dolor sit amet</b><br/><br/>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod<br/>tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,<br>/quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo<br/>consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse<br/>cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non<br/>proident, sunt in culpa qui officia deserunt mollit anim id est laborum.<br/><br/><br/><b>Lorem ipsum dolor sit amet</b><br/><br/>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod<br/>tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,<br>/quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo<br/>consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse<br/>cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non<br/>proident, sunt in culpa qui officia deserunt mollit anim id est laborum.<br/><br/><br/><b>Lorem ipsum dolor sit amet</b><br/><br/>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod<br/>tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,<br>/quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo<br/>consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse<br/>cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non<br/>proident, sunt in culpa qui officia deserunt mollit anim id est laborum.<br/>"));
    }
}
