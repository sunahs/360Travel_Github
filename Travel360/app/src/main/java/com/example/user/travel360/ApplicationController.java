package com.example.user.travel360;


import android.app.Application;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

public class ApplicationController extends Application {
    // 사용자 속성 저장
    String email;
    String pw;
    String gender;
    int point;
    Boolean LoginFlag = false;


    // SharedPreference
    SharedPreferences pref;
    SharedPreferences.Editor edit;

    /**
     * Application 클래스를 상속받은 ApplicationController 객체는 어플리케이션에서 단 하나만 존재해야 합니다.
     * 따라서 내부에 ApplicationController 형의 instance를 만들어준 후
     * getter를 통해 자신의 instance를 가져오는 겁니다.
     */
    // ApplicationController 인스턴스 생성 및 getter 설정
    private static ApplicationController instance;

    public static ApplicationController getInstance() {
        return instance;
    }

    public void setLoginFlag(boolean a) {
        this.LoginFlag = a;

    }

    public Boolean getLoginFlag() {
        return LoginFlag;
    }

    public String getEmail() {

        return this.email;
    }

    public void setEmail(String email) {
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        edit.putString("email", email);
        editor.commit();

    }

    public String getPw() {
        return this.pw;
    }

    public String getGender() {
        return gender;
    }


    public int getPoint() {
        return point;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 어플이 실행되자마자 ApplicationController가 실행됩니다.
         * 자신의 instance를 생성하고 networkService를 만들어줍니다.
         */
        Log.i("MyTag", "Application 객체가 가장 먼저 실행됩니다.");
        // 인스턴스 가져오고 서비스 실행
        ApplicationController.instance = this;

        this.initSharedPreference();
    }


    public void initSharedPreference() {
        pref = getSharedPreferences("login", 0);
        edit = pref.edit();

        this.email = pref.getString("email", email);              // 이메일 가져옴
        this.pw = pref.getString("pw", pw);                      // 비밀번호 가져옴
        this.gender = pref.getString("gender", null);           // 성별 가져옴
        // Toast.makeText(getApplicationContext(), pw + "/" + gender + "/" + email, Toast.LENGTH_SHORT).show();
        this.LoginFlag = pref.getBoolean("LoginFlag", true);
        pref = getSharedPreferences("option", 0);
        edit = pref.edit();


    }


}
