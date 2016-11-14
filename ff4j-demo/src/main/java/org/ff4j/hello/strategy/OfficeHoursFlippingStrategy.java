package org.ff4j.hello.strategy;

import java.util.Calendar;
import java.util.Map;

import org.ff4j.core.FeatureStore;
import org.ff4j.core.FlippingExecutionContext;
import org.ff4j.strategy.AbstractFlipStrategy;

public class OfficeHoursFlippingStrategy extends AbstractFlipStrategy {
	
	/** Start Hour. */
	private int start = 0;
	
	/** End Hour. */
	private int end = 0;

	/** {@inheritDoc} */
	@Override
	public void init(String featureName, Map<String, String> initValue) {
		super.init(featureName, initValue);
		assertRequiredParameter("startHour");
		assertRequiredParameter("endHour");
		start = new Integer(initValue.get("startHour"));
		end = new Integer(initValue.get("endHour"));
	}

	/** {@inheritDoc} */
	@Override
	public boolean evaluate(String fName, FeatureStore fStore, FlippingExecutionContext ctx) {
		int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		return (currentHour >= start && currentHour < end);
	}
	
}
