package kg.boosterschool.house_kg.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record  OurPropertyResponseDto (
        @JsonProperty("Тип_сделки")
        String id_transaction_type,
        @JsonProperty("Тип_недвижимости")
        String id_property_type,
        @JsonProperty("Количество_комнат")
        int id_number_of_room,
        @JsonProperty("Площадь")
        double square,
        @JsonProperty("Серия")
        String id_series,
        @JsonProperty("Тип_строения")
        String id_type_of_structure,
        @JsonProperty("Год_постройки")
        int year_of_construction,
        @JsonProperty("Этаж")
        int floor,
        @JsonProperty("Отопление")
        String id_heating,
        @JsonProperty("Состояние")
        String id_condition,
        @JsonProperty("Регион")
        String id_region,
        @JsonProperty("Населенный_пункт")
        String id_settlement,
        @JsonProperty("Район")
        String id_district,
        @JsonProperty("Название_улицы")
        String street_name,
        @JsonProperty("Номер_дома")
        String house_number,
        @JsonProperty("Валюты")
        String id_currencies,
        @JsonProperty("Тип_цены")
        String id_price_types,
        @JsonProperty("Цена")
        double price,
        @JsonProperty("Рассрочка")
        String id_installment_plan,
        @JsonProperty("Ипотека")
        String id_mortgage,
        @JsonProperty("Возможность_обмена")
        String id_possibility_of_exchange,
        @JsonProperty("Общая стоимость в долларах")
        double totalCostDollar,
        @JsonProperty("Общая стоимость в сомах")
        double totalCostCom
){
}
