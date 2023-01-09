package monprojet.dao;

import java.util.ArrayList;
import java.util.List;

import monprojet.dto.PopulationParPays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT SUM(c.population) FROM City c WHERE  c.country.id = :id ")
   public Integer getCountryPopulationByID(Integer id) ;

@Query (value =
        "SELECT c.name as nom, SUM (population) as population FROM Country c JOIN City  v ON c.id = v.country_id GROUP BY nom ", nativeQuery = true)
    public ArrayList<PopulationParPays> getPopulationParPays();
}
