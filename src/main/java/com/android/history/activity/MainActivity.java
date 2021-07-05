package com.android.history.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.history.R;
import com.android.history.fragment.EarFragment;
import com.android.history.fragment.PloyFragment;
import com.android.history.fragment.HistoryFragment;


/**
 * 主页面
 */
public class MainActivity extends Activity {
    private Activity myActivity;
    private LinearLayout llContent;
    private TextView tvTitle;
    private RadioButton rbEar;
    private RadioButton rbPloy;
    private RadioButton rbHistory;
    private Fragment[] fragments = new Fragment[]{null, null,null};//存放Fragment

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myActivity = this;
        setContentView(R.layout.activity_main);
        llContent =  (LinearLayout) findViewById(R.id.ll_main_content);
        tvTitle =  (TextView) findViewById(R.id.title);
        rbEar = (RadioButton) findViewById(R.id.rb_main_ear);
        rbPloy = (RadioButton) findViewById(R.id.rb_main_ploy);
        rbHistory = (RadioButton) findViewById(R.id.rb_main_history);

        initView();
        setViewListener();
    }

    private void setViewListener() {
        rbEar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTitle.setText("吃喝");
                switchFragment(0);
            }
        });
        rbPloy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTitle.setText("玩乐");
                switchFragment(1);
            }
        });
        rbHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvTitle.setText("人文历史");
                switchFragment(2);
            }
        });
    }

    private void initView() {
        //设置导航栏图标样式
        Drawable iconEar=getResources().getDrawable(R.drawable.selector_main_rb_eat);//设置主页图标样式
        iconEar.setBounds(0,0,68,68);//设置图标边距 大小
        rbEar.setCompoundDrawables(null,iconEar,null,null);//设置图标位置
        rbEar.setCompoundDrawablePadding(5);//设置文字与图片的间距
        Drawable iconPloy=getResources().getDrawable(R.drawable.selector_main_rb_ploy);//设置主页图标样式
        iconPloy.setBounds(0,0,68,68);//设置图标边距 大小
        rbPloy.setCompoundDrawables(null,iconPloy,null,null);//设置图标位置
        rbPloy.setCompoundDrawablePadding(5);//设置文字与图片的间距
        Drawable iconHistory=getResources().getDrawable(R.drawable.selector_main_rb_history);//设置主页图标样式
        iconHistory.setBounds(0,0,55,55);//设置图标边距 大小
        rbHistory.setCompoundDrawables(null,iconHistory,null,null);//设置图标位置
        rbHistory.setCompoundDrawablePadding(5);//设置文字与图片的间距
        switchFragment(0);
        rbEar.setChecked(true);
    }
    /**
     * 方法 - 切换Fragment
     *
     * @param fragmentIndex 要显示Fragment的索引
     */
    private void switchFragment(int fragmentIndex) {
        //在Activity中显示Fragment
        //1、获取Fragment管理器 FragmentManager
        FragmentManager fragmentManager = this.getFragmentManager();
        //2、开启fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //懒加载 - 如果需要显示的Fragment为null，就new。并添加到Fragment事务中
        if (fragments[fragmentIndex] == null) {
            switch (fragmentIndex) {
                case 0:
                    fragments[fragmentIndex] = new EarFragment();
                    break;
                case 1:
                    fragments[fragmentIndex] = new PloyFragment();
                    break;
                case 2:
                    fragments[fragmentIndex] = new HistoryFragment();
                    break;
            }

            //==添加Fragment对象到Fragment事务中
            //参数：显示Fragment的容器的ID，Fragment对象
            transaction.add(R.id.ll_main_content, fragments[fragmentIndex]);
        }

        //隐藏其他的Fragment
        for (int i = 0; i < fragments.length; i++) {
            if (fragmentIndex != i && fragments[i] != null) {
                //隐藏指定的Fragment
                transaction.hide(fragments[i]);
            }
        }
        //4、显示Fragment
        transaction.show(fragments[fragmentIndex]);

        //5、提交事务
        transaction.commit();
    }
    /**
     * 双击退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
        }

        return false;
    }

    private long time = 0;

    public void exit() {
        if (System.currentTimeMillis() - time > 2000) {
            time = System.currentTimeMillis();
            Toast.makeText(myActivity,"再点击一次退出应用程序", Toast.LENGTH_LONG).show();
        } else {
            finish();
        }
    }
}
