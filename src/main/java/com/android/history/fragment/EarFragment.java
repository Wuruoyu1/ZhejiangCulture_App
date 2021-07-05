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
import android.widget.SimpleAdapter;

import com.android.history.R;
import com.android.history.activity.InfoDetailActivity;
import com.android.history.adapter.InfoAdapter;
import com.android.history.bean.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * 吃喝
 */

public class EarFragment extends Fragment {
    private Activity myActivity;//上下文
    private ListView listView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myActivity= (Activity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_ear,container,false);
        listView = view.findViewById(R.id.list_view);
        initView();
        return view;
    }

    /**
     * 初始化页面
     */
    private void initView() {
        List<Info> list = new ArrayList<>();
        int[] images = new int[]{R.drawable.ic_1_1, R.drawable.ic_1_2, R.drawable.ic_1_3,R.drawable.ic_1_4,R.drawable.ic_1_5, R.drawable.ic_1_6, R.drawable.ic_1_7,R.drawable.ic_1_8,
                R.drawable.ic_1_9};
        String[] titles = new String[]{"西湖醋鱼", "东坡肉", "严州干菜鸭","烤菜奉芋","书圣剡溪鹅", "前童三宝", "三丝敲鱼","岩头锦粉饺", "矾山肉燕"};
        String[] infos = new String[]{"西湖醋鱼悠久的历史都可以追溯到南宋。西湖醋鱼一般选用鲜活西湖草鱼为主料，烹制火候要恰到好处，最后还要以本地的醋、酒、酱油和糖调出平滑红亮的糖醋汁浇淋在鱼身上，撒上姜末，咬上一口，酸甜可口。",
                "东坡肉至今已有900多年的历史，东坡肉由酒与肉一起烧制而成。将半肥半瘦的猪肉烧得透亮，色如玛瑙，夹起一块尝尝，软而不烂，肥而不腻，实在味美。",
                "严州干菜鸭是建德独有的特色名菜，距今已有三百多年的历史。严州干菜鸭用的是千岛湖水鸭，再加上火腿、肥膘肉、干菜、新安江啤酒等烧制。干菜浸渍鸭身，在鸭肉的鲜味中，伴有干菜的清香，并略带甜意；霉干菜则渗透了油润的鸭汁，酥烂可口，香味溢嘴。",
                "奉化芋艿头个大、皮薄、质粉、味香，因其味美可口，营养丰富而名闻遐迩，因此有了“跑过三关六码头，吃过奉化芋艿头”这句谚语。烤菜奉芋将天菜心与芋艿结合，味美鲜香，是奉化的传统名菜。",
                "“书圣剡溪鹅”选用正宗的溪口剡溪鹅。将鹅肉料理干净，用特定的香料卤煮至七八成熟，待冷却之后切成小块，煮至鹅肉自然散发出浓郁的鲜香。之后揭盖出锅，再由食客在餐桌上现场制作，放入青翠嫩绿的蔬菜与鹅汤同煮，那鲜香实在让人忍不住大快朵颐。",
                "前童豆腐白嫩细腻，前童香干喷香柔韧，前童空心腐又香又脆。前童豆腐、香干、空心腐，被称为前童“三宝”，男女老少人人喜爱。","三丝敲鱼刺少肉嫩，口感绝佳。“敲鱼”是温州民间一种特殊烹饪工艺。新鲜的去骨鱼肉撒上干淀粉，用木槌敲成鱼片。经过反复敲打，三丝敲鱼更容易为人体消化吸收。成菜后，鱼片透明亮丽，光滑洁白，味道鲜美，别具一格。",
                "锦粉饺又称山粉饺，是永嘉楠溪江一带特有的小吃。以红薯淀粉、鲜猪肉、豆腐、香菇等为原料而成。和普通的水饺相比，岩头锦粉饺个头要再大一些。出炉的岩头锦粉饺滑而不腻、香嫩可口，入口较有嚼头，吃上三五个就饱了。",
        "百余年前肉燕由福建传入，肉燕长得有些像馄饨，但是它的皮是肉加淀粉敲打出来的矾山人称肉燕制作工艺为“肉包肉”。一锅汤水，旺火烧开，肉燕遇水一热，燕皮一舒一张，酸辣汤的刺激和骨汤的润清又将矾山肉燕的美味发挥地淋漓尽致。\n"};
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
