package com.android.hys.studentapp.ui.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.hys.studentapp.Activity_home;
import com.android.hys.studentapp.KuaidiService;
import com.android.hys.studentapp.MainActivity;
import com.android.hys.studentapp.R;
import com.android.hys.studentapp.UserService;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    String name;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final EditText et_name = (EditText) getActivity().findViewById(R.id.et_name);
        final EditText et_info = (EditText) getActivity().findViewById(R.id.et_info);
        Button add=(Button) getActivity().findViewById(R.id.ensure_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name2 = et_name.getText().toString();
                String info = et_info.getText().toString();

                if (KuaidiService.kuaidiAdd(name,name2, info))
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "提交成功", Toast.LENGTH_LONG).show();
                        }
                    });
                else {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getActivity(), "提交失败", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        name = ((Activity_home) activity).getName();//通过强转成宿主activity，就可以获取到传递过来的数据
    }
}