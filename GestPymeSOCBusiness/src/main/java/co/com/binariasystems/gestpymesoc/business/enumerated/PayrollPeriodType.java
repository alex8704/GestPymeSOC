/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.com.binariasystems.gestpymesoc.business.enumerated;

/**
 *
 * @author Alexander
 */
public enum PayrollPeriodType {
    QUINCENAL(15,2), MENSUAL(30,1);
    private final int periodDaysRange;
    private final int maxPerMonth;
    
    PayrollPeriodType(int periodDaysRange, int maxPerMonth){
        this.periodDaysRange = periodDaysRange;
        this.maxPerMonth = maxPerMonth;
    }

	public int getPeriodDaysRange() {
		return periodDaysRange;
	}

	public int getMaxPerMonth() {
		return maxPerMonth;
	}
    
    
}
