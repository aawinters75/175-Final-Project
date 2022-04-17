package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

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
