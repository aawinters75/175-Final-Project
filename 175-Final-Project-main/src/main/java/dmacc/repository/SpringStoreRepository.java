package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dmacc.beans.StoreInformation;

/**
 * @author jword - jord
 * CIS175 - Spring - 2022
 * Apr 11, 2022
 */
@Repository
public interface SpringStoreRepository extends JpaRepository<StoreInformation, Long> {

}

/*
//Custom query
@Query(value = "select * from shop s where s.owner_name like %:keyword% or s.shop_type like %:keyword%", nativeQuery = true) List<Shop> findByKeyword(@Param("keyword") String keyword);
}
*/