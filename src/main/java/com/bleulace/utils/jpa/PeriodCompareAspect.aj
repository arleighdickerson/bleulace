package com.bleulace.utils.jpa;

import org.joda.time.Period;

public aspect PeriodCompareAspect
{
	declare parents : Period implements Comparable<Period>;

	public int Period.compareTo(Period that)
	{
		return this.getMillis() - that.getMillis();
	}
}