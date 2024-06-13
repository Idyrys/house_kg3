package kg.boosterschool.house_kg.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OurPropertyDto(
        @JsonProperty("Тип_сделки")
        Long id_transaction_type,
        @JsonProperty("Тип_недвижимости")
        Long id_property_type,
        @JsonProperty("Количество_комнат")
        Long id_number_of_room,
        @JsonProperty("Площадь_m2")
        Double square,
        @JsonProperty("Серия")
        Long id_series,
        @JsonProperty("Тип_строения")
        Long id_type_of_structure,
        @JsonProperty("Год_постройки")
        int year_of_construction,
        @JsonProperty("Этаж")
        int floor,
        @JsonProperty("Отопление")
        Long id_heating,
        @JsonProperty("Состояние")
        Long id_condition,
        @JsonProperty("Локация")
        Long id_location,
        @JsonProperty("Название_улицы")
        String street_name,
        @JsonProperty("Номер_дома")
        String house_number,
        @JsonProperty("Валюты")
        Long id_currencies,
        @JsonProperty("Тип_цены")
        Long id_price_types,
        @JsonProperty("Цена")
        double price,
        @JsonProperty("Рассрочка")
        Long id_installment_plan,
        @JsonProperty("Ипотека")
        Long id_mortgage,
        @JsonProperty("Возможность_обмена")
        Long id_possibility_of_exchange
) {
}
