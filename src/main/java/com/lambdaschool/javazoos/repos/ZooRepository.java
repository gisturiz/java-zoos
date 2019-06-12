package com.lambdaschool.javazoos.repos;

import com.lambdaschool.javazoos.models.Zoo;
import com.lambdaschool.javazoos.views.CountAnimalsInZoos;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ZooRepository extends CrudRepository<Zoo, Long>
{
    //    SELECT z.zooid, t.zooname, count(z.animalid) as countanimals
    //    FROM zooanimals z
    //    INNER JOIN zoo t
    //    on z.zooid=t.zooid
    //    GROUP BY z.zooid, t.zooname

    @Query(value ="SELECT a.zooid, t.zooname, count(a.animalid) as countanimals FROM zooanimals a INNER JOIN zoo t on a.zooid=t.zooid GROUP BY a.zooid, t.zooname", nativeQuery = true)
    ArrayList<CountAnimalsInZoos> getCountAnimalsInZoos();

    //DELETE
    //FROM zooanimals
    //WHERE zooid =

    @Modifying
    @Query(value ="DELETE FROM zooanimals WHERE zooid = :zooid", nativeQuery = true)
    void deleteZoosFromAnimalzoos(long zooid);
}
