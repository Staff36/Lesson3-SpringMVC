package com.tronin.spring.mvc.repositories;

import com.tronin.spring.mvc.model.Counter;
import com.tronin.spring.mvc.model.Product;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Repository
public class Products {
    final Counter counter;

    List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void init(){
            productList.add(new Product(counter.incrementAndAssign(), "Дрель-шуруповерт ударная", "Дрель-шуруповерт ударная BLACK+DECKER BCD003BAST-QW " +
                    "работает от аккумулятора, поэтому может использоваться в любом месте, где отсутствует электричество. " +
                    "В комплектацию входит зарядное устройство и 160 элементов оснастки. Состав оснастки: 37 шт. PH/PZ/SLOT/HEX/STAR биты (25мм); " +
                    "10 шт. PH/PZ/SLOT/STAR биты (50мм); 10 шт. сверла по дереву 3,4,5,6,7,8mm; 10 шт. сверла по бетону 3,4,5,5.5,6,6.5,7,mm; " +
                    "15 шт. сверла по металлу 1.5,2,2.5,3,3.5,4,4.5,5,6,6.5mm; 40 шт. шурупы - 20 x желтых дюбелей - 20 x красных дюбелей; 1 шт. " +
                    "магнитный держатель; набор дюбилей и саморезов.", 11090f));
           productList.add( new Product(counter.incrementAndAssign(), "Перфоратор SDS-Plus", "Перфоратор Makita HR2470X19 обладает мощным двигателем " +
                    "и ударным механизмом, за счет чего достигается высокая производительность инструмента. Прорезиненная основная, а также удобная " +
                    "дополнительная рукоятка обеспечивают комфортную эксплуатацию, а смена патрона выполняется без использования дополнительных приспособлений. " +
                    "Двойная защитная изоляция. Предусмотрена электронная регулировка количества оборотов. Функция реверса.", 7553f));
            productList.add(new Product(counter.incrementAndAssign(), "Пила дисковая 5008 MG, 1800 Вт", "Надежная дисковая пила мощностью 1800 Вт, с пильным диском " +
                    "диаметром 210 мм, предназначена для продольной и поперечной распиловки древесины с глубиной пропила до 75,5 мм." +
                    " Часть корпуса выполнена из магниевого сплава. Два встроенных светодиода освещают линию реза для повышения точности распила. " +
                    "Увеличенная разметка для лучшей читаемости. Функция сдува опилок с линии реза.", 12237f));
            productList.add(new Product(counter.incrementAndAssign(), "Фен технический", "троительный фен с 2 скоростями. " +
                    "2 настройки температуры (350 и 500 градусов). 2-скорости настройки воздушного потока (300 и 500 л / мин). " +
                    "Подача до 500 л / мин при 500 градусов. Удобный ползунковый переключатель. Эргономичная ручка из мягкой резины для удобной работы)", 3320f));
            productList.add(new Product(counter.incrementAndAssign(), "Полировальная машина", "Профессиональная угловая полировальная машина с " +
                    "егулировкой оборотов. Применяется для полировальных и шлифовальных работ. Продолжительный режим работы. Регулировка оборотов с " +
                    "электроникой поддержания оборотов под нагрузкой.", 6177f));
    }

    @Autowired
    public Products(Counter counter) {
        this.counter = counter;
    }
}


