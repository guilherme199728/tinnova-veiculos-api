package com.tinnova.vehicles.repositorys.veiculos;

import com.tinnova.vehicles.models.Vehicle;
import com.tinnova.vehicles.repositorys.filter.VehicleFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleRepositoryImpl implements VehicleRepositoryQuery {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Vehicle> findByFilter(VehicleFilter vehicleFilter) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Vehicle> criteriaQuery = builder.createQuery(Vehicle.class);
		Root<Vehicle> root = criteriaQuery.from(Vehicle.class);
		Predicate[] predicates = createWhere(vehicleFilter, builder, root);
		criteriaQuery.where(predicates);
		
		TypedQuery<Vehicle> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}
	
	private Predicate[] createWhere(VehicleFilter vehicleFilter, CriteriaBuilder criteriaBuilder, Root<Vehicle> root) {
		List<Predicate> predicates = new ArrayList<>();
		
		predicates.add(criteriaBuilder.equal(root.<String> get("sold"), vehicleFilter.isSold()));
		
		if (vehicleFilter.isRegisteredLasWeek()) {
			
			LocalDate beforeSevenDays = LocalDate.now().minusDays(7);
			Timestamp beforeSevenDaysTimesTamp = Timestamp.valueOf(beforeSevenDays.atStartOfDay());
			
			predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("creation_date"), beforeSevenDaysTimesTamp));
			
		}
		
		if (vehicleFilter.getBrand() != null && vehicleFilter.getBrand() != "") {
			predicates.add(criteriaBuilder.equal(criteriaBuilder.upper(root.get("brand")), vehicleFilter.getBrand().toUpperCase()));
		}
		
		if (vehicleFilter.getDecade() != null) {
			String decadaVeiculoString = vehicleFilter.getDecade().toString();
			decadaVeiculoString = decadaVeiculoString.substring(0, decadaVeiculoString.length() - 1);
			
			predicates.add(criteriaBuilder.between(root.get("year"), Integer.parseInt(decadaVeiculoString + "0"), Integer.parseInt(decadaVeiculoString + "9")));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
