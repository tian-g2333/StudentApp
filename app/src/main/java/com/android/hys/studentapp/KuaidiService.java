package com.android.hys.studentapp;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class KuaidiService {
    public static boolean kuaidiSelect(String name, String name2, String info) {
        KuaidiThread kuaidiThread = new KuaidiThread("http://8.129.48.153:8080/MyWeb/SignIn",name,name2,info);
        try
        {
            kuaidiThread.start();
            kuaidiThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        return kuaidiThread.getResult();
    }

    public static boolean kuaidiAdd(String name, String name2, String info) {
        KuaidiThread kuaidiThread = new KuaidiThread("http://8.129.48.153:8080/MyWeb/DeliveryAdd",name,name2,info);
        try
        {
            kuaidiThread.start();
            kuaidiThread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return kuaidiThread.getResult();
    }
}

class KuaidiThread extends Thread
{
    private String path;
    private String name;
    private String name2;
    private String info;
    private boolean result = false;

    public KuaidiThread(String path,String name,String name2,String info)
    {
        this.path = path;
        this.name = name;
        this.name2 = name2;
        this.info = info;
    }
    @Override
    public void run()
    {
        try {
            URL url = new URL(path);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(8000);//设置连接超时时间
            httpURLConnection.setReadTimeout(8000);//设置读取超时时间
            httpURLConnection.setRequestMethod("POST");//设置请求方法,post

            String data = "name=" + URLEncoder.encode(name, "utf-8") +"&name2=" + URLEncoder.encode(name2, "utf-8") + "&info=" + URLEncoder.encode(info, "utf-8");//设置数据
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");//设置响应类型
            httpURLConnection.setRequestProperty("Content-Length", data.length() + "");//设置内容长度
            httpURLConnection.setDoOutput(true);//允许输出
            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(data.getBytes("utf-8"));//写入数据
            result = (httpURLConnection.getResponseCode() == 200);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getResult()
    {
        return result;
    }
}