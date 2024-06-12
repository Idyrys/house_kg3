package kg.boosterschool.house_kg.controllers;

import kg.boosterschool.house_kg.dto.LocationDto;
import kg.boosterschool.house_kg.dto.OurPropertyDto;
import kg.boosterschool.house_kg.dto.responseDto.OurPropertyResponseDto;
import kg.boosterschool.house_kg.models.*;
import kg.boosterschool.house_kg.services.*;
import kg.boosterschool.house_kg.services.impl.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/real-estate/")
public class HouseController {
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
    private final OurPropertyService ourPropertyService;

    public HouseController(TransactionTypeServiceImpl transactionTypeService, PropertyTypeServiceImpl propertyTypeService, NumberOfRoomServiceImpl numberOfRoomService, SeriesServiceImpl seriesService, TypeOfStructureServiceImpl typeOfStructureService, HeatingServiceImpl heatingService, ConditionServiceImpl conditionService, LocationServiceImpl locationService, CurrencyServiceImpl currencyService, PriceTypeServiceImpl priceTypeService, MortgageOrInstallmentPlanServiceImpl mortgageOrInstallmentPlanService, PossibilityOfExchangeServiceImpl possibilityOfExchangeService, OurPropertyServiceImpl ourPropertyService) {
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
        this.ourPropertyService = ourPropertyService;
    }

    @GetMapping("get-all-transaction-type")
    ResponseEntity<List<TransactionType>> getAllTransactionType(){
        return ResponseEntity.ok(transactionTypeService.getAllTransactionType());
    }

    @GetMapping("get-all-property-type")
    ResponseEntity<List<PropertyType>> getAllPropertyType(){
        return ResponseEntity.ok(propertyTypeService.getAllPropertyType());
    }

    @GetMapping("get-all-number-of-room")
    ResponseEntity<List<NumberOfRoom>> getAllNumberOfRoom(){
        return ResponseEntity.ok(numberOfRoomService.getAllNumberOfRoom());
    }

    @GetMapping("get-all-series")
    ResponseEntity<List<Series>> getAllSeries(){
        return ResponseEntity.ok(seriesService.getAllSeries());
    }

    @GetMapping("get-all-type-of-structure")
    ResponseEntity<List<TypeOfStructure>> getAllTypeOfStructure(){
        return ResponseEntity.ok(typeOfStructureService.getAllTypeOfStructure());
    }

    @GetMapping("get-all-heating")
    ResponseEntity<List<Heating>> getAllHeating(){
        return ResponseEntity.ok(heatingService.getAllHeating());
    }

    @GetMapping("get-all-condition")
    ResponseEntity<List<Condition>> getAllCondition(){
        return ResponseEntity.ok(conditionService.getAllCondition());
    }
    @GetMapping("get-all-location/{id}")
    ResponseEntity<List<LocationDto>> getAllRegion(@PathVariable Long id){
        return ResponseEntity.ok(locationService.getAllLocation(id));
    }

    @GetMapping("get-all-currencies")
    ResponseEntity<List<Currency>> getAllCurrency(){
        return ResponseEntity.ok(currencyService.getAllCurrency());
    }

    @GetMapping("get-all-price-types")
    ResponseEntity<List<PriceType>> getAllPriceTypes(){
        return ResponseEntity.ok(priceTypeService.getAllPriceType());
    }

    @GetMapping("get-all-installment-plan")
    ResponseEntity<List<MortgageOrInstallmentPlan>> getAllInstallmentPlan(){
        return ResponseEntity.ok(mortgageOrInstallmentPlanService.getAllMortgageOrInstallmentPlan());
    }

    @GetMapping("get-all-mortgage")
    ResponseEntity<List<MortgageOrInstallmentPlan>> getAllMortgage(){
        return ResponseEntity.ok(mortgageOrInstallmentPlanService.getAllMortgageOrInstallmentPlan());
    }

    @GetMapping("get-all-possibility-of-exchange")
    ResponseEntity<List<PossibilityOfExchange>> getAllPossibilityOfExchange(){
        return ResponseEntity.ok(possibilityOfExchangeService.getAllPossibilityOfExchange());
    }

    @PostMapping("create-our-property")
    ResponseEntity<String> createOurProperty(@RequestBody OurPropertyDto ourPropertyDto){
        return ResponseEntity.ok(ourPropertyService.createOurProperty(ourPropertyDto));
    }

    @GetMapping("get-all-our-property-dto")
    ResponseEntity<List<String>> getAllOurPropertyResponseDto(){
        return ResponseEntity.ok(ourPropertyService.getAllOurPropertyResponseDto());
    }

    @GetMapping("get-all-our-properties")
    ResponseEntity<List<OurPropertyResponseDto>> getAllOutProperties(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "5") int pageSize,
            @RequestParam (required = false)Integer floor,
            @RequestParam (required = false)Integer yearBuilt,
            @RequestParam String dealType ,
            @RequestParam (required = false)String propertyType,
            @RequestParam (required = false)Integer roomCount,
            @RequestParam (required = false)String series,
            @RequestParam (required = false)String buildingType,
            @RequestParam (required = false)String heating,
            @RequestParam (required = false)String condition,
            @RequestParam (required = false)String region,
            @RequestParam (required = false)String settlement,
            @RequestParam (required = false)String district,
            @RequestParam (required = false)String streetName,
            @RequestParam (required = false)String houseNumber,
            @RequestParam (required = false)Double priceMin,
            @RequestParam (required = false)Double priceMax,
            @RequestParam String currency,
            @RequestParam String priceType,
            @RequestParam (required = false)String installmentPlan,
            @RequestParam (required = false) String mortgage,
            @RequestParam (required = false) String exchangeOption
    )
    {
        List<OurProperty> ourProperties = ourPropertyService.getAllOurPropertyByParameters(page,pageSize,floor,yearBuilt,dealType,propertyType,roomCount,series,buildingType,heating,condition,region,settlement,district,streetName,houseNumber,priceMin,priceMax,currency,priceType,installmentPlan,mortgage,exchangeOption);
        List<OurPropertyResponseDto> ourPropertyResponseDtos = ourPropertyService.getALlOurPropertyMapper(ourProperties);
        return ResponseEntity.ok(ourPropertyResponseDtos);
    }

}
