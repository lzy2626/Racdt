package com.racdt.webview;

interface ICallbackFromMainToWeb {
    void onResult(int responseCode, String actionName, String response);
}
