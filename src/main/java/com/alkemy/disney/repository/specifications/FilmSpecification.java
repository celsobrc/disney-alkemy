package com.alkemy.disney.repository.specifications;

import com.alkemy.disney.dto.FilmFiltersDTO;
import com.alkemy.disney.entity.FilmEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Component
public class FilmSpecification {

    public Specification<FilmEntity> getByFilters(FilmFiltersDTO filtersDTO){
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("title")),
                                "%" + filtersDTO.getName().toLowerCase() + "%"
                        )
                );
            }

            if (StringUtils.hasLength(filtersDTO.getGenreId())){
                Long genreId = Long.parseLong(filtersDTO.getGenreId());
                predicates.add(
                        criteriaBuilder.equal(root.get("genreId"), genreId)
                );
            }

            //Remove duplicates
            query.distinct(true);

            //Order resolver
            String orderByField = "title";
            query.orderBy(
                    filtersDTO.isAsc() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
