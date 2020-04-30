package by.baron.ff.util;

import java.io.IOException;

public class MogTranslator implements Translator {
    int responce = 0;

    @Override
    public String translate(String translate) throws IOException {
        responce++;
        System.out.println(responce);
        System.out.println("текст запроса " + responce);

        return translate;
    }
}
