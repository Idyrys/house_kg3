package kg.boosterschool.house_kg.repositories;

import kg.boosterschool.house_kg.models.OurProperty;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OurPropertyRepo extends JpaRepository<OurProperty, Long>, JpaSpecificationExecutor<OurProperty> {


    @Query(value = "SELECT t2.name , p3.name , " +
            "n4.number,o1.square , s5.name , t6.name , " +
            "o1.year_of_construction, o1.floor, h7.name , c8.name , " +
            "ls3.name ,ls2.name,ls1.name,o1.street_name, o1.house_number, c12.name , " +
            "p13.name , o1.price, m9.name , m10.name , " +
            "p11.name  " +
            "FROM our_property o1 " +
            "JOIN transaction_types t2 ON o1.id_transaction_type = t2.id " +
            "JOIN property_types p3 ON o1.id_property_type = p3.id " +
            "JOIN number_of_rooms n4 ON o1.id_number_of_room = n4.id " +
            "JOIN serieses s5 ON o1.id_series = s5.id " +
            "JOIN type_of_structures t6 ON o1.id_type_of_structure = t6.id " +
            "JOIN heatinges h7 ON o1.id_heating = h7.id " +
            "JOIN conditions c8 ON o1.id_condition = c8.id " +
            "JOIN mortgages_or_installment_plans m9 ON o1.id_installment_plan = m9.id " +
            "JOIN mortgages_or_installment_plans m10 ON o1.id_mortgage = m10.id " +
            "JOIN possibility_of_exchanges p11 ON o1.id_possibility_of_exchange = p11.id " +
            "JOIN currencies c12 ON o1.id_currencie = c12.id " +
            "JOIN price_types p13 ON o1.id_price_type = p13.id " +
            "join locations ls1 on o1.id_location = ls1.id " +
            "join locations ls2 on ls1.id_locations = ls2.id " +
            "join locations ls3 on ls2.id_locations = ls3.id ", nativeQuery = true)
    List<String> getAllOurPropertyResponseDto();

    List<OurProperty> findAll(Specification<OurProperty> specification);


    @Query(value = "Select l3.name from locations l3 where id =(\n" +
            "Select l2.id_locations from locations l2 where id =(\n" +
            "select  l1.id_locations from locations l1\n" +
            "\twhere upper(l1.name) =upper(:name)));",nativeQuery = true)
    String getRegion(String name);

    @Query(value = "Select l2.name from locations l2 where id =(\n" +
            "select  l1.id_locations from locations l1\n" +
            "\twhere upper(l1.name) =upper(:name))",nativeQuery = true)
    String getSettlement(String name);


}
