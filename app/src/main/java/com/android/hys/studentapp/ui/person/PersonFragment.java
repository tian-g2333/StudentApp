package com.android.hys.studentapp.ui.person;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.hys.studentapp.Activity_home;
import com.android.hys.studentapp.Adress;
import com.android.hys.studentapp.JiFen;
import com.android.hys.studentapp.Jiedan;
import com.android.hys.studentapp.MainActivity;
import com.android.hys.studentapp.R;
import com.android.hys.studentapp.lishidingdan;

public class PersonFragment extends Fragment {
    private PersonViewModel personViewModel;
    private TextView username;
    private View root;

    private Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        personViewModel =
                ViewModelProviders.of(this).get(PersonViewModel.class);
        root = inflater.inflate(R.layout.fragment_user_center, container, false);
        context=getContext();
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final Button bt_exit = (Button) getActivity().findViewById(R.id.per_bt_login);
        final TextView tv_jifen = (TextView) getActivity().findViewById(R.id.per_tv_score);
        final TextView tv_lishi = (TextView) getActivity().findViewById(R.id.per_tv_tradedetail);
        final TextView tv_jiedan = (TextView) getActivity().findViewById(R.id.per_tv_donatedetail);
        final TextView tv_adress = (TextView) getActivity().findViewById(R.id.per_tv_modifyaddress);
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);*/
                getActivity().finish();
            }
        });

        tv_jifen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), JiFen.class);
                startActivity(intent);
            }
        });

        tv_lishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), lishidingdan.class);
                startActivity(intent);
            }
        });

        tv_jiedan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Jiedan.class);
                startActivity(intent);
            }
        });

        tv_adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Adress.class);
                startActivity(intent);
            }
        });
    }

}
