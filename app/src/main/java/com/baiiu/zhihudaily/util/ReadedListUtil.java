package com.baiiu.zhihudaily.util;

import android.widget.TextView;
import com.baiiu.zhihudaily.R;
import java.util.Map;

import static com.baiiu.zhihudaily.util.PreferenceUtil.instance;

/**
 * author: baiiu
 * date: on 16/2/19 14:45
 * description:
 */
public class ReadedListUtil {

  public static void saveToReadedList(String prefName, String id) {
    PreferenceUtil preferenceUtil = instance(prefName);

    if (preferenceUtil.getSettings().getAll().size() > 100) {
      preferenceUtil.getSettings().edit().clear();
    }

    preferenceUtil.put(id, "T").commit();
  }

  public static Map<String, String> getReadedMap(String prefName) {
    return (Map<String, String>) instance(prefName).getSettings().getAll();
  }

  public static void setTextColor(TextView textView, boolean isRead) {
    textView.setTextColor(
        isRead ? UIUtil.getColor(R.color.color_readed) : UIUtil.getColor(R.color.color_normal));
  }
}
