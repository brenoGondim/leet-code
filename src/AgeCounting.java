//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//import java.util.*;
//import java.io.*;
//import java.net.*;
//
////CoderByte challenge 'age-counting'
//class AgeCounting {
//    public static void main (String[] args) {
//        System.setProperty("http.agent", "Chrome");
//        try {
//            //{"data":"key=IAfpK, age=58, key=WNVdi, age=64, key=jp9zt, age=47, key=0Sr4C, age=68"}
//            URL url = new URL("https://coderbyte.com/api/challenges/json/age-counting");
//            try {
//                URLConnection connection = url.openConnection();
//                InputStream inputStream = connection.getInputStream();
//                Scanner scanner = new Scanner(inputStream);
//                StringBuilder sB = new StringBuilder();
//                while (scanner.hasNext()) {
//                    sB.append(scanner.nextLine());
//                }
//                JsonObject json = JsonParser.parseString(sB.toString()).getAsJsonObject();
//                String[] dataList = String.valueOf(json.get("data")).split(", ");
//                int count = 0;
//                for (int i = 0; i < dataList.length; i++) {
//                    String pair = dataList[i].replace("\"", "");
//                    String[] key = pair.split("=");
//                    if (key[0].equals("age") && Integer.parseInt(key[1]) >= 50) {
//                        count++;
//                    }
//                }
//
//                String result = String.valueOf(count);
//                String challengeToken = "9t3mnbiyc2";
//
//                result = result.replaceAll("(?i)["+ challengeToken + "]", "");
//                if (result.isEmpty()) {
//                    result = "EMPTY";
//                }
//                System.out.println(result);
//
//            } catch (IOException ioEx) {
//                System.out.println(ioEx);
//            }
//        } catch (MalformedURLException malEx) {
//            System.out.println(malEx);
//        }
//    }
//}