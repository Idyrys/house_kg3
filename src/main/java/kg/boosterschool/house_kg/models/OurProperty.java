package kg.boosterschool.house_kg.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "our_property")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OurProperty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int floor;
    int yearOfConstruction;
    String streetName;
    String houseNumber;
    double price;
    boolean active;
    double Square;
    double totalCostCom;
    double totalCostDollar;
    double costPerSquareMeterInDollars;
    double costPerSquareMeterInSoms ;

    @ManyToOne
    @JoinColumn(name = "id_transaction_type")
    TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "id_property_type")
    PropertyType propertyType;

    @ManyToOne
    @JoinColumn(name = "id_number_of_room")
    NumberOfRoom numberOfRoom;

    @ManyToOne
    @JoinColumn(name = "id_series")
    Series series;

    @ManyToOne
    @JoinColumn(name = "id_type_of_structure")
    TypeOfStructure typeOfStructure;

    @ManyToOne
    @JoinColumn(name = "id_heating")
    Heating heating;

    @ManyToOne
    @JoinColumn(name = "id_condition")
    Condition condition;

    @ManyToOne
    @JoinColumn(name = "id_possibility_of_exchange")
    PossibilityOfExchange possibilityOfExchange;

    @ManyToOne
    @JoinColumn(name = "id_installment_plan")
    MortgageOrInstallmentPlan installmentPlan;

    @ManyToOne
    @JoinColumn(name = "id_location")
    Location location;

    @ManyToOne
    @JoinColumn(name = "id_currencie")
    Currency currency;

    @ManyToOne
    @JoinColumn(name = "id_price_type")
    PriceType priceType;

    @ManyToOne
    @JoinColumn(name = "id_mortgage")
    MortgageOrInstallmentPlan mortgage;












}
