package com.example.hyyerzhou;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hyyerzhou.bean.LoginBean;
import com.example.hyyerzhou.persenter.Persenter;
import com.example.hyyerzhou.persenter.PersenterImpl;
import com.example.hyyerzhou.view.IView;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,IView {
    private EditText editText,editText2;
    private TextView textView,textView2;
    private Button button;
    private ImageView imageView;
    private PersenterImpl persenter;
    private CheckBox checkBox;
    private String path="http://www.zhaoapi.cn/user/login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        editText=findViewById(R.id.editText);
        editText2=findViewById(R.id.editText2);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
        button=findViewById(R.id.button);
        imageView=findViewById(R.id.imageView);
        persenter=new PersenterImpl(this);
        textView.setOnClickListener(this);
        textView2.setOnClickListener(this);
        button.setOnClickListener(this);
        imageView.setOnClickListener(this);
        checkBox=findViewById(R.id.checkBox);
        checkBox.setOnClickListener(this);
        ImageLoader.getInstance().displayImage("http://www.zhaoapi.cn/images/quarter/ad1.png",imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //登录
            case R.id.button:
                persenter.sendMessage(path+"?mobile="+editText.getText().toString()+"&password="+editText2.getText().toString(),LoginBean.class);
                break;
                //注册
            case R.id.textView:
                Intent intent=new Intent(MainActivity.this,ZhuActivity.class);
                startActivity(intent);
                break;
                //找回密码
            case R.id.textView2:
                break;
                //第三方登录
            case R.id.imageView:
                UMShareAPI umShareAPI =  UMShareAPI.get(MainActivity.this);

                //开始登录
                //第一个参数：上下文
                //第二个参数，登录哪种平台
                //第三个参数，添加回调
                umShareAPI.getPlatformInfo(MainActivity.this, SHARE_MEDIA.QQ, new UMAuthListener() {
                    /**
                     * 开始登录回调
                     * @param share_media
                     */
                    @Override
                    public void onStart(SHARE_MEDIA share_media) {
                        Log.i("dj", "UMAuthListener onStart");
                    }

                    /**
                     * 登录完成
                     * @param share_media
                     * @param i
                     * @param map
                     */
                    @Override
                    public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                        //头像，昵称，如果拿不到，自己debug看Key是啥，再问打死
                        Log.i("dj", "UMAuthListener onComplete");

//                        //获取名字
//                        String name  = map.get("screen_name");
//                        //获取头像
//                        String img  = map.get("profile_image_url");
//
//                        Log.i("dj", "name is "+ name);
//                        Log.i("dj", "img is "+ img);
                        Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                        Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent1);
                    }

                    /**
                     * 登录失败
                     * @param share_media
                     * @param i
                     * @param throwable
                     */
                    @Override
                    public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
                        Log.i("dj", "UMAuthListener onError" + throwable.getLocalizedMessage());
                    }

                    /**
                     * 登录取消
                     * @param share_media
                     * @param i
                     */
                    @Override
                    public void onCancel(SHARE_MEDIA share_media, int i) {
                        Log.i("dj", "UMAuthListener onCancel");
                    }
                });


                break;
            case R.id.checkBox:
                if (checkBox.isChecked()){
                    editText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }else {
                    editText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }
                break;
            default:
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void setData(Object o) {
        LoginBean loginBean= (LoginBean) o;
        Toast.makeText(MainActivity.this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
        if (loginBean.getCode()==0){
            Intent intent=new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);
        }

    }
}
