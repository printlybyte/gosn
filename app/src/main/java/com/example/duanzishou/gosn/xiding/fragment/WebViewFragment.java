package com.example.duanzishou.gosn.xiding.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.duanzishou.gosn.R;
import com.example.duanzishou.gosn.xiding.fragment.base.HeaderViewPagerFragment;

public class WebViewFragment extends HeaderViewPagerFragment {

    private WebView webView;

    public static WebViewFragment newInstance() {
        return new WebViewFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        webView = (WebView) view.findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://github.com/jeasonlzy0216");
        return view;
    }

    @Override
    public View getScrollableView() {
        return webView;
    }
}
