package fi.hut.soberit.agilefant.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import fi.hut.soberit.agilefant.model.ExactEstimate;

public class ExactEstimateConverter extends StrutsTypeConverter {

    @SuppressWarnings("unchecked")
    @Override
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (values[0].length() == 0) {
            return null;
        }
        ExactEstimate result = new ExactEstimate();
        long value;
        try {
            return ExactEstimateUtils.convertFromString(values[0]);
        } catch (Exception ex) {
            try {
                value = Long.parseLong(values[0]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        result.setMinorUnits(value);
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String convertToString(Map context, Object o) {
        if (o == null)
            return null;
        if (o instanceof ExactEstimate)
            return ExactEstimateUtils.convertToString((ExactEstimate) o);
        return o.toString();
    }

}
