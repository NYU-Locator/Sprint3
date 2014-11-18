package com.example.mylocator;

import java.util.ArrayList;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;

public class home extends FragmentActivity {

	private ViewPager mPager;
	private ArrayList<Fragment> fragmentList;
	private ImageView image;
	private TextView view1, view2, view3, view4;
	private int currIndex;// current index
	private int bmpW;// width
	private int offset;//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);

		InitTextView();
		InitImage();
		InitViewPager();
	}

	public void InitTextView() {
		view1 = (TextView) findViewById(R.id.tv_guid1);
		view2 = (TextView) findViewById(R.id.tv_guid2);
		view3 = (TextView) findViewById(R.id.tv_guid3);
		view4 = (TextView) findViewById(R.id.tv_guid4);

		view1.setOnClickListener(new txListener(0));
		view2.setOnClickListener(new txListener(1));
		view3.setOnClickListener(new txListener(2));
		view4.setOnClickListener(new txListener(3));
	}

	public class txListener implements View.OnClickListener {
		private int index = 0;

		public txListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			mPager.setCurrentItem(index);
		}
	}

	/*
	 * InitImage
	 */
	public void InitImage() {
		image = (ImageView) findViewById(R.id.cursor);
		bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.tab_bg)
				.getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		offset = (screenW / 4 - bmpW) / 2;

		// imgageview set 1 offset
		Matrix matrix = new Matrix();
		matrix.postTranslate(offset, 0);
		image.setImageMatrix(matrix);
	}

	/*
	 * 初始化ViewPager
	 */
	public void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.viewpager);
		fragmentList = new ArrayList<Fragment>();
		Fragment btFragment = new ButtonFragment();
		Fragment secondFragment = TestFragment
				.newInstance("this is second fragment");
		Fragment thirdFragment = TestFragment
				.newInstance("this is third fragment");
		Fragment fourthFragment = TestFragment
				.newInstance("this is fourth fragment");
		fragmentList.add(btFragment);
		fragmentList.add(secondFragment);
		fragmentList.add(thirdFragment);
		fragmentList.add(fourthFragment);

		// ViewPager adapter
		mPager.setAdapter(new MyFragmentPagerAdapter(
				getSupportFragmentManager(), fragmentList));
		mPager.setCurrentItem(0);// the first page
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());//
	}

	public class MyOnPageChangeListener implements OnPageChangeListener {
		private int one = offset * 2 + bmpW;// offset

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onPageSelected(int arg0) {
			// TODO Auto-generated method stub
			Animation animation = new TranslateAnimation(currIndex * one, arg0
					* one, 0, 0);//
			currIndex = arg0;
			animation.setFillAfter(true);//
			animation.setDuration(200);//
			image.startAnimation(animation);//
			int i = currIndex + 1;
			Toast.makeText(home.this, "you choose " + i + "page",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
