package ua.implementation.specification;

import org.springframework.data.jpa.domain.Specification;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import ua.entity.ProductCreator;
import ua.form.filter.CreatorFilterForm;

public class CreatorFilterAdapter implements Specification<ProductCreator>{
	private String search = "";

	public CreatorFilterAdapter(CreatorFilterForm form) {
		search = form.getSearch();
	}

	@Override
	public Predicate toPredicate(Root<ProductCreator> root, CriteriaQuery<?> query,
			CriteriaBuilder cb) {
		if (query.getResultType() != Long.class && query.getResultType() != long.class) {
//			root.fetch("ingredient");
//			root.fetch("measuringSystem");
//			query.distinct(true);
		}
		Expression<String> exp = root.get("name");
		return cb.like(cb.upper(exp), search.toUpperCase()+"%");
	}
}
