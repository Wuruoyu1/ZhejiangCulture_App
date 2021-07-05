package com.android.history.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.history.R;
import com.android.history.activity.InfoDetailActivity;
import com.android.history.adapter.InfoAdapter;
import com.android.history.bean.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * 玩乐
 */

public class PloyFragment extends Fragment {
    private Activity myActivity;//上下文
    private ListView listView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myActivity= (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ploy,container,false);
        listView = view.findViewById(R.id.list_view);
        initView();
        return view;
    }

    /**
     * 初始化页面
     */
    private void initView() {
        List<Info> list = new ArrayList<>();
        int[] images = new int[]{R.drawable.ic_2_1, R.drawable.ic_2_2, R.drawable.ic_2_3,R.drawable.ic_2_4,R.drawable.ic_2_5, R.drawable.ic_2_6, R.drawable.ic_2_7};
        String[] titles = new String[]{"杭州西湖", "嘉兴乌镇", "宁波天一阁博物馆","温州雁荡山","绍兴鲁迅故里", "金华横店影视城", "丽水仙都"};
        String[] infos = new String[]{"西湖古称“钱塘湖”，又名“西子湖”，古代诗人苏轼就对它评价道：“欲把西湖比西子，淡妆浓抹总相宜。”西湖形态为近于等轴的多边形，湖面被孤山及苏堤、白堤两条人工堤分割为5个子湖区，子湖区间由桥孔连通，各部分的湖水不能充分掺混，造成各湖区水质差异，大部分径流补给先进入西侧3个子湖区，再进入外西湖；湖水总面积5.593平方公里;，总容积1．10亿立方米，平均水深1．97 米； ",
                "乌镇是江南六大古镇之一，是个具有六千余年悠久历史的古镇,曾名乌墩和青墩。乌镇是典型的江南水乡古镇,素有“鱼米之乡,丝绸之府”之称。1991年,乌镇被评为省级历史文化名城,1999年开始古镇保护和旅游开发工程,乌镇已被评为国家AAAAA级景区,是全国20个黄金周预报景点之一。 \n" +
                        "乌镇虽历经2000多年沧桑,仍完整地保存着原有的水乡古镇的风貌和格局,梁、柱、门、窗上的木雕和石雕工艺精湛。当地的居民至今仍住在这些老房子里。全镇以河成街,桥街相连,依河筑屋,深宅大 院,重脊高檐,河埠廊坊,过街骑楼,穿竹石栏,临河水阁,古色古香,水镇一体,呈现一派古朴、明洁的幽静,是江南典型的“小桥、流水、人家”石板小路,古旧木屋,还有清清湖水的气息,仿佛都在提示着一种情致,一种氛围。\n",
                "天一阁博物馆是以藏书文化为特色，融社会历史、艺术于一体的综合性博物馆，占地26000平方米。环境幽雅，园林精美、建筑古朴，富有浓郁的地方特色。总体布局由藏书文化区、园林休闲区、陈列展览区三大功能区组成。 \n" +
                        "天一阁藏书楼是我国现存历史最久的私家藏书楼，也是世界上现存最早的三个私家藏书楼之一，建于明嘉靖四十年至四十五年（公元1561―1566）之间，原为明兵部右侍郎范钦的藏书处。于1982年被国务院公布为全国重点文物保护单位。现藏各类古籍近30万卷，其中珍椠善本8万卷，尤以明代地方志和科举录最为珍贵。近年来，我馆事业发展迅速，先后新增中国地方志珍藏馆、银台第官宅博物馆、麻将起源地陈列馆等处。中国地方志珍藏馆收藏全国各级各类当代地方志6730多册，占总数的80%以上。 \n",
                "雁荡山位于中国东南温州市境和台州市南部，是中国十大名山之一。雁荡山以山水奇秀闻名，素有“海上名山”、“寰中绝胜”之誉，史称“东南第一山”。因山顶有湖，芦苇茂密，结草为荡，南归秋雁多宿于此，故名雁荡。雁荡景观，奇闻天下，但不只是在奇。还有雁湖岗、龙湫背之雄伟；云洞栈道之险；仙溪、清江山水之秀。 ",
                "鲁迅故里景区是市区保存最完好、最具文化内涵和水乡古城经典风貌的历史街区。1881年9月25日，鲁迅先生就诞生在这里。\n" +
                        "游客在看到原汁原味三味书屋的同时，还能看到鲁迅祖居从未对外开放的西厢房，新近恢复的周家新台门、长庆寺、土谷祠、静修庵、恒济当与鲁迅笔下有关的遗迹，以及寿家台门、朱家花园等一批古宅古迹。 \n",
                "作为全球规模最大的影视拍摄基地、中国唯一的“国家级影视产业实验区” ，横店影视基地同时也是国内影视外景拍摄基地中唯一一家5A级景区。方圆10平方公里的横店，拥有十余家星级宾馆共8000余个床位，无论是高档酒店还是基地宾馆、游乐园、夜总会、桑拿中心、演艺中心、健身中心、保龄球馆等设施配套齐全。 目前，影视城共有七大景区，分别是：秦皇宫景区、清明上河图景区、梦幻谷（江南水乡）景区、大智禅寺景区、广州街香港街景区、明清宫苑景区以及屏岩洞府景区。另外，尚有6座在建基地，分别是：上海滩、唐宫唐街、华夏文化园、九龙大峡谷、情人谷、电影梦幻世界。 ",
                "仙都位于浙江省丽水地区缙云县境内，是一处以峰岩奇绝、山水神秀为景观特色，融田园风光与人文史迹为一体，以观光、避暑休闲和开展科学文化活动为一体的国家级重点风景名胜区；亦是一个山明水秀、景物优美、气候宜人的游览胜地。境内九曲练溪，十里画廊，山水飘逸，云雾缭绕。",};
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
