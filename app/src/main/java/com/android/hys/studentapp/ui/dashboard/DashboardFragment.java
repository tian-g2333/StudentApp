package com.android.hys.studentapp.ui.dashboard;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.hys.studentapp.R;
import com.android.hys.studentapp.utitls.SecondHandGoods;

import java.util.ArrayList;
import java.util.HashMap;

public class DashboardFragment extends Fragment {

    private View view;
    private GridView gridview;

    private ArrayList<SecondHandGoods> goods_list;
    private ArrayAdapter spi_adapter_1;
    private ArrayAdapter spi_adapter_2;
    private ArrayAdapter<String> adapter;
    private Animation animation;
    private SwipeRefreshLayout swipeLayout;
    private ArrayList<HashMap<String, Object>> item_list;

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        initView();
        initreso();
        return view;
    }

    void initView(){
        gridview=(GridView)view.findViewById(R.id.grid_view);
        spi_adapter_1 = ArrayAdapter.createFromResource(view.getContext(), R.array.spingarr, android.R.layout.simple_spinner_item);
        spi_adapter_2 = ArrayAdapter.createFromResource(view.getContext(), R.array.spingarr2, android.R.layout.simple_spinner_item);

        spi_adapter_1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spi_adapter_2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);


        swipeLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_container);

        swipeLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        swipeLayout.setRefreshing(false);
                        //进行数据更新
                        Toast.makeText(view.getContext(), "正在进行数据更新", Toast.LENGTH_SHORT).show();
                    }
                }, 1000);
            }
        });
    }

    /**
     *资源初始化
     */
    void initreso(){
        goods_list=new ArrayList<SecondHandGoods>();
        item_list = new ArrayList<HashMap<String, Object>>();
        animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.myanim);
        /**
         * 得到商品的图片
         */
        // Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.goods);
        //模拟了六个商品
        int test=R.drawable.goods;
        SecondHandGoods good1=new SecondHandGoods(test,"¥22.2","墙纸");
        SecondHandGoods good2=new SecondHandGoods(test,"¥312.2","墙纸2");
        SecondHandGoods good3=new SecondHandGoods(test,"¥34.2","墙纸3");
        SecondHandGoods good4=new SecondHandGoods(test,"¥52.2","墙纸4");
        SecondHandGoods good5=new SecondHandGoods(test,"¥62.2","墙纸5");
        SecondHandGoods good6=new SecondHandGoods(test,"¥72.2","墙纸6");
        SecondHandGoods good7=new SecondHandGoods(test,"¥32.2","墙纸7");

        goods_list.add(good1);
        goods_list.add(good2);
        goods_list.add(good3);
        goods_list.add(good4);
        goods_list.add(good5);
        goods_list.add(good6);
        goods_list.add(good7);

        for(int i=0;i<goods_list.size();i++){
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("picture",goods_list.get(i).getPicture());
            map.put("price",goods_list.get(i).getPrice());
            map.put("name",goods_list.get(i).getName());
            item_list.add(map);
        }

        SimpleAdapter goods_adapter = new SimpleAdapter(view.getContext(),
                item_list,// 数据源
                R.layout.item,// 显示布局
                new String[] { "picture", "price","name" },
                new int[] { R.id.goods_image, R.id.goods_price,R.id.goods_name });

        gridview.setAdapter(goods_adapter);
        /*gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                animation = AnimationUtils.loadAnimation(view.getContext(), R.anim.myanim);
                ImageView iv = (ImageView) view.findViewById(R.id.goods_image);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(view.getContext(), "item单击事件", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                iv.startAnimation(animation);


            }
        });*/

    }

}