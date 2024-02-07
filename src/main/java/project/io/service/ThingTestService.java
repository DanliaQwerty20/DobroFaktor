package project.io.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.io.model.Things;
import project.io.repository.ThingsRepository;

import java.util.Arrays;
import java.util.List;

@Service

@Transactional
public class ThingTestService {
        @Autowired
        private ThingsRepository thingsRepository;

        public void insertTestData() {
            List<Things> testThings = Arrays.asList(
                    createThing("ручка раздельная SPLINE JK GR-23 графит", "https://xn--90afqsbambik.xn--p1ai/upload/resize_cache/iblock/0fe/1000_1000_10adcfd4e09558657d747190735ede44f/0fe8a6d416f4f0c2a4de0519987ef68d.jpg", 1000.99, "Описание ручки", "Дополнительное описание ручки", 15.0, 3.0, 2.0,1),
                    createThing("Клапан обратный 3/4\" CTM", "https://xn--90afqsbambik.xn--p1ai/upload/resize_cache/iblock/8ef/1452_1451_10adcfd4e09558657d747190735ede44f/8efd89587cfb41d06da92467a35e6250.jpeg", 1400.50, "Описание клапана", "Дополнительное описание клапана", 5.0, 4.0, 2.5,2),
                    createThing("Декоративный камень Камтек Кирпич", "https://xn--90afqsbambik.xn--p1ai/upload/resize_cache/iblock/a38/1000_1000_10adcfd4e09558657d747190735ede44f/a3802cea607bbe6bf3998f4aeff406f0.jpg", 2400.99, "Описание декоративного камня", "Дополнительное описание декоративного камня", 10.0, 12.0, 1.5,4),
                    createThing("Стяжка для пола БОЛАРС", "https://xn--90afqsbambik.xn--p1ai/upload/resize_cache/iblock/44b/1000_1000_10adcfd4e09558657d747190735ede44f/44b2ee6dfead3928783d9b00cf9547fd.jpg", 1800.50, "Описание стяжки для пола", "Дополнительное описание стяжки для пола", 8.0, 6.0, 2.0,5)
            );

            thingsRepository.saveAll(testThings);
        }

        private Things createThing(String name, String img, Double price, String description, String secondaryDescription, Double length, Double height, Double width, int CountId) {
            Things thing = new Things();
            thing.setName(name);
            thing.setImg(img);
            thing.setPrice(price);
            thing.setDescription(description);
            thing.setSecondaryDescription(secondaryDescription);
            thing.setLength(length);
            thing.setHeight(height);
            thing.setWidth(width);
            thing.setCountId(CountId);
            return thing;
        }
    }

