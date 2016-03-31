package com.ctbri.youeryuandaquan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.ctbri.youeryuandaquan.util.PhotoUtil;

public class WebActivity extends AppCompatActivity {
    private String type;
    private String path;
    private static String content;
    public static WebView mWebView;
    private TextView mOpentxt;
    private ImageView mOpenimage;
    private ValueCallback<Uri> mUploadMessage;
    private static final String IMAGE_FILE_NAME = "icon_face.jpg";
    private static final int IMAGE_REQUEST_CODE = 0;
    private static final int CAMERA_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
    }

    private void openHtml() {
        mWebView.setVisibility(View.VISIBLE);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);
        mWebView.addJavascriptInterface(new youxt(), "youxt");
        mWebView.loadUrl(path);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // 返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                view.addJavascriptInterface(new youxt(), "youxt");
                super.onPageFinished(view, url);
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient() {
            // For Android 3.0+
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {
                if (mUploadMessage != null)
                    return;
                mUploadMessage = uploadMsg;
                PhotoUtil.pickPhoto(WebActivity.this);
            }

            // For Android < 3.0
            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                openFileChooser(uploadMsg, "");
            }

            // For Android > 4.1.1
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType, String capture) {
                openFileChooser(uploadMsg, acceptType);
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg, String... acceptType) {
                openFileChooser(uploadMsg, acceptType);
            }

        });
    }

    class youxt {
        @JavascriptInterface
        public void vote(String votename, String oid, String name, String wName, String phoneNumber, String wish,
                         String content) {
//            if (null == EducationApplication.user) {
//                // Toast.makeText(WebviewActivity.this, "登录后才能投票哦~",
//                // Toast.LENGTH_LONG).show();
//                EducationApplication.votetype = 0;
//            } else if (EducationApplication.votetype != 2) {
//                EducationApplication.votetype = 1;
//            }
//            new VoteTask(WebActivity.this).execute(votename, oid, EducationApplication.votetype, name, wName,
//                    phoneNumber, wish, content);
        }

        @JavascriptInterface
        public void sharevote(String votename) {
            content = votename;
            mHandler.sendEmptyMessage(1);
            // UmengShareService.shareApp(WebviewActivity.this, content);
        }

        @JavascriptInterface
        public void shareoption(String votename) {
            content = votename;
            mHandler.sendEmptyMessage(1);
            // UmengShareService.shareApp(WebviewActivity.this, content);
        }

        @JavascriptInterface
        public void signupvote(String votename) {
            String url = "http://hd.youxt.cn/signup/" + votename;
            Uri u = Uri.parse(url);
            Intent it = new Intent(Intent.ACTION_VIEW, u);
            startActivity(it);
        }

    }

    public Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
//                    UmengShareService.shareApp(WebActivity.this, content);
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    // 改写物理按键——返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mWebView.canGoBack()) {
                mWebView.goBack();// 返回上一页面
                return true;
            } else {
                finish();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE || requestCode == IMAGE_REQUEST_CODE) {
            if (null == mUploadMessage)
                return;
            Uri result = data == null || resultCode != RESULT_OK ? null : data.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        }
    }
}
