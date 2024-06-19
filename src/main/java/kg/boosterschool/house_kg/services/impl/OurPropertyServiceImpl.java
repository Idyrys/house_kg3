package kg.boosterschool.house_kg.services.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import kg.boosterschool.house_kg.dto.requestDto.OurPropertyDto;
import jakarta.persistence.criteria.Predicate;
import kg.boosterschool.house_kg.dto.responseDto.OurPropertyResponseDto;
import kg.boosterschool.house_kg.models.*;
import kg.boosterschool.house_kg.repositories.*;
import kg.boosterschool.house_kg.services.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class OurPropertyServiceImpl implements OurPropertyService {
    private final OurPropertyRepo ourPropertyRepo;
    private final TransactionTypeService transactionTypeService;
    private final PropertyTypeService propertyTypeService;
    private final NumberOfRoomService numberOfRoomService;
    private final SeriesService seriesService;
    private final TypeOfStructureService typeOfStructureService;
    private final HeatingService heatingService;
    private final ConditionService conditionService;
    private final LocationService locationService;
    private final CurrencyService currencyService;
    private final PriceTypeService priceTypeService;
    private final MortgageOrInstallmentPlanService mortgageOrInstallmentPlanService;
    private final PossibilityOfExchangeService possibilityOfExchangeService;
    private final ExchangeRateService exchangeRateService;
    double totalCostCom1;
    double totalCostDollar1;
    double costPerSquareMeterInDollars1;
    double costPerSquareMeterInSoms1;


    public OurPropertyServiceImpl(OurPropertyRepo ourPropertyRepo, TransactionTypeService transactionTypeService,
                                  PropertyTypeService propertyTypeService, NumberOfRoomService numberOfRoomService,
                                  SeriesService seriesService, TypeOfStructureService typeOfStructureService,
                                  HeatingService heatingService, ConditionService conditionService,
                                  LocationService locationService, CurrencyService currencyService,
                                  PriceTypeService priceTypeService, MortgageOrInstallmentPlanService mortgageOrInstallmentPlanService,
                                  PossibilityOfExchangeService possibilityOfExchangeService, ExchangeRateService exchangeRateService) {
        this.ourPropertyRepo = ourPropertyRepo;
        this.transactionTypeService = transactionTypeService;
        this.propertyTypeService = propertyTypeService;
        this.numberOfRoomService = numberOfRoomService;
        this.seriesService = seriesService;
        this.typeOfStructureService = typeOfStructureService;
        this.heatingService = heatingService;
        this.conditionService = conditionService;
        this.locationService = locationService;
        this.currencyService = currencyService;
        this.priceTypeService = priceTypeService;
        this.mortgageOrInstallmentPlanService = mortgageOrInstallmentPlanService;
        this.possibilityOfExchangeService = possibilityOfExchangeService;
        this.exchangeRateService = exchangeRateService;
    }
    @Override
    public String createOurProperty(OurPropertyDto ourPropertyDto) {
        TransactionType transactionType = transactionTypeService.getReferenceById(ourPropertyDto.id_transaction_type());
        PropertyType propertyType = propertyTypeService.getReferenceById(ourPropertyDto.id_property_type());
        NumberOfRoom numberOfRoom = numberOfRoomService.getReferenceById(ourPropertyDto.id_number_of_room());
        Series series = seriesService.getReferenceById(ourPropertyDto.id_series());
        TypeOfStructure typeOfStructure = typeOfStructureService.getReferenceById(ourPropertyDto.id_type_of_structure());
        Heating heating = heatingService.getReferenceById(ourPropertyDto.id_heating());
        Condition condition = conditionService.getReferenceById(ourPropertyDto.id_condition());
        Location location = locationService.getReferenceById(ourPropertyDto.id_location());
        Currency currency = currencyService.getReferenceById(ourPropertyDto.id_currencies());
        PriceType priceType = priceTypeService.getReferenceById(ourPropertyDto.id_price_types());
        MortgageOrInstallmentPlan installmentPlan = mortgageOrInstallmentPlanService.getReferenceById(ourPropertyDto.id_installment_plan());
        MortgageOrInstallmentPlan mortgage = mortgageOrInstallmentPlanService.getReferenceById(ourPropertyDto.id_mortgage());
        PossibilityOfExchange possibilityOfExchange = possibilityOfExchangeService.getReferenceById(ourPropertyDto.id_possibility_of_exchange());

        if (currency.getName().equalsIgnoreCase(currencyService.typeDollars()) && priceType.getName().equalsIgnoreCase(priceTypeService.typePerSquareMeter())) {
            totalCostCom1 = (ourPropertyDto.square() * (ourPropertyDto.price()*exchangeRateService.findActiveExchangeRates()));
            totalCostDollar1 = ourPropertyDto.square() * ourPropertyDto.price();
        } else if (currency.getName().equalsIgnoreCase(currencyService.typeSoms() )&& priceType.getName().equalsIgnoreCase(priceTypeService.typePerSquareMeter())) {
            totalCostCom1 = ourPropertyDto.square() * ourPropertyDto.price();
            totalCostDollar1 = (ourPropertyDto.square() * (ourPropertyDto.price()/exchangeRateService.findActiveExchangeRates()));
        } else if (currency.getName().equalsIgnoreCase(currencyService.typeDollars()) && priceType.getName().equalsIgnoreCase(priceTypeService.typeForAll())) {
            totalCostCom1 = ourPropertyDto.price() * exchangeRateService.findActiveExchangeRates();
            totalCostDollar1 = ourPropertyDto.price();
        } else if (currency.getName().equalsIgnoreCase(currencyService.typeSoms()) && priceType.getName().equalsIgnoreCase(priceTypeService.typeForAll())) {
            totalCostCom1 = ourPropertyDto.price();
            totalCostDollar1 = ourPropertyDto.price() / exchangeRateService.findActiveExchangeRates();
        }
        costPerSquareMeterInDollars1 = totalCostDollar1 / ourPropertyDto.square();
        costPerSquareMeterInSoms1 = totalCostCom1 / ourPropertyDto.square();

            OurProperty ourProperty = new OurProperty();
            ourProperty.setTransactionType(transactionType);
            ourProperty.setPropertyType(propertyType);
            ourProperty.setNumberOfRoom(numberOfRoom);
            ourProperty.setSquare(ourPropertyDto.square());
            ourProperty.setSeries(series);
            ourProperty.setTypeOfStructure(typeOfStructure);
            ourProperty.setYearOfConstruction(ourPropertyDto.year_of_construction());
            ourProperty.setFloor(ourPropertyDto.floor());
            ourProperty.setHeating(heating);
            ourProperty.setCondition(condition);
            ourProperty.setLocation(location);
            ourProperty.setStreetName(ourPropertyDto.street_name());
            ourProperty.setHouseNumber(ourPropertyDto.house_number());
            ourProperty.setCurrency(currency);
            ourProperty.setPriceType(priceType);
            ourProperty.setPrice(ourPropertyDto.price());
            ourProperty.setInstallmentPlan(installmentPlan);
            ourProperty.setMortgage(mortgage);
            ourProperty.setPossibilityOfExchange(possibilityOfExchange);
            ourProperty.setTotalCostDollar(totalCostDollar1);
            ourProperty.setTotalCostCom(totalCostCom1);
            ourProperty.setCostPerSquareMeterInDollars(costPerSquareMeterInDollars1);
            ourProperty.setCostPerSquareMeterInSoms(costPerSquareMeterInSoms1);
            ourProperty.setActive(true);
            ourPropertyRepo.save(ourProperty);
            return "Успешно";
    }

    @Override
    public List<OurPropertyResponseDto> getALlOurPropertyMapper(List<OurProperty> ourProperties) {

        return ourProperties.stream()
                .map(ourProperty -> new OurPropertyResponseDto(
                        ourProperty.getTransactionType().getName(),
                        ourProperty.getPropertyType().getName(),
                        ourProperty.getNumberOfRoom().getNumber(),
                        ourProperty.getSquare(),
                        ourProperty.getSeries().getName(),
                        ourProperty.getTypeOfStructure().getName(),
                        ourProperty.getYearOfConstruction(),
                        ourProperty.getFloor(),
                        ourProperty.getHeating().getName(),
                        ourProperty.getCondition().getName(),
                        locationService.getRegion(ourProperty.getLocation().getName()),
                        locationService.getSettlement(ourProperty.getLocation().getName()),
                        ourProperty.getLocation().getName(),
                        ourProperty.getStreetName(),
                        ourProperty.getHouseNumber(),
                        ourProperty.getCurrency().getName(),
                        ourProperty.getPriceType().getName(),
                        ourProperty.getPrice(),
                        ourProperty.getInstallmentPlan().getName(),
                        ourProperty.getMortgage().getName(),
                        ourProperty.getPossibilityOfExchange().getName(),
                        ourProperty.getTotalCostDollar(),
                        ourProperty.getTotalCostCom()

                ))
                .toList();
    }

    @Override
    public List<String> getAllOurPropertyResponseDto() {
        return ourPropertyRepo.getAllOurPropertyResponseDto();
    }

    @Override
    public List<OurProperty> getAllOurPropertyByParameters(
            int page, int pageSize,
            Integer floor, Integer yearBuilt, String dealType,
            String propertyType ,Integer roomCount,String series,
            String buildingType, String heating, String condition,
            String region, String settlement, String district,
            String streetName, String houseNumber,Double priceMin,
            Double priceMax, String currency, String priceType,
            String installmentPlan, String mortgage, String exchangeOption
    ) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        Specification<OurProperty> parameters = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = buildPredicates(floor, yearBuilt,dealType, propertyType ,
                    roomCount,series,buildingType,heating,condition,region,settlement,district,
                    streetName,houseNumber ,priceMin,priceMax,currency , priceType,installmentPlan,
                    mortgage ,exchangeOption, root, criteriaBuilder);
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

         Page<OurProperty> pages =ourPropertyRepo.findAll(parameters,pageRequest);
         return pages.getContent();
    }

    private List<Predicate> buildPredicates(
            Integer floor, Integer yearBuilt, String dealType,
            String propertyType ,Integer roomCount,String series,
            String buildingType,String heating,String condition,
            String region,String settlement,String district,
            String streetName,String houseNumber ,Double priceMin,
            Double priceMax,String currency,String priceType,
            String installmentPlan, String mortgage, String exchangeOption,
            Root<OurProperty> root, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (floor != null) {
            predicates.add(criteriaBuilder.equal(root.get("floor"), floor));
        }
        if (yearBuilt != null) {
            predicates.add(criteriaBuilder.equal(root.get("yearOfConstruction"), yearBuilt));
        }
        if (streetName != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("streetName")), streetName.toUpperCase()));
        }
        if (houseNumber != null) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("houseNumber")), houseNumber.toUpperCase()));
        }

        if (priceMin != null && priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typeForAll()) && currency.equalsIgnoreCase(currencyService.typeDollars())) {
            predicates.add(criteriaBuilder.between(root.get("totalCostDollar"), priceMin, priceMax));
        } else if (priceMin != null && priceType.equalsIgnoreCase(priceTypeService.typeForAll()) && currency.equalsIgnoreCase(currencyService.typeDollars())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("totalCostDollar"), priceMin));
        } else if (priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typeForAll()) && currency.equalsIgnoreCase(currencyService.typeDollars())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalCostDollar"), priceMax));
        }else if (priceMin != null && priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typeForAll()) && currency.equalsIgnoreCase(currencyService.typeSoms())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalCostCom"), priceMax));
        }else if (priceMin != null && priceType.equalsIgnoreCase(priceTypeService.typeForAll()) && currency.equalsIgnoreCase(currencyService.typeSoms())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("totalCostCom"), priceMin));
        } else if (priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typeForAll()) && currency.equalsIgnoreCase(currencyService.typeSoms())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("totalCostCom"), priceMax));
        }

        if (priceMin != null && priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typePerSquareMeter()) && currency.equalsIgnoreCase(currencyService.typeDollars())) {
            predicates.add(criteriaBuilder.between(root.get("costPerSquareMeterInDollars"), priceMin, priceMax));
        } else if (priceMin != null && priceType.equalsIgnoreCase(priceTypeService.typePerSquareMeter()) && currency.equalsIgnoreCase(currencyService.typeDollars())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("costPerSquareMeterInDollars"), priceMin));
        } else if (priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typePerSquareMeter()) && currency.equalsIgnoreCase(currencyService.typeDollars())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("costPerSquareMeterInDollars"), priceMax));
        }else if (priceMin != null && priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typePerSquareMeter()) && currency.equalsIgnoreCase(currencyService.typeSoms())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("costPerSquareMeterInSoms"), priceMax));
        }else if (priceMin != null && priceType.equalsIgnoreCase(priceTypeService.typePerSquareMeter()) && currency.equalsIgnoreCase(currencyService.typeSoms())) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("costPerSquareMeterInSoms"), priceMin));
        } else if (priceMax != null && priceType.equalsIgnoreCase(priceTypeService.typePerSquareMeter()) && currency.equalsIgnoreCase(currencyService.typeSoms())) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("costPerSquareMeterInSoms"), priceMax));
        }

        if (dealType != null) {
            Join<OurProperty, TransactionType> join = root.join("transactionType");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), dealType.toUpperCase()));
        }
        if (propertyType != null) {
            Join<OurProperty, PropertyType> join = root.join("propertyType");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), propertyType.toUpperCase()));
        }
        if (roomCount != null) {
            Join<OurProperty, NumberOfRoom> join = root.join("numberOfRoom");
            predicates.add(criteriaBuilder.equal(join.get("number"), roomCount));
        }
        if (series != null) {
            Join<OurProperty, Series> join = root.join("series");
            predicates.add(criteriaBuilder.equal(join.get("name"), series));
        }
        if (buildingType != null) {
            Join<OurProperty, TypeOfStructure> join = root.join("typeOfStructure");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), buildingType.toUpperCase()));
        }
        if (heating != null) {
            Join<OurProperty, Heating> join = root.join("heating");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), heating.toUpperCase()));
        }
        if (condition != null) {
            Join<OurProperty, Condition> join = root.join("condition");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), condition.toUpperCase()));
        }
        if (region != null) {
            Join<OurProperty, Location> join1 = root.join("location");
            Join<Location, Location> join2 = join1.join("location");
            Join<Location, Location> join3 = join2.join("location");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join3.get("name")), region.toUpperCase()));
        }
        if (settlement != null) {
            Join<OurProperty, Location> join1 = root.join("location");
            Join<Location, Location> join2 = join1.join("location");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join2.get("name")), settlement.toUpperCase()));
        }
        if (district != null) {
            Join<OurProperty, Location> join1 = root.join("location");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join1.get("name")), district.toUpperCase()));
        }

        if (installmentPlan != null) {
            Join<OurProperty,MortgageOrInstallmentPlan> join = root.join("installmentPlan");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), installmentPlan.toUpperCase()));
        }
        if (mortgage  != null) {
            Join<OurProperty,MortgageOrInstallmentPlan> join = root.join("mortgage");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), mortgage.toUpperCase()));
        }
        if ( exchangeOption != null) {
            Join<OurProperty,PossibilityOfExchange> join = root.join("possibilityOfExchange");
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(join.get("name")), exchangeOption.toUpperCase()));
        }
        return predicates;
    }
}
