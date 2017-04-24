package com.example.administrator.flexboxlayout;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

public class MainActivity extends AppCompatActivity {
    private FlexboxLayout flexboxLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);

        initData();
    }


    private void initData() {
        String[] tags = {"人民的名义", "财经·投资·理财", "诗", "体育", "运动&健康", "大学生活", "青春","王者荣耀", "读书",
                "工具癖", "小说", "Python", "爱情", "短篇小说", "世间事", "教育", "心理", "奇思妙想", "美食", "摄影","前端","Android","iOS"};

        for (int i = 0; i < tags.length; i++) {
            flexboxLayout.addView(createItemView(i, tags[i]));
        }
    }

    //动态代码创建 FlexboxLayout的View item
    private View createItemView(int id, final String catalog) {
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText(catalog);
        textView.setTextSize(16);
        textView.setBackgroundResource(R.drawable.tag_background);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        textView.setTag(id);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, catalog, Toast.LENGTH_SHORT).show();
            }
        });

        ViewCompat.setPaddingRelative(textView, DpPxUtil.dpToPixel(this,4), DpPxUtil.dpToPixel(this,6), DpPxUtil.dpToPixel(this,4), DpPxUtil.dpToPixel(this,6));
        FlexboxLayout.LayoutParams params = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(DpPxUtil.dpToPixel(this,6), DpPxUtil.dpToPixel(this,16), DpPxUtil.dpToPixel(this,6), DpPxUtil.dpToPixel(this,0));
        textView.setLayoutParams(params);

        return textView;
    }
}
