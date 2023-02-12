package com.tinnova.vehicles.repositorys.veiculos;

import com.tinnova.vehicles.dtos.QuantityPerBrandsDto;
import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.filter.VehicleFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepositoryQuery {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findByFilter(VehicleFilter vehicleFilter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Vehicle> criteriaQuery = criteriaBuilder.createQuery(Vehicle.class);
        Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
        Predicate[] predicates = createWhere(vehicleFilter, criteriaBuilder, root);
        criteriaQuery.where(predicates).orderBy(criteriaBuilder.asc(root.get("id")));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Override
    public List<QuantityPerBrandsDto> findTotalQuantityPerBrands() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<QuantityPerBrandsDto> query = criteriaBuilder.createQuery(QuantityPerBrandsDto.class);
        Root<Vehicle> root = query.from(Vehicle.class);
        query.multiselect(root.get("brand"), criteriaBuilder.count(root));
        query.groupBy(root.get("brand"));

        return entityManager.createQuery(query).getResultList();
    }

    private Predicate[] createWhere(VehicleFilter vehicleFilter, CriteriaBuilder criteriaBuilder, Root<Vehicle> root) {
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(criteriaBuilder.equal(root.<String>get("sold"), vehicleFilter.isSold()));

        if (vehicleFilter.isRegisteredLasWeek()) {
            LocalDateTime beforeSevenDays = LocalDateTime.now().minusDays(7);
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("creationDate"), beforeSevenDays));
        }

        if (vehicleFilter.getBrand() != null && !vehicleFilter.getBrand().equals("")) {
            predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("brand")), vehicleFilter.getBrand().toUpperCase()));
        }

        if (vehicleFilter.getDecade() != null) {
            int firstYear = 1000 + vehicleFilter.getDecade();
            List<Predicate> predicatesYear = new ArrayList<>();
            LocalDate startDate = LocalDate.of(firstYear, 1, 1);
            LocalDate endDate = LocalDate.of(firstYear + 9, 12, 31);

            for (LocalDate date = startDate; date.isBefore(LocalDate.now()); date = date.plusYears(100)) {
                predicatesYear.add(criteriaBuilder.between(root.get("yearManufacture"), date.getYear(), endDate.getYear()));
                endDate = endDate.plusYears(100);
            }

            predicates.add(criteriaBuilder.or(predicatesYear.toArray(new Predicate[0])));
        }

        return predicates.toArray(new Predicate[0]);
    }
}
