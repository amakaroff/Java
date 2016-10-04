package com.ssu.alexey_makarov.task_2.db.reader.json.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssu.alexey_makarov.task_2.db.reader.Reader;
import com.ssu.alexey_makarov.task_2.model.eat.Eat;

import com.ssu.alexey_makarov.task_2.model.eat.dishes.dessert.Dessert;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.garnishe.Garnishe;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.meat.Meat;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.salad.Salad;
import com.ssu.alexey_makarov.task_2.model.eat.dishes.soup.Soup;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by csit on 28.09.2016.
 */
public class JSONReader implements Reader {

    private final static Logger LOGGER = Logger.getLogger(JSONReader.class);

    private static JSONReader jsonReader;

    private String path;

    private JSONReader() {
    }

    public static JSONReader getInstance() {
        if (jsonReader == null) {
            jsonReader = new JSONReader();
        }

        return jsonReader;
    }

    public JSONReader setPath(String path) {
        this.path = path;
        return this;
    }

    public <T extends Eat> Set<T> read() {
        if (this.path == null) {
            throw new NullPointerException("Path is empty");
        }
        Set<T> menu = new HashSet<T>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            menu = mapper.readValue(new File(path),
                    new TypeReference<HashSet<T>>() {
                    });
        } catch (IOException exception) {
            //System.out.println("Incorrect way to the file");
            LOGGER.error(exception.getMessage());
        }

        return menu;
    }
}

/**
 * Eat[] mas = new Eat[15];
 * mas[0] = new Dessert("Рулет с изюмом", 75, 15);
 * mas[1] = new Dessert("Пирог с повидлом", 60, 13);
 * mas[2] = new Dessert("Пирог с яблоками", 60, 13);
 * <p/>
 * mas[3] = new Salad("Салат Изюминка", 100, 35);
 * mas[4] = new Salad("Салат Лукошко", 100, 40);
 * mas[5] = new Salad("Салат Капустный с помидором", 100, 19);
 * <p/>
 * mas[6] = new Soup("Суп харчо с говядиной", 250, 31);
 * mas[7] = new Soup("Суп куриный с грибами", 250, 24);
 * mas[8] = new Soup("Суп болгарский вегетарианский", 250, 21);
 * <p/>
 * mas[9] = new Meat("Рыбное филе с помидоркой ", 80, 54);
 * mas[10] = new Meat("Печень  по королевски", 150, 54);
 * mas[11] = new Meat("Свинина запеченная\"По-гусарски\"", 80, 68);
 * <p/>
 * mas[12] = new Garnishe("Греча с маслом", 170, 17);
 * mas[13] = new Garnishe("Макароны отварные", 170, 15);
 * mas[14] = new Garnishe("Рис отварной с маслом", 170, 16);
 * <p/>
 * mapper.writerWithDefaultPrettyPrinter().writeValue(new File("D:\\Java\\menu\\src\\main\\resources\\menu.json"), mas);
**/
