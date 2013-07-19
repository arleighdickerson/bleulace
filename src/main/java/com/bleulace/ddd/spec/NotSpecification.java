package com.bleulace.ddd.spec;

/**
 * 
 * @author Slawek
 * 
 * @param <T>
 */
public class NotSpecification<T> extends CompositeSpecification<T>
{
	private Specification<T> wrapped;

	public NotSpecification(Specification<T> wrapped)
	{
		this.wrapped = wrapped;
	}

	public boolean isSatisfiedBy(T candidate)
	{
		return !wrapped.isSatisfiedBy(candidate);
	}
}