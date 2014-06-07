package com.example.baas;

import java.util.List;
import java.util.Map;

import android.content.Context;

import com.sina.sae.cloudservice.api.CloudClient;
import com.sina.sae.cloudservice.api.CloudDB;
import com.sina.sae.cloudservice.api.Statistic;
import com.sina.sae.cloudservice.exception.CloudServiceException;

public class Baas {

	Context mContext = null;
	//sae鍚庣
	final String AM = "acremind";
	final String AK = "0zyn4olmzz";
	final String SK = "ik34150ykwk4z5x3i22z1wy2l5mzjxwhyl12iyh1";

	public Baas(Context mContext) {
		super();
		this.mContext = mContext;
	}

	public int csh() {
		int flag = 0;

		if (CloudClient.checkNetwork(mContext)) {
			try {
				CloudClient.init(mContext, AM, AK, SK);//鍒濆鍖�
				Statistic.launch(mContext);
				flag = 1;
			} catch (CloudServiceException e) {
				e.printStackTrace();
			}
		}

		return flag;
	}

	public int login(String studentid, String password) {

		int t = 0;
		try {
			csh();
			String sql2 = "select * from auto_user_tb where studentid='" + studentid
					+ "' and password='" + password + "';";

			List<Map<String, String>> list = CloudDB.query(sql2);
			if (list == null || list.size() == 0) {
				t = 0;
			} else {
				Map<String, String> n = list.get(0);
				String sid = n.get("studentid");
				String pwd = n.get("password");
				if (sid.equals(studentid) && pwd.equals(password)) {
					t = 1;
				}
			}

		} catch (Exception e) {

		}
		return t;
	}

	public int register(String studentid, String password) {

		int flag = 0;
		try {
			csh();
			int t = 0;
			String sql2 = "select * from auto_user_tb where studentid='" + studentid
					+ "';";

			List<Map<String, String>> list = CloudDB.query(sql2);

			if (list == null || list.size() == 0) {
				t = 1;
			}

			final String sql = "INSERT INTO auto_user_tb (studentid, password, priority) VALUES ('"
					+ studentid + "', '" + password + "', 5)";
			if (t == 1) {
				CloudDB.execute(sql);
				flag = 1;
			}
		} catch (Exception e) {

		}
		return flag;
	}


	public int searchuser(int priority) {

		int flag = 0;
		try {
			csh();
			String sql = "select studentid from user where priority=" + priority
					+ ";";

			List<Map<String, String>> list = CloudDB.query(sql);
			Map<String, String> n = list.get(0);
			String t = n.get("studentid");
			System.out.println("Baas--->t=" + t);
			int tt = Integer.parseInt(t);
			System.out.println("Baas--->tt=" + tt);
			flag = tt;
		} catch (Exception e) {

		}
		System.out.println("Baas--->flag=" + flag);
		return flag;
	}

}
