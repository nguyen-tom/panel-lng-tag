/*
 * 作成日： 2012/03/9
 *
 * TODO この生成されたファイルのテンプレートを変更するには次を参照。
 * ウィンドウ ＞ 設定 ＞ Java ＞ コード・スタイル ＞ コード・テンプレート
 */
package com.panel.note.util;

import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

public class PropertyUtil {
    //WEB-INF/classes/jp/co/cacco/fb/util/
    private static final String CONFIG_PATH = "../../../../../../../config.properties";
    private static final String CONFIG_KEY = "config_properties";
    private static Properties props;
    private static ResourceBundle myResources;

    static {
        myResources = PropertyResourceBundle.getBundle("config");
    }

	/**
	 * コンストラクタ
	 */
	public PropertyUtil() {
	}

	
    public static String getProperty(String key) {
        return getProperties().getString(key);
    }
    
    private static ResourceBundle getProperties() {
        return myResources;
    }

}
