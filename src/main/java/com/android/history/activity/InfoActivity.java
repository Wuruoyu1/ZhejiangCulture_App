package com.android.history.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.history.R;
import com.android.history.adapter.InfoAdapter;
import com.android.history.bean.Info;

import java.util.ArrayList;
import java.util.List;


/**
 * 明细
 */
public class InfoActivity extends AppCompatActivity {
    private Activity myActivity;//上下文
    private ListView listView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myActivity =this;
        setContentView(R.layout.activity_info);
        listView = findViewById(R.id.list_view);
        initView();
    }
    /**
     * 初始化页面
     */
    private void initView() {
        List<Info> list = new ArrayList<>();
        int[] images = new int[]{R.drawable.ic_4_1, R.drawable.ic_4_2, R.drawable.ic_4_3,R.drawable.ic_4_4,R.drawable.ic_4_5};
        String[] titles = new String[]{"畲族", "越剧（绍兴嵊州）", "中国传统蚕桑丝织技艺","龙泉青瓷传统烧制技艺","中国篆刻(西泠印社金石篆刻)"};
        String[] infos = new String[]{"畲族是中国人口较少的少数民族之一，总人口708651人（2010年），分布在闽、浙、赣、粤、黔、皖、湘七省80多个县（市）内的部分山区，其中90%以上居住在福建、浙江广大山区。浙江主要的民族成分为汉族，2000年第五次人口普查时（下同）有45,535,266人，占全省人口的99.1%。少数民族总人口为39.97万。畲族是浙江世居的少数民族，也是目前人口最多的少数民族。",
                "越剧--中国第二大剧种 ，有第二国剧之称 ，也称绍兴戏，又被称为是\"流传最广的地方剧种\" ，有观点认为是\"最大的地方戏曲剧种\"， 在国外被称为\"中国歌剧\"。 与京剧、黄梅戏、评剧、豫剧并称中国五大剧种，汉族戏曲之一。 越剧发源于绍兴嵊州，先后在杭州和上海发展壮大起来，流行于全国，流传于世界，在发展中汲取了昆曲、话剧、绍剧等特色剧种之大成，经历了由男子越剧到女子越剧为主的历史性演变。",
                "中国传统桑蚕丝织技艺包括栽桑、养蚕、缫丝、染色和丝织等整个过程的生产技艺，以及其间用到的工具和织机和由此生产的绫绢、纱罗、织锦、缂丝等丝绸产品，同时也包括在这一过程中衍生的相关民俗活动。在丝织方面，各城镇之间形成了专业分工，如湖州织绫绉、嘉兴产绸、杭州产纱罗、南京产缎和绒、苏州产锦和缂丝等等，最后互相交换和补充，形成完整的丝织生产体系。中国传统桑蚕丝织技艺对中国历史做出了重大贡献，并通过丝绸之路对人类文明产生了深远影响。该遗产项目至今仍流传于浙江北部和江苏南部的太湖流域以及四川成都等地，是中国文化遗产不可分割的组成部分。",
                "龙泉青瓷传统烧制技艺是一种具有制作性、技能性和艺术性的传统手工艺。至今已有1700余年的历史。龙泉青瓷传统烧制技艺包括原料的粉碎、淘洗、陈腐和练泥；器物的成型、晾干、修坯、装饰、素烧、上釉、装匣、装窑；最后在龙窑内用木柴烧成。在原料选择、釉料配制、造型制作、窑温控制方面，龙泉青瓷均具有独特的技艺。龙泉青瓷烧制技艺服务人类生活，其成品具有独特的审美价值。陈设瓷、装饰瓷、茶具、餐具等，是烧制技术与艺术表现的完美结合。龙泉窑烧制的“粉青”“梅子青”厚釉瓷，淡雅、含蓄、敦厚、宁静，是中国古典审美情趣的表现。",
                "中国篆刻是以石材为主要材料，以刻刀为工具，以汉字为表象的一门独特的镌刻艺术。它由中国古代的印章制作技艺发展而来，至今已有3000多年的历史。它既强调中国书法的笔法、结构，又突出镌刻中自由、酣畅的艺术表达，于方寸间施展技艺、抒发情感，深受中国文人及普通民众的喜爱。篆刻艺术作品既可以独立欣赏，又可以在书画作品等领域广泛应用。",
                };
        for (int i = 0; i < images.length; i++) {
            Info info = new Info(titles[i],images[i],infos[i]);
            list.add(info);
        }
        InfoAdapter infoAdapter = new InfoAdapter(myActivity,R.layout.list_view,list);
        listView.setAdapter(infoAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(myActivity, InfoDetailActivity.class);
                intent.putExtra("title",titles[position]);
                intent.putExtra("image",images[position]);
                intent.putExtra("content",infos[position]);
                startActivity(intent);
            }
        });
    }
}
