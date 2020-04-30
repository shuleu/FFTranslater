package by.baron.ff.util;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;

public class YandexTranslator implements Translator {


    @Override
    public  String translate(String text) throws IOException {

//        String urlStr =
//                "https://translate.yandex.net/api/v1.5/tr.json/translate?key=trnsl.1.1.20200427T170437Z.ea55570780d18416.b9dfd6ba98ce64b64495d9da5ee487c596b65f19&ui=ru";

        String urlStr = "https://translate.google.by/?hl=en&tab=wT#view=home&op=translate&sl=ru&tl=en& ";
                     //    https://translate.google.by/?hl=en&tab=wT#view=home&op=translate&sl=ru&tl=en&

        URL urlObj = new URL(urlStr);
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());

        //dataOutputStream.writeBytes("text=" + URLEncoder.encode(text,"UTF-8") + "&lang=en");
        dataOutputStream.writeBytes("text=" + URLEncoder.encode(text,"UTF-8"));

        InputStream response = connection.getInputStream();
        String json = new java.util.Scanner(response).nextLine();


        int start = json.indexOf("[");
        int end = json.indexOf("]");


        String translated = json.substring(start + 2, end - 1);

        return translated;

    }
}
