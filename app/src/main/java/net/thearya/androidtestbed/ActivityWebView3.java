package net.thearya.androidtestbed;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ActivityWebView3 extends AppCompatActivity
{
	private WebView webView3;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_web_view_3);
		webView3 = findViewById(R.id.webview3);
		webView3.setWebViewClient(new CallBack());
		showTimeStampWebPage();
	}

	@TargetApi(Build.VERSION_CODES.N)
	private void showTimeStampWebPage()
	{
		// DateUtils.formatDateTime(this, new Date().getTime(), DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_TIME);
		// DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);
		// String IAmDatingPallavi = dateFormat.format(new Date().getTime());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault(Locale.Category.FORMAT));
		String IAmDatingPallavi = simpleDateFormat.format(new Date().getTime());    // Link text in the String HTML.
		String htmlAsString = "<HTML><BODY>Time is: <A HREF = 'http://fake.url'>" + IAmDatingPallavi + "</A></BODY></HTML>";
		webView3.loadData(htmlAsString, "text/html; charset=UTF-8", null);
	}

	private class CallBack extends WebViewClient
	{
		public boolean shouldOverrideUrlLoading(WebView webView, String url)
		{
			showTimeStampWebPage();

			// TODO: Web page still opening in the same WebView even if I change this to 'false'.  False means the Web page will be actually fetched, instead of being shown in the WebView.
			return true;
		}
	}
}
