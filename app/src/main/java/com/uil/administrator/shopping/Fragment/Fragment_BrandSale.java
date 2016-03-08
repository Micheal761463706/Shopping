package com.uil.administrator.shopping.Fragment;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uil.administrator.shopping.Adapter.BaseFragment;
import com.uil.administrator.shopping.R;

/**
 * 品牌特卖页面
 */
public class Fragment_BrandSale extends BaseFragment implements View.OnClickListener {
    private static final String TAG = "print";
    private ImageView iv_fragmet_brandsale_more;//选择更多按钮
    private TextView tv_fragmet_brandsale_sign; //签到赚金币按钮
    private Button btn_fragmet_brandsale_sousuo;//搜索框


    @Override
    protected int contentResid() {
        return R.layout.activity_fragment_brandsale;
    }

    @Override
    protected void initView(View view) {
        iv_fragmet_brandsale_more = (ImageView) view.findViewById(R.id.iv_fragmet_brandsale_more);
        tv_fragmet_brandsale_sign = (TextView) view.findViewById(R.id.tv_fragmet_brandsale_sign);
        btn_fragmet_brandsale_sousuo = (Button) view.findViewById(R.id.btn_fragmet_brandsale_sousuo);
        iv_fragmet_brandsale_more.setOnClickListener(this);
        tv_fragmet_brandsale_sign.setOnClickListener(this);
        btn_fragmet_brandsale_sousuo.setOnClickListener(this);

    }


    /**
     * 按钮点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_fragmet_brandsale_sousuo:
                //点击进行搜索
            case R.id.tv_fragmet_brandsale_sign:
                //
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fl_fragment_brandsale, new Fragment_Goldmall())
                        .commit();
                break;
            case R.id.iv_fragmet_brandsale_more:
                //点击选择更多
                break;
        }
    }
}
