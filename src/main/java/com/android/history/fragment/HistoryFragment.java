package com.android.history.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.history.R;
import com.android.history.activity.InfoActivity;
import com.android.history.activity.InfoDetailActivity;

/**
 * 人文历史
 */
public class HistoryFragment extends Fragment {
    private Activity myActivity;//上下文
    private LinearLayout llLocation;
    private LinearLayout llCulture;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myActivity= (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_history,container,false);
        llLocation = view.findViewById(R.id.ll_location);
        llCulture = view.findViewById(R.id.ll_culture);
        initView();
        return view;
    }

    /**
     * 初始化页面
     */
    private void initView() {
        llLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myActivity, InfoDetailActivity.class);
                intent.putExtra("title","地理位置");
                intent.putExtra("image",R.drawable.ic_3_1);
                intent.putExtra("content","浙江省地理特征非常丰富，浙北地区水网密集的冲积平原，浙东地区的沿海丘陵，浙南地区的山区，舟山市的海岛地貌，可谓山河湖海无所不有。浙江地势自西南向东北呈阶梯状倾斜。西南多为千米以上的群山盘结，其中位于龙泉境内的黄茅尖，海拔1929米，为全省最高峰。地形以丘陵、山脉、盆地为主，占全省总面积70.4%。浙江海岸线总长6400余公里，居全国首位。有沿海岛屿3000余个，水深在200米以内的大陆架面积达23万平方公里。");
                startActivity(intent);
            }
        });
        llCulture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myActivity, InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
