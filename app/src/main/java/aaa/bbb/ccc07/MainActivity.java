package aaa.bbb.ccc07;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.ybq.parallaxviewpager.ParallaxViewPager;
import com.uncopt.android.widget.text.justify.JustifiedTextView;


public class MainActivity extends AppCompatActivity {

    private ParallaxViewPager mParallaxViewPager;
    private int[] imgs = new int[]{
            R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6,
            R.drawable.f7
    };
    private String[] texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texts = getResources().getStringArray(R.array.texts);

        mParallaxViewPager = findViewById(R.id.viewpager);
        initViewPager();
    }

    private void initViewPager() {
        PagerAdapter adapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0 == arg1;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object obj) {
                container.removeView((View) obj);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = View.inflate(container.getContext(), R.layout.pager_item, null);

                ImageView imageView = view.findViewById(R.id.item_img);
                JustifiedTextView desc = view.findViewById(R.id.desc);

                if (position != 0) {
                    imageView.setImageResource(imgs[position - 1]);
                }
                desc.setText(texts[position]);

                container.addView(view, ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
                return view;
            }

            @Override
            public int getCount() {
                return imgs.length+1;
            }
        };
        mParallaxViewPager.setAdapter(adapter);
    }
}
